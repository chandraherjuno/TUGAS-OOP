import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // membaca input dari penggun
        Cafe cafe = new Cafe(); //object nya cafe
        Order[] orders = new Order[100]; // melacak jumlah pesanan
        int totalOrders = 0;

        while (true) {
            System.out.println("Selamat datang di Cafe Juno!");
            System.out.println("1. Pesan Menu");
            System.out.println("2. Total Orderan Hari Ini");
            System.out.println("3. Keluar");
            System.out.print("Menu yang dipilih: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("------------------------");
                System.out.print("Nama Pelanggan: ");
                String customerName = scanner.next();
                System.out.print("Nomor Meja: ");
                String tableNumber = scanner.next();

               
                Customer customer = new Customer(customerName, tableNumber);

                System.out.println("1. Makanan");
                System.out.println("2. Minuman");
                System.out.println("3. Kembali");
                System.out.println("------------------------");
                System.out.print("Menu yang dipilih: ");
                int menuChoice = scanner.nextInt();

                if (menuChoice == 1) {
                    cafe.displayFoodMenu();
                    System.out.print("Menu yang dipilih: ");
                    int foodChoice = scanner.nextInt();

                    if (foodChoice <= 0 || foodChoice > cafe.makananMenu.length) {
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                        continue;
                    }

                    System.out.print("Berapa jumlah pesanan? ");
                    int quantity = scanner.nextInt();

                    
                    if (cafe.makananMenu[foodChoice - 1].stok < quantity) {
                        System.out.println("Maaf, stok tidak mencukupi. Silakan pilih lagi.");
                        continue;
                    }

                    cafe.makananMenu[foodChoice - 1].stok -= quantity;
                    orders[totalOrders++] = new Order(cafe.makananMenu[foodChoice - 1], quantity, customer);

                    System.out.print("Batalkan pesanan? (y/n) ");
                    String cancelChoice = scanner.next();
                    if (cancelChoice.equalsIgnoreCase("y")) {
                        totalOrders--;
                        cafe.makananMenu[foodChoice - 1].stok += quantity;
                    }
                } else if (menuChoice == 2) {
                    cafe.displayDrinkMenu();
                    System.out.print("Menu yang dipilih: ");
                    int drinkChoice = scanner.nextInt();

                    if (drinkChoice <= 0 || drinkChoice > cafe.minumanMenu.length) {
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                        continue;
                    }

                    System.out.print("Berapa jumlah pesanan? ");
                    int quantity = scanner.nextInt();


                    if (cafe.minumanMenu[drinkChoice - 1].stok < quantity) {
                        System.out.println("Maaf, stok tidak mencukupi. Silakan pilih lagi.");
                        continue;
                    }

                    cafe.minumanMenu[drinkChoice - 1].stok -= quantity;
                    orders[totalOrders++] = new Order(cafe.minumanMenu[drinkChoice - 1], quantity, customer);

                    System.out.print("Batalkan pesanan? (y/n) ");
                    String cancelChoice = scanner.next();
                    if (cancelChoice.equalsIgnoreCase("y")) {
                        totalOrders--;
                        cafe.minumanMenu[drinkChoice - 1].stok += quantity;
                    }
                }
            } else if (choice == 2) {
                System.out.println("Pencatatan Total Orderan yang Masuk Hari Ini");
                int totalHarga = 0;
                for (int i = 0; i < totalOrders; i++) {
                    totalHarga += orders[i].getTotalHarga();
                }
                System.out.println("Total orderan yang masuk hari ini adalah: " + totalOrders + " pesanan");
                System.out.println("Total harga semua pesanan: " + totalHarga);
                System.out.println("------------------------");
            } else if (choice == 3) {
                System.out.println("Terima kasih!");
                scanner.close(); // Tutup scanner sebelum keluar dari program
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
 }
