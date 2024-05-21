package ADVENTUREGAME;
import java.util.Random;
public class Monster {
    private String name;
    private int damage,award,health,maxRange;
    

    public Monster(String name,int damage,int health,int award,int maxRange){
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.maxRange = maxRange;

    }
    public int monsterCounter(){
        Random r = new Random();
        return r.nextInt(this.maxRange) + 1;

    }

    public String getName(){
        return name;

    }

    public void setName(String name){
       this.name = name;

    }

    public int getDamage(){
        return damage;

    }

    public void setDamage(int damage){
        this.damage = damage;

    }

    public int getHealth(){
        return health;

    }

    public void setHealth(int health){
        this.health = health;

    }

    public int getAward(){
        return award;

    }

    public void setAward(int award){
        this.award = award;

    }

    public int getMaxRange(){
        return maxRange;

    }

    public void setMaxRange(int maxRange){
        this.maxRange = maxRange;

    }
}   