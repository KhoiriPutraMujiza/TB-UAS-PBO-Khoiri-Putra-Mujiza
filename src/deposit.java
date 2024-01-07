import java.text.SimpleDateFormat;
import java.util.Date;

public class deposit extends perintah {
    public static Integer Noresi=10;
    private Integer JumlahDepo;
    private Integer Saldo;
    public  Integer hasil;

    public deposit(){

    }
    public deposit(Integer Noresi,Integer NoRek, String Nama, Integer NoPin, Integer JumlahDepo,Integer Saldo) {
        super(NoRek, Nama, NoPin);
        this.Noresi=Noresi;
        this.JumlahDepo=JumlahDepo;
        this.Saldo=Saldo;
        depo(JumlahDepo);
        
        Nasabah nasabah = new Nasabah(NoRek, Nama, NoPin);
        nasabah.transaksiList.add(this);
        
        CetakStruk();
    }

    public void depo(int amount){
        if (amount > 0) {
            hasil = amount + Saldo;
            System.out.println();
            System.out.println("Deposit successful. New balance ");

        } else {
            System.out.println();
            System.out.println("Invalid deposit amount.");
        }
    }
    
    @Override
    public void CetakStruk(){
        System.out.println("=======================================");
        System.out.println("Bank Khoiri");
        System.out.println("Satu Untuk Semua");
        System.out.println();
        System.out.println();
         Date tanggalSekarang = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String tanggalTerformat = sdf.format(tanggalSekarang);
        System.out.println("Tanggal       : " + tanggalTerformat);
            Date waktuSekarang = new Date();
             SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String waktuTerformat = sdf.format(waktuSekarang);
        System.out.println("Waktu         : " + sdf2.format(waktuSekarang) + " WIB");
        System.out.println();
        System.out.println("No Resi       : " +Noresi);
        System.out.println("No Rekening   : " +NoRek);
        System.out.println("Nama          : " +Nama);
        System.out.println("Deposit       : Rp. " +JumlahDepo);
        System.out.println("Saldo         : Rp. " +hasil);



    }
}
