package Bank;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceInquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin_code;

    BalanceInquiry(String pin_code) {
        this.pin_code = pin_code;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);


        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Back");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        b1.setBounds(390, 633, 150, 35);
        l3.add(b1);
        int balance = 0;
        try{
            DBConnection c1 = new DBConnection();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin_code = '" + pin_code + "'");

            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        
        l1.setText("Your Current Account Balance is " + balance + " Euro");

        b1.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);

        // Set Frame to Open in the Center of the Screen at Runtime
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);

        setVisible(true);
    }



    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new MainScreen(pin_code).setVisible(true);
    }


    public static void main(String[] args) {
        new BalanceInquiry("").setVisible(true);
    }
}
