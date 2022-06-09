import java.sql.*;  

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "root";
        // String sql = "SELECT * FROM city where CountryCode='NLD'";
        String sql = "SELECT world.countrylanguage.Language, round(sum(world.country.population * world.countrylanguage.percentage/100),0) as total from world.country inner join world.countrylanguage on country.Code = countrylanguage.CountryCode group by world.countrylanguage.language order by total desc;";
        try (Connection con = DriverManager.getConnection(url, user, password)) {  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);  
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getInt(2));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
