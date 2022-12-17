package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    //connection
    //statement
    //close
    //com.mysql.jdbc.Driver
//oracle.jdbc.driver.OracleDriver
//org.postgresql.Driver
//com.microsoft.sqlserver.jdbc.SQLServerDrive
//org.sqlite.JDBC
    //bunlar sabit, hangisini kullanacaksak sec
    private static Connection con;
    private static Statement st;

    public static Connection getConnection(String hostname, String databaseismi,String username,String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //url syntax:jdbc:postgresql://hostname:portnumber/databaseismi
        String url="jdbc:postgresql://"+hostname+":5432/"+databaseismi;
        try {
            con= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
public static Statement getStatement(){
    try {
        st=con.createStatement();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return st;
}
public static void closeConnection(){
    try {
        con.close();
        st.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}


}
