import java.util.Scanner;

public class ini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a, b;
        int c, d;

        System.out.println("Menu : ");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.print("Pilih : ");
        int pilih = input.nextInt(); // Read user input
        if (pilih == 1) {
            input.nextLine();
            System.out.println("pilihan anda : Mobil"); // Output user input
            System.out.print("Masukkan merk : ");
            a = input.nextLine();
            System.out.print("Masukkan horse power : ");
            c = input.nextInt();
            System.out.print("Masukkan harga : ");
            d = input.nextInt();
            input.nextLine();
            System.out.print("Masukkan warna : ");
            b = input.nextLine();
            mobil Mobil = new mobil(a, c, d);
            Mobil.setWarna(b);
            System.out.print("Mobil dengan merk ");
            Mobil.bergerak();
            System.out.print("Mobil seharga " + d + " ini juga berwarna " + Mobil.getWarna());

        } else if (pilih == 2) {
            input.nextLine();
            System.out.println("pilihan anda : Motor"); // Output user input
            System.out.print("Masukkan merk : ");
            a = input.nextLine();
            System.out.print("Masukkan horse power : ");
            c = input.nextInt();
            System.out.print("Masukkan harga : ");
            d = input.nextInt();
            motor Motor = new motor(a, c, d);
            System.out.print("Motor seharga " + d + " dengan merk ");
            Motor.bergerak();
        } else {
            System.out.println("Menu tidak tersedia");
        }
    }
}
