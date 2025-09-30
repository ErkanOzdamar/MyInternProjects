<?php

if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
?>

<?php
include 'config.php';
include 'auth.php';

$stmt = $pdo->query("SELECT * FROM kullanicilar ORDER BY id DESC");
$kullanicilar = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<a href="?sayfa=kullanici_ekle">+ Yeni Kullanıcı</a>

<table>
    <tr>
        <th>ID</th>
        <th>Kullanıcı Adı</th>
        <th>Rol</th>
        <th>İşlem</th>
    </tr>
    <?php foreach ($kullanicilar as $k): ?>
        <tr>
            <td><?= $k['id'] ?></td>
            <td><?= htmlspecialchars($k['kullanici_adi']) ?></td>
            <td><?= $k['rol'] ?></td>
            <td>
                <a class="red" href="/mali_yonetim/sayfalar/kullanici_sil.php?id=<?= $k['id'] ?>" onclick="return confirm('Silinsin mi?')">Sil</a>
                <a class="green" href="/mali_yonetim/sayfalar/yetki_degistir.php?id=<?= $k['id'] ?>">Yetki</a>
            </td>
        </tr>
    <?php endforeach; ?>
</table>

