package eCommerceApp;

import java.util.ArrayList;

public class Order {
    private User orderingUser;
    private Product orderedProduct;
    private CreditCard creditCard;
    private int purchasedQuantity;
    
    public Order(User orderingUser, Product orderedProduct, CreditCard creditCard, int purchasedQuantity) {
        this.orderingUser = orderingUser;
        this.orderedProduct = orderedProduct;
        this.creditCard = creditCard;
        this.purchasedQuantity = purchasedQuantity;
    }
    
    public void processOrder() {
        getOrderedProduct().StockControl(purchasedQuantity);
        orderingUser.orderProduct(getOrderedProduct(), purchasedQuantity);
    }

    public User getOrderingUser() {
        return orderingUser;
    }

    public void setOrderingUser(User orderingUser) {
        this.orderingUser = orderingUser;
    }


    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public int getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(int purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    public Product getOrderedProduct() {
        return orderedProduct;
    }

    public void setOrderedProduct(Product orderedProduct) {
        this.orderedProduct = orderedProduct;
    }
    
}
