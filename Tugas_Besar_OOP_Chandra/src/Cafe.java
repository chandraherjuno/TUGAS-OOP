 public class Cafe {
    Makanan[] makananMenu;
    Minuman[] minumanMenu;

    public Cafe() {
        this.makananMenu = new Makanan[]{
                new Makanan("Kentang Goreng", 50),
                new Makanan("Udang Rambutan", 100),
                new Makanan("Udang Keju", 10)
        };
        this.minumanMenu = new Minuman[]{
                new Minuman("Lemon Tea", 20),
                new Minuman("Matcha Tea", 15),
                new Minuman("Teh tarik", 10)
        };
    }

    public void displayFoodMenu() {
        System.out.println("Daftar Makanan:");
        for (int i = 0; i < makananMenu.length; i++) {
            System.out.println((i + 1) + ". " + makananMenu[i].nama);
        }
    }

    public void displayDrinkMenu() {
        System.out.println("Daftar Minuman:");
        for (int i = 0; i < minumanMenu.length; i++) {
            System.out.println((i + 1) + ". " + minumanMenu[i].nama);
        }
    }
}
