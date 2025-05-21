import java.util.ArrayList;
import java.util.Scanner;

public class Manajemen {
    static ArrayList<String> NamaMahasiswa = new ArrayList<>();
    static ArrayList<Integer> NIMMahasiswa = new ArrayList<>();
    static ArrayList<String> JurusanMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        Scanner In = new Scanner(System.in);

        System.out.println("--Selmat Datang di Manajemen Siswa Siswa--");
        while (!exit) {
            System.out.println("");
            System.out.println("==Menu==");
            System.out.println("Apa yang Anda Mau Lakukan ?");
            System.out.println("1. Masukan Data Menggunakan (Nama, NIM, Jurusan)");
            System.out.println("2. Tampilkan Semua Mahasiswa");
            System.out.println("3. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("4. Hapus Mahasiswa Berdasarkan NIM");
            System.out.println("5. Exit");
            int userchoice = In.nextInt();
            if (userchoice == 1) {
                System.out.println("Tambahkan Data Mahasiswa");
                System.out.println("Masukan Nama MahaSiswa: ");
                String Nama = In.next();
                In.nextLine();
                System.out.println("Masukan NIM MahaSiswa: ");
                int NIM = In.nextInt();
                In.nextLine();
                System.out.println("Masukan Jurusan MahaSiswa: ");
                String Jurusan = In.nextLine();
                TambahData(Nama, NIM, Jurusan);
                System.out.println("Data Berhasil Dimasukan Ke DATABASE");
            } else if (userchoice == 2) {
                System.out.println("Mahasiswa Telkom School");
                TampilkanData();
            } else if (userchoice == 3) {
                System.out.println("Cari Nama Mahasiswa Menggunakan NIM");
                System.out.println("Masukan NIM Siswa yang akan anda cari");
                int NIM = In.nextInt();
                CariNama(NIM);
            } else if (userchoice == 4) {
                System.out.println("Hapus Mahasiswa Menggunakan NIM");
                System.out.println("hapusa data siswa menggunakan NIM yang anda masukan");
                int NIM = In.nextInt();
                HapusData(NIM);
            } else if (userchoice == 5) {
                exit = true;
                System.out.println("Anda Keluar dari Program");
                System.out.println("-------------------------------------------------");
            } else {
                System.out.println("!!Invalid Input!!");
            }
        }
    }

    public static void TambahData(String Nama, int NIM, String Jurusan) {
        NamaMahasiswa.add(Nama);
        NIMMahasiswa.add(NIM);
        JurusanMahasiswa.add(Jurusan);
    }

    public static void TampilkanData() {
        for (int i = 0; i < NamaMahasiswa.size(); i++) {
            System.out.println("Siswa ke:" + (i + 1));
            System.out.println("Nama: " + NamaMahasiswa.get(i));
            System.out.println("Nomor Induk Mahasiswa (NIM): " + NIMMahasiswa.get(i));
            System.out.println("Jurusan Mahasiswa: " + JurusanMahasiswa.get(i));
        }
    }

    public static void CariNama(int input) {
        boolean found = false;
        for (int i = 0; i < NIMMahasiswa.size(); i++) {
            if (NIMMahasiswa.get(i) == input) {
                System.out.println("! MAHASISWA DITEMUKAN !");
                System.out.println("Nama: " + NamaMahasiswa.get(i));
                System.out.println("Jurusan: " + JurusanMahasiswa.get(i));
                found = true;
                break;
            }
            if (!found) {
                System.out.println("!!Mahasiswa Tidak Ditemukan!!");
            }

        }
    }

    public static void HapusData(int inputNIM) {
        boolean found = false;
        for (int i = 0; i < NamaMahasiswa.size(); i++) {
            if (NIMMahasiswa.get(i) == inputNIM) {
                NamaMahasiswa.remove(i);
                NIMMahasiswa.remove(i);
                JurusanMahasiswa.remove(i);
                System.out.println("Data Mahasiwa Telah di hapus secara permanen dari DATA");
                found = true;
                break;
            }
            if (!found) {
                System.out.println("!!Data Tidak Ditemukan!!");
            }

        }
    }
}
