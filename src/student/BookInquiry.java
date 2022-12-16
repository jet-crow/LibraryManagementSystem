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
    public BookInquiry() {
        JTextField textField = new JTextField(10);
        textField.addFocusListener(new JTextFieldHintListener(textField, "输入要搜索的书名"));
        JButton button = new JButton("搜索");
        add(textField);
        add(button);
        DBUtils dbUtils = new DBUtils();
        dbUtils.getConnection();
        button.addActionListener(e -> {
            String book = textField.getText().trim();
            try {
                ResultSet resultSet = dbUtils.getStatement().executeQuery("SELECT * FROM book WHERE bookname LIKE '%" + book + "%'");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("bookname"));
                    System.out.println(resultSet.getString("author"));
                    System.out.println(resultSet.getString("allowance"));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
    }
}
