<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
include __DIR__ . '/../config.php';
if (ob_get_level()) {
  ob_end_clean();
}
// Tarih aralığı kontrolleri
$tarih_bas = $_GET['tarih_bas'] ?? '';
$tarih_son = $_GET['tarih_son'] ?? '';
if (!$tarih_bas || !$tarih_son) {
    die('Tarih aralığı seçilmedi.');
}

// Verileri çek
$stmt = $pdo->prepare("
  SELECT id, odeme_turu, tarih, harcama_yeri, aciklama, tutar
  FROM harcamalar
  WHERE tarih BETWEEN :tarih_bas AND :tarih_son
  ORDER BY tarih DESC
");
$stmt->execute([
  ':tarih_bas' => $tarih_bas,
  ':tarih_son' => $tarih_son
]);
$harcamalar = $stmt->fetchAll(PDO::FETCH_ASSOC);

// TCPDF yüklemesi (composer autoload)
require __DIR__ . '/../vendor/autoload.php';


// PDF nesnesi oluştur
$pdf = new TCPDF('P', 'mm', 'A4', true, 'UTF-8', false);
$pdf->SetCreator('Mali Yönetim Sistemi');
$pdf->SetAuthor('Sistem');
$pdf->SetTitle('Harcama Detayları ' . $tarih_bas . ' - ' . $tarih_son);
$pdf->SetMargins(10, 10, 10);
$pdf->AddPage();

// Başlık
$pdf->SetFont('dejavusans', '', 14);
$pdf->Cell(0, 10, 'Harcama Detayları (' . $tarih_bas . ' - ' . $tarih_son . ')', 0, 1, 'C');
$pdf->Ln(4);

// Tablo başlıkları
$pdf->SetFont('dejavusans', 'B', 10);
$tbl_header = '
<table border="1" cellpadding="4">
  <tr>
    <th align="center">ID</th>
    <th align="center">Ödeme Türü</th>
    <th align="center">Tarih</th>
    <th align="center">Harcama Yeri</th>
    <th align="center">Açıklama</th>
    <th align="center">Tutar (₺)</th>
  </tr>
';
$tbl_footer = '</table>';

// Tablo satırlarını oluştur
$pdf->SetFont('dejavusans', '', 9);
$tbl = '';
foreach ($harcamalar as $h) {
    $tbl .= '<tr>';
    $tbl .= '<td align="center">' . $h['id'] . '</td>';
    $tbl .= '<td>' . htmlspecialchars($h['odeme_turu']) . '</td>';
    $tbl .= '<td>' . htmlspecialchars($h['tarih']) . '</td>';
    $tbl .= '<td>' . htmlspecialchars($h['harcama_yeri']) . '</td>';
    $tbl .= '<td>' . htmlspecialchars($h['aciklama']) . '</td>';
    $tbl .= '<td align="right">' . number_format($h['tutar'], 2, ',', '.') . '</td>';
    $tbl .= '</tr>';
}

// HTML olarak tabloyu ekle ve çıktı al
$pdf->writeHTML($tbl_header . $tbl . $tbl_footer, true, false, false, false, '');
$pdf->Output('harcamalar_' . $tarih_bas . '_' . $tarih_son . '.pdf', 'D');
exit;
?>