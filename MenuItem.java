import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    private String name;
    private int price;
    private int qty;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public int setQty(int qty) {

        return this.qty += qty;
    }
}

class Menu {

    ArrayList<MenuItem> pesananMenuItems = new ArrayList<>();

    private MenuItem[] menuItems = {
            new MenuItem("Nasi Goreng", 15000),
            new MenuItem("Mie Goreng", 13000),
            new MenuItem("Bihun Goreng", 12000),
            new MenuItem("Es Teh Manis", 3000),
            new MenuItem("Es Jeruk", 8000)
    };

    public void printOrder() {
        for (MenuItem order : pesananMenuItems) {
            System.out.println(order.getName() + " " + order.getPrice() + " " + order.getQty());
        }
    }

    public void printMenu() {
        System.out.println("================");
        System.out.println("Selamat Datang di Binar FUD");
        System.out.println("================");
        System.out.println("Silahkan Pilih Makanan : ");
        for (int i = 0; i < this.menuItems.length; i++) {
            System.out.println((i + 1) + ". " + this.menuItems[i].getName() + " | " + this.menuItems[i].getPrice());
        }
        System.out.println("98. Lihat Menu");
        System.out.println("99. Pesan dan Bayar");
    }

    public int printMenu(int pilihan) {
        int hasil = 0;
        System.out.println("================");
        System.out.println("Berapa pesanan anda");
        System.out.println("================");
        System.out.println(this.menuItems[pilihan].getName() + " | " + this.menuItems[pilihan].getPrice());
        System.out.println("input 0 untuk kembali");

        Scanner input = new Scanner(System.in);

        System.out.print("Qty :");
        int banyak = input.nextInt();

        if (banyak == 0) {
            System.out.println(hasil);
            return hasil;
        } else {

            for (MenuItem order : pesananMenuItems) {
                // Jika pesanan yang sama sudah ada, tambahkan qty
                if (order.getName().equals(this.menuItems[pilihan].getName())) {
                    // Mengubah qty sesuai dengan input baru
                    order.setQty(banyak);
                    hasil += (this.menuItems[pilihan].getPrice() * banyak);
                    System.out.println("Anda Memesan " + this.menuItems[pilihan].getName() + " sebanyak " + banyak
                            + " = " + hasil);
                    return hasil;
                }
            }

            // Jika pesanan yang sama belum ada, tambahkan ke dalam ArrayList
            pesananMenuItems
                    .add(new MenuItem(this.menuItems[pilihan].getName(), this.menuItems[pilihan].getPrice(), banyak));

            hasil += (this.menuItems[pilihan].getPrice() * banyak);

            System.out
                    .println("Anda Memesan " + this.menuItems[pilihan].getName() + " sebanyak " + banyak + " = "
                            + hasil);

            return hasil;

        }

    }

    public ArrayList<MenuItem> orderMenu(int pilihan) {
        ArrayList<MenuItem> order = new ArrayList<>();
        order.add(new MenuItem(this.menuItems[pilihan].getName(), this.menuItems[pilihan].getPrice()));

        return order;

    }

}
