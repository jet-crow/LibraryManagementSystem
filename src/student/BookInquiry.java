package student;

import tools.DBUtils;
import tools.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInquiry extends JPanel {
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);
    public BookInquiry() {
        setLayout(null);
        JLabel jLabel = new JLabel("图书查询",JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024,100);
        add(jLabel);
        // search
        JPanel searchJpanel = new JPanel();
        searchJpanel.setLayout(null);
        searchJpanel.setBounds(0, 140, 1024,60);
        JTextField searchJTextField  = new JTextField(10);
        searchJTextField.setFont(bigFont);
        searchJTextField.addFocusListener(new JTextFieldHintListener(searchJTextField, "输入要搜索的书名"));
        searchJTextField.setBounds(137,0,500,60);
        searchJpanel.add(searchJTextField);
        JButton searchBtn = new JButton("搜索");
        searchBtn.setBounds(637,0,200,60);
        searchBtn.setFont(bigFont);
        searchJpanel.add(searchBtn);
        add(searchJpanel);

    }
}
