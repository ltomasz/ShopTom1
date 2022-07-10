package main.java;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Product {


        int productID;
        String name;
        int supplierID;
         float buyUnitPrice;
        float saleUnitPrice;
        Date lastUpDate;

        public Product (int productID, String name,  int supplierID,float buyUnitPrice, float saleUnitPrice,  Date lastUpDate){

            this.productID= productID;
            this.name= name;
            this.supplierID=supplierID;
            this.buyUnitPrice= buyUnitPrice;
            this.saleUnitPrice= saleUnitPrice;

            this.lastUpDate = lastUpDate;
        }


        public long getProductID() {
            return productID;
        }
        public void setProductID(int productID){
            this.productID= productID;
        }
        public String getNameame(){
            return name;
        }

        public void setname(String name) {
            this.name = name;
        }

        public int getsupplierID() {
            return supplierID;
        }

        public void setsupplierID(int supplierID) {
            this.supplierID = supplierID;
        }

        public float getbuyUnitPrice() {
            return buyUnitPrice;
        }

        public void setbuyUnitPrice(float buyUnitPrice) {
            this.buyUnitPrice = buyUnitPrice;
        }

        public float getsaleUnitPrice() {
            return saleUnitPrice;
        }

        public void saleUnitPrice(float saleUnitPrice) {
            this.saleUnitPrice = saleUnitPrice;
        }

        public Date getLastUpDate() {
            return lastUpDate;
        }

        public void setLastUpDate(Date lastUpDate) {
            this.lastUpDate = lastUpDate;
        }

        @Override

        public String toString() {
            return "Product{" +
                    "productID=" + productID +
                    ", name='" + name + '\'' +
                    ", supplierID='" + supplierID + '\'' +
                    ", buyUnitPrice='" + buyUnitPrice + '\'' +
                    ", saleUnitPrice='" + saleUnitPrice + '\'' +

                    ", lastUpDate=" + lastUpDate +
                    '}';
        }
    }



