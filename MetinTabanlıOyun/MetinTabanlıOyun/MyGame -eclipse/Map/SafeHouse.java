package Map;
import java.util.Scanner;

import Location.Location;
import Location.NormalLoc;
import Manager.Camp;
import Manager.People;
import Manager.Player;

public class SafeHouse extends NormalLoc{
    Scanner scan = new Scanner(System.in);
    boolean menuLoop = true;
    Location location;
    
    public SafeHouse(Player player, People people, Camp camp, String name){
        super(player, people, camp, "Güvenli Ev");
    }

    public boolean getLocation(){
        CampMenu();
        return true;
    }
    public void CampMenu(){
        clean();
        while(menuLoop){
            escape();
            bar();
            if(player.getInv().getDay() > 11){
                System.out.println("1. Fişek ateşle:");
            }
            System.out.println("2. Vatandaşları geliştir");
            System.out.println("3. Kampı geliştir");
            System.out.println("4. Tarlanı ek");
            System.out.println("5. Depoda Giyin:");
            System.out.println("6. Genel Üs Raporu:");
            System.out.println("7. Kamptan çık:");
            bar();
            System.out.print("Yapmak istediğin iş:");
            int selLoop = scan.nextInt();

            if(player.getInv().getDay() < 12){
                while(selLoop < 2 || selLoop > 7){
                    System.out.print("Mevcut iş seçiniz! *:");
                    selLoop = scan.nextInt();
                }
            }else{
                while(selLoop < 1 || selLoop > 7){
                    System.out.print("Mevcut iş seçiniz! *:");
                    selLoop = scan.nextInt();
                }
            }
            
            switch(selLoop){
                case 1:
                clean();
                if(player.getInv().getDay() > camp.getSenarioLevel()*10){
                    location = new SafeHouseWar(player, people, camp, "Üs Baskını");
                    System.out.println("Savaşı kazandın!");
                }else{
                    System.out.println("Yakınlar da yaklaşan düşman grubu yok!");
                }
                    break;
                case 2:
                    PeopleWearing();
                    break;
                case 3:
                    buildCamp();
                    break;
                case 4:
                    farm();
                    break;
                case 5:
                    playerWearing();
                    break;
                case 6:
                    clean();
                    rapor();
                    try{
                        for(int i=1; i>0; i--){
                            
                            Thread.sleep(10000);
                            clean();
                        }
                    }catch(Exception e){
                        System.out.println("Something get wrong");
                    }
                    break;
                case 7:
                    clean();
                    menuLoop = false;    
            }
        }
    }
    
    public void farm(){
        if(player.getInv().getDay() > camp.getFarmLimit()){
            clean();
        System.out.println("Tarlana geldin!");
        bar();
            try{
                for(int i=1; i<6; i++){
                    System.out.println("Tarlanı Ekiyorsun!");
                    Thread.sleep(1000);
                    bar();
                }
            }catch(Exception e){
                System.out.println("Something get wrong");
            }
            clean();    
        player.getInv().setFood(player.getInv().getFood()+player.getInv().getFarmFood());
        bar();
        System.out.println(player.getInv().getFarmFood()+" Çuval mahsül aldın!");
        camp.setFarmLimit(camp.getFarmLimit()+3);
        }else{
            clean();
            bar();
            System.out.println("Tarla mahsül vermeye hazır değil!");
        }
    }

    public void playerWearing(){
        clean();
        bar();
        System.out.println("Depodaki Ekipmanların:");
        bar();
        
            switch (player.getStr().getWearingStore()){
                case -2:
                   clean();
                   System.out.println("Böyle bir ekipman mevcut değil!");
                   break;
                case -1:
                   clean();
                   break;  
                case 1:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setWname("AK47");
                    player.getInv().setDamage(40);
                    break;
                case 2:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setAname("Balistik Zırh");
                    player.getInv().setArmor(80);
                    break;
                case 3:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setAname("Çelik Yelek");
                    player.getInv().setArmor(30);
                    break;
                case 4:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setWname("M4");
                    player.getInv().setDamage(60);
                    break;
                case 5:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setWname("Pala");
                    player.getInv().setDamage(5);
                    break;
                case 6:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setAname("Askeri Sınıf Zırh");
                    player.getInv().setArmor(60);
                    break;
                case 7:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setWname("9mm");
                    player.getInv().setDamage(20);
                    break;
                case 8:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setAname("Plaka Zırh");
                    player.getInv().setArmor(45);
                    break;
                case 9:
                clean();
                System.out.println("Ekipman Alındı!");                                
                    player.getInv().setAname("Polis Ekipmanarı");
                    player.getInv().setArmor(50);
                    break;
                case 10:
                clean();
                System.out.println("Ekipman Alındı!");
                    player.getInv().setWname("Çete Stil Uzi");
                    player.getInv().setDamage(35);
                    break;    
                }
    }
    
    public void PeopleWearing(){
        clean();
        bar();
        System.out.println("Depodaki Ekipmanların:");
        bar();
        
            switch (player.getStr().getWearingStore()){
                case -2:
                   clean();
                   System.out.println("Böyle bir ekipman mevcut değil!");
                   break;
                case -1:
                   clean();
                   break;
                case 1:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setWname("AK47");
                    people.getPeopleInv().setDamage(40);
                    break;
                case 2:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setAname("Balistik Zırh");
                    people.getPeopleInv().setArmor(80);
                    break;
                case 3:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setAname("Çelik Yelek");
                    people.getPeopleInv().setArmor(30);
                    break;
                case 4:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setWname("M4");
                    people.getPeopleInv().setDamage(60);
                    break;
                case 5:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setWname("Pala");
                    people.getPeopleInv().setDamage(5);
                    break;
                case 6:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setAname("Askeri Sınıf Zırh");
                    people.getPeopleInv().setArmor(60);
                    break;
                case 7:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setWname("9mm");
                    people.getPeopleInv().setDamage(20);
                    break;
                case 8:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setAname("Plaka Zırh");
                    people.getPeopleInv().setArmor(45);
                    break;
                case 9:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");                                
                    people.getPeopleInv().setAname("Polis Ekipmanarı");
                    people.getPeopleInv().setArmor(50);
                    break;
                case 10:
                clean();
                System.out.println("Ekipman Vatandaşlara Dağıtıldı!");
                    people.getPeopleInv().setWname("Çete Stil Uzi");
                    people.getPeopleInv().setDamage(35);
                    break;    
                }
    }

    public void buildCamp(){
        clean();
        boolean buildLoop = true;
        while(buildLoop){
            bar();
            System.out.println("1. Duvarlar:");
            System.out.println("2. Nöbetçi Kuleleri:");
            System.out.println("3. Barınma Alanları:");
            System.out.println("4. Tarlalar:");
            System.out.println("5. Gelişimden çık:");
            bar();
            System.out.print("Senin Geliştirme Emirlerin:");
            int buildSel = scan.nextInt();

            while(buildSel < 1 || buildSel > 5){
                System.out.print("Mevcut emir seçiniz! *:");
                buildSel = scan.nextInt();
            }

            switch (buildSel){
                case 1:
                    buildCampWall();
                    break;
                case 2:
                    buildCampTower();
                    break;
                case 3:
                    buildCampShelter();
                    break;
                case 4:
                    buildCampFarm();
                    break;
                case 5:
                    clean();
                    buildLoop = false;
                break;     
            }     
        }
    }

    public void buildCampWall(){
        clean();
        boolean buildWallLoop = true;

        while(buildWallLoop){
            bar();
            System.out.println("Odun:"+player.getInv().getWood()+" Taş:"+player.getInv().getRock());
            bar();
            System.out.println("1. Odun Duvarlar:[Düşük Kamp Koruması][60:Odun]");
            System.out.println("2. Taş Duvarlar:[Orta Kamp Koruması][80:Taş]");
            System.out.println("3. Gelişmiş Taş Duvarlar:[Yüksek Kamp Koruması][120:Taş 80:Odun]");
            System.out.println("4. Gelişimden çık:");
            bar();
            System.out.print("Senin Geliştirme Emirlerin:");
            int buildSel = scan.nextInt();

            while(buildSel < 1 || buildSel > 4){
                System.out.print("Mevcut yükseltme seçiniz! *:");
                buildSel = scan.nextInt();
            }

            switch (buildSel){
                case 1:
                if(player.getInv().getWood() >= 60 && !(camp.getWallN() == "Odun Duvarlar!")){
                    player.getInv().setWood(player.getInv().getWood()-60);
                    camp.setWallN("Odun Duvarlar!");
                    camp.setWallA(100);
                    clean();
                    System.out.println(camp.getWallN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 2:
                if(player.getInv().getRock() >= 80 && !(camp.getWallN() == "Taş Duvarlar!")){
                    player.getInv().setRock(player.getInv().getRock()-80);
                    camp.setWallN("Taş Duvarlar!");
                    camp.setWallA(200);
                    clean();
                    System.out.println(camp.getWallN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 3:
                if(player.getInv().getRock() >= 120 && player.getInv().getWood() >= 80 && !(camp.getWallN() == "Gelişmiş Taş Duvarlar!")){
                    player.getInv().setWood(player.getInv().getWood()-80);
                    player.getInv().setRock(player.getInv().getRock()-120);
                    camp.setWallN("Gelişmiş Taş Duvarlar!");
                    camp.setWallA(400);
                    clean();
                    System.out.println(camp.getWallN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 4:
                    clean();
                    buildWallLoop = false;
                break;     
            }     
        }
    }

    public void buildCampTower(){
        clean();
        boolean buildTowerLoop = true;

        while(buildTowerLoop){
            bar();
            System.out.println("Odun:"+player.getInv().getWood()+" Taş:"+player.getInv().getRock());
            bar();
            System.out.println("1. Odun Kuleler:[Düşük Nöbetçi Koruması][45:Odun]");
            System.out.println("2. Taş Kuleler:[Orta Nöbetçi Koruması][85:Taş]");
            System.out.println("3. Gelişmiş Taş Kuleler:[Yüksek Nöbetçi Koruması][80:Taş 50:Odun]");
            System.out.println("4. Gelişimden çık:");
            bar();
            System.out.print("Senin Geliştirme Emirlerin:");
            int buildSel = scan.nextInt();

            while(buildSel < 1 || buildSel > 4){
                System.out.print("Mevcut yükseltme seçiniz! *:");
                buildSel = scan.nextInt();
            }

            switch (buildSel){
                case 1:
                if(player.getInv().getWood() >= 45 && !(camp.getTowerN() == "Odun Kuleler!")){
                    player.getInv().setWood(player.getInv().getWood()-45);
                    camp.setTowerN("Odun Kuleler!");
                    camp.setTowerA(100);
                    clean();
                    System.out.println(camp.getTowerN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 2:
                if(player.getInv().getRock() >= 85 && !(camp.getTowerN() == "Taş Kuleler!")){
                    player.getInv().setRock(player.getInv().getRock()-85);
                    camp.setTowerN("Taş Kuleler!");
                    camp.setTowerA(200);
                    clean();
                    System.out.println(camp.getTowerN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 3:
                if(player.getInv().getRock() >= 80 && player.getInv().getWood() >= 50 && !(camp.getTowerN() == "Gelişmiş Taş Kuleler!")){
                    player.getInv().setWood(player.getInv().getWood()-50);
                    player.getInv().setRock(player.getInv().getRock()-80);
                    camp.setTowerN("Gelişmiş Taş Kuleler!");
                    camp.setTowerA(400);
                    clean();
                    System.out.println(camp.getTowerN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 4:
                    clean();
                    buildTowerLoop = false;
                break;     
            }     
        }
    }

    public void buildCampFarm(){
        clean();
        boolean buildFarmLoop = true;
        
        while(buildFarmLoop){
            bar();
            System.out.println("Odun:"+player.getInv().getWood()+" Taş:"+player.getInv().getRock());
            bar();
            System.out.println("1. Düzenli Tarlalar:[40 mahsül kapasitesi][35:Odun]");
            System.out.println("2. Büyük Tarlalar:[80 mahsül kapasitesi][65:Odun]");
            System.out.println("3. Gelişmiş Tarlalar:[120 mahsül kapasitesi][50:Taş 50:Odun]");
            System.out.println("4. Gelişimden çık:");
            bar();
            System.out.print("Senin Geliştirme Emirlerin:");
            int buildSel = scan.nextInt();

            while(buildSel < 1 || buildSel > 4){
                System.out.print("Mevcut yükseltme seçiniz! *:");
                buildSel = scan.nextInt();
            }

            switch (buildSel){
                case 1:
                if(player.getInv().getWood() >= 35 && !(camp.getFarmSizeN() == "Düzenli Tarlalar!")){
                    player.getInv().setWood(player.getInv().getWood()-35);
                    camp.setFarmSizeN("Düzenli Tarlalar!");
                    player.getInv().setFarmFood(30);
                    clean();
                    System.out.println(camp.getFarmSizeN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 2:
                if(player.getInv().getWood() >= 65 && !(camp.getFarmSizeN() == "Büyük Tarlalar!")){
                    player.getInv().setWood(player.getInv().getWood()-65);
                    camp.setFarmSizeN("Büyük Tarlalar!");
                    player.getInv().setFarmFood(40);
                    clean();
                    System.out.println(camp.getFarmSizeN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 3:
                if(player.getInv().getRock() >= 50 && player.getInv().getWood() >= 50 && !(camp.getFarmSizeN() == "Gelişmiş Tarlalar!")){
                    player.getInv().setWood(player.getInv().getWood()-50);
                    player.getInv().setRock(player.getInv().getRock()-50);
                    camp.setFarmSizeN("Gelişmiş Tarlalar!");
                    player.getInv().setFarmFood(50);
                    clean();
                    System.out.println(camp.getFarmSizeN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 4:
                    clean();
                    buildFarmLoop = false;
                break;     
            }
        }
    }

    public void buildCampShelter(){
        clean();
        boolean buildShelterLoop = true;
        
        while(buildShelterLoop){
            bar();
            System.out.println("Odun:"+player.getInv().getWood()+" Taş:"+player.getInv().getRock());
            bar();
            System.out.println("1. Odun Kulübeler:[5 vatandaş kapasitesi][20:Odun]");
            System.out.println("2. Geniş Odun Kulübeler:[10 vatandaş kapasitesi][100:Odun]");
            System.out.println("3. Büyük Taş Sığınak:[30 vatandaş kapasitesi][150:Taş 100:Odun]");
            System.out.println("4. Gelişimden çık:");
            bar();
            System.out.print("Senin Geliştirme Emirlerin:");
            int buildSel = scan.nextInt();

            while(buildSel < 1 || buildSel > 4){
                System.out.print("Mevcut yükseltme seçiniz! *:");
                buildSel = scan.nextInt();
            }

            switch (buildSel){
                case 1:
                if(player.getInv().getWood() >= 20 && !(camp.getFarmSizeN() == "Odun Kulübeler!")){
                    player.getInv().setWood(player.getInv().getWood()-20);
                    camp.setShelterN("Odun Kulübeler!");
                    people.setCommunityLimit(5);
                    clean();
                    System.out.println(camp.getShelterN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 2:
                if(player.getInv().getWood() >= 100 && !(camp.getFarmSizeN() == "Geniş Odun Kulübeler!!")){
                    player.getInv().setWood(player.getInv().getWood()-100);
                    camp.setShelterN("Geniş Odun Kulübeler!!");
                    people.setCommunityLimit(10);
                    clean();
                    System.out.println(camp.getShelterN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 3:
                if(player.getInv().getRock() >= 150 && player.getInv().getWood() >= 100 && !(camp.getFarmSizeN() == "Büyük Taş Sığınak!")){
                    player.getInv().setWood(player.getInv().getWood()-100);
                    player.getInv().setRock(player.getInv().getRock()-150);
                    camp.setShelterN("Büyük Taş Sığınak!");
                    people.setCommunityLimit(30);
                    clean();
                    System.out.println(camp.getShelterN()+" inşaa ediliyor...");
                }else{
                    clean();
                    System.out.println("Yetersiz kaynak yada yapı mevcut!");
                }
                    break;
                case 4:
                    clean();
                    buildShelterLoop = false;
                break;     
            }
        }
    }

    public void rapor(){
        bar();
        System.out.println("Kullanılan Alan:"+camp.getShelterN()+" Vatandaş kapasitemiz:"+people.getCommunityLimit());
        bar();
        System.out.println("Üs Savunması:");
        System.out.println("Tahkimatlar: "+camp.getWallN());
        System.out.println("Nöbetçi Kuleleri: "+camp.getTowerN());
        bar();
        System.out.println(camp.getFarmSizeN()+" Mahsül Verimi:"+player.getInv().getFarmFood());
        bar();
        if(people.getPeopleInv().getDamage() != 0 || people.getPeopleInv().getArmor() != 0){
            System.out.println("Vatandaşlara Dağılatılmış Ekipmanlar:");
            System.out.println("Silah:"+people.getPeopleInv().getWname());
            System.out.println("Zırh:"+people.getPeopleInv().getAname());
        }else{
            System.out.println("Vatandaşlara Ekipman Dağıtılmamış!");
        }
    }

    public void escape(){
        if(lootCount() > 9 && people.getCommunity() > 3){
            clean();
            bar();

                System.out.println("[Haydut]: 3 arkadaşın elimizde, 1000 dolar ödemezsen...");
                System.out.println("[Haydut]: Gözlerinin önünde dostlarının ölümünü izleyeceksin.");

            bar();
            aSleep();
            System.out.println("[Samael]: Alçaksınız...");
            aSleep();
            bar();

            System.out.println("[Samael]: 1)Öde      2)Ödeme");
            System.out.print("A:");
            int prisoner = scan.nextInt();

            while(prisoner < 1 || prisoner > 2){
                System.out.print("Mevcut tercih seçiniz! *:");
                prisoner = scan.nextInt();
            }
           
            if(prisoner == 1 && player.getMoney() > 1000){
                clean();
                bar();
                System.out.println("[Adam]: Onları kurtardık!");
                bar();
            }else if(prisoner == 1 && player.getMoney() < 1000){
                clean();
                bar();
                System.out.println("[Adam]: Lanet olsun!Hayır...");
                bar();
            }else if(prisoner == 2 && player.getMoney() > 1000){
                clean();
                bar();
                System.out.println("[Adam]: Sen alçak bir adamsın Samael!!!");
                bar();
            }else{
                clean();
                bar();
                System.out.println("[Adam]: Lanet olsun!Hayır...");
                bar();
            }
        }
    }
}
