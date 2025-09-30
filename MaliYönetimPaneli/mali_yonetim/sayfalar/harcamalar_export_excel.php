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

// PhpSpreadsheet yüklemesi (composer autoload)
require __DIR__ . '/../vendor/autoload.php';
use PhpOffice\PhpSpreadsheet\Spreadsheet;
use PhpOffice\PhpSpreadsheet\Writer\Xlsx;

// Çalışma kitabı oluştur
$spreadsheet = new Spreadsheet();
$sheet = $spreadsheet->getActiveSheet();

// Başlık satırları
$sheet->setCellValue('A1', 'ID');
$sheet->setCellValue('B1', 'Ödeme Türü');
$sheet->setCellValue('C1', 'Tarih');
$sheet->setCellValue('D1', 'Harcama Yeri');
$sheet->setCellValue('E1', 'Açıklama');
$sheet->setCellValue('F1', 'Tutar');

// Verileri satırlara yaz
$row = 2;
foreach ($harcamalar as $h) {
    $sheet->setCellValue('A1' . $row, $h['id']);
    $sheet->setCellValue('B1' . $row, $h['odeme_turu']);
    $sheet->setCellValue('C1' . $row, $h['tarih']);
    $sheet->setCellValue('D1' . $row, $h['harcama_yeri']);
    $sheet->setCellValue('E1' . $row, $h['aciklama']);
    $sheet->setCellValue('F1' . $row, $h['tutar']);
    $row++;
}

// HTTP header ayarları
header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
header('Content-Disposition: attachment; filename="harcamalar_' . $tarih_bas . '_' . $tarih_son . '.xlsx"');
header('Cache-Control: max-age=0');

// Dosyayı çıktı olarak gönder
$writer = new Xlsx($spreadsheet);
$writer->save('php://output');
exit;
?>