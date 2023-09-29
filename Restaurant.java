
import java.util.Scanner;

public class Restaurant {

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.printMenu();

        int choice;
        int hasil = 0;
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("=======Pilih Menu=======: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:

                    hasil += menu.printMenu(0);

                    break;
                case 2:
                    hasil += menu.printMenu(1);
                    break;
                case 3:
                    hasil += menu.printMenu(2);
                    break;
                case 4:
                    hasil += menu.printMenu(3);
                    break;
                case 5:

                    hasil += menu.printMenu(4);
                    break;
                case 97:
                    System.out.println("Pesanan saat ini");
                    menu.printOrder();
                case 98:
                    menu.printMenu();
                    break;
                case 99:
                    System.out.println("================");
                    System.out.println("Konfirmasi & Pembayaran");
                    System.out.println("================");

                    menu.printOrder();

                    System.out.println("-------------------+");
                    System.out.println("Total : " + hasil);

                    System.out.println("1. Konfirmasi dan Bayar");
                    System.out.println("2. Kembali ke menu utama");
                    System.out.println("0. Keluar Aplikasi");
                    System.out.print("=>");
                    int confirm = input.nextInt();
                    switch (confirm) {

                        case 1:
                            System.out.println("Cumanprint");
                            System.exit(0);

                        case 2:
                            System.out.println("Kembali ke menu awal ----");
                            break;
                        case 0:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Pilihan salah -> Kembali ke menu awal ");
                            break;
                    }

                    break;

                default:
                    System.out.println("Pilihan Salah ");

                    break;

            }
        }

    }

}
