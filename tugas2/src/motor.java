public class motor extends kendaraanbermotor {

    public motor(String merk, int hp, int harga) {
        super(merk, hp, harga);
    }

    @Override
    double kecepatan() {
        return (hp / 0.7);
    }

    void bergerak() {
        System.out.println(merk + " dapat bergerak secepat " + kecepatan() + " km/h");
    }
}
