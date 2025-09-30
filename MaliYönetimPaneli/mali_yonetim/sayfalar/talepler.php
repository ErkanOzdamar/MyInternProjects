<?php
// admin rol kontrolü
if ($_SESSION['rol'] !== 'admin') {
    header('Location: ?sayfa=anasayfa'); 
}

include __DIR__ . '/../config.php';

// Onay/red işlem parametreleri
if (isset($_GET['action'], $_GET['id'])) {
    $action  = $_GET['action'];    // 'approve' veya 'reject'
    $talepId = (int)$_GET['id'];

    // Talebi veritabanından çek
    $t = $pdo->prepare("
        SELECT ht.*, h.* 
        FROM harcama_talepleri ht
        LEFT JOIN harcamalar h ON h.id = ht.harcama_id
        WHERE ht.id = ? AND ht.durum = 'pending'
    ");
    $t->execute([$talepId]);
    $talep = $t->fetch(PDO::FETCH_ASSOC);

    if ($talep) {
        $harcamaId   = (int)$talep['harcama_id'];
        $actionType  = $talep['action_type']; // 'update' veya 'delete'
        $jsonPayload = $talep['veri'];
        $data        = json_decode($jsonPayload, true);
        
        // Mevcut harcama kaydını çek (eski veri)
        $oldStmt = $pdo->prepare("SELECT * FROM harcamalar WHERE id = ?");
        $oldStmt->execute([$harcamaId]);
        $oldRow = $oldStmt->fetch(PDO::FETCH_ASSOC);

        // --- 1) ONAY İŞLEMİ ---
        if ($action === 'approve') {

            if ($actionType === 'delete'){
                // 1.a) Silme onayı: Eski veriyi lastData'ya kaydet, sonra sil
              if ($oldRow){
                          $eskiJson = json_encode([
        'odeme_turu'   => $oldRow['odeme_turu'],
        'tarih'        => $oldRow['tarih'],
        'harcama_yeri' => $oldRow['harcama_yeri'],
        'aciklama'     => $oldRow['aciklama'],
        'tutar'        => $oldRow['tutar']
    ], JSON_UNESCAPED_UNICODE);

    // 2) lastData'ya pending kayıt olarak ekle
    $insLast = $pdo->prepare("
        INSERT INTO lastData (harcama_id, eski_data, yeni_data, action_type, durum)
        VALUES (?, ?, ?, 'delete', 'pending')
    ");
    $insLast->execute([
        $harcamaId,
        $eskiJson,
        json_encode(null)  // yeni_data boş JSON
    ]);


    // 4) Silme sonrası durumu approved yap
    $updLast = $pdo->prepare("
        UPDATE lastData
        SET durum = 'approved',
            changed_at = CURRENT_TIMESTAMP
        WHERE harcama_id = ? AND durum = 'pending'
        ORDER BY changed_at DESC
        LIMIT 1
    ");
    $updLast->execute([$harcamaId]);
    }
    
    $pdo->prepare("DELETE FROM harcamalar WHERE id = ?")
                    ->execute([$harcamaId]);
                $pdo->prepare("DELETE FROM harcama_talepleri WHERE id = ?")
                    ->execute([$talepId]);
                
            }
            else {
                // ----- B) Güncelleme onayı: Eski ve Yeni veriyi lastData'ya kaydet, sonra güncelle -----
                if ($oldRow) {
                    $eskiJson = json_encode([
                        'odeme_turu'   => $oldRow['odeme_turu'],
                        'tarih'        => $oldRow['tarih'],
                        'harcama_yeri' => $oldRow['harcama_yeri'],
                        'aciklama'     => $oldRow['aciklama'],
                        'tutar'        => $oldRow['tutar']
                    ], JSON_UNESCAPED_UNICODE);

                    $yeniJson = json_encode([
                        'odeme_turu'   => $data['odeme_turu'],
                        'tarih'        => $data['tarih'],
                        'harcama_yeri' => $data['harcama_yeri'],
                        'aciklama'     => $data['aciklama'],
                        'tutar'        => $data['tutar']
                    ], JSON_UNESCAPED_UNICODE);

                    // lastData.durum = 'approved' olarak güncelle
                    $updLast = $pdo->prepare("
                        UPDATE lastData
                        SET durum = 'approved',
                            yeni_data = ?,
                            action_type = 'update',
                            changed_at = CURRENT_TIMESTAMP
                        WHERE harcama_id = ? AND durum = 'pending'
                        ORDER BY changed_at DESC
                        LIMIT 1
                    ");
                    $updLast->execute([
                        $harcamaId,
                        $yeniJson
                    ]);

                    $insertLast = $pdo->prepare("
                        INSERT INTO lastData 
                            (harcama_id, eski_data, yeni_data, action_type, durum)
                        VALUES (?, ?, ?, 'update', 'approved')
                    ");
                    $insertLast->execute([
                        $harcamaId,
                        $eskiJson,
                        $yeniJson
                    ]);
                }

                // Güncelleme işlemi
                $u = $pdo->prepare("
                    UPDATE harcamalar SET
                        odeme_turu   = ?,
                        tarih        = ?,
                        harcama_yeri = ?,
                        aciklama     = ?,
                        tutar        = ?
                    WHERE id = ?
                ");
                $u->execute([
                    $data['odeme_turu'],
                    $data['tarih'],
                    $data['harcama_yeri'],
                    $data['aciklama'],
                    $data['tutar'],
                    $harcamaId
                ]);
            }

            // 2) Harcama taleplerinden bu kaydı sil 
            $pdo->prepare("DELETE FROM harcama_talepleri WHERE id = ?")
                ->execute([$talepId]);
        }

        // --- 2) REDDİYORSA ---
        elseif ($action === 'reject') {
             if ($actionType === 'delete'){
                if ($oldRow){
                          $eskiJson = json_encode([
        'odeme_turu'   => $oldRow['odeme_turu'],
        'tarih'        => $oldRow['tarih'],
        'harcama_yeri' => $oldRow['harcama_yeri'],
        'aciklama'     => $oldRow['aciklama'],
        'tutar'        => $oldRow['tutar']
    ], JSON_UNESCAPED_UNICODE);

    // 2) lastData'ya pending kayıt olarak ekle
    $insLast = $pdo->prepare("
        INSERT INTO lastData (harcama_id, eski_data, yeni_data, action_type, durum)
        VALUES (?, ?, ?, 'delete', 'pending')
    ");
    $insLast->execute([
        $harcamaId,
        $eskiJson,
        json_encode(null)  // yeni_data boş JSON
    ]);


    // 4) Silme sonrası durumu approved yap
    $updLast = $pdo->prepare("
        UPDATE lastData
        SET durum = 'rejected',
            changed_at = CURRENT_TIMESTAMP
        WHERE harcama_id = ? AND durum = 'pending'
        ORDER BY changed_at DESC
        LIMIT 1
    ");
    $updLast->execute([$harcamaId]);}
             }else{
                
                $updLast = $pdo->prepare("
                UPDATE lastData
                SET durum = 'rejected'
                WHERE harcama_id = ? AND durum = 'pending'
                ORDER BY changed_at DESC
                LIMIT 1
                ");
            
                $updLast->execute([
                    $harcamaId
                ]);
             }
            // talepler tablosundan sil
            $pdo->prepare("DELETE FROM harcama_talepleri WHERE id = ?")
                ->execute([$talepId]);
        }
    }

    header('Location: ?sayfa=talepler');
    exit;
}

// bekleyenleri listele
$liste = $pdo->query("
  SELECT 
    ht.id,
    ht.harcama_id,
    ht.kullanici_id,
    ht.veri,
    ht.action_type,       -- action_type burada eklendi
    ht.created_at,
    k.kullanici_adi
  FROM harcama_talepleri ht
  JOIN kullanicilar k ON k.id = ht.kullanici_id
  WHERE ht.durum = 'pending'
")->fetchAll(PDO::FETCH_ASSOC);
?>

<head>
<link rel="stylesheet" href="/mali_yonetim/css/style3.css">
</head>


<table>
<tbody>
  <tr>
  <th>#</th>
  <th>Kullanıcı</th>
  <th>Talep Türü</th>
  <th>Tarih</th>
  <th>İşlem</th>
</tr>
<?php $i  =  1; foreach($liste as $row): ?>
<tr>
  <td><?=$i++?></td>
  <td><?=htmlspecialchars($row['kullanici_adi'])?></td>
  <td>
    <?php if ($row['action_type'] === 'delete'): ?>
    <?='Silme Talebi'?>
    <?php else: ?>
    <?='Güncelleme Talebi' ?>            
    <?php endif; ?>
  </td>
  <td><?=$row['created_at']?></td>
  <td>
    <a class="green"  href="?sayfa=talepler&action=approve&id=<?=$row['id']?>">Onayla</a>
    <a class="red"    href="?sayfa=talepler&action=reject&id=<?=$row['id']?>">Reddet</a>
  </td>
</tr>
<?php endforeach; ?>
</tbody>
</table>
