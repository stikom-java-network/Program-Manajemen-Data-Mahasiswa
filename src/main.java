
import java.io.*;

public class main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int pilih;
    static String[][] Data = new String[2][7];
    static double tgs, uts, uas, na;
    static String nh, nim;
  

    public static void main(String[] args) throws IOException {
        do {
            menu();
            casse();
        } while (true);
    }

    static void garis() {
        System.out.println("================================");
    }

    static void menu() throws IOException {
        garis();
        System.out.println("PROGRAM MANAJEMEN DATA MAHASISWA");
        garis();
        System.out.println("1. Input Data");
        System.out.println("2. Lihat Data");
        System.out.println("3. Ubah Data");
        System.out.println("4. Keluar");
        System.out.println("");
        System.out.print("Pilih Menu (1-4) : ");
        pilih = Integer.parseInt(br.readLine());

    }

    static void casse() throws IOException {
        switch (pilih) {
            case 1:
                createData(Data);
                break;
            case 2:
                readData(Data);
                break;
            case 3:
                UpdateData(Data);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan menu yang dimasukan salah!");
                break;
        }
    }

    static void createData(String[][] createData) throws IOException {
        garis();
        System.out.println("CREATE DATA MAHASISWA");
        garis();
        for (int i = 0; i < Data.length; i++) {
            System.out.println("Data Mahasiswa ke - " + (i + 1));
            System.out.print("Masukkan NIM : ");
            Data[i][0] = br.readLine();
            System.out.print("Masukkan Nama : ");
            Data[i][1] = br.readLine();
            System.out.print("Masukkan Nilai Tugas : ");
            Data[i][2] = br.readLine();
            tgs = Double.parseDouble(Data[i][2]);
            System.out.print("Masukkan Nilai UTS : ");
            Data[i][3] = br.readLine();
            uts = Double.parseDouble(Data[i][3]);
            System.out.print("Masukkan Nilai UAS : ");
            Data[i][4] = br.readLine();
            uas = Double.parseDouble(Data[i][4]);
            System.out.println("");
            NilaiAkhir();
            Data[i][5] = Double.toString(na);
            NilaiHuruf();
            Data[i][6] = nh;
        }

    }

    static void readData(String[][] readData) {
        garis();
        System.out.println("READ DATA MAHASISWA");
        garis();
        for (int i = 0; i < Data.length; i++) {
            System.out.println("Data Mahasiswa ke - " + (i + 1));
            System.out.println("NIM : " + Data[i][0]);
            System.out.println("Nama : " + Data[i][1]);
//            System.out.println("Nilai Tugas : " + Data[i][2]);
//            System.out.println("Nilai UTS : " + Data[i][3]);
//            System.out.println("Nilai UAS : " + Data[i][4]);
            System.out.println("Nilai Akhir  : " + Data[i][5]);
            System.out.println("Nilai Huruf  : " + Data[i][6]);
            System.out.println("");
        }
    }

    static void UpdateData(String[][] updateData) throws IOException {
        int ulang = 1;
        garis();
        System.out.println("UPDATE DATA MAHASISWA");
        garis();
        System.out.print("Masukkan NIM : ");
        nim = br.readLine();
        for (int i = 0; i < Data.length; i++) {
//            while (ulang <= 3) {
            if (nim.equalsIgnoreCase(Data[i][0])) {
                System.out.print("Nilai Tugas [UPDATE] : ");
                Data[i][2] = br.readLine();
                tgs = Double.parseDouble(Data[i][2]);
                NilaiAkhir();
                Data[i][5] = Double.toString(na);
                NilaiHuruf();
                Data[i][6] = nh;
            }else{
                System.err.println("NIM yang dimasukkan Salah!");
            }
                   
//                ulang++;
//            }
//            if (ulang > 3) {
//                System.err.println("Salah Memasukkan Password 3 kali!. System akan berhenti");
//                System.out.println("");
//                System.exit(0);
//            }

        }
        System.out.println("");
    }

    static double NilaiAkhir() {
        na = ((tgs * .4) + (uts * .3) + (uas * .3));
        return na;
    }

    static void NilaiHuruf() {
        NilaiAkhir();
        if (na >= 80) {
            nh = "A";
        } else if (na <= 79 && na >= 75) {
            nh = "B+";
        } else if (na <= 74 && na >= 65) {
            nh = "B";
        } else if (na <= 64 && na >= 60) {
            nh = "C+";
        } else if (na <= 59 && na >= 55) {
            nh = "C";
        } else if (na <= 54 && na >= 50) {
            nh = "D";
        } else {
            nh = "E";
        }
    }

}
