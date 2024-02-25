package Bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin_code;

    FastCash(String pin) {
        this.pin_code = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("Select Withdrawal Amount");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("1 Euro");
        b2 = new JButton("5 Euro");
        b3 = new JButton("10 Euro");
        b4 = new JButton("20 Euro");
        b5 = new JButton("50 Euro");
        b6 = new JButton("100 Euro");
        b7 = new JButton("Back");

        setLayout(null);

        l1.setBounds(235, 400, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l3.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l3.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l3.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(960, 1080);

        // Set Frame to Open in the Center of the Screen at Runtime
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);

        setUndecorated(true);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b7) {
                processBackButton();
            } else {
                JButton sourceButton = (JButton) ae.getSource();
                String buttonText = sourceButton.getText();
                processWithdrawal(buttonText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processBackButton() {
        this.setVisible(false);
        new MainScreen(pin_code).setVisible(true);
    }

    private void processWithdrawal(String buttonText) {
        try {
            int amount = Integer.parseInt(buttonText.split(" ")[0]);
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from bank where pin_code = '"+ pin_code + "'");

            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            c.s.executeUpdate("insert into bank values('"+ pin_code +"', '" + date + "', 'Withdraw', '" + amount + "')");
            JOptionPane.showMessageDialog(null, amount + " Euro" + " Debited Successfully");

            setVisible(false);
            new MainScreen(pin_code).setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}