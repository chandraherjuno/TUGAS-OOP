import java.util.Scanner;

import Model.Layout;
import Model.Position;
import Model.Robot;

public class RobotApp {
    public static void main(String[] args){
        new RobotApp();
    }

    /*
     * Perintah Soal:
     * Anggap 'o' adalah sebuah robot yang berada didalam area permainan.
     * Buat robot dapat bergerak ke kiri/kanan/atas/bawah sesuai jumlah langkah yang diinstruksikan.
     * Format instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah} dan 'x' untuk keluar aplikasi *case sensitive
     * Robot tidak boleh keluar dari area permainan dan buat pesan kesalahannya.
     * Buat pesan kesalahan jika pengguna tidak menulis instruksi dengan benar.
     * Lanjut pada perintah soal dibawah.
     */

    private Layout layout;
    private Robot robot;
    private Scanner scanner;
    public RobotApp() {
        // contoh konfigurasi (inisiasi object layout) area permainan: X = 10, Y = 10, icon area yang tidak ditempati robot adalah '*'
        this.layout = new Layout(10, 10, '*');
        this.scanner = new Scanner(System.in);
        String instruction = "";

        Position posisisatu = new Position(3, 3);
        this.robot = new Robot('0', posisisatu);

        System.out.println("-------- Permainan Dimulai --------");
        do{
            draw();
            instruction = waitInstruction();

            int step = 0;
            if (!(instruction.equals("x"))) {
                step = Integer.parseInt(instruction.substring(1)); 
            }

            String directstep = instruction.substring(0,1);

            if (robot.getPosition().getX() == 0 && robot.getPosition().getX() + step < layout.getMaxX() && robot.getPosition().getY() >= 0 && robot.getPosition().getY() + step < layout.getMaxY()){
                switch (directstep) {
                    case "d":
                    robot.setPosition(new Position(robot.getPosition().getX(), robot.getPosition().getY() + step));
                    break;
                    case "s":
                    robot.setPosition(new Position(robot.getPosition().getX() + step, robot.getPosition().getY()));
                    break;
                    case "a":
                    robot.setPosition(new Position(robot.getPosition().getX(), robot.getPosition().getY() - step));
                    break;
                    case "w":
                    robot.setPosition(new Position(robot.getPosition().getX() - step, robot.getPosition().getY()));
                    break;
                }
            }
            else {
                System.out.println("Robot tidak boleh keluar dari area permainan.");
                break;
            }


        }while(!instruction.equals("x"));
        System.out.println("-------- Permainan Selesai --------");
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'keatas 3 langkah'");
        System.out.print("Masukan instruksi: ");
        return scanner.nextLine();
    }

    private void draw() {
        System.out.println("------ Posisi Terbaru ------");
        /*
        Gambar layout:
        Contoh:
        - Posisi robot di 1,1
        - Area permainan luasnya 10,10
        sehingga gambar layout akan menjadi:

            o*********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********

            - konfigurasi (icon robot, posisi robot, luas area dan icon area permainan yang tidak ditempati robot) silahkan gunakan prinsip OOP
            - icon cukup menggunakan karakter yang ada di keyboard.
         */

        for(int j = 0;j <10 ; j++){
            for (int u = 0; u < 10 ; u++){
                if (j == robot.getPosition().getX() && u == robot.getPosition().getY()) {
                    System.out.print(robot.getIcon());
                } else {
                    System.out.print(layout.getArea()[j][u]);
                }
            }
            System.out.println();
        }

    }
}