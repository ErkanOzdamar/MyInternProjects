<?php
ob_start();
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

include 'config.php';

$hata = '';
$bilgi = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $kadi = $_POST['kullanici_adi'] ?? '';
    $sifre = $_POST['sifre'] ?? '';
    
    
    $bilgi .= "<p>Gönderilen kullanıcı adı: $kadi</p>";
    $bilgi .= "<p>Gönderilen şifre: $sifre</p>";

    $stmt = $pdo->prepare("SELECT * FROM kullanicilar WHERE kullanici_adi = ?");
    $stmt->execute([$kadi]);
    $kullanici = $stmt->fetch(PDO::FETCH_ASSOC);

    if ($kullanici) {
        $bilgi .= "<p>Veritabanından kullanıcı bulundu.</p>";
        $bilgi .= "<p>Veritabanındaki hash: " . $kullanici['sifre'] . "</p>";

        if (crypt($sifre, $kullanici['sifre']) === $kullanici['sifre']){
            $_SESSION['giris'] = true;
            $_SESSION['kullanici'] = $kadi;
            $_SESSION['rol'] = $kullanici['rol'];
            $_SESSION['id'] =  $kullanici['id'];

            header("Location: /mali_yonetim/index.php");

            exit;            
        } else {
            $hata = "❌ Şifre eşleşmedi.";
        }
    } else {
        $hata = "❌ Kullanıcı bulunamadı.";
    } 
}
?>

<head>
    <link rel="stylesheet" href="/mali_yonetim/css/style.css">
</head>


<div class="login-container">
  <div class="login-box">
    <h1 class="reveal-title">BIG ANATOLIA</h1>
    <h2>Giriş Yap</h2>
    <form method="POST" action="login.php" class="login-form">
      <input type="text"     name="kullanici_adi" placeholder="Kullanıcı Adı" required>
      <input type="password" name="sifre"          placeholder="Şifre"        required>
      <button type="submit">Giriş</button>
    </form>
  </div>
</div>

