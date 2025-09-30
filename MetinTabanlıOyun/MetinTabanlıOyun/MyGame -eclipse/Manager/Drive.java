package Manager;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.json.JSONObject;

import Location.Location;
import Map.Forest;
import Map.Mine;
import Map.SafeHouse;
import Map.Town;
import RandomSenario.Senario;

public class Drive{
    Player player;
    People people;
    Camp camp;
    Location location;
    Senario snr;
    Scanner scan = new Scanner(System.in);

    public void Login(){
        System.out.println("Hoşgeldiniz!");
        System.out.print("İsminiz:");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        people = new People();
        camp = new Camp();
        snr = new Senario();
        
        String userHome = System.getProperty("user.home");
		String desktopPath = userHome + "/Desktop/Game/" + player.getName() + "_data.json";
		File file = new File(desktopPath);
		
		if(file.isFile()){
			Start();
		}
        bar();
        player.selectCharacter();
        bar();
        /*try{
        for(int i=5; i>0; i--){
            
            Thread.sleep(1000);
            System.out.println("Oyun başlıyor!!!");
            System.out.println(i);
            bar();
        }
    }catch(Exception e){
        System.out.println("Something get wrong");
    }*/
        /*player.Tutorial1();
        try{
            for(int i=1; i>0; i--){
                Thread.sleep(15000);
                clean();
            }
        }catch(Exception e){
            System.out.println("Something get wrong");
        }
        snr.senario1();
        snr.senario2();
        try{
            for(int i=1; i>0; i--){
                Thread.sleep(10000);
                clean();
            }
        }catch(Exception e){
            System.out.println("Something get wrong");
        }*/
    }

    public void clean(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public void bar(){
        System.out.println("==========================================================");
    }
    
    
    public void save(){
    	try {
    		JSONObject obje1 = new JSONObject();
    		String userHome = System.getProperty("user.home");
    		String desktopPath = userHome + "/Desktop/Game/"+player.getName()+"_data.json";
    		Path filePath = Paths.get(desktopPath);
        	
    		//player 5
    		obje1.put("playerDamage", player.getDamage());
    		obje1.put("cName", player.getCname());//String
    		obje1.put("playerName", player.getName());//String
    		obje1.put("playerHeal", player.getHeal());
    		obje1.put("money", player.getMoney());
    		//player.ınvnetory 10
    		obje1.put("wood", player.getInv().getWood());
    		obje1.put("rock", player.getInv().getRock());
    		obje1.put("food", player.getInv().getFood());
    		obje1.put("farmFood", player.getInv().getFarmFood());
    		obje1.put("ınventoryDamage", player.getInv().getDamage());
    		obje1.put("armor", player.getInv().getArmor());
    		obje1.put("dayTime", player.getInv().getDayTime());
    		obje1.put("day", player.getInv().getDay());
    		obje1.put("wName", player.getInv().getWname());//String
    		obje1.put("aName", player.getInv().getAname());//String
    		//player.stroge 10
    		obje1.put("m4", player.getStr().getM4());//boolean all
    		obje1.put("ak47", player.getStr().getAk47());
    		obje1.put("nineMm", player.getStr().getNineMm());
    		obje1.put("machete", player.getStr().getMachete());
    		obje1.put("uzi", player.getStr().getUzi());
    		obje1.put("plaka", player.getStr().getPlaka());
    		obje1.put("policE", player.getStr().getPolicE());
    		obje1.put("military", player.getStr().getMilitary());
    		obje1.put("bulletProof", player.getStr().getBulletProof());
    		obje1.put("balisticVest", player.getStr().getBalisticVest());
    		//camp 14
    		obje1.put("wallN", camp.getWallN());//String
    		obje1.put("towerN", camp.getTowerN());//String
    		obje1.put("shelterN", camp.getShelterN());//String
    		obje1.put("farmSizeN", camp.getFarmSizeN());//String
    		obje1.put("wallA", camp.getWallA());
    		obje1.put("towerA", camp.getTowerA());
    		obje1.put("farmLimit", camp.getFarmLimit());
    		obje1.put("warWave", camp.getWarWave());
    		obje1.put("senarioLevelLoop", camp.getSenarioLevelLoop());
    		obje1.put("senarioLevel", camp.getSenarioLevel());
    		obje1.put("senarioLevelForest", camp.getSenarioLevelForest());
    		obje1.put("senarioLevelMine", camp.getSenarioLevelMine());
    		obje1.put("senarioLevelTown", camp.getSenarioLevelTown());
    		obje1.put("warWaveWalk", camp.getWarWaveWalk());
    		//people 4
    		obje1.put("community", people.getCommunity());
    		obje1.put("communityLimit", people.getCommunityLimit());
    		obje1.put("peopleHeal", people.getHeal());
    		obje1.put("peopleDamage", people.getDamage());
    		
        	Files.write(filePath, obje1.toString(4).getBytes());
    	}catch(Exception e){}
    }
    
    
    
    public void load(){
    	try{
    		String userHome = System.getProperty("user.home");
    		String desktopPath = userHome + "/Desktop/Game/"+player.getName()+"_data.json";
    		Path filePath = Paths.get(desktopPath);
    		String content = new String(Files.readAllBytes(filePath));
        	JSONObject obje2 = new JSONObject(content);
        	
        	//player 5
        	player.setDamage(obje2.getInt("playerDamage"));
        	player.setCname(obje2.getString("cName"));
        	player.setName(obje2.getString("playerName"));
        	player.setHeal(obje2.getInt("playerHeal"));
        	player.setMoney(obje2.getInt("money"));
        	//player.ınventory 10
        	player.getInv().setWood(obje2.getInt("wood"));
        	player.getInv().setRock(obje2.getInt("rock"));
        	player.getInv().setFood(obje2.getInt("food"));
        	player.getInv().setFarmFood(obje2.getInt("farmFood"));
        	player.getInv().setDamage(obje2.getInt("ınventoryDamage"));
        	player.getInv().setArmor(obje2.getInt("armor"));
        	player.getInv().setDayTime(obje2.getInt("dayTime"));
        	player.getInv().setDay(obje2.getInt("day"));
        	player.getInv().setWname(obje2.getString("wName"));
        	player.getInv().setAname(obje2.getString("aName"));
        	//player.Stroge 10
        	player.getStr().setM4(obje2.getBoolean("m4"));
        	player.getStr().setAk47(obje2.getBoolean("ak47"));
        	player.getStr().setNineMm(obje2.getBoolean("nineMm"));
        	player.getStr().setMachete(obje2.getBoolean("machete"));
        	player.getStr().setUzi(obje2.getBoolean("uzi"));
        	player.getStr().setPlaka(obje2.getBoolean("plaka"));
        	player.getStr().setPolicE(obje2.getBoolean("policE"));
        	player.getStr().setMilitary(obje2.getBoolean("military"));
        	player.getStr().setBulletProof(obje2.getBoolean("bulletProof"));
        	player.getStr().setBalisticVest(obje2.getBoolean("balisticVest"));
        	//camp 14
        	camp.setWallN(obje2.getString("wallN"));
        	camp.setTowerN(obje2.getString("towerN"));
        	camp.setShelterN(obje2.getString("shelterN"));
        	camp.setFarmSizeN(obje2.getString("farmSizeN"));
        	camp.setWallA(obje2.getInt("wallA"));
        	camp.setTowerA(obje2.getInt("towerA"));
        	camp.setFarmLimit(obje2.getInt("farmLimit"));
        	camp.setWarWave(obje2.getInt("warWave"));
        	camp.setSenarioLevelLoop(obje2.getInt("senarioLevelLoop"));
        	camp.setSenarioLevel(obje2.getInt("senarioLevel"));
        	camp.setSenarioLevelForest(obje2.getInt("senarioLevelForest"));
        	camp.setSenarioLevelMine(obje2.getInt("senarioLevelMine"));
        	camp.setSenarioLevelTown(obje2.getInt("senariolevelTown"));
        	camp.setWarWaveWalk(obje2.getInt("warWaveWalk"));
        	//people 4
        	people.setCommunity(obje2.getInt("community"));
        	people.setCommunityLimit(obje2.getInt("communityLimit"));
        	people.setHeal(obje2.getInt("peopleHeal"));
        	people.setDamage(obje2.getInt("peopleDamage"));
    	}catch(Exception e){}
    }
    
    
    
    
    public void timer(){
        if(player.getInv().getDayTime() <= 0){
            player.getInv().setDay(player.getInv().getDay()+1);
            player.getInv().setDayTime(player.getInv().getDayTime()+24);
            System.out.println("Gün "+player.getInv().getDay());
            System.out.println("Sonraki güne "+player.getInv().getDayTime()+" saat kaldı!");
            
            if(player.getInv().getFood() <= 0){
                bar();
                System.out.println("[Samael]: Adam yiyecek tükendi çabuk üsse dön!");
                if(people.getCommunity() > 2){
                    people.setCommunity(people.getCommunity()-1);
                }
            }else{
                player.getInv().setFood(player.getInv().getFood()-people.getCommunity()*2);
            }
        }else{
            System.out.println("Gün "+player.getInv().getDay());
            System.out.println("Sonraki güne "+player.getInv().getDayTime()+" saat kaldı!");
        }
    }

    public void Start(){
        load();    
    	
        while(true){

        	save();
        	
            switch (camp.getSenarioLevelLoop()){
                case 1:
                if(player.getInv().getDay() == 2){
                    snr.senario6();
                    camp.setSenarioLevelLoop(2);
                    clean();
                }
                    break;
                case 2:
                if(player.getInv().getDay() == 4){
                    snr.senario7();
                    camp.setSenarioLevelLoop(3);
                    clean();
                }
                    break;
                case 3:
                if(player.getInv().getDay() == 12){
                    snr.senario8();
                    camp.setSenarioLevelLoop(4);
                    clean();
                }
                    break;
                case 4:
                    break;                
            }

            bar();
            timer();
            bar();
            System.out.println("1. Güvenli Ev:[4 Saat]");
            System.out.println("2. Orman:[5 Saat]");
            System.out.println("3. Maden Ocağı:[7 Saat]");
            System.out.println("4. Kasaba:[8 Saat]");
            System.out.println("5. Envanterim:");
            System.out.println("6. Depo Listem:"+" Odun:"+player.getInv().getWood()+" Taş:"+player.getInv().getRock()+" Yiyecek:"+player.getInv().getFood());
            System.out.println("7. Çıkış:");
            bar();
            System.out.print("Gitmek istediğin yön:");
            int selLoc = scan.nextInt();

            while(selLoc < 1 || selLoc > 7){
                System.out.println("Mevcut mekan seçiniz! *:");
                selLoc = scan.nextInt();
            }

            switch(selLoc){
                case 1:
                    location = new SafeHouse(player, people, camp, "Güvenli Ev");
                    player.getInv().setDayTime(player.getInv().getDayTime()-4);
                    break;
                case 2:
                    location = new Forest(player, people, camp, "Orman");
                    player.getInv().setDayTime(player.getInv().getDayTime()-5);
                    break;
                case 3:
                    location = new Mine(player, people, camp, "Maden");
                    player.getInv().setDayTime(player.getInv().getDayTime()-7);
                    break;
                case 4:
                    location = new Town(player, people, camp, "Kasaba");
                    player.getInv().setDayTime(player.getInv().getDayTime()-8);
                    break;
                case 5:
                    clean();
                    clean();
                    bar();
                    System.out.println("Silahım:"+player.getInv().getWname());
                    System.out.println("Zırhım:"+player.getInv().getAname());
                    System.out.println("Param:"+player.getMoney()+" Dolar.");
                    bar();
                    save();
                    Start();
                    break;
                case 6:
                    clean();
                    clean();
                    bar();
                    System.out.println("Odun:"+player.getInv().getWood());
                    System.out.println("Taş:"+player.getInv().getRock());
                    System.out.println("Yiyecek:"+player.getInv().getFood());
                    System.out.println("Vatandaşlar:"+people.getCommunity());
                    System.out.println("Teçhizatlar:");
                    player.getStr().getHave();
                    bar();
                    save();
                    Start();
                    break;
                case 7:
                	save();
                	clean();
                	System.out.println("Hoşçakal!");
                	System.exit(0);
                	break;
            }
            save();
            if(!location.getLocation()){
                clean();
                bar();
                bar();
                System.out.println("!!!ÖLDÜN!!!");
                System.out.println("Oyun bitti!");
                bar();
                bar();
                clean();
                Login();
            }
        }
    }
}
