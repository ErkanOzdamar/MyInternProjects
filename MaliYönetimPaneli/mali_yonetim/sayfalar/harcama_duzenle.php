<?php
if (session_status() === PHP_SESSION_NONE) session_start();
include __DIR__ . '/../config.php';

$id = $_GET['id'] ?? null;
if (!$id) {
    header('Location: ?sayfa=harcamalar');
    exit;
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $odeme_turu   = $_POST['odeme_turu'];
    $tarih        = $_POST['tarih'];
    $harcama_yeri = $_POST['harcama_yeri'];
    $neden        = $_POST['aciklama'];
    $tutar        = $_POST['tutar'];

    $stmt = $pdo->prepare("
      UPDATE harcamalar 
      SET odeme_turu = ?, tarih = ?, harcama_yeri = ?, aciklama = ?, tutar = ?
      WHERE id = ?
    ");
    $stmt->execute([
      $odeme_turu, $tarih, $harcama_yeri, $neden, $tutar, $id
    ]);

    header("Location: ?sayfa=harcamalar");
    exit;
}

// GET ile mevcut veriyi çek
$stmt = $pdo->prepare("SELECT * FROM harcamalar WHERE id = ?");
$stmt->execute([$id]);
$h = $stmt->fetch(PDO::FETCH_ASSOC);
if (!$h) {
    header('Location: ?sayfa=harcamalar');
    exit;
}
?>

<?php if (isset($_SESSION['rol']) && $_SESSION['rol'] === 'admin'): ?>
<div class="form-container">
  <form method="POST" class="user-form">
    <select name="odeme_turu" required>
      <option value="nakit"    <?= $h['odeme_turu']==='nakit'   ? 'selected':'' ?>>Nakit</option>
      <option value="kredi kartı" <?= $h['odeme_turu']==='kredi kartı' ? 'selected':'' ?>>Kredi Kartı</option>
    </select>
    <input type="date"   name="tarih"        value="<?= htmlspecialchars($h['tarih']) ?>" required>
    <input type="text"   name="harcama_yeri" placeholder="Harcama Yeri" value="<?= htmlspecialchars($h['harcama_yeri']) ?>" required>
    <input type="text"   name="aciklama"      placeholder="Açıklama"      value="<?= htmlspecialchars($h['aciklama']) ?>" required>
    <input type="number" step="0.01" name="tutar" placeholder="Tutar" value="<?= htmlspecialchars($h['tutar']) ?>" required>
    <button type="submit">Güncelle</button>
    <div class="return">
        <a href="?sayfa=harcamalar">← Geri</a>
    </div>
  </form>
</div>
<?php endif; ?>

<?php if (isset($_SESSION['rol']) && $_SESSION['rol'] === 'kullanici'): ?>
<div class="form-container">
  <form method="POST" action="?sayfa=harcama_talep" class="user-form">
    <input type="hidden" name="harcama_id" value="<?= $h['id'] ?>">

    <label>Ödeme Tipi</label>
    <select name="odeme_tipi" required>
      <option value="nakit" <?= $h['odeme_turu']==='nakit'?'selected':'' ?>>Nakit</option>
      <option value="kredi kartı" <?= $h['odeme_turu']==='kredi kartı'?'selected':'' ?>>Kredi Kartı</option>
    </select>

    <label>Harcama Tarihi</label>
    <input type="date" name="harcama_tarihi" value="<?= date('Y-m-d', strtotime($h['tarih'])) ?>" required>

    <label>Yer</label>
    <input type="text" name="yer" value="<?= htmlspecialchars($h['harcama_yeri'], ENT_QUOTES) ?>" required>

    <label>Açıklama</label>
    <input type="text" name="sebep" value="<?= htmlspecialchars($h['aciklama'], ENT_QUOTES) ?>" required>

    <label>Tutar</label>
    <input type="number" step="0.01" name="tutar" value="<?= $h['tutar'] ?>" required>

    <button type="submit" name="talep_gonder">Güncelleme Talebi Gönder</button>
    <div class="return">
      <a href="?sayfa=harcamalar">← Geri</a>
    </div>
  </form>
</div>
<?php endif; ?>
