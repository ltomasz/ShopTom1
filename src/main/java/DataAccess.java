package main.java;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;

public final class DataAccess {
   // private static Logger LOGGER = Logger.getLogger(DataAccess.class.getName());
    private Connection dbConnection;
    public DataAccess(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

// metoda wczytujące tabele Customers z bazy danych
       public List<Customer> readCustomers() throws SQLException {

        Statement statement = null;
        List<Customer> customers = new LinkedList<Customer>();
        try {
            statement = openConnection();
            ResultSet rs = statement.executeQuery("SELECT* FROM Customers");
            int customerID;
            String firstName;
            String lastName;
            String country;
            String city;
            Date lastUpDate;
            while (rs.next()){
            customerID= rs.getInt("customerID");
            firstName= rs.getString("firstname");
            lastName = rs.getString("lastName");
            country = rs.getString("country");
            city= rs.getString("city");
            lastUpDate= (Date) rs.getDate("lastupdate");
            customers.add( new Customer(customerID,firstName,lastName, country,city,lastUpDate ) );

            }

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return customers;
    }


    // metoda wczytujace  tabele Orders z bazy danych
    public List<Order> readOrders() throws SQLException {

        Statement statement = null;
        List<Order> orders = new LinkedList<Order>();
        try {
            statement = openConnection();
            ResultSet rs = statement.executeQuery("SELECT* FROM Orders");
            int orderID;
            int customerID;
            Date orderDate;
            Date saleDate;
            Date lastUpDate;

            while (rs.next()){
                orderID= rs.getInt("orderID");
                customerID= rs.getInt("customerID");
                orderDate = rs.getDate("orderdate");
                saleDate = rs.getDate("saledate");
                lastUpDate= (Date) rs.getDate("lastupdate");
                orders.add( new Order (orderID,customerID,orderDate,saleDate,lastUpDate ) );
            }

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return orders;
    }


    // metoda wczytujace  tabele OrdersDetails z bazy danych
    public List<OrderDetails> readOrdersDetails() throws SQLException {

        Statement statement = null;
        List<OrderDetails> ordersDetails = new LinkedList<OrderDetails>();
        try {
            statement = openConnection();
            ResultSet rs = statement.executeQuery("SELECT* FROM OrdersDetails");
            int orderID;
            int productID;
            int quantity;
            float discount;
            Date lastUpDate;
            int orderDetailsID;

            while (rs.next()){
                orderID= rs.getInt("orderID");
                productID= rs.getInt("productID");
                quantity = rs.getInt("quantity");
                discount = rs.getFloat("discount");
                lastUpDate= (Date) rs.getDate("lastupdate");


                orderDetailsID=rs.getInt ("orderDetailsID");
                ordersDetails.add( new OrderDetails (orderID,productID, quantity,discount,lastUpDate, orderDetailsID ) );
            }

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return ordersDetails;
            }

    // metoda wczytujące tabele Products z bazy danych

    public List<Product> readProducts() throws SQLException {

        Statement statement = null;
        List<Product> products = new LinkedList<Product>();
        try {
            statement = openConnection();
            ResultSet rs = statement.executeQuery("SELECT* FROM Products");
            int productID;
            String name;
            int supplierID;
            float buyUnitPrice;
            float saleUnitPrice;
            Date lastUpDate;

            while (rs.next()){
                productID= rs.getInt("productID");
                name= rs.getString("name");
                supplierID= rs.getInt("supplierID");
                buyUnitPrice = rs.getFloat("buyUnitPrice");
                saleUnitPrice= rs.getFloat("saleUnitPrice");
                lastUpDate= (Date) rs.getDate("lastupdate");
                products.add( new Product(productID,name,supplierID, buyUnitPrice, saleUnitPrice,lastUpDate ) );

            }

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return products;
    }

    // metoda wczytujące tabele Suppliers z bazy danych

    public List<Supplier> readSuppliers() throws SQLException {

        Statement statement = null;
        List<Supplier> suppliers = new LinkedList<Supplier>();
        try {
            statement = openConnection();
            ResultSet rs = statement.executeQuery("SELECT* FROM Suppliers");
            int supplierID;
            String name;
            String phoneNumber;
            String city;
            String country;
            Date lastUpDate;

            while (rs.next()){
                supplierID= rs.getInt("supplierID");
                name= rs.getString("name");
                phoneNumber = rs.getString("phoneNumber");
                country = rs.getString("country");
                city= rs.getString("city");
                lastUpDate= (Date) rs.getDate("lastupdate");
                suppliers.add( new Supplier(supplierID,name,phoneNumber, country,city,lastUpDate ) );

            }

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return suppliers;
    }


    // metoda dodająca rekord do tabeli customers

    public boolean insertCustomer (String firstName, String lastName, String country, String city)  {

        PreparedStatement prepareStatement = null;

        try {
            prepareStatement =  openConnection1("insert into customers  (firstname, lastname,country, city) values( ?,?,?,?);");
            prepareStatement.setString(1,firstName);
            prepareStatement.setString(2,lastName);
            prepareStatement.setString(3,country);
            prepareStatement.setString(4,city);
            prepareStatement.execute();


        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("blad przy dodawaniu customer " + e.getMessage());
            return false;
        }
        System.out.println("wprowadzono new customer");
        return true;
    }
    // metoda dodajaca rekordy do tabeli Orders

    public boolean insertOrders (int customerID, Date orderDate, Date saleDate)  {

        PreparedStatement prepareStatement = null;

        try {
            prepareStatement =  openConnection1("insert into orders  (customerID, orderDate,saleDate) values( ?,?,?);");
            prepareStatement.setInt(1,customerID);
            prepareStatement.setDate(2, orderDate);
            prepareStatement.setDate(3,saleDate);
            prepareStatement.execute();


        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("blad przy dodawaniu orders " + e.getMessage());
            return false;
        }
        System.out.println("wprowadzono new order");
        return true;
    }
// metoda dodająca rekord do tabeli OrdersDetails

    public boolean insertOrdersDetails (int orderId, int productID, int quantity,float discount)  {

        PreparedStatement prepareStatement = null;

        try {
            prepareStatement =  openConnection1("insert into ordersdetails  (orderId, productID, quantity, discount) values( ?,?,?,?);");
            prepareStatement.setInt(1,orderId);
            prepareStatement.setInt(2, productID);
            prepareStatement.setInt(3, quantity);
            prepareStatement.setFloat(4,discount);
            prepareStatement.execute();

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("blad przy dodawaniu ordersdetails " + e.getMessage());
            return false;
        }
        System.out.println("wprowadzono new orderDetails");
        return true;
    }

    // metoda dodająca rekord do tabeli Products

    public boolean insertProducts (String name,  int supplierID,float buyUnitPrice, float saleUnitPrice)  {

        PreparedStatement prepareStatement = null;

        try {
            prepareStatement =  openConnection1("insert into products  (name,supplierID, buyUnitPrice, saleUnitPrice) values( ?,?,?,?);");
            prepareStatement.setString(1,name);
            prepareStatement.setInt(2, supplierID);
            prepareStatement.setFloat(3, buyUnitPrice);
            prepareStatement.setFloat(4,saleUnitPrice);
            prepareStatement.execute();

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("blad przy dodawaniu produsts " + e.getMessage());
            return false;
        }
        System.out.println("wprowadzono new products");
        return true;
    }

    // metoda dodająca rekord do tabeli suppliers

    public boolean insertSuppliers (String name,  String phoneNumber,String city, String country)  {

        PreparedStatement prepareStatement = null;

        try {
            prepareStatement =  openConnection1("insert into suppliers  (name, phoneNumber, city, country) values( ?,?,?,?);");
            prepareStatement.setString(1,name);
            prepareStatement.setString(2,phoneNumber);
            prepareStatement.setString(3,country);
            prepareStatement.setString(4,city);
            prepareStatement.execute();


        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("blad przy dodawaniu suppliers " + e.getMessage());
            return false;
        }
        System.out.println("wprowadzono new supplier");
        return true;
    }

    // metoda wczytujaca tabela OrdersDetails z bazy danych
    public String read(List<String> selectQueries, String columnName) throws SQLException {
        Statement statement = null;
        String resultMessage = "NO SELECT RESULT";


        try {
            statement = openConnection();

            for (String query : selectQueries) {
                //LOGGER.info(query);

                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    //LOGGER.info("Data was found! " + rs.getString(columnName));
                    resultMessage = rs.getString(columnName);
                    System.out.println("Data was found- wiersz " + rs.getRow() + "  =" + rs.getString(columnName));
                }

                rs.close();
            }

        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return resultMessage;
    }

        public String readRow(List<String> selectQueries, String columnName, int row) throws SQLException {
            Statement statement = dbConnection.createStatement(TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String resultMessage = "NO SELECT RESULT";


            try {
                statement =  openConnection();

                for (String query : selectQueries) {
                    //LOGGER.info(query);

                    ResultSet rs = statement.executeQuery(query);
                    rs.relative(row);

                        resultMessage= rs.getString(columnName);
                        System.out.println("Data was found- wiersz " +rs.getRow()+"  ="+ rs.getString(columnName));
                    rs.close();
                    }


                }


            catch (SQLException e) {
                // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
                System.out.println("read error " + e.getMessage());
            } finally {
                if (statement != null) {
                    statement.close();
                }
            }
            return resultMessage;
    }
    public String readAll(List<String> selectQueries) throws SQLException {
         Statement statement = dbConnection.createStatement(TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String resultMessage = "NO SELECT RESULT";

        try {
            statement = openConnection();

            for (String query : selectQueries) {
                //LOGGER.info(query);
                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                while (rs.next()) {
                     for (int i=1;i<=rsmd.getColumnCount(); i++)  {

                        //LOGGER.info("Data was found! " + rs.getString(columnName));
                        resultMessage = rs.getString(i);
                        System.out.println("Data was found- wiersz " + rs.getRow() +" kolumna "+i+ "  =" + resultMessage);
                    }

                }
                rs.close();
            }


        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return resultMessage;
    }

    public ArrayList<String> readWriteAll(List<String> selectQueries) throws SQLException {
        Statement statement = dbConnection.createStatement(TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String resultMessage = "NO SELECT RESULT";

        ArrayList<String> lista= new ArrayList<>();
        try {
            statement = openConnection();

            for (String query : selectQueries) {
                //LOGGER.info(query);
                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();


                while (rs.next()) {
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                        //LOGGER.info("Data was found! " + rs.getString(columnName));

                        lista.add(rs.getString(i));
                        System.out.print(" wiersz "+ rs.getRow() + " kolumna " + i + "  =" + rs.getString(i));
                    }
                    System.out.println("");

                }
                rs.close();
            }


        } catch (SQLException e) {
            // LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println("read error " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return lista;// zwraca tabele w formie ArrayListy Stringow
    }


    public void closeConnection() throws SQLException {
        if (dbConnection != null) {
            dbConnection.close();
        }
    }
    private Statement openConnection() throws SQLException {
        Statement statement;
        if (dbConnection == null) {
            dbConnection = DatabaseConnector.getDBConnection();
        }
        statement = dbConnection.createStatement();
        return statement;
    }

    private PreparedStatement openConnection1(String s) throws SQLException {
        PreparedStatement preparedStatement;
        if (dbConnection == null) {
            dbConnection = DatabaseConnector.getDBConnection();
        }
        preparedStatement = (PreparedStatement) dbConnection.prepareStatement(s);
        return preparedStatement;
    }
}
