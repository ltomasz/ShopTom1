package main.java;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Supplier {

        int supplierID;
        String name;
        String phoneNumber;
        String city;
        String country;
        Date lastUpDate;

        public Supplier (int supplierID, String name,  String phoneNumber,String city, String country, Date lastUpDate){

        this.supplierID= supplierID;
        this.name= name;
        this.phoneNumber= phoneNumber;
        this.city= city;
        this.country= country;
        this.lastUpDate = lastUpDate;
    }


    public long getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(int supplierID){
            this.supplierID= supplierID;
    }
    public String getName(){
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getLastUpDate() {
        return lastUpDate;
    }

    public void setLastUpDate(Date lastUpDate) {
        this.lastUpDate = lastUpDate;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", lastUpDate=" + lastUpDate +
                '}';
    }
}

