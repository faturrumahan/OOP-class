public class mobil extends kendaraanbermotor {
    private String warna;

    public String getWarna() {
        return this.warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public mobil(String merk, int hp, int harga) {
        super(merk, hp, harga);
    }

    @Override
    double kecepatan() {
        return (hp / 0.6); // misale ada rumus hp --> km/h begini
    }

    void bergerak() {
        System.out.println(merk + " dapat bergerak secepat " + kecepatan() + " km/h");
    }
}
