 public class Order {
    MenuItem item;
    int jumlah;
    Customer customer;

    public Order(MenuItem item, int jumlah, Customer customer) {
        this.item = item;
        this.jumlah = jumlah;
        this.customer = customer;
    }

    public int getTotalHarga() { // overriding
        return item.harga * jumlah;
    }
}