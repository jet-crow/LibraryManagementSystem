import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    Font bigFont = new Font("heiti",18,18);
    Font smallFont = new Font("heiti",13,13);
    public Login() {

        setTitle("图书管理系统");
        setSize(500, 300);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("图书管理系统", JLabel.CENTER);
        title.setFont(new Font("heiti",24,24));
        JLabel userLabel = new JLabel("账号：");
        userLabel.setFont(bigFont);
        JTextField userField = new JTextField(5);

        JLabel passwordLabel = new JLabel("密码：");
        JTextField passwordField = new JTextField(5);
        JButton button = new JButton("Login");


        add(title);
        add(userLabel);
        add(userField);
        add(passwordLabel);
        add(passwordField);
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
                //追加判断是否为管理员
                String columnLabel = "student_id";
                ResultSet resultSet = dbUtils.getStatement().executeQuery("SELECT * FROM student WHERE student_id = " + user + " and password = " + password);
                if (resultSet.next()) {
                    System.out.println("登录成功");
                    LibraryManagement.userID = resultSet.getString(columnLabel);
                    dispose();
                    new Client();
                    return;
                }
                System.out.println("登录失败");

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}
