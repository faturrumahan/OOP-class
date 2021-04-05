public abstract class kendaraanbermotor {
    String merk;
    int hp;
    int harga;

    public kendaraanbermotor(String merk, int hp, int harga) {
        this.merk = merk;
        this.hp = hp;
        this.harga = harga;
    }

    void bergerak() {
        System.out.println("ngeng");
    }

    abstract double kecepatan();
}
