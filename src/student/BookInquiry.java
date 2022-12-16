package student;

import javax.swing.*;
import java.awt.*;

public class BookInquiry extends JPanel {
    private Font font = new Font("宋体", Font.BOLD, 70);
    public BookInquiry() {
        JLabel jLabel = new JLabel("图书查询");
        jLabel.setFont(font);
        jLabel.setBounds(230, 50, 1000,200);
        add(jLabel);
    }
}
