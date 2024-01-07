import java.util.Scanner;
import java.sql.*;

public class app {

    public static void main(String[] args)throws Exception{
      boolean pilihan1=true;
      boolean pilihan2=false;

      //Read
      Read halo=new Read();
      System.out.println("");

      //Create
      Scanner kho =new Scanner(System.in);
      Create.insertEmployeeData(kho);
      System.out.println("");

      //update
      Scanner kho2 = new Scanner(System.in);
      Update.updateEmployeeCredentials(kho2);
      System.out.println("");

      //Delete
      Delete.deleteEmployeeById();
      System.out.println("");

      LoginBank KM = new LoginBank();
      Scanner khoiri=new Scanner(System.in);
      Nasabah nasabah = new Nasabah();
      System.out.println("---------Selamat datang---------");
      System.out.println();
      System.out.println("Silahkan Pilih jenis transaksi    : ");
      System.out.println("1. Deposit \n2. Penarikan");
      System.out.println("Pilih : (1/2)");

      try{
              do {
                int Pilihan=khoiri.nextInt();
                if(Pilihan ==1){
                    Scanner kho3=new Scanner(System.in);
                    System.out.print("No Rekening          : ");
                    int Rek= kho3.nextInt();
                    System.out.print("Nama                 : ");
                    String Nama = kho3.next();
                    System.out.print("No Pin               : ");
                    int pin = kho3.nextInt();
                    System.out.print("Jumlah Deposit       : ");
                    int jlhd= kho3.nextInt();
                    System.out.print("Saldo                : ");
                    int Sal = kho3.nextInt();
                    
                    deposit depooo= new deposit(10, Rek, Nama, pin, jlhd, Sal);
                    nasabah.transaksiList.add(depooo);
                    pilihan1=pilihan2;
                    System.out.println("=========================");
                }else if(Pilihan ==2){
                    Scanner kho4=new Scanner(System.in);
                    System.out.print("No Rekening          : ");
                    int Rek= kho4.nextInt();
                    System.out.print("Nama                 : ");
                    String Nama = kho4.next();
                    System.out.print("No Pin               : ");
                    int pin = kho4.nextInt();
                    System.out.print("Jumlah Penarikan     : ");
                    int jlht= kho4.nextInt();
                    System.out.print("Saldo                : ");
                    int Sal = kho4.nextInt();

                    penarikan tarikkkk=new penarikan(11, Rek, Nama, pin, jlht, Sal);
                    nasabah.transaksiList.add(tarikkkk);
                    pilihan1=pilihan2;
                    System.out.println("==========================");
                }else{
                    for(int i =0; i<=10;i++){
                        System.out.print("=");
                        
                    }
                    System.out.println("transaksi gagal===========");
                }
                if (!nasabah.transaksiList.isEmpty()) {
                    System.out.println("Data Transaksi:");
                    for (perintah transaksi : nasabah.transaksiList) {
                        System.out.println(transaksi.getClass().getSimpleName());
                    }
                } else {
                    System.out.println("Tampilan Array List: ");
                    System.out.println("Tidak ada transaksi ");
                }
            } while (pilihan1);
            }catch(Exception e){
                System.out.println("Silahkan coba lagi");
                
            }
    }
}
