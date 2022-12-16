package student;

import javax.swing.*;
import java.awt.*;

public class AccountManagement extends JPanel {
    private Font font = new Font("宋体", Font.BOLD, 70);
    public AccountManagement() {
        JLabel jLabel = new JLabel("账号管理");
        jLabel.setFont(font);
        jLabel.setBounds(230, 50, 1000,200);
        add(jLabel);
    }
}
