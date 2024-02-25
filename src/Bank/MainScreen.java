package Bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin_code;
    MainScreen(String pin){
        this.pin_code = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
       
        b1 = new JButton("Deposit");
        b2 = new JButton("Cash Withdrawal");
        b3 = new JButton("Fast Cash");
        b4 = new JButton("Mini Statement");
        b5 = new JButton("Change Pin");
        b6 = new JButton("Balance Inquiry");
        b7 = new JButton("Exit");
        
        setLayout(null);
        
        l1.setBounds(235,400,700,35);
        l2.add(l1);
        
        b1.setBounds(170,499,150,35);
        l2.add(b1);
        
        b2.setBounds(390,499,150,35);
        l2.add(b2);
        
        b3.setBounds(170,543,150,35);
        l2.add(b3);
        
        b4.setBounds(390,543,150,35);
        l2.add(b4);
        
        b5.setBounds(170,588,150,35);
        l2.add(b5);
        
        b6.setBounds(390,588,150,35);
        l2.add(b6);
        
        b7.setBounds(390,633,150,35);
        l2.add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        setSize(960,1080);

        // Set Frame to Open in the Center of the Screen at Runtime
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);

        setUndecorated(true);
        setVisible(true);
    }




    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(pin_code).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdraw(pin_code).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new FastCash(pin_code).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new MiniStatement(pin_code).setVisible(true);
        }else if(ae.getSource()==b5){ 
            setVisible(false);
            new Pin(pin_code).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceInquiry(pin_code).setVisible(true);
        }else if(ae.getSource() == b7){
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new MainScreen("").setVisible(true);
    }
}