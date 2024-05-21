package ADVENTUREGAME;

import java.util.Scanner;

public class Player {
    protected int damage,health,money,rHealth;
    private String name,cName;
    private Inventory inv;
    Scanner sc = new Scanner (System.in);
    
    public Player(String name){
        this.name = name;
        this.inv = new Inventory();
    }
    public void selectChar(){
        switch(charMenu()){
            case 1:
                initPlayer("Samurai",5,21,15);
            break;
            case 2:
                initPlayer("Archer",7,18,20);
            break;
            case 3:
                initPlayer("Knight",8,24,15);
            break;
    }
    System.out.println("Character:"+ getcName()+ ",Damage:" + getDamage()+ ",Health:" + getHealty() + ",Money:" + getMoney());
}
    public int charMenu(){
        System.out.println("Please select a character : ");
        System.out.println("1-Samurai \t Damage:5 \t Health:21 \t Money:15");
        System.out.println("2-Archer \t Damage:7 \t Health:18 \t Money:20");
        System.out.println("3-Knight \t Damage:8 \t Health:24 \t Money:15");
        System.out.print("Your character choise is:");
    int charID = sc.nextInt();

        while (charID < 1 || charID > 3){
            System.out.println("There is not any character for this number. Please select again :)");
        charID = sc.nextInt();
    }
    return charID;
} 
   
    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();

    }


    public void initPlayer(String cName, int damage,int health,int money){
        setcName(cName);
        setDamage(damage);
        setHealthy(health);
        setMoney(money);
        setrHealthy(health);

}


    public int getDamage(){
        return damage;
}

    public void setDamage(int damage){
        this.damage = damage;
}

    public int getHealty(){
        return health;
}

    public void setHealthy(int health){
        this.health = health;
}

    public int getMoney(){
        return money;
}

    public void setMoney(int money){
        this.money = money;
}

    public String getName(){
        return name;
}

    public void setName(String name){
        this.name = name;
}

    public String getcName(){
        return cName;
}

    public void setcName(String cName){
        this.cName = cName;
}

    public Inventory getInv(){
        return inv;
}


    public void setInv(Inventory inv){
        this.inv = inv;
}

    public int getrHealthy(){
        return rHealth;
}

    public void setrHealthy(int rHealth){
        this.rHealth = rHealth;
} 
}