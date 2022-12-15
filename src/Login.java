import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    public Login() {
        setTitle("图书管理系统");
        setSize(500, 500);
        setLayout(new GridLayout(4, 1));


        JLabel userLabel = new JLabel("账号：");
        JTextField userField = new JTextField(5);
        JLabel userPassword = new JLabel("密码：");
        JTextField passwordField = new JTextField(5);
        JButton button = new JButton("Login");


        add(new JLabel("图书管理系统", JLabel.CENTER));
        add(userLabel);
        add(userField);
        add(passwordField);
        add(userPassword);
        add(button);
        setLocationRelativeTo(null);
        setVisible(true);


        //登录事件
        button.addActionListener(e -> {
            String user = userField.getText();
            String password = passwordField.getText();
            if (user.length() == 0 || password.length() == 0) {
                System.out.println("不能为空");
                return;
            }
            //链接数据库
            DBUtils dbUtils = new DBUtils();
            dbUtils.getConnection();
            try {
                ResultSet resultSet = dbUtils.getStatement().executeQuery("SELECT * FROM student WHERE student_id = " + user + " and password = " + password);
                if (resultSet.next()) {
                    System.out.println("登录成功");
                    LibraryManagement.userID = resultSet.getString("student_id");

                    return;
                }
                System.out.println("登录失败");

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}
