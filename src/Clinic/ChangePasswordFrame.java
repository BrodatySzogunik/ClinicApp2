package Clinic;

import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordFrame extends JFrame implements ActionListener {
    User user;
    JLabel lOldPassword ,lNewPassword,lRepeatNewPassword,lWrongPassword,lNewPasswordMatch;
    JTextField tOldPassword ,tNewPassword,tRepeatNewPassword;
    JButton bAccept;



    public ChangePasswordFrame(User user){
        this.user = user;
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        lOldPassword = new JLabel("Stare Hasło: ");
        lOldPassword.setBounds(20,20,150,20);
        add(lOldPassword);


        lNewPassword = new JLabel("Nowe Hasło: ");
        lNewPassword.setBounds(20,40,150,20);
        add(lNewPassword);

        lRepeatNewPassword = new JLabel("Powtórz nowe Hasło:  ");
        lRepeatNewPassword.setBounds(20,60,150,20);
        add(lRepeatNewPassword);

        lWrongPassword = new JLabel("Podano złe hasło!");
        lWrongPassword.setForeground(Color.RED);
        lWrongPassword.setBounds(20,80,150,20);


        lNewPasswordMatch = new JLabel("Nowe hasła nie pokrywają się!");
        lNewPasswordMatch.setForeground(Color.RED);
        lNewPasswordMatch.setBounds(20,80,190,20);


        tOldPassword = new JTextField();
        tOldPassword.setBounds(170,20,120,20);
        tOldPassword.addActionListener(this);
        add(tOldPassword);

        tNewPassword = new JTextField();
        tNewPassword.setBounds(170,40,120,20);
        tNewPassword.addActionListener(this);
        add(tNewPassword);

        tRepeatNewPassword = new JTextField();
        tRepeatNewPassword.setBounds(170,60,120,20);
        tRepeatNewPassword.addActionListener(this);
        add(tRepeatNewPassword);

        bAccept = new JButton("Zaakceptuj");
        bAccept.setBounds(170,100,120,20);
        bAccept.addActionListener(this);
        add(bAccept);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        this.remove(lWrongPassword);
        this.remove(lNewPasswordMatch);
        if(source == bAccept){
            if(user.password.equals(tOldPassword.getText())&&tNewPassword.getText().equals(tRepeatNewPassword.getText())){
                for(User actualUser:Users.returnUsers("Patients")){
                    if (actualUser.phoneNumber==user.phoneNumber){
                        actualUser.password=tNewPassword.getText();
                        Users.saveListOfUsersToFile();
                        this.dispose();
                    }
                }
            }else if(!user.password.equals(tOldPassword.getText())){
                this.add(lWrongPassword);

            }else if(!tNewPassword.getText().equals(tRepeatNewPassword.getText())){
                this.add(lNewPasswordMatch);

            }
        }
        this.repaint();



    }
}
