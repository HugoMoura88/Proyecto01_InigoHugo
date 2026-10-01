
package util;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

/**
 * Clase encargada de realizar la conexión con la base de datos de MySQL 
 * utilizando los datos del archivo .env.
 * 
 * @author InigoHugo
 * @version 1.0

 */
public class mysqlconnect {
   /**
    * 
    * @return la conexión con MySQL
    * @throws SQLException si se produce un error al establecer la conexión.
    */
   public static Connection conectar() throws SQLException {
        Dotenv env = Dotenv.load();

        String url = env.get("DB_URL");
        String user = env.get("DB_USER");
        String pass = env.get("DB_PASS");

        return DriverManager.getConnection(url, user, pass);
        
    }
   
}
