import tools.DBUtils;
import tools.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Login extends JFrame {
    Font bigFont = new Font("heiti", 18, 18);
    Font smallFont = new Font("heiti", 13, 13);

    public Login() {

        setTitle("图书管理系统");
        setSize(700, 390);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("图书管理系统", JLabel.CENTER);
        title.setFont(new Font("heiti", 26, 26));

        JLabel userLabel = new JLabel("账号：", JLabel.RIGHT);
        userLabel.setFont(bigFont);
        JTextField userField = new JTextField(10);
        userField.setFont(bigFont);
        JPanel userJpanel = new JPanel();

        userJpanel.setLayout(new GridLayout(1, 3));
        userJpanel.add(userLabel);
        userJpanel.add(userField);
        userJpanel.add(new Label());

        JLabel passwordLabel = new JLabel("密码：", JLabel.RIGHT);
        passwordLabel.setFont(bigFont);
        JTextField passwordField = new JTextField(1);
        passwordField.setFont(bigFont);


        JPanel passwordJpanel = new JPanel();
        passwordJpanel.setLayout(new GridLayout(1, 3));
        passwordJpanel.add(passwordLabel);
        passwordJpanel.add(passwordField);
        passwordJpanel.add(new Label());

        JPanel buttonJpanel = new JPanel();
        buttonJpanel.setLayout(new GridLayout(1, 3));
        JButton button = new JButton("Login");
        buttonJpanel.add(new Label());
        buttonJpanel.add(button);
        buttonJpanel.add(new Label());

        add(new Label());
        add(title);
        add(userJpanel);
        add(passwordJpanel);
        add(buttonJpanel);

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
                new MyDialog().init("登录失败");

                System.out.println("登录失败");

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}
