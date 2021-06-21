package connect;

import java.sql.*;

public class koneksi {
    private static Connection koneksi;
    public static Connection getKoneksi()
    {
        if(koneksi == null)
        {
            try {
                String url="jdbc:mysql://localhost/responsipbo";
                String username= "root";     
                String password= "";         
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
            }
        }
        return koneksi;
    }
}
