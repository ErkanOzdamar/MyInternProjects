<?php
if (session_status() === PHP_SESSION_NONE){
session_start();
} 
include __DIR__ . '/../config.php';

// Silme talebi gelirse
if ($_SERVER['REQUEST_METHOD'] === 'POST' && ($_POST['action_type'] ?? '') === 'delete') {
    $harcamaId   = $_POST['harcama_id'];
    $kullaniciId = $_SESSION['id'];
    $jsonData    = $_POST['veri']; // harcama_sil.php tarafından hazırlandı

    $stmt = $pdo->prepare("
        INSERT INTO harcama_talepleri
            (harcama_id, kullanici_id, veri, action_type)
        VALUES (?, ?, ?, 'delete')
    ");
    $stmt->execute([
        $harcamaId,
        $kullaniciId,
        $jsonData
    ]);

    header('Location: ?sayfa=harcamalar');
    exit;
}

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    header('Location: ?sayfa=harcamalar');
    exit;
}

// POST ile gelen verileri JSON haline getir
$harcamaId   = $_POST['harcama_id'];
$kullaniciId = $_SESSION['id'];
$payload = [
    'odeme_turu'   => $_POST['odeme_tipi'],
    'tarih'        => $_POST['harcama_tarihi'],
    'harcama_yeri' => $_POST['yer'],
    'aciklama'     => $_POST['sebep'],
    'tutar'        => $_POST['tutar']
];
$jsonData = json_encode($payload, JSON_UNESCAPED_UNICODE);

// 2. Mevcut harcamayı çek (eski veri için) 
$stmt2 = $pdo->prepare("SELECT * FROM harcamalar WHERE id = ?");
$stmt2->execute([$harcamaId]);
$h = $stmt2->fetch(PDO::FETCH_ASSOC);

if ($h) {
    $eskiJson = json_encode([
        'odeme_turu'   => $h['odeme_turu'],
        'tarih'        => $h['tarih'],
        'harcama_yeri' => $h['harcama_yeri'],
        'aciklama'     => $h['aciklama'],
        'tutar'        => $h['tutar']
    ], JSON_UNESCAPED_UNICODE);

    // 3. lastData tablosuna eski ve yeni veriyi kaydet 
    $stmtLast = $pdo->prepare("
        INSERT INTO lastData
            (harcama_id, eski_data, yeni_data, action_type)
        VALUES (?, ?, ?, 'update')
    ");
    $stmtLast->execute([
        $harcamaId,
        $eskiJson,
        $jsonData
    ]);
}

// 4. Talebi harcama_talepleri tablosuna kaydet 
$stmt = $pdo->prepare("
    INSERT INTO harcama_talepleri
        (harcama_id, kullanici_id, veri)
    VALUES (?, ?, ?)
");
$stmt->execute([
    $harcamaId,
    $kullaniciId,
    $jsonData
]);

header('Location: ?sayfa=harcamalar');
