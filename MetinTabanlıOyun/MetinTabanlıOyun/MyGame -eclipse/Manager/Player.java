package Manager;
import java.util.*;

import Inventory.Inventory;
import Inventory.Storage;

public class Player{
    private String name,cName;
    private int money,dmg,heal;
    protected Inventory inv;
    protected Storage str;
    Scanner scan = new Scanner(System.in);
    
    public Player(String name){
        this.name = name;
        this.inv = new Inventory();
        this.str = new Storage(); 
    }

    public void initPlayer(String cName, int dmg, int heal, int money){
        setCname(cName);
        setDamage(dmg);
        setHeal(heal);
        setMoney(money);
    }
    
    public String getCname(){
        return cName;
    }
    public void setCname(String cName){
        this.cName = cName;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getDamage(){
        return dmg;
    }
    public void setDamage(int dmg){
        this.dmg = dmg;
    }
    public int getHeal(){
        return heal;
    }
    public void setHeal(int heal){
        this.heal = heal;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public Inventory getInv(){
        return inv;
    }
    public void setInv(Inventory inv){
        this.inv = inv;
    }
    public Storage getStr(){
        return str;
    }
    public void setStr(Storage str){
        this.str = str;
    }
    public void clean(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public void bar(){
        System.out.println("==========================================================");
    }





    public void selectCharacter(){
        switch (chaMenu()){
            case 1:
                initPlayer("Adam", 20, 40, 60);
                break;
            case 2:
                initPlayer("Adam", 25, 50, 40);
                break;
            default:
                initPlayer("Adam", 20, 40, 60);
                break; 
        }
        System.out.println("Sevgili "+getName()+" Karakterin oluşturuldu!");
        bar();
        System.out.println("İsmin:"+getCname()+"  Hasarın:"+getDamage()+"  Canın:"+getHeal()+"  Varlığın:"+getMoney()+" Dolar");
    }

    public int chaMenu(){
        System.out.println("Karakter Seçimi:");
        System.out.println("1)Kırmızı Hap 2)Mavi Hap");
        System.out.print("Seçiminiz:");
        int chaId = scan.nextInt();

        while(chaId < 1 || chaId > 2){
            System.out.println("Mevcut olan bir karakter seçimi yapınız!");
            bar();
            System.out.print("Seçiminiz:");
            chaId = scan.nextInt();
        }
        return chaId;
    }
    public void Tutorial1(){
        clean();
        System.out.println("Telsiz cızırtısı...");
        System.out.println("zzztt...");
        bar();
        System.out.print("Caluem Radyosu:\n");
        bar();
        System.out.println("Büyük felaketten sağ kalanlara sesleniyoruz!!!");
        System.out.println("Saklandığınz yerden çıkın ve medeniyeti bulunduğunuz yerde tekrar kurun...");
        System.out.println("Öldürmeyin...Birbirimize ihtiyacımız var!");
        System.out.println("Güzel gelecekte beraber olmak üzere sağlıcakla kalın...");
        System.out.println("zzzzttt...");
        bar();
    }
}
