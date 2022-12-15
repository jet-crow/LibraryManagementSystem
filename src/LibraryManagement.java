//import java.sql.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryManagement {
    public static String userID;
    public static void main(String[] args) {
        new Login();

        /*//使用
        tools.tools.DBUtils dbUtils = new tools.tools.DBUtils();
        dbUtils.getConnection();
        // 执行查询
        System.out.println(" 实例化对象...");

        ResultSet rs = dbUtils.getStatement().executeQuery("SELECT * from student");

        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            String user = rs.getString("student_id");
            String name = rs.getString("name");
            // 输出数据
            System.out.print("user: " + user);
            System.out.print(", 站点名称: " + name);
            System.out.print("\n");
        }
        dbUtils.close();
        rs.close();
        1111*/

    }
}


