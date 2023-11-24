public class Main {
    public static void main(String[] args) {
        BaseInvoice yogya = new BaseInvoice();
        yogya.kode_invoice = "001";
        yogya.klasifikasi_produk = "convenience";
        yogya.nama_supplier = "juno chicken";
        yogya.waiting_time_pembongkaran = "10 menit";
        yogya.jumlah_box = "100 box";
        yogya.estimasi_sampai();
        yogya.Pengiriman_wilayah();
    }
}
