<?php
if (session_status()===PHP_SESSION_NONE) session_start();
include __DIR__ . '/../config.php';

$id = $_GET['id'] ?? null;
if (!$id) {
    header('Location: ?sayfa=harcamalar');
    exit;
}
if (isset($_SESSION['rol']) && $_SESSION['rol'] === 'admin'){
        if ($id) {
            $stmt = $pdo->prepare("DELETE FROM harcamalar WHERE id = ?");
            $stmt->execute([$id]);
        }
         header('Location: ?sayfa=harcamalar');
        exit;
}

if ($_SERVER['REQUEST_METHOD']==='POST') {
    $harcamaId   = $id;
    $kullaniciId = $_SESSION['id'];

    // Mevcut kaydı al
    $stmt = $pdo->prepare("SELECT * FROM harcamalar WHERE id = ?");
    $stmt->execute([$harcamaId]);
    $h = $stmt->fetch(PDO::FETCH_ASSOC);
    if ($h) {
        $payload = [
            'odeme_turu'   => $h['odeme_turu'],
            'tarih'        => $h['tarih'],
            'harcama_yeri' => $h['harcama_yeri'],
            'aciklama'     => $h['aciklama'],
            'tutar'        => $h['tutar']
        ];
        $jsonData = json_encode($payload, JSON_UNESCAPED_UNICODE);

        // Silme talebini kaydet
        $stmt2 = $pdo->prepare("
          INSERT INTO harcama_talepleri
            (harcama_id, kullanici_id, veri, action_type)
          VALUES (?, ?, ?, 'delete')
        ");
        $stmt2->execute([$harcamaId, $kullaniciId, $jsonData]);
    }

    header('Location: ?sayfa=harcamalar');
    exit;
}

// GET: onay formu
$stmt = $pdo->prepare("SELECT * FROM harcamalar WHERE id = ?");
$stmt->execute([$id]);
$h = $stmt->fetch(PDO::FETCH_ASSOC);
if (!$h) {
    header('Location: ?sayfa=harcamalar');
    exit;
}
?>

<?php if (isset($_SESSION['rol']) && $_SESSION['rol']==='kullanici'): ?>
<div class="form-container">
  
  <ul>
    <h2>Harcama Silme Talebi</h2>
    <li>Ödeme Türü: <?=htmlspecialchars($h['odeme_turu'])?></li>
    <li>Tarih: <?=htmlspecialchars($h['tarih'])?></li>
    <li>Yeri: <?=htmlspecialchars($h['harcama_yeri'])?></li>
    <li>Açıklama: <?=htmlspecialchars($h['aciklama'])?></li>
    <li>Tutar: <?=htmlspecialchars($h['tutar'])?></li>
  </ul>
  <form method="POST" class="user-form">
    <button type="submit">Silme Talebi Gönder</button>
    <div class="return">
      <a href="?sayfa=harcamalar">← Geri</a>
    </div>
  </form>
</div>
<?php endif; ?>
