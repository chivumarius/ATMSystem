
package Bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin_code;


    Withdraw(String pin){
        this.pin_code = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel("Maximum Withdrawal is 100 Euro");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("Please Enter Your Amount");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("Withdraw");
        b2 = new JButton("Back");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,20);
        l3.add(l1);
        
        l2.setBounds(190,400,400,20);
        l3.add(l2);
        
        t1.setBounds(190,450,330,30);
        l3.add(t1);
        
        b1.setBounds(390,588,150,35);
        l3.add(b1);
        
        b2.setBounds(390,633,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(960,1080);
        setLocation(500,0);

        // Set Frame to Open in the Center of the Screen at Runtime
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);

        setUndecorated(true);
        setVisible(true);
    }
    



    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();

            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{

                    DBConnection c1 = new DBConnection();

                    // Query
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin_code = '" + pin_code + "'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+ pin_code + "', '" + date + "', 'Withdraw', '" + amount + "')");
                    JOptionPane.showMessageDialog(null,  amount + " Euro" + " Debited Successfully");
                    
                    setVisible(false);
                    new MainScreen(pin_code).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new MainScreen(pin_code).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdraw("").setVisible(true);
    }
}
