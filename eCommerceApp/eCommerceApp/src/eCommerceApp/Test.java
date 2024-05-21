package eCommerceApp;

import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        System.out.println("WELCOME TO APP");
        System.out.println("----------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter date of birth:");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter work address:");
        String workAddress = scanner.nextLine();
        System.out.println("Enter home address:");
        String homeAddress = scanner.nextLine();
        System.out.println("Enter credit card number:");
        String cardNumber = scanner.nextLine();
        System.out.println("Enter card user:");
        String cardUser = scanner.nextLine();
        System.out.println("Enter security code:");
        String securityCode = scanner.nextLine();
        System.out.println("Enter expiration date:");
        String expirationDate = scanner.nextLine();

        CreditCard creditCard = new CreditCard(cardNumber, cardUser, securityCode, expirationDate);

        User user = new User(username, name, surname, dateOfBirth, password, email, workAddress, homeAddress, creditCard);

        System.out.println("User and credit card added successfully!");

        Product product1 = new Product("Laptop", "Silver", "Electronics", 10, 2.5, "8 GB,13,3 inç (2560 × 1600)");
        Product product2 = new Product("Smartphone", "Black", "Electronics", 25, 0.3, "128GB,4 ulta HD cameras");
        Product product3 = new Product("Headphones", "White", "Electronics", 15, 0.2, "Bass Quality");
        Product product4 = new Product("Sweatshirts", "Red", "Wear", 50, 1.2, "It is %80 Cotton,%20 Polyester");
        Product product5 = new Product("Cups", "Pink", "Porcelain", 30, 0.7, "It protects warming in beverages");

        while (true) {
            System.out.println("Please choose a product");
            System.out.println("PRODUCT MENU");
            System.out.println("----------------------------");
            System.out.println("1. Laptop");
            System.out.println("2. Smartphone");
            System.out.println("3. Headphones");
            System.out.println("4. Sweatshirts");
            System.out.println("5. Cups");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    processProduct(product1, user, scanner);
                    break;
                case 2:
                    processProduct(product2, user, scanner);
                    break;
                case 3:
                    processProduct(product3, user, scanner);
                    break;
                case 4:
                    processProduct(product4, user, scanner);
                    break;
                case 5:
                    processProduct(product5, user, scanner);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void processProduct(Product product, User user, Scanner scanner) {
        System.out.println("1. Order product");
        System.out.println("2. Add to favorites");
        System.out.println("3. Go back to main menu");
        System.out.println("Please choose an option:");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Enter how many of your chosen product you will buy:");
                int purchasedQuantity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter credit card number:");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter full name of card user:");
                String cardUser = scanner.nextLine();
                System.out.println("Enter security code:");
                String securityCode = scanner.nextLine();
                System.out.println("Enter expiration date:");
                String expirationDate = scanner.nextLine();

                CreditCard creditCard = new CreditCard(cardNumber, cardUser, securityCode, expirationDate);
                Order order = new Order(user, product, creditCard, purchasedQuantity);
                order.processOrder();
                break;
            case 2:
                user.AddFavouriteProducts(product);
                System.out.println("Product added to favorites.");
                break;
            case 3:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid option!");
                
        }
        
    }
}
