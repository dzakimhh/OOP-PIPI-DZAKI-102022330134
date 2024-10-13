public class Penumpang {

    private final String NIK;
    private final String namaDepan;
    private final String namaBelakang;

    public Penumpang(String NIK, String namaDepan, String namaBelakang) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public String NIK() {
        return NIK;
    }

    public String NAMADEPAN() {
        return namaDepan;
    }

    public String NAMABELAKANG() {
        return namaBelakang;
    }

    public void tampilDaftarPenumpang() {
        System.out.println("Nomor Induk Kependudukan: " + NIK);
        System.out.println("Nama Depan: " + namaDepan);
        System.out.println("Nama Belakang: " + namaBelakang);
    }
}