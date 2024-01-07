import java.text.SimpleDateFormat;
import java.util.Date;

public class penarikan extends perintah {
    public static Integer Noresi=11;
    private Integer Jumlahtarikk;
    private Integer Saldo;
    public  Integer hasil;

    public penarikan(){

    }

    public penarikan(Integer Noresi,Integer NoRek, String Nama, Integer NoPin, Integer Jumlahtarikk,Integer Saldo) {
        super(NoRek, Nama, NoPin);
        this.Noresi=Noresi;
        this.Jumlahtarikk=Jumlahtarikk;
        this.Saldo=Saldo;
        tarik(Jumlahtarikk);

        Nasabah nasabah = new Nasabah(NoRek, Nama, NoPin);
        nasabah.transaksiList.add(this);
        
        System.out.println();
        CetakStruk();
    }

     public void tarik(int amount){
        if (amount < 0) {
            System.out.println("Invalid withdraw amount.");
        } else {
            hasil = Saldo - amount;
            System.out.println();
            System.out.println("Withdraw successful. New balance ");
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
        System.out.println("Penarikan     : Rp. " +Jumlahtarikk);
        System.out.println("Saldo         : Rp. " +hasil);
    } 
}
