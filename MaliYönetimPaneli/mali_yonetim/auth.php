<?php
if (!isset($_SESSION['giris']) || $_SESSION['giris'] !== true) {
    header("Location: /mali_yonetim/login.php");
    exit;
}