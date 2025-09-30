<?php
session_start();
session_destroy();
header("Location: /mali_yonetim/login.php");
exit;
?>