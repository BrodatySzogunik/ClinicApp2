package Clinic.Frames;

import Clinic.Register;
import Clinic.baseOfUsers.Spec;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterFrame extends JFrame implements ActionListener {

    JLabel lName,lLastName,lPhoneNumber,lLogin,lPassword,lRegisterFailed,lSpecialization,lChoseUserType;
    JTextField tName,tLastName,tPhoneNumber,tLogin,tPassword;
    JButton bRegister;
    JComboBox cChoseUserType,cSpecialization;



    public RegisterFrame(){
        setTitle("Rejestracja");
        setSize(500,500);
        setLayout(null);

        //etykiety

        lChoseUserType =new JLabel("Typ konta:");
        lChoseUserType.setBounds(20,0,120,20);


        lName =new JLabel("Imię: ");
        lName.setBounds(20,20,120,20);
        add(lName);

        lLastName =new JLabel("Nazwisko: ");
        lLastName.setBounds(20,40,120,20);
        add(lLastName);

        lPhoneNumber =new JLabel("Numer Telefonu: ");
        lPhoneNumber.setBounds(20,60,120,20);
        add(lPhoneNumber);

        lLogin =new JLabel("Login: ");
        lLogin.setBounds(20,80,120,20);
        add(lLogin);

        lSpecialization =new JLabel("Specjalizacja: ");
        lSpecialization.setBounds(20,120,120,20);


        lPassword =new JLabel("Hasło: ");
        lPassword.setBounds(20,100,120,20);
        add(lPassword);

        //Pola tekstowe

        tName =new JTextField();
        tName.setBounds(140,20,120,20);
        add(tName);

        tLastName =new JTextField();
        tLastName.setBounds(140,40,120,20);
        add(tLastName);

        tPhoneNumber =new JTextField();
        tPhoneNumber.setBounds(140,60,120,20);
        add(tPhoneNumber);

        tLogin =new JTextField();
        tLogin.setBounds(140,80,120,20);
        add(tLogin);

        tPassword =new JTextField();
        tPassword.setBounds(140,100,120,20);
        add(tPassword);

        // Buttons

        bRegister = new JButton("Zarejestruj");
        bRegister.setBounds(140,140,120,20);
        bRegister.addActionListener(this);
        add(bRegister);


        cSpecialization = new JComboBox(Spec.values());
        cSpecialization.setBounds(140,120,120,20);

        String[] userTypes= {"Admin","Pacjent","Lekarz","Recepcjonista"};
        cChoseUserType =new JComboBox(userTypes);
        cChoseUserType.setBounds(140,0,120,20);
        cChoseUserType.addActionListener(this);





        lRegisterFailed =new JLabel("Błąd podczas rejestracji");
        lRegisterFailed.setBounds(140,160,200,20);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == cChoseUserType){
            if(cChoseUserType.getSelectedItem().equals("Lekarz")){
                this.add(cSpecialization);
                this.add(lSpecialization);

            }else{
                if(cSpecialization.isShowing()){
                    this.remove(cSpecialization);
                    this.remove(lSpecialization);
                }
            }
            this.repaint();
        }

        if(source==bRegister&&!(tLogin.getText()).isEmpty()&&!(tName.getText()).isEmpty()&&!(tLastName.getText()).isEmpty()&&!(tPassword.getText()).isEmpty()&&!(tPhoneNumber.getText()).isEmpty()) {
            switch ((String) cChoseUserType.getSelectedItem()) {
                case "Lekarz" -> Register.registerDoctor(tName.getText(), tLastName.getText(), Integer.parseInt(tPhoneNumber.getText()), tLogin.getText(), tPassword.getText(), (Spec) cSpecialization.getSelectedItem());
                case "Pacjent" -> Register.registerPatient(tName.getText(), tLastName.getText(), Integer.parseInt(tPhoneNumber.getText()), tLogin.getText(), tPassword.getText());
                case "Admin" -> Register.registerAdmin(tName.getText(), tLastName.getText(), Integer.parseInt(tPhoneNumber.getText()), tLogin.getText(), tPassword.getText());
                case "Recepcjonista" -> Register.registerReceptionist(tName.getText(), tLastName.getText(), Integer.parseInt(tPhoneNumber.getText()), tLogin.getText(), tPassword.getText());
            }
            this.dispose();
        }


    }
}
