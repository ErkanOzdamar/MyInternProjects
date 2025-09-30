<?php
include __DIR__ . '/../config.php';
if (!isset($_GET['id'])) {
  header('Location: index.php?sayfa=harcamalar');
  exit;
}
$id = intval($_GET['id']);
$stmt = $pdo->prepare('SELECT * FROM harcamalar WHERE id = ?');

$stmt->execute([$id]);
$h = $stmt->fetch(PDO::FETCH_ASSOC);
if (!$h) {
  echo 'Kayıt bulunamadı.';
  exit;
}
?>


<div class="form-container">
  <form method="POST" class="user-form">
    <div>
      <label>Tarih</label>
      <input type="date" value="<?= htmlspecialchars($h['tarih']) ?>" disabled>
    </div>
    <div>
      <label>Ödeme Türü</label>
      <input type="text" value="<?= htmlspecialchars($h['odeme_turu']) ?>" disabled>
    </div>
    <div>
      <label>Harcama Yeri</label>
      <input type="text" value="<?= htmlspecialchars($h['harcama_yeri']) ?>" disabled>
    </div>
    <div>
      <label>Tutar</label>
      <input type="number" value="<?= htmlspecialchars($h['tutar']) ?>" disabled>
    </div>
    <div class="pre-wrap">
        <?= htmlspecialchars($h['aciklama'])?>
    </div>

    <div class="return">
        <a href="?sayfa=harcamalar">← Geri</a>
    </div>
  </form>
</div>  
