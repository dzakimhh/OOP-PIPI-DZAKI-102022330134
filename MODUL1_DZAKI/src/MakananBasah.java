// Don't delete any comments below!!!
public class MakananBasah{
    // Todo : Create private attribute of MakananKering (nama, jumlah, harga, and bahan)
    private String bahan;
    private String nama;
    private int jumlah;
    private double harga;
    // Todo : Create Constructor of MakananBasah
    public MakananBasah (String nama, int jumlah, double harga, String bahan) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.bahan = bahan;
    }
    // Todo : Create Getter and Setter
    public String getBahan(){
        return bahan;
    }

    public void setBahan(String bahan){
        this.bahan = bahan;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Todo : Create Method ShowData
    public void tampilkanData() {
        System.out.println("Nama Makanan: " + nama);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Harga: " + harga);
        System.out.println("Bahan: " + bahan);
    }
}
