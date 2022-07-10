package main.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection dbConnection = DatabaseConnector.getDBConnection();
        DataAccess dataAccess = new DataAccess(dbConnection);
        //List<String> selectQueries = readyFrom(); // wczytanie z pliku zapytań do listy
        ArrayList<String> lista = new ArrayList<>();


        lista.add("select * from orders");


       // dataAccess.read(lista, "City");// columnName - kolumna której wartość chcesz odczytać
       // System.out.println(dataAccess.readCustomers());
       // dataAccess.readWriteAll(lista);
       // dataAccess.insertCustomer("Tom","Lewandowski","Poland","Krakow");
      ;
       // dataAccess.insertOrders(4, Date.valueOf("2022-03-16") , Date.valueOf("2022-03-17"));
        // dataAccess.insertOrdersDetails(7,1,55,0);
       // dataAccess.insertProducts("scissor", 3, 15.5F,17);
        dataAccess.insertSuppliers("fff","49123456789","German","Berlin");
        System.out.println(dataAccess.readOrders());


        dataAccess.closeConnection();
    }

}
