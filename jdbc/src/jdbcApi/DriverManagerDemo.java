package jdbcApi;

import java.sql.*;

public class DriverManagerDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
       Class.forName("com.mysql.jdbc.Driver");

       // 获取连接对象
        //连接信息
        String url = "jdbc:mysql://127.0.0.1:3306/jdb?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 获取执行普通sql对象

        Statement stmt = conn.createStatement();

//        // 执行sql语句
////         增加一条记录
//        String sql = "insert into account values(3, '王二麻子', 2000)";
//        int count = stmt.executeUpdate(sql);
//        System.out.println(count);

        // 查询事务
        String sql = "select * from account";
        ResultSet resultSet = stmt.executeQuery(sql);
        while(resultSet.next()){
            // 获取数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int money = resultSet.getInt("money");
            System.out.println("{" + id + "  " + name+ "  " + money + "}");
        }

    }
}
