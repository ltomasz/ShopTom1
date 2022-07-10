package main.java;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Customer {

        int customerID;
        String firstName;
        String lastName;
        String country;
        String city;

        Date lastUpDate;

        public Customer (int customerID, String firstName,  String lastName,String country, String city,  Date lastUpDate){

            this.customerID= customerID;
            this.firstName= firstName;
            this.lastName=lastName;
            this.country= country;
            this.city= city;

            this.lastUpDate = lastUpDate;
        }


        public long getSupplierID() {
            return customerID;
        }
        public void setCustomerID(int customerID){
            this.customerID= customerID;
        }
        public String getName(){
            return firstName;
        }

        public void setName(String name) {
            this.firstName = name;
        }

        public String getlastName() {
            return lastName;
        }

        public void setlastName(String lastName) {
            this.lastName = lastName;
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
                    "supplierID=" + customerID +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", country='" + country + '\'' +
                    ", city='" + city + '\'' +

                    ", lastUpDate=" + lastUpDate +
                    '}';
        }
    }


