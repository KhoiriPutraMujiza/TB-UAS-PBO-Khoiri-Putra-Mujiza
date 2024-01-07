import java.util.ArrayList;

public class Nasabah implements BankKhoiri{
    public Integer NoRek;
    public String Nama;
    public Integer NoPin;
    public ArrayList<perintah> transaksiList;

    public Nasabah(){
        transaksiList = new ArrayList<>();
    }
    public Nasabah(Integer NoRek, String Nama, Integer NoPin){
        this.NoRek=NoRek;
        this.Nama=Nama;
        this.NoPin=NoPin;
        transaksiList = new ArrayList<>();
    }
    @Override
    public void CetakStruk(){

    }

}
