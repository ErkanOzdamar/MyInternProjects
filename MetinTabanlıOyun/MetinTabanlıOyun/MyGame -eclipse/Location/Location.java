package Location;
import Manager.Camp;
import Manager.People;
import Manager.Player;
import RandomSenario.Senario;

public abstract class Location{
    protected Player player;
    protected String name;
    protected People people;
    protected Camp camp;
    protected Senario snr;

    Location(Player player, People people, Camp camp){
        this.player = player;
        this.people = people;
        this.camp = camp;
    }

    public abstract boolean getLocation();

    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int playerPower(){
        int playerPower = player.getDamage()+player.getInv().getDamage()+people.getCommunity()*people.getDamage();
        return playerPower;
    }
    public int playerArmorCamp(){
        int playerArmor = player.getHeal()+player.getInv().getArmor()+camp.getTowerA()+camp.getWallA()+people.getCommunity()*people.getHeal()+people.getCommunity()*people.getPeopleInv().getArmor();
        return playerArmor;
    }
    public int playerArmor(){
        int playerArmor = player.getHeal()+player.getInv().getArmor()+people.getCommunity()*people.getHeal()+people.getCommunity()*people.getPeopleInv().getArmor();
        return playerArmor;
    }
    public int enemyPower(){
        return camp.getWarWave();
    }
    public int enemyPowerWalk(){
        return camp.getWarWaveWalk();
    }
    public boolean winerLoserCamp(){
        if(playerPower()-(enemyPower()-playerArmorCamp()) > 0){
            return true;
        }else{
            return false;
        }
    }public boolean winerLoserWalk(){
        if(playerPower()-(enemyPowerWalk()-playerArmor()) > 0){
            return true;
        }else{
            return false;
        }
    }
    public void clean(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public void bar(){
        System.out.println("==========================================================");
    }
    public void RandomDialogWarWin(){
        System.out.println("[Adam]: yeni dostumuz üsse doğru yola çıktı Sam.");
        System.out.println("[Samael]: Anlaşıldı Kaptan!");                        
    }
    public void warGif(){
        boolean loop = true;
            int loopCount = 0;;
        while (loop){
            loopCount  += 1;
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("Savaş Alanı:");
            System.out.println("       O      O    ");
            System.out.println("      /|\\    /|\\   ");
            System.out.println("      / \\    / \\   ");
            System.out.println("  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("    BANG! BANG! BANG!");
            System.out.println("  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(" O      O ");
            System.out.println("/|\\    /|\\ ");
            System.out.println("/ \\    / \\ ");

            try{
                Thread.sleep(500); 
            } catch (InterruptedException e){}

            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("Savaş Alanı:");
            System.out.println("       O           O    ");
            System.out.println("      /|\\         /|\\   ");
            System.out.println("      / \\         / \\   ");
            System.out.println("  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("    BANG! BANG! BANG!");
            System.out.println("  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(" O           O ");
            System.out.println("/|\\         /|\\ ");
            System.out.println("/ \\         / \\ ");
            try{
                Thread.sleep(500); 
            }catch(InterruptedException e){}
            
            if(loopCount == 10){
                loop = false;
            }
        }
    }
    public void warGif2(){
        boolean loop = true;
            int loopCount = 0;;
        while (loop){
            loopCount  += 1;
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("   _______________________________");
            System.out.println("  /                               \\");
            System.out.println(" |   [🏕️ KAMP SAVUNMA NOKTASI 🏕️]  |");
            System.out.println(" |                                 |");
            System.out.println(" |    🔥        ⛺        🔥        |");
            System.out.println(" |   ( )       ( )       ( )       |");
            System.out.println(" |  /|\\       /|\\       /|\\        |");
            System.out.println(" | _/ \\_______/ \\_______/ \\_______ |");
            System.out.println(" | |   |   |   |   |   |   |   |   ||");
            System.out.println(" | |===|===|===|===|===|===|===|===||");
            System.out.println("  \\_______________________________/");

            try{
                Thread.sleep(500); 
            } catch (InterruptedException e){}

            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("   _______________________________");
            System.out.println("  / !!!!!!!! SALDIRI !!!!!!!!     \\");
            System.out.println(" |   [⚔️  DÜŞMAN SALDIRIYOR  ⚔️]   |");
            System.out.println(" |     💥     💣    💥    💣      |");
            System.out.println(" |    (X)       (🔥)       (X)    |");
            System.out.println(" |   /|\\       /|\\       /|\\      |");
            System.out.println(" | _/ \\_______/ \\_______/ \\_______|");
            System.out.println(" | |   |   |   |   |   |   |   |  ||");
            System.out.println(" | |===|===|===|===|===|===|===|==||");
            System.out.println("  \\_______________________________/");
            try{
                Thread.sleep(500); 
            }catch(InterruptedException e){}
            
            if(loopCount == 10){
                loop = false;
            }
        }
    }
}
