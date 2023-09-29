// Menu item buat ArrayList
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
