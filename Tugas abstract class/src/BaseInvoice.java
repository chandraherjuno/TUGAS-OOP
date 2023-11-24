public abstract class BaseInvoice {
    public String kode_invoice;
    public String nama_supplier;
    public String klasifikasi_produk;
    public String jumlah_box;
    public String waiting_time_pembongkaran;
    
    public void estimasi_sampai(){
        System.out.println("estimasi waktu pengantaran?");
    }
    public abstract void Pengiriman_wilayah();

}


