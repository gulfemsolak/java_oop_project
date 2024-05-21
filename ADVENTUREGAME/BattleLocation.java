package ADVENTUREGAME;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    protected Monster monster;
    protected String award;
    protected Scanner sc;

    BattleLocation(Player player, String name, Monster monster, String award) {
        super(player);
        this.monster = monster;
        this.name = name;
        this.award = award;
        this.sc = new Scanner(System.in);
    }

    public boolean getLocation() {
        int monsCounter = monster.monsterCounter();
        System.out.println("Currently, you are in " + this.getName());
        System.out.println("Be careful! In here " + monsCounter + " " + monster.getName() + " live.");
        System.out.println("<W>ar or <E>scape");
        String selCase = sc.next();
        selCase = selCase.toUpperCase();
        if (selCase.equals("W")) {
            if (combat(monsCounter)) {
                System.out.println("In " + this.getName() + ", you have cleared all enemies in the area.");
                if (this.award.equals("Food") && !player.getInv().isFood()) {
                    System.out.println(this.award + " Won!");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && !player.getInv().isWater()) {
                    System.out.println(this.award + " Won!");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Firewood") && !player.getInv().isFirewood()) {
                    System.out.println(this.award + " Won!");
                    player.getInv().setFirewood(true);
                }
                System.out.println("Your Current Values");
                System.out.println( "==========================");
                System.out.println("Money:" + player.getMoney());
                System.out.println("Health:" + (player.getHealty() - monster.getDamage()));
                return true;
            }
            
            if (player.getHealty() <= 0) {
                System.out.println("You died!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int monsCounter) {
        for (int i = 0; i < monsCounter; i++) {
            int defMonsHealth = monster.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealty() > 0 && monster.getHealth() > 0) {
                System.out.print("<W>ar or <E>scape");
                String selCase = sc.nextLine();
                if (selCase.equals("W")) {
                    System.out.println("You hit the monster!");
                    monster.setHealth(monster.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (monster.getHealth() > 0) {
                        System.out.println();
                        System.out.println("Monster hit you!");
                        player.setHealthy(player.getHealty() - (monster.getDamage() - player.getInv().getArmor()));
                        System.out.println("Your current health:" + player.getHealty());
                    afterHit();
                    }
                } else {
                    break;
                }
            }
            if (monster.getHealth() < player.getHealty()) {
                System.out.println("You defeated the enemy!");
                player.setMoney(player.getMoney() + monster.getAward());
                System.out.println("Your current money: " + (player.getMoney()));
                monster.setHealth(defMonsHealth);
            } else {
                return false;
            }
            System.out.println("======================================");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Gamer Values\n=====================");
        System.out.println("Health: " + (player.getHealty() - monster.getDamage()));
        System.out.println("Damage: " + player.getTotalDamage());
        System.out.println("Money: " + player.getMoney());
        System.out.println("=======================================");
        if (player.getInv().getDamage() > 0) {
            System.out.println("Weapon: " + player.getInv().getwName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Armor: " + player.getInv().getaName());
        }
    }

    public void enemyStats() {
        System.out.println(monster.getName() + " Values\n=====================");
        System.out.println("Health: " + monster.getHealth());
        System.out.println("Damage: " + monster.getDamage());
        System.out.println("Earned award: " + monster.getAward());
    }
    public void afterHit(){
        System.out.println("Player Health:" + player.getHealty()); 
        System.out.println(monster.getName() + "'s Health:" + monster.getHealth());   
    }
    
}
