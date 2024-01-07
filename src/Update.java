import java.sql.*;
import java.util.*;

public class Update {
    //Driver
    private static final String URL = "jdbc:mysql://localhost:3306/bank_Khoiri";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void updateEmployeeCredentials(Scanner kho2) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE pelanggan SET Nama = ?, No_pin = ? WHERE No_Rekening = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("UPDATE DATA Nasabah");
                System.out.println("===================================================");

                System.out.print("No Rek            : ");
                int rek2 = kho2.nextInt();
                
                System.out.print("Nama Nasabah      : ");
                String nama2 = kho2.next();

                System.out.print("No pin            : ");
                int pin2 = kho2.nextInt();
                
                preparedStatement.setInt(1, rek2);
                preparedStatement.setString(2, nama2);
                preparedStatement.setInt(3, pin2);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data Berhasil Diupdate!");
                } else {
                    System.out.println("Data Tidak Ditemukan");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
