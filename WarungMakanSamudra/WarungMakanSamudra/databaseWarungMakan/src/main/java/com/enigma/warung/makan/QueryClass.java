package com.enigma.warung.makan;

public class QueryClass {
    private String QueryCase2 = """
            SELECT COUNT(id_pembayaran_transaksi) AS LayananTerpakai, pembayaran.nama_pembayaran AS TipePembayaran,SUM(produk.harga * transaksi.barang_terjual) AS TotalTerjual FROM pembayaran
            JOIN transaksi ON transaksi.id_pembayaran_transaksi = pembayaran.id_pembayaran
            JOIN produk ON produk.kode_produk = transaksi.id_makanan
            GROUP BY pembayaran.nama_pembayaran;
            """;

    public String getQueryClass1() {
        return QueryClass1;
    }

    private String QueryClass1 = """
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

    String case3 = """
            SELECT
                cabang.Nama_Cabang AS Cabang,
                COUNT(transaksi.barang_terjual) AS Terjual,
                SUM(
                    produk.harga * transaksi.barang_terjual
                ) AS ProdukTerjual
            FROM
                cabang
            JOIN transaksi ON transaksi.id_cabang_transaksi = cabang.kode_cabang
            JOIN produk ON produk.kode_produk = transaksi.id_makanan
            GROUP BY
                transaksi.id_cabang_transaksi;
            """;

    public String getCase3() {
        return case3;
    }

    public String getQueryCase2() {
        return QueryCase2;
    }
}
