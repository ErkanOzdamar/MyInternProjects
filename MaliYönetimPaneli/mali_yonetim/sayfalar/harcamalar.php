

<?php

if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
include  __DIR__  .  '/../config.php';

?>



<?php
//  filtre  verilerini  al
$odeme_turu = $_GET['odeme_turu']  ?? '';
$tarih_bas  = $_GET['tarih_bas']   ?? '';
$tarih_son  = $_GET['tarih_son']   ?? '';
$search     = trim($_GET['search'] ?? '');

$conds  = [];
$params = [];

if ($odeme_turu !== '') {
  $conds[]             = 'odeme_turu = :odeme_turu';
  $params[':odeme_turu'] = $odeme_turu;
}
if ($tarih_bas !== '') {
  $conds[]             = 'tarih >= :tarih_bas';
  $params[':tarih_bas']  = $tarih_bas;
}
if ($tarih_son !== '') {
  $conds[]             = 'tarih <= :tarih_son';
  $params[':tarih_son']  = $tarih_son;
}
if ($search !== '') {
  $conds[]            = '(harcama_yeri LIKE :search OR aciklama LIKE :search)';
  $params[':search']   = "%{$search}%";
}

$sql = 'SELECT * FROM harcamalar';
if (count($conds)) {
  $sql .= ' WHERE ' . implode(' AND ', $conds);
}
$sql .= ' ORDER BY tarih DESC';

$stmt = $pdo->prepare($sql);
$stmt->execute($params);
$harcamalar = $stmt->fetchAll(PDO::FETCH_ASSOC);

?>




<a  href="?sayfa=harcama_ekle">Yeni  Harcama</a>


<div  class="harcamalar-wrapper">
  <form method="GET" action="index.php" class="search-form">
  <input type="hidden" name="sayfa" value="harcamalar">

  <select name="odeme_turu">
    <option value="">Tümü</option>
    <option value="nakit"      <?= $odeme_turu==='nakit'      ? 'selected':''?>>Nakit</option>
    <option value="kredi kartı"<?= $odeme_turu==='kredi kartı'? 'selected':''?>>Kredi Kartı</option>
  </select>

  <input type="date" name="tarih_bas" value="<?= htmlspecialchars($tarih_bas) ?>">
  <input type="date" name="tarih_son" value="<?= htmlspecialchars($tarih_son) ?>">

  

  <button type="submit">Filtrele</button>
  <input type="text" name="search" placeholder="Yer veya açıklama" value="<?= htmlspecialchars($search) ?>">
  <button type="submit">Ara</button>
  <?php if($odeme_turu||$tarih_bas||$tarih_son||$search): ?>
        <a href="index.php?sayfa=harcamalar">Temizle</a>
  <?php endif; ?>
  
   <!-- Tarih Aralığı Seçildiyse İndirme Butonları -->
    <?php if ($tarih_bas !== '' && $tarih_son !== ''): ?>
      <a href="index.php?sayfa=harcamalar_export_excel&tarih_bas=<?= $tarih_bas ?>&tarih_son=<?= $tarih_son ?>" class="btn">Excel İndir</a>
      <a href="index.php?sayfa=harcamalar_export_pdf&tarih_bas=<?= $tarih_bas ?>&tarih_son=<?= $tarih_son ?>" class="btn">PDF İndir</a>
    <?php endif; ?>
  
  </form>
                
    <table>
            <thead>
                <tr>
                <th>#</th>
                <th>Ödeme  Türü</th>
                <th>Tarih</th>
                <th>Yer</th>
                <th>Açıklama</th>
                <th>Tutar  (₺)</th>
                <th>İşlemler</th>
                </tr>
            </thead>



    <tbody>
        <?php  $i  =  1;  foreach  ($harcamalar  as  $h):  ?>
            <tr>
                <td><?=  $i++  ?></td>
                <td><?=  htmlspecialchars($h['odeme_turu'])  ?></td>
                <td><?=  htmlspecialchars($h['tarih'])  ?></td>
                <td><?=  htmlspecialchars($h['harcama_yeri'])  ?></td>
                <td>
                    <?= htmlspecialchars(
                    mb_strlen($h['aciklama'], 'UTF-8') > 20
                    ? mb_substr($h['aciklama'], 0, 15, 'UTF-8') . '...'
                    : $h['aciklama'],
                    ENT_QUOTES,
                    'UTF-8'
                    ) ?>
                </td>
                <td><?=  number_format($h['tutar'],  2,  ',',  '.')  ?></td>
                <td>
                      <a class="red" href="?sayfa=harcama_sil&id=<?=  $h['id']  ?>"  >Sil</a>
                      &nbsp;
                      <a class="green" href="?sayfa=harcama_duzenle&id=<?= $h['id'] ?>" >Düzenle</a>
                      &nbsp;
                      <a class="green" href="?sayfa=harcama_detay&id=<?= $h['id'] ?>">Detay</a>
                </td>
            </tr>
        <?php  endforeach;  ?>
    </tbody>
    </table>
</div>








