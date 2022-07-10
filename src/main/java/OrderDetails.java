package main.java;

import java.sql.Date;

public class OrderDetails {

    int orderID;
    int productID;
    int quantity;
    float discount;
    Date lastUpDate;
    int orderDetailsID;

    public OrderDetails (int orderID, int productID, int quantity,float discount, Date lastUpDate, int orderDetailsID ){

        this.orderID= orderID;
        this.productID = productID;
        this.quantity=quantity;
        this.discount= discount;
        this.lastUpDate = lastUpDate;
        this.orderDetailsID= orderDetailsID;
    }


    public long getorderID() {
        return orderID;
    }
    public void setorderID(int orderID){
        this.orderID= orderID;
    }


    public int getproductIDD(){
        return productID;
    }

    public void setproductID(int productID) {
        this.productID = productID;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public float getdiscount() {
        return discount;
    }

    public void setdiscount(float discount) {
        this.discount = discount;
    }


    public Date getLastUpDate() {
        return lastUpDate;
    }

    public void setLastUpDate(Date lastUpDate) {
        this.lastUpDate = lastUpDate;
    }

        public int getorderDetailsID() {
            return orderDetailsID;
        }
        public void setorderDetailsID (int orderDetailsID){
            this.orderDetailsID= orderDetailsID;
        }

    @Override

    public String toString() {
        return "OrderDetails{" +
                "OrderID=" + orderID +
                ",productID='" + productID + '\'' +
                ", quantity='" + quantity + '\'' +
                ", discount='" + discount+ '\'' +
                ", lastUpDate=" + lastUpDate +'\''+
                "OrderDetailsID=" + orderDetailsID +
                '}';
    }
}

