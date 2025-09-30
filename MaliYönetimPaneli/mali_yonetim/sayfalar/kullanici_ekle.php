<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

include __DIR__ . '/../config.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $kadi  = $_POST['kullanici_adi'] ?? '';
    $sifre = $_POST['sifre'] ?? '';
    $rol   = $_POST['rol'] ?? 'kullanici';
    

    
    $kontrol = $pdo->prepare("SELECT COUNT(*) FROM kullanicilar WHERE kullanici_adi = ?");
    $kontrol->execute([$kadi]);
    $var_mi = $kontrol->fetchColumn();

    if ($var_mi > 0) {
        echo "<script>alert('Bu kullanıcı zaten var!'); history.back();</script>";
    }

    
    $hashli_sifre = password_hash($sifre, PASSWORD_DEFAULT);
    $stmt = $pdo->prepare("INSERT INTO kullanicilar (kullanici_adi, sifre, rol) VALUES (?, ?, ?)");
    $stmt->execute([$kadi, $hashli_sifre, $rol]);

    header("Location: ?sayfa=kullanicilar");
    exit;
}
?>

<div class="form-container">
  <form method="POST" class="user-form">
    <input type="text" name="kullanici_adi" placeholder="Kullanıcı Adı" required>
    <input type="password" name="sifre" placeholder="Şifre" required>
    <select name="rol" required>
      <option value="" disabled selected>Rol Seçin</option>
      <option value="kullanici">Kullanıcı</option>
      <option value="admin">Admin</option>
    </select>
    <button type="submit">Ekle</button>
  </form>
</div>