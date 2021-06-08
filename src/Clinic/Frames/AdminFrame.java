package Clinic.Frames;

import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;
import Clinic.baseOfVisits.VisitFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener {
    JButton bAddNewAccount,bDeleteAccount,bShowAccountDetails,bGetDetails;
    JLabel lFirstName,lLastName, lPhoneNumber, lLogin, lPassword,lType;
    JTextField tPhone;
    User user1=null;
    String type;
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

        bShowAccountDetails=new JButton("Wyświetl szczegóły konta");
        bShowAccountDetails.setBounds(20,60,150,20);
        bShowAccountDetails.addActionListener(this);
        add(bShowAccountDetails);

        bGetDetails=new JButton("Akceptuj");
        bGetDetails.setBounds(270,60,150,20);
        bGetDetails.addActionListener(this);

        tPhone=new JTextField("Number");
        tPhone.setBounds(170,60,100,20);

        lFirstName=new JLabel();
        lLastName=new JLabel();
        lPhoneNumber=new JLabel();
        lLogin=new JLabel();
        lPassword=new JLabel();
        lType=new JLabel();
        lFirstName.setBounds(20,80,100,20);
        lLastName.setBounds(20,100,100,20);
        lPhoneNumber.setBounds(20,120,100,20);
        lLogin.setBounds(20,140,100,20);
        lPassword.setBounds(20,160,100,20);
        lType.setBounds(20,180,180,20);
        add(lFirstName);
        add(lLastName);
        add(lPhoneNumber);
        add(lLogin);
        add(lPassword);
        add(lType);

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
        }else if(source == bDeleteAccount) {
            RemoveUserFrame removeUserFrame = new RemoveUserFrame();
            removeUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            removeUserFrame.setVisible(true);
        }else if(source==bShowAccountDetails){
            add(tPhone);
            add(bGetDetails);
        }else if(source==bGetDetails){
            for(User user: Users.users.get("Patients")) {
                if(user.phoneNumber == Integer.parseInt(tPhone.getText())){
                    type="Pacjent";
                    user1=user;
                    break;
                }
            }
            if(user1==null)
            {
                for(User user: Users.doctors) {
                    if(user.phoneNumber == Integer.parseInt(tPhone.getText())){
                        type="Doktor";
                        user1=user;
                        break;
                    }
                }
            }
            if(user1==null)
            {
                for(User user: Users.users.get("Receptionists")) {
                    if(user.phoneNumber == Integer.parseInt(tPhone.getText())){
                        type="Recepcjonista";
                        user1=user;
                        break;
                    }
                }
            }
            if(user1==null)
            {
                for(User user: Users.users.get("Admins")) {
                    if(user.phoneNumber == Integer.parseInt(tPhone.getText())){
                        type="Admin";
                        user1=user;
                        break;
                    }
                }
            }

            if(user1!=null){
                lFirstName.setText("Imie: "+user1.firstName);
                lLastName.setText("Nazwisko: "+user1.lastName);
                lPhoneNumber.setText(String.valueOf("Numer: "+user1.phoneNumber));
                lLogin.setText("Login: "+user1.login);
                lPassword.setText("Haslo: "+user1.password);
                lType.setText("Typ konta: "+type);
            }
            user1=null;
        }
        this.repaint();
    }
}
