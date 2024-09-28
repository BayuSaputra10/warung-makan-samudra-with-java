import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterDriver {
    @Test
    void registTest() throws SQLException {
        Driver drivertest = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(drivertest);
    }
}
