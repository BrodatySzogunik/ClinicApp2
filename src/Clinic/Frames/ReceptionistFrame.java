package Clinic.Frames;

import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;
import Clinic.baseOfVisits.VisitFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistFrame extends JFrame implements ActionListener {

    JButton bAddVisit,bEditVisit,bAddNewPatient,bEditPatientData,bShowPrescriptions,ShowReferral;

    JButton bAddVisitC;
    JTextField tPhone;

    public ReceptionistFrame(User receptionist){
        setSize(500,500);
        setTitle("Zalogowany jako Recepcjonista: "+receptionist.firstName+" "+receptionist.lastName);
        setLayout(null);


        bAddVisit =new JButton("Umów na wizytę");
        bAddVisit.setBounds(20,20,100,20);
        bAddVisit.addActionListener(this);
        add(bAddVisit);
        bAddVisitC = new JButton("przejdź dalej");
        bAddVisitC.setBounds(300,20,100,20);
        bAddVisitC.addActionListener(this);
        tPhone=new JTextField("Number");
        tPhone.setBounds(200,20,100,20);





        bEditVisit= new JButton("Edytuj wizytę");
        bEditVisit.setBounds(20,40,150,20);
        bEditVisit.addActionListener(this);
        add(bEditVisit);

        bAddNewPatient =new JButton("Zarejestruj Nowego pacjenta");
        bAddNewPatient.setBounds(20,60,150,20);
        bAddNewPatient.addActionListener(this);
        add(bAddNewPatient);

        bEditPatientData = new JButton("Zmień dane pacjenta");
        bEditPatientData.setBounds(20,80,150,20);
        bEditPatientData.addActionListener(this);
        add(bEditPatientData);

        bShowPrescriptions = new JButton("Wyświetl recepty");
        bShowPrescriptions.setBounds(20,100,150,20);
        bShowPrescriptions.addActionListener(this);
        add(bShowPrescriptions);

        /*ShowReferral = new JButton("Wyświetl skierowania");
        ShowReferral.setBounds(20,120,150,20);
        ShowReferral.addActionListener(this);
        add(ShowReferral);*/





    }



    @Override
    public void actionPerformed(ActionEvent e) {
        User user1=null;
        Object source = e.getSource();
        if(source==bAddNewPatient)
        {
            RegisterFrame registerFrame=new RegisterFrame();
            registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            registerFrame.setVisible(true);
        }

        if(source==bAddVisit)
        {
            add(tPhone);
            add(bAddVisitC);
        }
        if(source==bAddVisitC)
        {
            for(User user: Users.users.get("Patients")) {
                if(user.phoneNumber == Integer.parseInt(tPhone.getText())){
                    user1=user;
                    break;
                }
            }
            if(user1!=null){
                VisitFrame visitFrame=new VisitFrame("addVisit", user1);
                visitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                visitFrame.setVisible(true);
            }
        }
        this.repaint();
    }
}
