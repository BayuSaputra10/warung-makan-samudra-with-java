package com.enigma.warung.makan;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.Scanner;

public class LihatRekap {
    public void getFullRekap() throws SQLException {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost/warung_makan_samudra");
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setUsername("root");
//        config.setPassword("");
//
//        HikariDataSource dataSource = new HikariDataSource(config);

        String jdbcUrl = "jdbc:mysql://localhost:3306/warung_makan_samudra";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

        Statement statement = connection.createStatement();
//        Statement statement = dataSource.getConnection().createStatement();

        String sql = """
                 SELECT
                     Tanggal_transaksi AS Tanggal,
                     No_Struk AS Struk,
                     cabang.kode_cabang AS KodeCabang,
                     cabang.Nama_Cabang AS NamaCabang,
                     pembayaran.nama_pembayaran AS TipePembayaran,
                     produk.kode_produk AS KodeProduk,
                     produk.Nama_produk AS NamaProduk,
                     transaksi.barang_terjual AS Terjual,
                     produk.harga AS Harga,
                         SUM(transaksi.barang_terjual * produk.harga) AS Total
                     
                 FROM
                     `transaksi`
                 JOIN cabang ON transaksi.id_cabang_transaksi = cabang.kode_cabang
                 JOIN produk ON transaksi.id_makanan = produk.kode_produk
                 JOIN pembayaran ON transaksi.id_pembayaran_transaksi = pembayaran.id_pembayaran
                 GROUP BY
                 transaksi.id_transaksi;
                """;

        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            System.out.printf("%-20s",columnName);
        }
        System.out.println();

        // Tampilkan data
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnValue = resultSet.getString(i);
                System.out.printf("%-20s",columnValue);
            }
            System.out.println();
        }

        resultSet.close();
        statement.close();
    }

    public void getRecapDivision() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/warung_makan_samudra";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);


        Scanner in = new Scanner(System.in);

        Statement statement = connection.createStatement();

        System.out.println("1. Sesuai Tipe Pembayaran");
        System.out.println("2. Sesuai Layanan Pembayaran");
        System.out.println("2. Sesuai Cabang");

        System.out.print("Masukan Pilihan : ");
        System.out.println();

        switch (in.nextInt()){
            case 1 -> {
                QueryClass case1 = new QueryClass();
                ResultSet resultSet = statement.executeQuery(case1.getQueryClass1());

                while(resultSet.next()){
                    System.out.print("Tipe Pembayaran : ");
                    System.out.println(resultSet.getString("TipePembayaran"));
                    System.out.print("Total Pemasukan : ");
                    System.out.println(resultSet.getString("Terjual"));
                    System.out.println();
                }
            }
            case 2 -> {
                QueryClass case2 = new QueryClass();
                ResultSet resultSet = statement.executeQuery(case2.getQueryCase2());
                while (resultSet.next()) {
                    System.out.print("Nama Layanan : ");
                    System.out.println(resultSet.getString("LayananTerpakai"));
                    System.out.print("Tipe Pembayaran : ");
                    System.out.println(resultSet.getString("TipePembayaran"));
                    System.out.print("Total : ");
                    System.out.println(resultSet.getString("TotalTerjual"));
                    System.out.println();
                }
            }
            case 3 -> {
                QueryClass case3 = new QueryClass();
                ResultSet resultSet = statement.executeQuery(case3.getCase3());
                while (resultSet.next()) {
                    System.out.print("Nama Cabang : ");
                    System.out.println(resultSet.getString("Cabang"));
                    System.out.print("Tipe Pembayaran : ");
                    System.out.println(resultSet.getString("Terjual"));
                    System.out.print("Total : ");
                    System.out.println(resultSet.getString("ProdukTerjual"));
                    System.out.println();
                }
            }
            default -> System.out.println("Salah input");
        }

    }
}
