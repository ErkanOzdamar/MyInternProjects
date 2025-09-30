<?php

if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
?>

<?php
include __DIR__ . '/../config.php';


$id = $_GET['id'] ?? 0;
$stmt = $pdo->prepare("SELECT rol FROM kullanicilar WHERE id = ?");
$stmt->execute([$id]);
$kullanici = $stmt->fetch();

if ($kullanici) {
    $mevcut_rol = $kullanici['rol'];

    // Eğer mevcut rol admin ve sayısı 2'den azsa düşürme işlemini engelle
    if ($mevcut_rol === 'admin') {
        $sayac = $pdo->query("SELECT COUNT(*) FROM kullanicilar WHERE rol = 'admin'")->fetchColumn();
        
        if ($sayac == 1 ) {
            echo "<script>alert('Sistemde en az 1 admin kalmalı. Yetki değiştirilemez.'); window.location.href = '../index.php?sayfa=kullanicilar';</script>";
            exit;
        }
    }

    // Yetki ters çevrilir
    $yeni_rol = ($mevcut_rol === 'admin') ? 'kullanici' : 'admin';
    $pdo->prepare("UPDATE kullanicilar SET rol = ? WHERE id = ?")->execute([$yeni_rol, $id]);
}

header("Location: ../index.php?sayfa=kullanicilar");
exit;