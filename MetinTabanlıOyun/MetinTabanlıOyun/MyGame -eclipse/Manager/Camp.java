package Manager;

public class Camp{
    protected String wallN, towerN, shelterN,farmSizeN;
    protected int wallA, towerA, farmLimit, warWave, warWaveWalk, senarioLevel;
    protected int senarioLevelTown, senarioLevelMine, senarioLevelForest, senarioLevelLoop;
    
    public Camp(){
        this.wallN = "YOK!";
        this.towerN = "YOK!";
        this.shelterN = "Ana Sığınak!";
        this.farmSizeN = "Küçük Tarla!";
        this.wallA = 0;
        this.towerA = 0;
        this.farmLimit = 0;
        this.warWave = 600;
        this.senarioLevelLoop = 1;
        this.senarioLevel = 1;
        this.senarioLevelForest = 1;
        this.senarioLevelMine = 1;
        this.senarioLevelTown = 1;
        this.warWaveWalk = 100;
    }
    
    public int getSenarioLevelLoop(){
        return senarioLevelLoop;
    }
    public void setSenarioLevelLoop(int senarioLevelLoop){
        this.senarioLevelLoop = senarioLevelLoop; 
    }
    public int getSenarioLevelForest(){
        return senarioLevelForest;
    }
    public void setSenarioLevelForest(int senarioLevelForest){
        this.senarioLevelForest = senarioLevelForest;
    }
    public int getSenarioLevelMine(){
        return senarioLevelMine;
    }
    public void setSenarioLevelMine(int senarioLevelMine){
        this.senarioLevelMine = senarioLevelMine;
    }
    public int getSenarioLevelTown(){
        return senarioLevelTown;
    }
    public void setSenarioLevelTown(int senarioLevelTown){
        this.senarioLevelTown = senarioLevelTown;
    }
    public int getSenarioLevel(){
        return senarioLevel;
    }
    public void setSenarioLevel(int senarioLevel){
        this.senarioLevel =senarioLevel;
    }
    public int getWarWaveWalk(){
        return warWaveWalk;
    }
    public void setWarWaveWalk(int warWaveWalk){
        this.warWaveWalk = warWaveWalk;
    }
    public int getWarWave(){
        return warWave;
    }
    public void setWarWave(int warWave){
        this.warWave = warWave;
    }
    public String getWallN(){
        return wallN;
    }
    public void setWallN(String wallN){
        this.wallN = wallN;
    }
    public String getTowerN(){
        return towerN;
    }
    public void setTowerN(String towerN){
        this.towerN = towerN;
    }
    public String getShelterN(){
        return shelterN;
    }
    public void setShelterN(String shelterN){
        this.shelterN = shelterN;
    }
    public String getFarmSizeN(){
        return farmSizeN;
    }
    public void setFarmSizeN(String farmSizeN){
        this.farmSizeN = farmSizeN;
    }
    public int getFarmLimit(){
        return farmLimit;
    }
    public void setFarmLimit(int farmLimit){
        this.farmLimit = farmLimit;
    }
    public int getWallA(){
        return wallA;
    }
    public void setWallA(int wallA){
        this.wallA = wallA;
    }
    public int getTowerA(){
        return towerA;
    }
    public void setTowerA(int towerA){
        this.towerA = towerA;
    }
}
