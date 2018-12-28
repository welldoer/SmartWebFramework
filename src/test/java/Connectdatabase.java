import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.junit.Test;

//import org.junit.jupiter.api.Test;


public class Connectdatabase {

        Connection con = null;

//        @Test
        public void testDB() {
        	ConnecrDb();
        }
        
        public static Connection ConnecrDb(){

            try{
                //String dir = System.getProperty("user.dir");
                Class.forName("org.sqlite.JDBC");
                Connection con = DriverManager.getConnection("jdbc:sqlite:build/sample.db");
                System.out.println( "ok!");
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery( "select * from customer where id = 1;" );
                
                return con;
            }
            catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null,"Problem with connection of database");
                return null;
            }
        }

    }