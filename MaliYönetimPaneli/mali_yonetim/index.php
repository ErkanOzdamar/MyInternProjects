<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
include 'auth.php';
?>



<head>
    <link rel="stylesheet" href="/mali_yonetim/css/style.css">
    <link rel="stylesheet"
     href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" 
     integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
     crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>




<div class="wrapper">
    <div class="sideBar">
        <ul>
            <a href="?sayfa=anasayfa"><i class="fa-solid fa-house"></i> ANASAYFA</a>
            <?php if (isset($_SESSION['rol']) && $_SESSION['rol'] === 'admin'): ?>
            <a href="?sayfa=kullanicilar"><i class="fa-solid fa-user"></i> KULLANICILAR</a>
            <a href="?sayfa=talepler"><i class="fa-solid fa-bell"></i> BEKLEYEN TALEPLER</a>
            <a href="?sayfa=harcamalar_takip">
            <i class="fa-solid fa-bell"></i> TALEP TAKİP</a>
            <?php endif; ?>
            <a href="?sayfa=harcamalar"><i class="fa-solid fa-money-check-dollar"></i> HARCAMALAR</a>
            <a href="logout.php"><i class="fa-solid fa-right-from-bracket"></i> ÇIKIŞ YAP</a>    
        </ul>
    </div>
    <div class="main">
        <div class="topbar">
            <h3>BIG ANATOLIA</h3>
            <div class="profile">
                <div>
                    <strong><?php if (isset($_SESSION['rol']) && $_SESSION['rol'] === 'admin'): ?>
                    <dt><i class="fa-solid fa-crown"></i> ADMİN</dt>
                    <small></small>
                    <?php else: ?>
                    <dt><i class="fa-solid fa-user"></i> KULLANICI</dt>
                    <?php endif; ?>
                    </strong><br />
                </div>
            </div>
        </div>
        <div class="content">
            <div class="box">
                <?php
                $sayfa = $_GET['sayfa'] ?? 'anasayfa';
                include "sayfalar/{$sayfa}.php";
                ?>
            </div>
        </div>
    </div>
</div>





