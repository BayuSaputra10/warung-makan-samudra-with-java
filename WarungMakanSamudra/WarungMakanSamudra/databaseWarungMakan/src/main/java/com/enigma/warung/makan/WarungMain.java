//Created By : Bayu Saputra
// Note : Project ini saya buat untuk submission Java Database

package com.enigma.warung.makan;

import java.sql.SQLException;
import java.util.Scanner;

public class WarungMain {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("===== APLIKASI REKAPITULASI WARUNG MAKAN SAMUDRA =====");

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Lihat Rekap Keseluruhan");
            System.out.println("2. Lihat Rekapitulasi Per-Kolom");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu (1/2/3): ");
            int choice = in.nextInt();

            LihatRekap rekap = new LihatRekap();
            switch (choice) {
                case 1:
                    rekap.getFullRekap();
                    break;
                case 2:
                    rekap.getRecapDivision();
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

}
