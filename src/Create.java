import java.sql.*;
import java.util.*;

public class Create{

    private static final String URL = "jdbc:mysql://localhost:3306/bank_Khoiri";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static void insertEmployeeData(Scanner kho) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO pelanggan (No_Rekening, Nama, No_pin) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("MEMBUAT DATA Nasabah BARU");
                System.out.println("===================================================");

                System.out.print("Masukkan No REK Baru      : ");
                int rek = kho.nextInt();

                System.out.print("Masukkan Nama Nasabah     : ");
                String name = kho.next();

                System.out.print("Masukkan No Pin           : ");
                int pin = kho.nextInt();

                preparedStatement.setInt(1, rek);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, pin);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Berhasil Menambahkan Data");
                } else {
                    System.out.println("Silahkan Inputkan Kembali Data");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
