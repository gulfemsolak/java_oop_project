package ADVENTUREGAME;

public abstract class SafeLocation extends Location {
    SafeLocation(Player player,String name){
        super(player);
        this.name = name;
    }
    
    public boolean getLocation(){
        return true;
    }
   
}
