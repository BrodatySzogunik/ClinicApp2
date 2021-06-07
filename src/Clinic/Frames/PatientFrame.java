package Clinic.Frames;

import Clinic.baseOfUsers.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientFrame extends JFrame implements ActionListener {
    User user;
    JButton bAddVisit,bShowVisits,bChangePassword;
    public PatientFrame(User user){
        this.user = user;
        setSize(500,500);
        setTitle("Zalogowany jako pacjent: "+user.firstName+" "+user.lastName);
        setLayout(null);

        bAddVisit =new JButton("Umów się na wizytę");
        bAddVisit.setBounds(20,20,150,20);
        bAddVisit.addActionListener(this);
        add(bAddVisit);

        // wyświetlanie wizyt docelowo bedzie zawierać edycję/usuwanie wizyt
        bShowVisits =new JButton("Wyświetl swoje wizyty");
        bShowVisits.setBounds(20,40,150,20);
        bShowVisits.addActionListener(this);
        add(bShowVisits);

        bChangePassword =new JButton("Zmień hasło");
        bChangePassword.setBounds(20,60,150,20);
        bChangePassword.addActionListener(this);
        add(bChangePassword);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == bAddVisit){
            VisitFrame visitFrame = new VisitFrame("addVisit");
            visitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            visitFrame.setVisible(true);
        }
        if(source == bChangePassword){
            ChangePasswordFrame changePasswordFrame = new ChangePasswordFrame(user);
            changePasswordFrame.setVisible(true);
        }


    }
}
