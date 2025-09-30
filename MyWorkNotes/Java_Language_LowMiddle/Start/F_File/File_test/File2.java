package File_test;

/*
import java.io.IOException;
import java.util.Date;
import java.io.File;
public class File2 {
    public static void main(String[] args) {
        File file=new File("C:\\metin.txt");
        System.out.println("File Name:"+file+":");
        System.out.println("Mevcut mu?"+file.exists());
        System.out.println("Bir Klasör Mü?"+file.isDirectory());
        System.out.println("Bir dosya mi?"+file.isFile());
        System.out.println("Gizli Dosya mi?"+file.isHidden());
        Date tarih=new Date(file.lastModified());
        System.out.println("Son güncelleme tarihi:"+tarih);
    }    
}
*/




/* 
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
public class File2 {
    public static void main(final String[] args)throws IOException{
        Path file = new File("C:\\metin.txt").toPath();
        System.out.println("File Name:"+file+":");
        System.out.println("Bir Klasör Mü?"+Files.isDirectory(file));
        System.out.println("Bir dosya mi?"+Files.isRegularFile(file));
        System.out.println("Mevcut mu?"+Files.exists(file));
        System.out.println("Gizli dosya mı?"+Files.isHidden(file));
        FileTime tarih=Files.getLastModifiedTime(file);
        System.out.println("Son güncelleme tarihi:"+tarih);
    }
}
*/





/*
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class File2 {
    public static void main(String[] args)throws IOException{
        File dosya=new File("C:\\dosyam\\metin.txt");
        dosya.createNewFile();
        FileWriter dYaz=new FileWriter(dosya);
        Scanner input=new Scanner(System.in);
        System.out.println("Dosyaya yazilacak metin:");
        dYaz.write(input.next());
        dYaz.flush();
        dYaz.close();
    }
}
*/



/*
import java.io.*;
public class File2{
    public static void main(String[] args)throws IOException{
        int i;
        File dosya=new File("C:\\dosyam\\metin2.txt");
        FileInputStream dOku=new FileInputStream(dosya);
        do{
           i=dOku.read();
           if(i != -1){
            System.out.print((char) i);
           }
        }while(i != -1);
    dOku.close();    
    }    
}
*/
//Yada
/*
import java.io.*;
public class File2 {
    private static BufferedReader dOku;
    public static void main(String[] args)throws IOException{
        File dosya=new File("C:\\dosyam\\metin2.txt");
        dOku = new BufferedReader(new FileReader(dosya));
        while(true){
            if(!dOku.ready()){
                break;
            }
        String str= dOku.readLine();
        System.out.println(str);        
        } 
    }    
}
*/












//BİR DOSYAYI DİĞER DOSYAYA KOPYALAMA
/*
import java.io.*;
public class File2{
    public static void main(String[] args){
        try{
            File dosy1=new File("C:\\dosyam\\metin.txt");
            File dosy2=new File("C:\\dosyam\\metin2.txt");
            BufferedReader br=new BufferedReader(new FileReader(dosy1));
            BufferedWriter bw=new BufferedWriter(new FileWriter(dosy2));
            String satir;
            while((satir=br.readLine())!=null){
                bw.write(satir);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
        }
        catch(IOException ioe){
            //okuma yazma hatasi
        } 
    }
}
*/








//METİN DOSYASINA VERİ EKLEMEK:
/*
import java.io.*;
public class File2{
    public static void main(String[] args)throws IOException{
        File dosya=new File("C:\\dosyam\\metin2.txt");
        BufferedWriter dYaz=new BufferedWriter(new FileWriter(dosya,true));
        String str;
        str="ne güzeldir onlar";
        dYaz.write(str);
        dYaz.close();
    }
}
*/






//BİNARY DOSYALARI:
/*
import java.io.*;
public class File2{
    public static void main(String[] args)throws IOException{
        char arrays[] = {'x', 'y', 'z'};
        File dosya = new File("C:\\dosyam\\Dosya.bin");
        ObjectOutputStream aDosya = new ObjectOutputStream(new FileOutputStream(dosya));
        aDosya.writeObject(arrays);
        aDosya.close();
    }
}
*/








/*
import java.io.*;
public class File2{
    public static void main(String[] args)throws IOException,ClassNotFoundException{
        File dosya = new File("C:\\dosyam\\Dosya.bin");
        ObjectInputStream bDosya = new ObjectInputStream(new FileInputStream(dosya));
        byte[] dOku = (byte[]) bDosya.readObject();
        bDosya.close();
        String str = new String(dOku);
        System.out.println(str);

    }
}
*/






















































































































