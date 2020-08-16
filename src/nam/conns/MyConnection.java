/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.conns;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Đỗ Nam
 */
public class MyConnection implements Serializable{
    public static Connection getMyConnection() throws Exception {
        //1
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1455;databaseName=PE01", "sa", "123");
        return conn;
    }
}
