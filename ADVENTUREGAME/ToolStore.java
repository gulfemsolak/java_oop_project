package ADVENTUREGAME;

import java.util.Scanner;

public class ToolStore extends SafeLocation {
    Scanner sc;

    ToolStore(Player player) {
        super(player, "Tool Store");
        sc = new Scanner(System.in);
    }

    public boolean getLocation() {
        System.out.println("Money:" + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.print("Your choice : ");

        int selTool = sc.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:
                return false;
        }
        return true;
    }

    public int armorMenu() {
        System.out.println("1. Light Armor \t --- Money : 15 - Damage Reduction : 1 ---");
        System.out.println("2. Medium Armor \t --- Money : 25 - Damage Reduction : 3 ---");
        System.out.println("3. Heavy Armor \t --- Money : 30 - Damage Reduction : 5 ---");
        System.out.println("4. \t --- Exit ---");
        System.out.print("Please select an armor: ");
        int selArmorID = sc.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        int damageReduction = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                damageReduction = 1;
                aName = "Light Armor";
                price = 15;
                break;
            case 2:
                damageReduction = 3;
                aName = "Medium Armor";
                price = 25;
                break;
            case 3:
                damageReduction = 5;
                aName = "Heavy Armor";
                price = 30;
                break;
            case 4:
                System.out.println("You are exiting.");
                return;
            default:
                System.out.println("Invalid process! Try again.");
                return;
        }

        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmor(damageReduction);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName + " bought, Damage reduced by: " + damageReduction);
                System.out.println("Your current balance: " + player.getMoney());
            } else {
                System.out.println("Insufficient balance!");
            }
        }
    }

    public int weaponMenu() {
        System.out.println("1. Gun \t --- Money : 25 - Damage : 2 ---");
        System.out.println("2. Sword \t --- Money : 25 - Damage : 3 ---");
        System.out.println("3. Rifle \t --- Money : 35 - Damage : 7 ---");
        System.out.println("4. \t --- Exit ---");
        System.out.print("Please select a weapon: ");
        int selWeaponID = sc.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Gun";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Sword";
                price = 25;
                break;
            case 3:
                damage = 7;
                wName = "Rifle";
                price = 35;
                break;
            case 4:
                System.out.println("You are exiting.");
                return;
            default:
                System.out.println("Invalid process! Try again.");
                return;
        }

        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You got your weapon, Previous Damage: " + player.getDamage() + ", Current Damage: "
                        + player.getTotalDamage());
                System.out.println("Your current balance: " + player.getMoney());
            } else {
                System.out.println("Insufficient balance!");
            }
        }
    }
}
