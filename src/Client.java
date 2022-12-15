import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
    public String[] Serial = {"123", "1234", "123456"};

    public Client() {
        setTitle("图书管理系统");
        setSize(1024, 768);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        for (int i = 0; i < 3; i++) {
            JMenu menu = new JMenu(Serial[i]);
            bar.add(menu);
        }

        //添加结果集
        add(bar);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
