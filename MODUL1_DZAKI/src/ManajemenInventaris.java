// Don't delete any comments below!!!
// Todo : Import Arraylist and Scanner
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenInventaris {
    // Todo : Create ArrayList of MakananKering (daftarMakananKering) and MakananBasah (daftarMakananBasah) to store items
    private ArrayList <MakananKering>  daftarMakananKering = new ArrayList<>();
    private ArrayList <MakananBasah>  daftarMakananBasah = new ArrayList<>(); 


    public void tambahMakananKering() {
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Brand Makanan
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Makanan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jumlah Makanan: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan Harga Makanan: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan Brand Makanan: ");
        String brand = scanner.nextLine();
        // Todo : Create a new object for MakananKering
        MakananKering makananKering = new MakananKering(nama, jumlah, harga, brand);
        daftarMakananKering.add(makananKering);
        // Todo : Create Print Notifitaction "Makanan kering berhasil ditambahkan"
        System.out.println("Makanan Kering berhasil ditambahkan!");
    }

    public void tambahMakananBasah() {
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Bahan Makanan
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Makanan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jumlah Makanan: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan Harga Makanan: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        String bahan = scanner.nextLine();
        // Todo : Create a new object for MakananBasah
        MakananBasah makananBasah = new MakananBasah(nama, jumlah, harga, bahan);
        daftarMakananBasah.add(makananBasah);
        // Todo :Create Print Notifitaction "Makanan Basah berhasil ditambahkan"
        System.out.println("Makanan Basah berhasil ditambahkan");
    }

    public void tampilkanSemuaMakanan() {
        if (daftarMakananKering.isEmpty() && daftarMakananBasah.isEmpty()) {
            // Todo : Create Print Notification "Tidak ada makanan disini"
            System.out.println("Tidak ada Makanan dalam inventaris.");
        } else {
            // Todo : Create print notification for Makanan Kering  
            System.out.println("=== Daftar Makanan Kering ===");
            for (MakananKering mk : daftarMakananKering) {
                mk.tampilkanData();
                System.out.println();
            }
           // Todo : Create print notification for  Makanan Basah
            System.out.println("=== Daftar Makanan Basah ===");
            for (MakananBasah mb : daftarMakananBasah) {
                mb.tampilkanData();
                System.out.println();
            }
            
           
        }
    }
}