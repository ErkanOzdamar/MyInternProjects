package Map;
import java.util.Random;
import java.util.Scanner;

import Location.NormalLoc;
import Manager.Camp;
import Manager.People;
import Manager.Player;
import RandomSenario.Senario;

public class Forest extends NormalLoc{
    Scanner scan = new Scanner(System.in);
    private int maxDialogSelection = 5;
    protected Senario snr;
    
    

    public Forest(Player player, People people, Camp camp, String name){
        super(player, people, camp, "Orman");
        this.snr = new Senario();
    }

    public boolean getLocation(){
        clean();
        System.out.println(getName()+"a geldin!");
        System.out.print("<t>opla yada <d>ön! *:");
        String selection = scan.nextLine();
        bar();
        if(selection.equalsIgnoreCase("T")){
            try{
                for(int i=3; i>0; i--){
                    
                    ForestRandomDialog2();
                    System.out.println(i);
                    Thread.sleep(1000);
                    bar();
                }
            }catch(Exception e){
                System.out.println("Something get wrong");
            }
        }else{
            player.getInv().setDayTime(player.getInv().getDayTime()+5);
            clean();
            return true;
        }
        
        if(lootCount() > 10){
            if(people.getCommunity() < people.getCommunityLimit()){
                clean();
                ForestRandomDialogPeople();
                bar();
                aSleep();
                ForestRandomDialogPlayer();
                bar();
                aSleep();
                ForestRandomDialogPlayerWar();
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
    public void ForestRandomDialog1(){
        String[] dialogRandom = {"Ellerindeki odun, parmaklarını delip geçecek gibi ağırlaştı.",
                                "Her odun parçası, seni biraz daha yalnızlaştırıyordu, hissettin.",
                                "Kırılan odun sesi, derin karanlıkta yankılandı.",
                                "Odunları keserken, bir ses duyduğunda kalbin hızlandı.",
                                "Her odun parçası, geceye karışan tuhaf sesler çıkarıyordu."};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void ForestRandomDialog2(){
        String[] dialogRandom = {"Ellerin titriyor.",
                                "Odunlar kırıldı.",
                                "Rüzgar aniden durdu.",
                                "Odunlar çatırdıyor.",
                                "Yerdeki odun."};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void ForestRandomDialogPlayer(){
        String[] dialogRandom = {"[Adam]: Birilerini buldum.",
                                "[Adam]: Yardıma ihtiyacı olan insanlar var.",
                                "[Adam]: Yardım etmeye gidiyorum!",
                                "[Adam]: Umarım hala hayattadır.",
                                "[Adam]: Koşuyorum!!!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void ForestRandomDialogPlayerWar(){
        String[] dialogRandom = {"[Adam]: Kurtlar!",
                                "[Adam]: Haydutlar geliyor!",
                                "[Adam]: Zavallı adamı kıstırmışlar!",
                                "[Adam]: Bu haydutlar silahlı!",
                                "[Adam]: Olamaz bir ayı var!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void ForestRandomDialogPeople(){
         String[] dialogRandom = {"[Vatandaş]: Yardımm edinnn!!!",
                                "[Vatandaş]: Peşimdeler kimse yok mu??",
                                "[Vatandaş]: Lütfen Bana yardım et!",
                                "[Vatandaş]: Açlıktan Ölüyorum!",
                                "[Vatandaş]: Günlerdir dışardayım sıcak bir yer!"};
        System.out.println(dialogRandom[randomDialog()]);                        
    }
    public void normalLoop(){
        int loot = people.getCommunity()*lootCount();
        player.getInv().setWood(player.getInv().getWood()+loot);
        clean();
        bar();
        //senario();
        clean();
        ForestRandomDialog1();
    }
    public int randomDialog(){
        Random r = new Random();
        return r.nextInt(maxDialogSelection);
    }
    public void senario(){
        switch (camp.getSenarioLevelForest()){
            case 1:
                snr.senario3();
                camp.setSenarioLevelForest(2);
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
