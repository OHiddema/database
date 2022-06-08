import java.sql.*;  

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "root";
        String sql = "SELECT * FROM city where CountryCode='NLD'";
        try (Connection con = DriverManager.getConnection(url, user, password)) {  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);  
            while(rs.next()) {
                System.out.println(rs.getString("Name"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
