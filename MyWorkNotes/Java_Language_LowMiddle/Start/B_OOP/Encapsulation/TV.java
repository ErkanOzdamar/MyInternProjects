package Encapsulation;

public class TV {
    private int boy;
    private int en;
    private int yükseklik;

    //setter fonksiyonları
    public void setUz(int p){
        boy=p;
    }
    public void setEn(int p){
        en=p;
    }
    public void setYük(int p){
        yükseklik=p;
    }

    //getter fonksiyonları
    public int getSes(){
        return (boy*en*yükseklik);
    }



    public static void main(String[] args) {
        TV nesne=new TV();
        float ses;
        nesne.setUz(10);
        nesne.setEn(8);
        nesne.setYük(6);
        ses=nesne.getSes();
        System.out.println("Ses Ayarı:"+ses+" Birim");
    }
}
