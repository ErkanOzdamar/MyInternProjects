package Map;
import java.util.Random;
import java.util.Scanner;

import Location.NormalLoc;
import Manager.Camp;
import Manager.People;
import Manager.Player;
import RandomSenario.Senario;

public class Mine extends NormalLoc{
    Scanner scan = new Scanner(System.in);
    private int maxDialogSelection = 5;
    protected Senario snr;
    
    
    public Mine(Player player, People people, Camp camp, String name){
        super(player, people, camp, "Maden Ocağı");
        this.snr = new Senario();
    }
    
    public boolean getLocation(){
        
        clean();
        System.out.println(getName()+"na geldin!");
        System.out.print("<t>opla yada <d>ön! *:");
        String selection = scan.nextLine();
        bar();
        if(selection.equalsIgnoreCase("T")){
            try{
                for(int i=3; i>0; i--){
                    
                    MineRandomDialog2();
                    System.out.println(i);
                    Thread.sleep(1000);
                    bar();
                }
            }catch(Exception e){
                System.out.println("Something get wrong");
            }
        }else{
            player.getInv().setDayTime(player.getInv().getDayTime()+7);
            clean();
            return true;
        }
        
        if(lootCount() > 10){
            if(people.getCommunity() < people.getCommunityLimit()){
                clean();
                MineRandomDialogPeople();
                bar();
                aSleep();
                MineRandomDialogPlayer();
                bar();
                aSleep();
                MineRandomDialogPlayerWar();
                aSleep();
                aSleep();
                if(winerLoserWalk()){
                    clean();
                    bar();
                    warGif();
                    aSleep();
                    RandomDialogWarWin();
                    aSleep();
                    people.setCommunity(people.getCommunity()+1);
                }else{
                    warGif();
                    aSleep();
                    clean();
                    bar();
                    System.out.println("[Adam]: Onu kaybettik Sam.");
                    aSleep(); 
                }
            }
        }
        normalLoop();    
        return true;
    }
    public void MineRandomDialog1(){
        String[] dialogRandom = {"Her taşı toprağa yerleştirirken, içindeki ağırlık seni daha da huzursuz ediyor.",
                                "Taşları toplarken, bir şeylerin seni izlediğini hissediyorsun, ama arkanı dönüp bakmaya cesaretin yok.",
                                "Bir taş daha alıyorsun, ama bu sefer, toprağın altından farklı bir şey çıkacak gibi hissediyorsun.",
                                "Ellerindeki taşlar her geçen saniye daha soğuk, daha ağır geliyor. Bir şeyler yanlış.",
                                "Bir taş daha aldığında, etrafındaki hava birdenbire ağırlaşıyor, bir şeyler değişiyor."};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void MineRandomDialog2(){
        String[] dialogRandom = {"Taşlar ağırlaşıyor.",
                                "Gözler seni izliyor.",
                                "Rüzgar aniden durdu.",
                                "Bir fısıldama duydun.",
                                "Hızla yaklaşıyorlar."};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void MineRandomDialogPlayer(){
        String[] dialogRandom = {"[Adam]: Birilerini buldum.",
                                "[Adam]: Yardımı ihtiyacı olan insanlar var.",
                                "[Adam]: Yardım etmeye gidiyorum!",
                                "[Adam]: Umarım hala hayattadır.",
                                "[Adam]: Koşuyorum!!!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void MineRandomDialogPlayerWar(){
        String[] dialogRandom = {"[Adam]: Kurtlar!",
                                "[Adam]: Haydutlar geliyor!",
                                "[Adam]: Zavallı adamı kıstırmışlar!",
                                "[Adam]: Bu haydutlar silahlı!",
                                "[Adam]: Olamaz bir ayı var!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void MineRandomDialogPeople(){
         String[] dialogRandom = {"[Vatandaş]: Yardımm edinnn!!!",
                                "[Vatandaş]: Peşimdeler kimse yok mu??",
                                "[Vatandaş]: Lütfen Bana yardım et!",
                                "[Vatandaş]: Açlıktan Ölüyorum!",
                                "[Vatandaş]: Günlerdir dışardayım sıcak bir yer!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void normalLoop(){
        int loot = people.getCommunity()*lootCount();
        player.getInv().setRock(player.getInv().getRock()+loot);
        clean();
        bar();
        //senario();
        clean();
        MineRandomDialog1();
    }
    public int randomDialog(){
        Random r = new Random();
        return r.nextInt(maxDialogSelection);
    }
    public void senario(){
        switch (camp.getSenarioLevelMine()){
            case 1:
                snr.senario4();
                camp.setSenarioLevelMine(2);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;                
        }
    }
}
