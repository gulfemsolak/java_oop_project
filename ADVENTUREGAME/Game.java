package ADVENTUREGAME;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner sc = new Scanner(System.in);
    public void login(){
        System.out.println("WELCOME TO ADVENTURE GAME!");
        System.out.println("Please enter your name:");
        String playerName = sc.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();

    }
    
    public void start(){
        while(true){
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println();
        System.out.println("Please select place:");
        System.out.println("1.Home --> There is no monster ,you are safe");
        System.out.println("2.Cave --> There is zombie,you may encounter");
        System.out.println("3.Forest -->There is vampire,you may encounter");
        System.out.println("4.River --> There is beer.you may encounter");
        System.out.println("5.Store --> You can buy some equipments");
        System.out.print("Your location choise:");
        int selLoc = sc.nextInt();
        while(selLoc<0 || selLoc>5 ){
            System.out.println("Invalid number,please try again");
            selLoc = sc.nextInt();

        }
        switch(selLoc){
            case 1:
                location = new SafeHouse(player);
            break;
            case 2:
                location = new Cave(player);
            break;
            case 3:
                location = new River(player);
            break;
            case 4:
                location = new Forest(player);
            break;
            case 5:
                location = new ToolStore(player);
            break;
            default:
                location = new SafeHouse(player);  
            break;
        }
        if(location.getClass().getName().equals("SafeHouse")){
            if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()){
                System.out.println("Congratulations,You Won The Game !");
                break;
            }

        }
        if(!location.getLocation()){
            System.out.println("GAME IS FINISHED!");
            break;  
        }
    }

  }

}