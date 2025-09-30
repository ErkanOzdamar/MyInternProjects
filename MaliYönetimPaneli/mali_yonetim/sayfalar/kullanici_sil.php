<?php

if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
?>

<?php
include __DIR__ . '/../config.php';


$id = $_GET['id'] ?? null;

if ($id) {
    // Silinmek istenen kullanıcının rolünü al
    $stmt = $pdo->prepare("SELECT rol FROM kullanicilar WHERE id = ?");
    $stmt->execute([$id]);
    $kullanici = $stmt->fetch();

    if ($kullanici && $kullanici['rol'] === 'admin') {
        // Admin sayısını kontrol et
        $admin_sayisi = $pdo->query("SELECT COUNT(*) FROM kullanicilar WHERE rol = 'admin'")->fetchColumn();

        if ($admin_sayisi < 2) {
            echo "<script>alert('Sistemde en az 1 admin kalmalıdır. Admin silme işlemi engellendi.'); window.location.href = '../index.php?sayfa=kullanicilar';</script>";
            exit;
        }
    }

    // Silme işlemi yapılabilir
    $pdo->prepare("DELETE FROM kullanicilar WHERE id = ?")->execute([$id]);
}

header("Location: ../index.php?sayfa=kullanicilar");
exit;
