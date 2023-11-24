import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Meminta memasukkan nama dan NIM
        System.out.println("Masukkan Nama :");
        String nama = input.nextLine();

        System.out.println("Masukkan NIM: ");
        String nim = input.nextLine(); // Menggunakan String untuk NIM

        // Meminta memasukkan nilai-nilai
        System.out.println("Masukkan Nilai Tubes: ");
        double nilaiTubes = input.nextDouble();

        System.out.println("Masukkan Nilai Quiz: ");
        double nilaiQuiz = input.nextDouble();

        System.out.println("Masukkan Nilai Tugas: ");
        double nilaiTugas = input.nextDouble();

        System.out.println("Masukkan Nilai UTS: ");
        double nilaiUTS = input.nextDouble();

        System.out.println("Masukkan Nilai UAS: ");
        double nilaiUAS = input.nextDouble();

        // Menghitung nilai akhir
        double nilaiAkhir = Operator.calculateNilaiAkhir(nilaiTubes, nilaiQuiz, nilaiTugas, nilaiUTS, nilaiUAS);
        
        // Menampilkan nama, nim dan nilai akhir
        System.out.println("\nNama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Nilai Matakuliah Pemrograman Berorientasi Objek :" + nilaiAkhir);

        // Menutup scanner
        input.close();
    }
}


