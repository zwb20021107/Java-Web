package jdbcApi;

import java.sql.*;

public class PrepareStatementDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/jdb?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection coon = DriverManager.getConnection(url, user, password);

        String sql = "select * from account where name = ? and money = ?";
        PreparedStatement preparedStatement = coon.prepareStatement(sql);

        preparedStatement.setInt(2, 3000);
        preparedStatement.setString(1, "张三");

        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            // 获取数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int money = rs.getInt("money");
            System.out.println("{" + id + "  " + name+ "  " + money + "}");
        }

    }
}
