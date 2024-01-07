import java.sql.*;
import java.util.*;
import java.security.SecureRandom;

public class LoginBank {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 6;


    public LoginBank(){
        String Check;
        try{
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Menghubungkan ke database
            String url = "jdbc:mysql://localhost:3306/bank_Khoiri";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

            String id;
            String passwordInput;
            Scanner khoir=new Scanner(System.in);

            System.out.println("===================LOGIN MBanking==================");
            System.out.println("===================================================");
            System.out.println("Log in  ");
            String Captcha = generateRandomString();
                do{

                    System.out.print("name                 : ");
                    id = khoir.next();
                    System.out.print("Pin                  : ");
                    passwordInput = khoir.next();
                    if(validateUser(connection, id, passwordInput)){
                        int random = 0;

                        do{
                            Captcha = generateRandomString();
                            if(random>0){
                                System.out.println("Captcha Salah !!!");
                            }
                            random++;
                           // hitung ++;
                            //hitung %=3;
                            System.out.println("Kode Captcha         : " + Captcha);
                            System.out.print("Entry Captcha        : ");
                            Scanner KM1 = new Scanner(System.in);
                             Check = KM1.next();


                        }while(!Captcha.equals(Check));


                        System.out.println("Akun Anda Berhasil Terverifikasi");
                        break;
                    }else{
                        System.out.println("Coba Lagi");
                    }
                }while(true); 
                connection.close();

            }catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        private boolean validateUser(Connection connection, String username, String password) throws SQLException {
            String query = "SELECT * FROM pelanggan WHERE Nama =? AND No_pin =?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
        }
     }

     private static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }


}

