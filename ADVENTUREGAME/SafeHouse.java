package ADVENTUREGAME;

public class SafeHouse extends SafeLocation {
    SafeHouse(Player player){
    super(player,"Safe House");
    }
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("Your life is full now!");
        System.out.println("Your Current Values");
        System.out.println("==========================");
        System.out.println("Health:" + player.getHealty());
        System.out.println("Money:" + player.getMoney());
        return true;

    }
}
