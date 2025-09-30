<?php

if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
include __DIR__ . '/../config.php';

?>


<?php
// filtre verilerini al
$action_type = $_GET['action_type'] ?? '';
$durum       = $_GET['durum']       ?? '';
$tarih_bas   = $_GET['tarih_bas']   ?? '';
$tarih_son   = $_GET['tarih_son']   ?? '';
$search      = $_GET['search']      ?? '';

// WHERE koşullarını hazırla
$where  = [];
$params = [];

if ($action_type !== '') {
    $where[]         = "action_type = :action_type";
    $params[':action_type'] = $action_type;
}

if ($durum !== '') {
    $where[]         = "durum = :durum";
    $params[':durum'] = $durum;
}

if ($tarih_bas !== '') {
    $where[]         = "changed_at >= :tarih_bas";
    $params[':tarih_bas'] = $tarih_bas;
}

if ($tarih_son !== '') {
    $where[]         = "changed_at <= :tarih_son";
    $params[':tarih_son'] = $tarih_son;
}

if ($search !== '') {
    $where[]             = "(eski_data LIKE :search OR yeni_data LIKE :search)";
    $params[':search'] = '%' . $search . '%';
}

$sql = "SELECT * FROM lastData";
if ($where) {
    $sql .= " WHERE " . implode(' AND ', $where);
}
$sql .= " ORDER BY changed_at DESC";

$stmt = $pdo->prepare($sql);
$stmt->execute($params);
$kaydlar = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<div class="harcamalar-wrapper">

  <form method="GET" action="index.php" class="search-form">
    <input type="hidden" name="sayfa" value="harcamalar_takip">

    <select name="action_type">
      <option value="">Tümü</option>
      <option value="update" <?= $action_type === 'update' ? 'selected' : '' ?>>Güncelleme</option>
      <option value="delete" <?= $action_type === 'delete' ? 'selected' : '' ?>>Silme</option>
    </select>

    <select name="durum">
      <option value="">Hepsi</option>
      <option value="pending"  <?= $durum === 'pending'  ? 'selected' : '' ?>>Beklemede</option>
      <option value="approved" <?= $durum === 'approved' ? 'selected' : '' ?>>Onaylandı</option>
      <option value="rejected" <?= $durum === 'rejected' ? 'selected' : '' ?>>Reddedildi</option>
    </select>

    <input type="date" name="tarih_bas" value="<?= htmlspecialchars($tarih_bas) ?>">
    <input type="date" name="tarih_son" value="<?= htmlspecialchars($tarih_son) ?>">

    <input type="text" name="search" placeholder="Eski/Yeni veri içinde ara" value="<?= htmlspecialchars($search) ?>">

    <button type="submit">Filtrele/Ara</button>

    <?php if ($action_type || $durum || $tarih_bas || $tarih_son || $search): ?>
      <a href="index.php?sayfa=harcamalar_takip">Temizle</a>
    <?php endif; ?>
  </form>

  <table>
    <thead>
      <tr>
        <th>#</th>
        <th>Veri Kontrol</th>
        <th>İşlem Türü</th>
        <th>Durum</th>
        <th>Değişiklik Tarihi</th>
      </tr>
    </thead>
    <tbody>
      <?php foreach ($kaydlar as $h): ?>
        <tr>
          <td><?= $h['id'] ?></td>
          <td>
            <?php
// 2) Hangi harcamaya ait eski/yeni JSON’ı çekeceğiz? (örn: GET parametresinden alıyoruz)
$harcamaId = isset($h['harcama_id']) ? (int) $h['harcama_id'] : 0;
if ($harcamaId <= 0) {
    die('Geçersiz harcama_id.');
}

// 3) “lastData” tablosundan en son kaydı çek
$sql = "
    SELECT
        eski_data,
        yeni_data
    FROM lastData
    WHERE harcama_id = ?
    ORDER BY changed_at DESC
    LIMIT 1
";
$stmt = $pdo->prepare($sql);
$stmt->execute([$harcamaId]);
$row = $stmt->fetch();

if (!$row) {
    die('Bu harcama_id için kayıt bulunamadı.');
}

// 4) Gelen JSON’ları değişkene ata
$eskiJson = $row['eski_data'];  // Örn: {"odeme_turu":"kredi","tutar":100,"aciklama":"Açıklama A"}
$yeniJson = $row['yeni_data'];  // Örn: {"odeme_turu":"nakit","tutar":150,"aciklama":"Açıklama A"}

// 5) JSON’u PHP dizisine çevir
$eskiArr = json_decode($eskiJson, true);
$yeniArr = json_decode($yeniJson, true);

if (!is_array($eskiArr)) {
    $eskiArr = []; 
}
if (!is_array($yeniArr)) {
    $yeniArr = [];
}

// Tüm anahtarları elde etmek için birleştirme
$anahtarlar = array_unique(array_merge(array_keys($eskiArr), array_keys($yeniArr)));

foreach ($anahtarlar as $anahtar) {
    $eskiDeger = array_key_exists($anahtar, $eskiArr) ? $eskiArr[$anahtar] : null;
    $yeniDeger = array_key_exists($anahtar, $yeniArr) ? $yeniArr[$anahtar] : null;
    // Eski ve yeni değer farklı ise fark olarak ekle
    if ($eskiDeger !== $yeniDeger) {
        $farklar[$anahtar] = [
            'eski' => $eskiDeger,
            'yeni' => $yeniDeger
        ];
    }
}

// Farklılıkları tablo halinde ekrana bas
if (!empty($farklar)) {
    echo '<table border="1" cellpadding="4" cellspacing="0">';
    echo '<thead><tr>';
    echo '<th>Anahtar</th><th>Eski Veri</th><th>Yeni Veri</th>';
    echo '</tr></thead>';
    echo '<tbody>';
    foreach ($farklar as $anahtar => $degerler) {
        // HTML güvenliği için htmlspecialchars kullan
        $eskiTxt = htmlspecialchars((string)$degerler['eski'], ENT_QUOTES, 'UTF-8');
        $yeniTxt = htmlspecialchars((string)$degerler['yeni'], ENT_QUOTES, 'UTF-8');
        echo '<tr>';
        echo '<td>' . ($anahtar === 'odeme_turu'  ? 'Ödeme Türü'  : ($anahtar === 'tutar'  ? 'Tutar'  : ($anahtar === 'tarih' ? 'Tarih' : ($anahtar === 'harcama_yeri' ? 'Harcama Yeri' : ($anahtar === 'aciklama' ? 'Açıklama': "BOŞ"))))) .'</td>';
        echo "<td>{$eskiTxt}</td>";
        echo "<td>{$yeniTxt}</td>";
        echo '</tr>';
    }
    echo '</tbody>';
    echo '</table>';
} else {
    echo 'Farklılık bulunamadı.';
}
?>
          </td>
          <td><?= $h['action_type'] === 'delete' ? 'Silme Talebi' : ($h['action_type'] === 'update' ? 'Güncelleme Talebi' : 'Beklemede')?></td>
          <td><?= $h['durum'] === 'approved' ? 'Onaylandı' : ($h['durum'] === 'rejected' ? 'Reddedildi' : 'Beklemede')?></td>
          <td><?= htmlspecialchars($h['changed_at']) ?></td>
        </tr>
      <?php endforeach; ?>
    </tbody>
  </table>
</div>
