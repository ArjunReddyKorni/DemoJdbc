import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        Statement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesperson","root","Arjun@123");
            if(connection != null){
                System.out.println("CONNECTED");
                st = connection.createStatement();
               boolean row = st.execute("CREATE TABLE salesDetails(salesId int PRIMARY KEY,salespersonName varchar(100),city varchar(100),commissionRate double)");

                if(row){
                    System.out.println("TABLE NOT CREATED");
                } else if (row) {
                    System.out.println("TABLE  CREATED");
                }

                int row1 = st.executeUpdate("INSERT into salesDetails values(1001,'Mary','berlin',24.0)");
                int row2 = st.executeUpdate("INSERT into salesDetails values(1002,'sam','stockholm',25.0)");
                int row3 = st.executeUpdate("INSERT into salesDetails values(1003,'dave','rome',12.0)");
                int row4 = st.executeUpdate("INSERT into salesDetails values(1004,'gary','stockholm',13.5)");

                    if(row1 == 1){
                        System.out.println("DATA INSERTED");
                    }else {
                        System.out.println("not inserted");
                    }


               ResultSet resultSet = st.executeQuery("SELECT * FROM salesdetails");
                while(resultSet.next()){
                    System.out.println("SalesId = " + resultSet.getInt(1));
                    System.out.println("Name = " + resultSet.getString(2));
                    System.out.println("City = " + resultSet.getString(3));
                    System.out.println("CommissionRate = " + resultSet.getInt(4));


                }


            }else
                System.out.println("not connected");
        } catch (ClassNotFoundException e) {
            System.out.println("e = " + e);

        } catch (SQLException e) {
            System.out.println("e = " + e);

        }


    }
}
