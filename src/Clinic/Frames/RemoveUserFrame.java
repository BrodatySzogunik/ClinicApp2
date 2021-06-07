package Clinic.Frames;

import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveUserFrame extends JFrame implements ActionListener {
    JComboBox cRemoveBox,cUserType;
    JButton bRemoveUser;
    public RemoveUserFrame(){



        this.setTitle("Jebać Disa");
        this.setSize(500,500);
        this.setLayout(null);

        String [] userTypes = {"Admins","Receptionists","Patients","Doctors"};
        cUserType=new JComboBox(userTypes);
        cUserType.setBounds(20,20,120,20);
        cUserType.addActionListener(this);
        add(cUserType);

        cRemoveBox = new JComboBox();
        cRemoveBox.setBounds(20,40,200,20);

        bRemoveUser = new JButton("Usuń użytkownika");
        bRemoveUser.setBounds(20,60,120,20);
        bRemoveUser.setForeground(Color.RED);
        bRemoveUser.addActionListener(this);
        add(bRemoveUser);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == cUserType){
            remove(cRemoveBox);
            cRemoveBox.removeAllItems();
            if(Users.returnUsers((String)cUserType.getSelectedItem())!=null) {
                for (User user : Users.returnUsers((String) cUserType.getSelectedItem())) {

                    cRemoveBox.addItem(user.firstName + " " + user.lastName + " " + user.phoneNumber);
                }
            }
                add(cRemoveBox);
                this.repaint();
        }
        if(source == bRemoveUser && !(Users.returnUsers((String)cUserType.getSelectedItem())==null)){
            Users.removeUser((String)cUserType.getSelectedItem(),Users.returnUser(Users.returnUsers((String) cUserType.getSelectedItem()),cRemoveBox.getSelectedIndex()));
            Users.saveListOfUsersToFile();
            this.dispose();
        }

    }
}
