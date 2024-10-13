import java.util.ArrayList;
import java.util.Scanner;

public class Pembelian {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
            Penumpang penumpang = null;

            daftarPenerbangan.add(new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000));
            daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000));

            int pilihan = 0;
            String nomorPenerbanganDipilih = null;

            while (pilihan != 4) {
                System.out.println("======= EAD Ticket Booking System =======");
                System.out.println("1. Tampilkan Daftar Penerbangan");
                System.out.println("2. Beli Tiket");
                System.out.println("3. Tampilkan Pesanan Tiket");
                System.out.println("4. Exit");
                System.out.print("Silahkan pilih menu: \n");
                
                if (scanner.hasNextInt()) {
                    pilihan = scanner.nextInt();
                } else {
                    System.out.println("Input tidak valid. Tolong masukkan angka dari 1-4.");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n");
                        for (int i = 0; i < daftarPenerbangan.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarPenerbangan.get(i).tampilDaftarPenerbangan();
                            System.out.println();
                        }
                    }
                    case 2 -> {
                        System.out.println("\nSilakan isi data diri anda terlebih dahulu!");
                        System.out.println("-----------------------------");
                        System.out.print("Masukan NIK: \n");
                        String NIK = scanner.nextLine();
                        System.out.print("Masukan Nama Depan: \n");
                        String namaDepan = scanner.nextLine();
                        System.out.print("Masukan Nama Belakang: \n");
                        String namaBelakang = scanner.nextLine();

                        penumpang = new Penumpang(NIK, namaDepan, namaBelakang);
                        System.out.println("\nTerima Kasih telah Mengisi Data Pelanggan. Silakan Pilih Tiket Penerbangan Yang Tersedia");
                        System.out.println("-----------------------------");

                        for (int i = 0; i < daftarPenerbangan.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarPenerbangan.get(i).tampilDaftarPenerbangan();
                            System.out.println();
                        }

                        System.out.print("\nPilih nomor penerbangan (ex: 1): \n");
                        if (scanner.hasNextInt()) {
                            int pilihanPenerbangan = scanner.nextInt();
                            scanner.nextLine();  

                            if (pilihanPenerbangan >= 1 && pilihanPenerbangan <= daftarPenerbangan.size()) {
                                nomorPenerbanganDipilih = daftarPenerbangan.get(pilihanPenerbangan - 1).NOMORPENERBANGAN();
                                System.out.println("\nPemesanan Tiket Berhasil Dilakukan, Cek Pesanan Tiket pada Menu (3)\n");
                            } else {
                                System.out.println("\nNomor penerbangan tidak valid.\n");
                            }
                        } else {
                            System.out.println("Input tidak valid. Tiket batal dibeli.\n");
                            scanner.next();
                        }
                    }
                    case 3 -> {
                        if (penumpang == null || nomorPenerbanganDipilih == null) {
                            System.out.println("Pembelian Tiket Tidak Ada\n");
                        } else {
                            System.out.println("\n======= Detail Tiket Penerbangan =======");
                            penumpang.tampilDaftarPenumpang();
                            for (Penerbangan penerbangan : daftarPenerbangan) {
                                if (penerbangan.NOMORPENERBANGAN().equals(nomorPenerbanganDipilih)) {
                                    penerbangan.tampilDaftarPenerbangan();
                                    break;
                                }
                            }
                            System.out.println();
                        }
                    }
                    case 4 -> System.out.println("Terima kasih!");
                    default -> System.out.println("Pilihan tidak valid, coba lagi.");
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}