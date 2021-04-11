import java.util.InputMismatchException;
import java.util.Scanner;

public class ini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = "0", b = "0";
        int c = 0, d = 0, pilih = 0;

        System.out.println("Menu : ");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");

        try {
            System.out.print("Pilih : ");
            pilih = input.nextInt(); // ketika pemilihan menu, user input nama "ex : mobil" bukan angka disamping
        } catch (InputMismatchException error) {
            System.out.println("errornya adalah " + error.getMessage());
        } finally {
            if (pilih == 1) {
                input.nextLine();
                try {
                    System.out.println("pilihan anda : Mobil"); // Output user input
                    System.out.print("Masukkan merk : ");
                    a = input.nextLine();
                    System.out.print("Masukkan horse power : ");
                    c = input.nextInt(); //ketika memasukkan hp, mungkin user menginputkan hp bukan dengan angka atau ditambah satuan "ex : 50hp"
                    System.out.print("Masukkan harga : ");
                    d = input.nextInt(); //ketika memasukkan harga, mungkin user menginputkan harga bukan dengan angka
                    input.nextLine();
                    System.out.print("Masukkan warna : ");
                    b = input.nextLine();
                } catch (Exception error) {
                    System.out.println("errornya adalah " + error.getMessage());
                } finally {
                    mobil Mobil = new mobil(a, c, d);
                    Mobil.setWarna(b);
                    System.out.print("Mobil dengan merk ");
                    Mobil.bergerak();
                    System.out.print("Mobil seharga " + d + " ini juga berwarna " + Mobil.getWarna());
                }

            } else if (pilih == 2) {
                input.nextLine();
                try {
                    System.out.println("pilihan anda : Motor"); // Output user input
                    System.out.print("Masukkan merk : ");
                    a = input.nextLine();
                    System.out.print("Masukkan horse power : ");
                    c = input.nextInt(); //ketika memasukkan hp, mungkin user menginputkan hp bukan dengan angka atau ditambah satuan "ex : 50hp"
                    System.out.print("Masukkan harga : ");
                    d = input.nextInt(); //ketika memasukkan harga, mungkin user menginputkan harga bukan dengan angka
                } catch (Exception error) {
                    System.out.println("errornya adalah " + error.getMessage());
                } finally {
                    motor Motor = new motor(a, c, d);
                    System.out.print("Motor seharga " + d + " dengan merk ");
                    Motor.bergerak();
                }

            } else {
                System.out.println("Menu tidak tersedia");
            }
        }
    }
}
