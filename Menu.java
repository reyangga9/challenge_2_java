import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    // pake arrayList Object MenuItem biar bisa 2 tipe data
    DecimalFormat decimalFormat = new DecimalFormat("#,###");
    ArrayList<MenuItem> pesananMenuItems = new ArrayList<>();

    // Print arrayList
    public void printOrder() {
        for (MenuItem order : pesananMenuItems) {
            System.out.println(order.getName() + " " + decimalFormat.format(order.getPrice() * order.getQty()) + " "
                    + order.getQty());
        }
    }

    // membuat Menunya
    private MenuItem[] menuItems = {
            new MenuItem("Nasi Goreng", 15000),
            new MenuItem("Mie Goreng", 13000),
            new MenuItem("Bihun Goreng", 12000),
            new MenuItem("Es Teh Manis", 3000),
            new MenuItem("Es Jeruk", 8000)
    };

    // Looping menunya sama nampilin menu
    public void printMenu() {
        System.out.println("================");
        System.out.println("Selamat Datang di Binar FUD");
        System.out.println("================");
        System.out.println("Silahkan Pilih Makanan : ");
        for (int i = 0; i < this.menuItems.length; i++) {
            System.out.println((i + 1) + ". " + this.menuItems[i].getName() + " | "
                    + decimalFormat.format(this.menuItems[i].getPrice()));
        }
        System.out.println("98. Lihat Menu");
        System.out.println("99. Pesan dan Bayar");
    }

    // Mesen
    public int printMenu(int pilihan) {
        int hasil = 0;
        System.out.println("================");
        System.out.println("Berapa pesanan anda");
        System.out.println("================");
        System.out.println(
                this.menuItems[pilihan].getName() + " | " + decimalFormat.format(this.menuItems[pilihan].getPrice()));
        System.out.println("input 0 untuk kembali");

        Scanner input = new Scanner(System.in);

        System.out.print("Qty :");
        int banyak = input.nextInt();

        if (banyak == 0) {

            return hasil;
        } else {

            for (MenuItem order : pesananMenuItems) {
                // Jika pesanan yang sama sudah ada, tambahkan qty
                if (order.getName().equals(this.menuItems[pilihan].getName())) {
                    // Mengubah qty sesuai dengan input baru
                    order.setQty(banyak);
                    hasil += (this.menuItems[pilihan].getPrice() * banyak);
                    System.out.println("Anda Memesan " + this.menuItems[pilihan].getName() + " sebanyak " + banyak
                            + " = " + decimalFormat.format(hasil));
                    return hasil;
                }
            }

            // Jika pesanan yang sama belum ada, tambahkan ke dalam ArrayList
            pesananMenuItems
                    .add(new MenuItem(this.menuItems[pilihan].getName(), this.menuItems[pilihan].getPrice(), banyak));

            hasil += (this.menuItems[pilihan].getPrice() * banyak);

            System.out
                    .println("Anda Memesan " + this.menuItems[pilihan].getName() + " sebanyak " + banyak + " = "
                            + decimalFormat.format(hasil));

            return hasil;

        }

    }

    // buat file ke txt
    public void saveOrderToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("================ \nBinar FUD  \n================ \n");
            writer.write("Terima kasih sudah memesan di BinarFud \nDibawah ini adalah pesanan anda\n \n");
            for (MenuItem order : pesananMenuItems) {
                writer.newLine();
                writer.write(order.getName() + " " + decimalFormat.format(order.getPrice() * order.getQty()) + " "
                        + order.getQty());
            }
            writer.newLine();
            writer.write("================ \nSimpan struk sebagai bukti pembayaran \n================ \n");

            System.out.println("Bip bip bip... pesanan telah di print ke " + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
