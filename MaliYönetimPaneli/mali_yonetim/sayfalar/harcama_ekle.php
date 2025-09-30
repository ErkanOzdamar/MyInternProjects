<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
include __DIR__ . '/../config.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $odeme_turu   = $_POST['odeme_turu'] ?? '';
    $tarih        = $_POST['tarih'] ?? '';
    $harcama_yeri = $_POST['harcama_yeri'] ?? '';
    $neden        = $_POST['aciklama'] ?? '';
    $tutar        = $_POST['tutar'] ?? '';

    // Temel boşluk kontrolü
    if ($odeme_turu && $tarih && $harcama_yeri && $neden && $tutar) {
        $stmt = $pdo->prepare("INSERT INTO harcamalar (odeme_turu, tarih, harcama_yeri, aciklama, tutar) VALUES (?, ?, ?, ?, ?)");
        $stmt->execute([$odeme_turu, $tarih, $harcama_yeri, $neden, $tutar]);
    }

    header("Location: ?sayfa=harcamalar");
    exit;
}
?>

<div class="form-container">
  <form method="POST" class="user-form">
    <select name="odeme_turu" required>
      <option value="" disabled selected>Ödeme Türü Seçin</option>
      <option value="nakit">Nakit</option>
      <option value="kredi kartı">Kredi Kartı</option>
    </select>
    <input type="date" name="tarih" required>
    <input type="text" name="harcama_yeri" placeholder="Harcama Yeri" required>
    <input type="text" name="aciklama" placeholder="Açıklama" required>
    <input type="number" step="0.01" name="tutar" placeholder="Tutar" required>
    <button type="submit">Fatura Ekle</button>
  </form>
</div>
