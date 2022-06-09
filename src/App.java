import java.sql.*;  

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "root";
        // String sql = "SELECT * FROM city where CountryCode='NLD'";
        String sql = "SELECT world.countrylanguage.Language, round(sum(world.country.population * world.countrylanguage.percentage/100),0) as total from world.country inner join world.countrylanguage on country.Code = countrylanguage.CountryCode group by world.countrylanguage.language order by total desc limit 10;";
        try (Connection con = DriverManager.getConnection(url, user, password)) {  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);  
            System.out.println("Top 10 languages spoken in the world:");
            while(rs.next()) {
                System.out.format("%-32s", rs.getString(1));
                System.out.format("%15d", rs.getInt(2));
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
