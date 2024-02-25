package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l9, l10, l11, l12, l13;
    JButton b;
    JRadioButton r1, r2, r3, r4;
    JTextField t1, t2, t3;
    JComboBox<String> c1, c2, c3, c4, c5, c6; // Added c6 for Qualification dropdown
    String form_number;

    Signup2(String formNumber) {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        this.form_number = formNumber;
        setTitle("NewW Account Application Form - Page 2");

        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("Educational Qualification:"); // Updated label
        l5.setFont(new Font("Raleway", Font.BOLD, 18)); // Updated font size

        l11 = new JLabel("Occupation:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("Personal Identification No:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l7 = new JLabel("Senior Citizen:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("Existing Account:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("Form No:");
        l10.setFont(new Font("Raleway", Font.BOLD, 13));

        l13 = new JLabel(formNumber);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        String[] religion = {"Orthodox Christian", "Catholic", "Muslim", "Hindu", "Other"};
        c1 = new JComboBox<>(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] category = {"General", "Ethnic Minorities", "Refugees and Immigrants", "People with Disabilities", "Other"};
        c2 = new JComboBox<>(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] income = {"Null", "<1714", "<2857", "<5714", "<11428", ">11428"};
        c3 = new JComboBox<>(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] education = {"Non-Graduate", "Graduate", "Post-Graduate", "PHD", "Others"};
        c4 = new JComboBox<>(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] occupation = {"Salaried", "Self Employed", "Business", "Student", "Retired", "Others"};
        c5 = new JComboBox<>(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));

        // Adding the Qualification dropdown
        String[] qualification = {"10th Standard", "12th Standard", "Diploma", "Bachelor's Degree", "Master's Degree", "PhD", "Others"};
        c6 = new JComboBox<>(qualification);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 14));

        setLayout(null);

        JLabel blankLabel1 = new JLabel(); // Empty label for creating space
        blankLabel1.setBounds(0, 40, 850, 30);
        add(blankLabel1);

        JLabel blankLabel2 = new JLabel(); // Empty label for creating space
        blankLabel2.setBounds(0, 500, 850, 20);
        add(blankLabel2);

        l10.setBounds(700, 10, 60, 30);
        add(l10);

        l13.setBounds(760, 10, 60, 30);
        add(l13);

        l1.setBounds(280, 70, 600, 40); // Changed y-coordinate to create space
        add(l1);

        l2.setBounds(100, 120, 100, 30); // Changed y-coordinate to create space
        add(l2);

        c1.setBounds(350, 120, 320, 30);
        add(c1);

        l3.setBounds(100, 170, 100, 30); // Changed y-coordinate to create space
        add(l3);

        c2.setBounds(350, 170, 320, 30);
        add(c2);

        l4.setBounds(100, 220, 100, 30); // Changed y-coordinate to create space
        add(l4);

        c3.setBounds(350, 220, 320, 30);
        add(c3);

        l5.setBounds(100, 270, 250, 30); // Changed y-coordinate to create space
        add(l5);

        c4.setBounds(350, 270, 320, 30);
        add(c4);


        l11.setBounds(100, 320, 150, 30); // Adjusted y-coordinate to create space
        add(l11);

        c5.setBounds(350, 320, 320, 30);
        add(c5);

        // Qualification dropdown
        JLabel lQualification = new JLabel("Qualification:");
        lQualification.setFont(new Font("Raleway", Font.BOLD, 18));
        lQualification.setBounds(100, 370, 150, 30);
        add(lQualification);

        c6.setBounds(350, 370, 320, 30);
        add(c6);

        l6.setBounds(100, 420, 250, 30); // Adjusted y-coordinate to create space
        add(l6);

        t1.setBounds(350, 420, 320, 30);
        add(t1);

        l7.setBounds(100, 470, 150, 30); // Adjusted y-coordinate to create space
        add(l7);

        r1.setBounds(350, 470, 100, 30);
        add(r1);

        r2.setBounds(460, 470, 100, 30);
        add(r2);

        l9.setBounds(100, 520, 150, 30); // Adjusted y-coordinate to create space
        add(l9);

        r3.setBounds(350, 520, 100, 30);
        add(r3);

        r4.setBounds(460, 520, 100, 30);
        add(r4);

        b.setBounds(570, 570, 100, 30); // Adjusted y-coordinate to create space
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 700); // Increased height of the frame

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String religion = (String) c1.getSelectedItem();
        String category = (String) c2.getSelectedItem();
        String income = (String) c3.getSelectedItem();
        String education = (String) c4.getSelectedItem();
        String occupation = (String) c5.getSelectedItem();
        String qualification = (String) c6.getSelectedItem(); // Added to get selected qualification

        String personal_identification_number = t1.getText();

        String senior_citizen = "";
        if (r1.isSelected()) {
            senior_citizen = "Yes";
        } else if (r2.isSelected()) {
            senior_citizen = "No";
        }

        String existing_account = "";

        if (r3.isSelected()) {
            existing_account = "Yes";
        } else if (r4.isSelected()) {
            existing_account = "No";
        }

        try {
            if (t1.getText().equals("")) { // Corrected the condition to check t1 instead of t2
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                DBConnection c1 = new DBConnection();

                // Escape special characters in qualification
                qualification = qualification.replace("'", "''");

                // Inserting Data into Table
                String q1 = "insert into signup2 values('" + form_number + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + qualification + "', '" + personal_identification_number + "','" + senior_citizen + "', '" + existing_account + "')";

                c1.s.executeUpdate(q1);

                new Signup3(form_number).setVisible(true);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("").setVisible(true);
    }
}