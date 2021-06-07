package Clinic.Frames;

import Clinic.Login;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrame extends JFrame implements ActionListener {

    JTextField tLogin, tPassword;
    JLabel lLogin,lPassword,lNotLogged;
    JButton bLogin,bRegisterNewPatient;
    ButtonGroup accountType;
    JCheckBox Patient,Doctor,Admin,Receptionist;

    public LoginFrame (){


        setSize(500,500);
        setTitle("Clinic app");
        setLayout(null);

        lLogin = new JLabel("Login:");
        lLogin.setBounds(20,40,120,20);

        lPassword = new JLabel("Hasło: ");
        lPassword.setBounds(20,60,120,20);

        tLogin = new JTextField("");
        tLogin.setBounds(140,40,120,20);
        tPassword = new JTextField("");
        tPassword.setBounds(140,60,120,20);

        bLogin = new JButton("Zaloguj");
        bLogin.setBounds(60,80,120,20);
        bLogin.addActionListener(this);

        bRegisterNewPatient = new JButton("Zarejestruj się!");
        bRegisterNewPatient.setBounds(180,80,120,20);
        bRegisterNewPatient.addActionListener(this);


        lNotLogged= new JLabel("Niepoprawne dane logowania");
        lNotLogged.setForeground(new Color(255,0,0));
        lNotLogged.setBounds(60,100,180,20);

        accountType = new ButtonGroup();

        Patient = new JCheckBox("Pacjent");
        Patient.setBounds(20,20,80,20);
        accountType.add(Patient);
        add(Patient);

        Doctor = new JCheckBox("Lekarz");
        Doctor.setBounds(100,20,80,20);
        accountType.add(Doctor);
        add(Doctor);

        Admin = new JCheckBox("Administrator");
        Admin.setBounds(180,20,120,20);
        accountType.add(Admin);
        add(Admin);

        Receptionist = new JCheckBox("Recepcjonista");
        Receptionist.setBounds(280,20,120,20);
        accountType.add(Receptionist);
        add(Receptionist);

        add(bRegisterNewPatient);
        add(tLogin);
        add(tPassword);
        add(lLogin);
        add(lPassword);
        add(bLogin);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();


        // logowanie urzytkownika, wyświetlenie panelu urzytkownika

        if(source==bLogin) {
            User user ;
            if (Patient.isSelected()) {
                user = Login.checkCredentials(Users.users.get("Patients"),tLogin.getText(),tPassword.getText());
                if (user != null) {
                    PatientFrame patientFrame = new PatientFrame(user);
                    patientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    patientFrame.setVisible(true);
                    this.dispose();
                } else {
                    add(lNotLogged);
                    //błąd w logowaniu

                }
                this.repaint();
            }

            // logowanie admina, wyświetlenie panelu admina
            if (Doctor.isSelected()) {
                user =Login.checkCredentials(Users.users.get("Doctors"),tLogin.getText(),tPassword.getText());
                if (user != null) {
                    DoctorFrame doctorFrame = new DoctorFrame(user);
                    doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    doctorFrame.setVisible(true);
                    this.dispose();
                } else {
                    add(lNotLogged);
                    //błąd w logowaniu

                }
                this.repaint();
            }

            //logowanie doktora, wyświetlenie panelu dokrora
            if (Admin.isSelected()) {
                user =Login.checkCredentials(Users.users.get("Admins"),tLogin.getText(),tPassword.getText());
                if (user != null) {
                    AdminFrame adminFrame = new AdminFrame(user);
                    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    adminFrame.setVisible(true);
                    this.dispose();
                } else {
                    add(lNotLogged);
                    //błąd w logowaniu

                }
                this.repaint();
            }
            //logowanie recepcjonisty, wyświetlenie panelu recepcjonisty
            if (Receptionist.isSelected()) {
                user =Login.checkCredentials(Users.users.get("Receptionists"),tLogin.getText(),tPassword.getText());
                if (user != null) {
                    ReceptionistFrame receptionistFrame = new ReceptionistFrame(user);
                    receptionistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    receptionistFrame.setVisible(true);
                    this.dispose();
                } else {
                    add(lNotLogged);
                    //błąd w logowaniu

                }
                this.repaint();
            }
        }
        if(source == bRegisterNewPatient){
            RegisterFrame registerFrame = new RegisterFrame();
            registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            registerFrame.setVisible(true);


        }


    }
}

