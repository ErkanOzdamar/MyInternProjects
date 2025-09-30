package Map;
import java.util.Random;
import java.util.Scanner;

import Location.NormalLoc;
import Manager.Camp;
import Manager.People;
import Manager.Player;
import RandomSenario.Senario;
import RandomSenario.TownItem;

public class Town extends NormalLoc{
    TownItem item;
    private int maxDialogSelection = 5;
    protected Senario snr;
    
    Scanner scan = new Scanner(System.in);
   
    public Town(Player player, People people, Camp camp, String name){
        super(player, people, camp, "Kasaba");
        this.item = new TownItem(player);
        this.snr = new Senario();
    }
   
    public boolean getLocation(){
        
        clean();
        System.out.println(getName()+"ya geldin!");
        System.out.print("<t>opla yada <d>ön! *:");
        String selection = scan.nextLine();
        bar();
        if(selection.equalsIgnoreCase("T")){
            try{
                for(int i=3; i>0; i--){
                    
                    TownRandomDialog2();
                    System.out.println(i);
                    Thread.sleep(1000);
                    bar();
                }
            }catch(Exception e){
                System.out.println("Something get wrong");
            }
        }else{
            player.getInv().setDayTime(player.getInv().getDayTime()+8);
            clean();
            return true;
        }
        
        if(lootCount() > 10){
            if(people.getCommunity() < people.getCommunityLimit()){
                clean();
                TownRandomDialogPeople();
                bar();
                aSleep();
                TownRandomDialogPlayer();
                bar();
                aSleep();
                TownRandomDialogPlayerWar();
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

    public void TownRandomDialog1(){
        String[] dialogRandom = {"Gözlerin karanlıkta bir hareketin farkına vardı. Başını çevirdiğinde, üç adamın siluetini gördün. neler topladığına bakamadan kaçmak zorunda kaldın!",
                                "Kurtlar, derin ormanın içinden sessizce süzüldüler. Uzakta bir uluma, Canını kurtarmak için kaçmalıydın!",
                                "Miden bulanıyordu kendini iyi hissetmiyordun kasabadan uzaklaşmaya karar verdin!",
                                "Bir anda, derin sessizliğin içinde, bir keskin patlama duyuldu.Tek düşündüğün kaçmaktı!",
                                "Seni izleyen birinin bakışlarını hissedebiliyordun. Gözlerin duvarlarda gezinirken, bir gölge kayboldu!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void TownRandomDialog2(){
        String[] dialogRandom = {"Evleri Geziyorsun!!!",
                                "Benzinliktesin...",
                                "Bir çocuk parkı gördün.",
                                "Polis karakolundasın!!!",
                                "Askeri kamptasın æßææJeneratör sesi..."};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void TownRandomDialogPlayer(){
        String[] dialogRandom = {"[Adam]: Birilerini buldum.",
                                "[Adam]: Yardımı ihtiyacı olan insanlar var.",
                                "[Adam]: Yardım etmeye gidiyorum!",
                                "[Adam]: Umarım hala hayattadır.",
                                "[Adam]: Koşuyorum!!!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void TownRandomDialogPlayerWar(){
        String[] dialogRandom = {"[Adam]: Kurtlar!",
                                "[Adam]: Haydutlar geliyor!",
                                "[Adam]: Zavallı adamı kıstırmışlar!",
                                "[Adam]: Bu haydutlar silahlı!",
                                "[Adam]: Olamaz bir ayı var!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void TownRandomDialogPeople(){
         String[] dialogRandom = {"[Vatandaş]: Yardımm edinnn!!!",
                                "[Vatandaş]: Peşimdeler kimse yok mu??",
                                "[Vatandaş]: Lütfen Bana yardım et!",
                                "[Vatandaş]: Açlıktan Ölüyorum!",
                                "[Vatandaş]: Günlerdir dışardayım sıcak bir yer!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void normalLoop(){
        for(int i=0; i<people.getCommunity()+1; i++){
            item.TownLoot();
        }
        clean();
        bar();
        //senario();
        clean();
        TownRandomDialog1();
    }
    public int randomDialog(){
        Random r = new Random();
        return r.nextInt(maxDialogSelection);
    }
    public void senario(){
        switch (camp.getSenarioLevelTown()){
            case 1:
                snr.senario5();
                camp.setSenarioLevelTown(2);
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
