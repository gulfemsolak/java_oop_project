package eCommerceApp;
import java.util.ArrayList;
import java.util.Scanner;
public class User {
    private String username;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String password;
    private String email;
    private String workAddress;
    private String homeAddress;
    private ArrayList<User>users;
    private ArrayList<Order> orders;
    private ArrayList<Product> favouriteProducts;
    private ArrayList<CreditCard>creditCards;
   
    public User(String userName,String name,
                String surname,String dateOfBirth,
                String passsword,String email,String workAdress,
                String homeAdress,CreditCard creditCard){
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.email = email;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.orders = new ArrayList<>();
        this.favouriteProducts = new ArrayList<>();
        this.creditCards = new ArrayList<>();
        this.users= new ArrayList<>();
        this.creditCards.add(creditCard);
    }
    
  public void orderProduct(Product product, int purchasedQuantity) {
    Order order = new Order(this, product, creditCards.get(0), purchasedQuantity); // Assuming the user has only one credit card for simplicity
    orders.add(order); 
}

    public void AddFavouriteProducts(Product product){
        favouriteProducts.add(product);
    }
   public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getWorkAddress() {
        return workAddress;
    }
    
    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
    
    public String getHomeAddress() {
        return homeAddress;
    }
    
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    public ArrayList<Order> getOrderedProducts() {
        return orders;
    }
    
    public void setOrderedProducts(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Product> getFavouriteProducts() {
        return favouriteProducts;
    }
    
    public void setFavouriteProducts(ArrayList<Product> favProducts) {
        this.favouriteProducts = favProducts;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ArrayList<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
   

    
    }



