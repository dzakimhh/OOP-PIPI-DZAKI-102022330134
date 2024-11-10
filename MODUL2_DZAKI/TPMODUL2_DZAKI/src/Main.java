public class Main {
    public static void main(String[] args) {
        System.out.println("Data Hewan!!!\n");

        Kucing kucing = new Kucing("Milo", 3, "Anggora");
        System.out.println("Nama Hewan: " + kucing.nama);
        kucing.suara();
        kucing.makan();
        kucing.makan("daging ayam");
        System.out.println();

        Burung burung = new Burung("Molly", 2, "Abu Gelap");
        System.out.println("Nama Hewan: " + burung.nama);
        burung.suara();
        burung.makan();
        burung.makan("biji bunga matahari");
        System.out.println();

        System.out.println("Informasi Detail Hewan:");
        kucing.infoHewan();
        burung.infoHewan();
    }
}