package Clinic;

import Clinic.baseOfUsers.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordFrame extends JFrame implements ActionListener {
    User user;
    JLabel lOldPassword ,lNewPassword,lRepeatNewPassword;
    JTextField tOldPassword ,tNewPassword,tRepeatNewPassword;
    JButton bAccept;



    public ChangePasswordFrame(User user){
        this.user = user;
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        lOldPassword = new JLabel("Stare Hasło: ");
        lOldPassword.setBounds(20,20,120,20);
        add(lOldPassword);


        lNewPassword = new JLabel("Nowe Hasło: ");
        lNewPassword.setBounds(20,40,120,20);
        add(lNewPassword);

        lRepeatNewPassword = new JLabel("Powtórz nowe Hasło:  ");
        lRepeatNewPassword.setBounds(20,60,120,20);
        add(lRepeatNewPassword);

        tOldPassword = new JTextField();
        tOldPassword.setBounds(140,20,120,20);
        tOldPassword.addActionListener(this);
        add(tOldPassword);

        tNewPassword = new JTextField();
        tNewPassword.setBounds(140,40,120,20);
        tNewPassword.addActionListener(this);
        add(tNewPassword);

        tRepeatNewPassword = new JTextField();
        tRepeatNewPassword.setBounds(140,60,120,20);
        tRepeatNewPassword.addActionListener(this);
        add(tRepeatNewPassword);

        bAccept = new JButton("Zaakceptuj");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == bAccept){
            if(user.password.equals(tOldPassword.getText()));
        }



    }
}
