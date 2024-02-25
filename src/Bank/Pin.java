
package Bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pin_code;



    Pin(String pin){
        this.pin_code = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);


        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);
        
        l1 = new JLabel("Change Your Pin");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("New Pin:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("Re-Enter New Pin:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("Change");
        b2 = new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(280,330,800,35);
        l4.add(l1);
        
        l2.setBounds(180,390,150,35);
        l4.add(l2);
        
        l3.setBounds(180,440,200,35);
        l4.add(l3);
        
        t1.setBounds(350,390,180,25);
        l4.add(t1);
        
        t2.setBounds(350,440,180,25);
        l4.add(t2);
        
        b1.setBounds(390,588,150,35);
        l4.add(b1);
        
        b2.setBounds(390,633,150,35);
        l4.add(b2);
        
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
        try{
            char[] passwordChars1 = t1.getPassword();
            String newPin = new String(passwordChars1);

            char[] passwordChars2 = t2.getPassword();
            String reEnterPin = new String(passwordChars2);
            
            if(!newPin.equals(reEnterPin)){
                JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Enter New Pin");
                }
                if (t2.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new Pin");
                }
                
                DBConnection c1 = new DBConnection();
                String q1 = "update bank set pin_code = '"+ reEnterPin +"' where pin_code = '"+ pin_code +"' ";
                String q2 = "update login set pin_code = '" + reEnterPin + "' where pin_code = '"+ pin_code +"' ";
                String q3 = "update signup3 set pin_code = '" + reEnterPin + "' where pin_code = '"+ pin_code +"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Pin Changed successfully");
                setVisible(false);
                new MainScreen(reEnterPin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new MainScreen(pin_code).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
