package Inventory;

import java.util.Scanner;

public class Storage{
    protected boolean m4,ak47,nineMm,machete,uzi,plaka,policE,military,bulletProof,balisticVest;
    int selection;
    Scanner scan = new Scanner(System.in);

    public Storage(){
        this.m4 = false;
        this.ak47 = false;
        this.nineMm = false;
        this.machete = true;
        this.uzi = false;
        
        this.plaka = false;
        this.policE = false;
        this.military = false;
        this.bulletProof = false;
        this.balisticVest = false;
    }

    public boolean getM4(){
        return m4;
    }
    public void setM4(boolean m4){
        this.m4 = m4;
    }
    public boolean getAk47(){
        return ak47;
    }
    public void setAk47(boolean ak47){
        this.ak47 = ak47;
    }
    public boolean getNineMm(){
        return nineMm;
    }
    public void setNineMm(boolean nineMm){
        this.nineMm= nineMm;
    }
    public boolean getMachete(){
        return machete;
    }
    public void setMachete(boolean machete){
        this.machete= machete;
    }
    public boolean getUzi(){
        return uzi;
    }
    public void setUzi(boolean uzi){
        this.uzi= uzi;
    }
    public boolean getPlaka(){
        return plaka;
    }
    public void setPlaka(boolean plaka){
        this.plaka= plaka;
    }
    public boolean getPolicE(){
        return policE;
    }
    public void setPolicE(boolean policE){
        this.policE= policE;
    }
    public boolean getMilitary(){
        return military;
    }
    public void setMilitary(boolean military){
        this.military= military;
    }
    public boolean getBulletProof(){
        return bulletProof;
    }
    public void setBulletProof(boolean bulletProof){
        this.bulletProof= bulletProof;
    }
    public boolean getBalisticVest(){
        return balisticVest;
    }
    public void setBalisticVest(boolean balisticVest){
        this.balisticVest= balisticVest;
    }
    public void getHave(){
        boolean[] have = {this.ak47,this.balisticVest,this.bulletProof,this.m4,this.machete,this.military,this.nineMm,this.plaka,this.policE,this.uzi};
        for(int i=0; i < have.length; i++){
            if(have[i]){
                switch (i){
                    case 0:
                    System.out.println("AK47:+");
                        break;
                    case 1:
                    System.out.println("Balistik Zırh:+");
                        break;
                    case 2:
                    System.out.println("Çelik Zırh:+");
                        break;                                                
                    case 3:
                    System.out.println("M4:+");
                        break;
                    case 4:
                    System.out.println("Pala:+");
                        break;
                    case 5:
                    System.out.println("Askeri Sınıf Zırh:+");
                        break;
                    case 6:
                    System.out.println("9mm:+");
                        break;
                    case 7:
                    System.out.println("Plaka Zırh:+");
                        break;
                    case 8:
                    System.out.println("Polis Ekipmanları:+");
                        break;
                    case 9:
                    System.out.println("Çete Stil Uzi:+");
                        break;                                        
                }
            }
        }
    }
    public int getWearingStore(){
        boolean[] have = {this.ak47,this.balisticVest,this.bulletProof,this.m4,this.machete,this.military,this.nineMm,this.plaka,this.policE,this.uzi};
        boolean[] storageHave = new boolean[11];
        String[] menu = new String[11];
        for(int i=0; i < have.length; i++){
            if(have[i]){
                switch (i){
                    case 0:
                    storageHave[1] = have[i];
                    menu[1] = "AK47 [Hasar:40]";
                        break;
                    case 1:
                    storageHave[2] = have[i];
                    menu[2] = "Balistik Zırh [Zırh:80]";
                        break;
                    case 2:
                    storageHave[3] = have[i];
                    menu[3] = "Çelik Yelek [Zırh:30]";
                        break;                                                
                    case 3:
                    storageHave[4] = have[i];
                    menu[4] = "M4 [Hasar:60]";
                        break;
                    case 4:
                    storageHave[5] = have[i];
                    menu[5] = "Pala [Hasar:5]";
                        break;
                    case 5:
                    storageHave[6] = have[i];
                    menu[6] = "Askeri Sınıf Zırh [Zırh:60]";
                        break;
                    case 6:
                    storageHave[7] = have[i];
                    menu[7] = "9mm [Hasar:20]";
                        break;
                    case 7:
                    storageHave[8] = have[i];
                    menu[8] = "Plaka Zırh [Zırh:45]";
                        break;
                    case 8:
                    storageHave[9] = have[i];
                    menu[9] = "Polis Ekipmanları [Zırh:50]";
                        break;
                    case 9:
                    storageHave[10] = have[i];
                    menu[10] = "Çete Stil Uzi [Hasar:35]";
                        break;                                        
                }
            }
        }
        for(int j=1; j<storageHave.length; j++){
            if(storageHave[j]){
                System.out.println(j+")"+menu[j]);
            } 
        }
        System.out.print("[Çıkış:-1] Teçhizatı seç:");
            selection = scan.nextInt();
           
        if(selection == -1){
            return -1;
        }else if(storageHave[selection]){
            return selection;
        }else{
            return -2;
        }
    }
}
