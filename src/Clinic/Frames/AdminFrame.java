package Clinic.Frames;

import Clinic.baseOfUsers.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener {
    JButton bAddNewAccount,bDeleteAccount,bModifyData;

    public AdminFrame(User admin){

        setSize(500,500);
        setTitle("Zalogowany jako Admin: "+admin.firstName+" "+admin.lastName);
        setLayout(null);


        bAddNewAccount =new JButton("Dodaj nowego użytkownika");
        bAddNewAccount.setBounds(20,20,150,20);
        bAddNewAccount.addActionListener(this);
        add(bAddNewAccount);

        bDeleteAccount= new JButton("Usuń użytkownika");
        bDeleteAccount.setBounds(20,40,150,20);
        bDeleteAccount.addActionListener(this);
        add(bDeleteAccount);

        bModifyData =new JButton("Modyfikuj użytkownika");
        bModifyData.setBounds(20,60,150,20);
        bModifyData.addActionListener(this);
        add(bModifyData);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == bAddNewAccount){
            RegisterFrame registerFrame = new RegisterFrame();
            registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            registerFrame.setVisible(true);
            registerFrame.add(registerFrame.lChoseUserType);
            registerFrame.add(registerFrame.cChoseUserType);
        }else if(source == bDeleteAccount){
            RemoveUserFrame removeUserFrame = new RemoveUserFrame();
            removeUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            removeUserFrame.setVisible(true);
        }else if(source == bModifyData){

        }

    }
}
