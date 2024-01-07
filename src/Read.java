import java.sql.*;

public class Read {
    public Read(){
        try {
        Connection baca = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_Khoiri", "root", "");
        Statement mydata = baca.createStatement();
        ResultSet mybank = mydata.executeQuery("select * FROM pelanggan");
        
        while (mybank.next()) {
            System.out.println("Data Saat Ini Di DataBase");
            System.out.println("=======================================");
            System.out.println("No Rekening     : " + mybank.getInt("No_Rekening") );
            System.out.println("Nama Nasabah    : " + mybank.getString("Nama"));
            System.out.println("No Pin          : " + mybank.getInt("No_pin"));
        }    
        } catch (Exception e) {
            
        }
    }
}
