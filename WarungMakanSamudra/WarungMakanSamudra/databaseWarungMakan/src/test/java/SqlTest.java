import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class SqlTest {
    @Test
    void testHikariCp() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getDataSource().getConnection();
        Statement statement = connection.createStatement();


        String sql = """
                   SELECT * FROM transaksi
                    """;

        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void manualHikariCp() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost/warung_makan_samudra");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("");

        HikariDataSource dataSource = new HikariDataSource(config);

        dataSource.getConnection();
        dataSource.close();
    }

    @Test
    void ConnectDatabse() {
        String jdbcUrl = "jdbc:mysql://localhost/warung_makan_samudra";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Sukses Koneksi Ke Database");
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
