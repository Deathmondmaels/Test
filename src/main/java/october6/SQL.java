package october6;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class SQL {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, Exception {
        String userName = "root";
        String password = "31088888";
        String connectionUrl = "jdbc:mysql://localhost:3306/mytable?useSSL=false";
        Scanner scanner = new Scanner(System.in);
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        System.out.print("Input product name: ");
        String name = scanner.nextLine();
        System.out.print("Input product price: ");
        int price = scanner.nextInt();
        //String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            String sql = "INSERT INTO Products (ProductName, Price) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            int rows = preparedStatement.executeUpdate();
            //Statement statement = connection.createStatement();
            //statement.executeUpdate(sqlCommand);
            //int rows = statement.executeUpdate("INSERT Products(ProductName, Price) VALUES ('iPhone X', 76000)," + "('Galaxy S9', 45000), ('Nokia 9', 36000)");
            //int rows = statement.executeUpdate("UPDATE Products SET Price = Price - 5000");
            //ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
//            while (resultSet.next()){
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                int price = resultSet.getInt(3);
                //System.out.printf("%d. %s. - %d \n", id, name, price);
            System.out.printf("%d rows added", rows);
            }
            //System.out.printf("Added %d rows", rows);
            //System.out.printf("Updated %d rows", rows);
        }
    }
