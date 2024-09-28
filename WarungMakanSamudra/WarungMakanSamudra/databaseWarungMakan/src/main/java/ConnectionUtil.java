import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class ConnectionUtil {


    static private HikariDataSource dataSource;

    static{

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost/warung_makan_samudra");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("");

        dataSource = new HikariDataSource(config);

    }

    public static HikariConfig getDataSource() {
        return dataSource;
    }
}
