public class Penerbangan {
    private final String nomorPenerbangan;
    private final String bandaraKeberangkatan;
    private final String bandaraTujuan;
    private final String waktuKeberangkatan;
    private final String waktuKedatangan;
    private final float hargaTiket;
    
    public Penerbangan(String nomorPenerbangan, String bandaraKeberangkatan, String bandaraTujuan,
                       String waktuKeberangkatan, String waktuKedatangan, float hargaTiket) {
        this.nomorPenerbangan = nomorPenerbangan;
        this.bandaraKeberangkatan = bandaraKeberangkatan;
        this.bandaraTujuan = bandaraTujuan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.hargaTiket = hargaTiket;
    }

    public String NOMORPENERBANGAN() {
        return nomorPenerbangan;
    }

    public String BANDARAKEBERANGKATAN() {
        return bandaraKeberangkatan;
    }

    public String BANDARATUJUAN() {
        return bandaraTujuan;
    }

    public String WAKTUKEBERANGKATAN() {
        return waktuKeberangkatan;
    }

    public String WAKTUKEDATANGAN() {
        return waktuKedatangan;
    }

    public float HARGATIKET() {
        return hargaTiket;
    }

    public void tampilDaftarPenerbangan() {
        System.out.println("\nNomor Penerbangan: " + nomorPenerbangan);
        System.out.println("Bandara Keberangkatan: " + bandaraKeberangkatan + " ---> Bandara Tujuan: " + bandaraTujuan);
        System.out.println("Waktu Keberangkatan: " + waktuKeberangkatan + " ---> Waktu Kedatangan: " + waktuKedatangan);
        System.out.println("Harga Tiket: Rp." + hargaTiket);
    }
}