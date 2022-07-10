package main.java;

import java.sql.Date;



    public class Order {

        int orderID;
        int customerID;
         Date orderDate;
        Date orderSale;
        Date lastUpDate;

        public Order (int orderID, int employeesID, Date orderDate,Date orderSale, Date lastUpDate){

            this.orderID= orderID;

            this.customerID = customerID;
            this.orderDate=orderDate;
            this.orderSale= orderSale;
            this.lastUpDate = lastUpDate;
        }


        public long getorderID() {
            return orderID;
        }
        public void setorderID(int orderID){
            this.orderID= orderID;
        }


        public int getcustomerID(){
            return customerID;
        }

        public void setcustomerID(int customerID) {
            this.customerID = customerID;
        }

        public Date getorderDate() {
            return orderDate;
        }

        public void setorderDate(Date orderSale) {
            this.orderDate = orderDate;
        }

        public Date getorderSale() {
            return orderSale;
        }

        public void setorderSale(Date orderSale) {
            this.orderSale = orderSale;
        }


        public Date getLastUpDate() {
            return lastUpDate;
        }

        public void setLastUpDate(Date lastUpDate) {
            this.lastUpDate = lastUpDate;
        }

        @Override

        public String toString() {
            return "Order{" +
                    "OrderID=" + orderID +
                    ",customerID='" + customerID + '\'' +
                    ", orderDate='" + orderDate + '\'' +
                    ", orderSale='" + orderSale+ '\'' +
                    ", lastUpDate=" + lastUpDate +
                    '}';
        }
    }


