package z_fileNote;








//FİLE-PATH SINIFLARI:
//
//File değişken_adı = new File ("dosya_adi ve yolu");
//File dosya = new File("D:\\Test\\Dosya.bin");
//
//import java.io.*;
//şeklinde import edilmelidir.

//====================================

//import java.nio.file.*;
//şeklinde import edilmelidir.
//
//Path değişken_adı = Paths.get("dosya_adi ve yolu");
//Path dosya = Paths.get("D:\\Test\\Dosya.bin");


//FİLE--------------PATH        ORTAK METOTLAR:
//createNewFile()   createFile()           dosya oluşturur      
//delete()          delete()               dosya veya klasörü siler
//exists()          exists()               dosya veya klasör mevcutsa true değerini döndürür        
//isFile()          Files.isFile(dsy)      dosya ise true değerini döndürür
//isDirectory()     Files.isDirectory(dsy) klasör ise true değerini döndürür
//getName()         getName()              dosyanın adını döndürür
//                  getFileName()
//toString()        toString()             dosyanın yolunu döndürür

//new FileOutputStream(dsy)         Files.newOutputStream        dosya yazma
//new FileInputStream(dsy)          Files.newInputStream         dosya okuma    amaçlı açar
//file.lenght()     Files.size(path)       dosyanın byte cinsinden uzunluğunu verir






//STREAM KAVRAMI:
//Stream veri akışı anlamına gelir.
//En genel tabiriyle veriyi hedef gönderen veya alan nesneye denir.
//Kaynak ile hedef arasındaki veriyi yönetirler.
//tüm giriş/çıkış işlemleri (I/O) veri akışı sistemine dayanır
//Tüm stream sınıfları java.lang.object sınıfından türetilir;
//java.io.InputStream
//java.io.OutputStream
//java.io.Reader
//java.io.Writer




//GENEL METOTLAR:
//mkdir()  klasör oluşturur
//getAbsolutePath()   dosya yolunu elde eder
//lenght() dosyanın byte cinsinden uzunluğunu verir
//exists() dosya yada klasör mevcutsa true değerini döndürür
//isFile() dosya ise true
//isDirectory() klasör ise true
//lastModified() dosyanın son değiştirilme tarihini verir
//renameTo()  dos.renameTo(dosya);
//write() dosyaya veri yazar
//append() dosyaya veri ekler
//print() dosyaya veri yazar
//println() dosyaya veri yazar
//read() dosyadan veri okur
//next() dosyadan boşluk karakterine kadar veri okur
//nextLine() dosyadan satır satır veri okur
//seek() dosya işaretçisinin belirttiği bir kaynağa gider
//readDouble() dosyadan double türde veri okur
//writeDouble() dosyaya double türünde veri yazar
//readObject() dosyadan byte türünde veri okur
//writeObject() dosyaya byte şeklinde veri yazar
//flush()    veri akış kanalını temizler
//close()  dosyayı kapatır(path otomatik kapanır gerekmez.)



//METİN DOSYASINDAN VERİ OKUMAK:
//read()-readLine() metotları kullanılır.
//read() okunacak kayıt kalmadığında -1 döndürür.
//readLine() null sonucunu döndürür.
//okuma bittiğinde close() ile veri akışı kapatılır.
//
//import java.io.File; import edilmelidir
//File dosya= new File(dosya adı ve yolu);
//FileReader veya FileInputStream ile dosya açılır
//döngü ile tüm kayıtları oku...
//dOku.close(); dosyayı kapat






//İKİLİ DOSYALAR(BİNARY FİLES):
//resim,ses, video verileri içeren dosyalardır.
//metin dosyası olmayan tüm dosyalar genelde binary dosyasıdır.

































































































