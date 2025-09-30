DROP TABLE IF EXISTS kullanicilar;

CREATE TABLE kullanicilar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_adi VARCHAR(50) NOT NULL UNIQUE,
    sifre VARCHAR(255) NOT NULL,
    rol ENUM('admin', 'kullanici') DEFAULT 'admin'
);

-- Şifre: admin123 (bcrypt ile hash'lenmiş)
INSERT INTO kullanicilar (kullanici_adi, sifre, rol) VALUES
('admin', '$2b$12$W37RE9bh.d4CMbEEjzYU2eiPaG4FOW1i5fsQZYvkTKBfmpl9KDPay', 'admin');


-- Harcamalar
CREATE TABLE IF NOT EXISTS harcamalar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    odeme_turu ENUM('kredi kartı', 'nakit') NOT NULL,
    tarih DATE NOT NULL,
    harcama_yeri VARCHAR(100) NOT NULL,
    aciklama VARCHAR(1200) NOT NULL,
    tutar DECIMAL(10,2) NOT NULL
);
--Harcama Talepleri
CREATE TABLE harcama_talepleri (
  id INT AUTO_INCREMENT PRIMARY KEY,
  harcama_id INT NOT NULL,
  kullanici_id INT NOT NULL,
  veri JSON NOT NULL,
  action_type ENUM('update','delete') NOT NULL DEFAULT 'update',
  durum ENUM('pending','approved','rejected') NOT NULL DEFAULT 'pending',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--Eski Talep Tablosu 
CREATE TABLE IF NOT EXISTS lastData (
    id INT AUTO_INCREMENT PRIMARY KEY,
    harcama_id INT NOT NULL,
    eski_data JSON NOT NULL,
    yeni_data JSON NOT NULL,
    action_type ENUM('update','delete') NOT NULL DEFAULT 'update',
    durum ENUM('pending','approved','rejected') NOT NULL DEFAULT 'pending',
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
