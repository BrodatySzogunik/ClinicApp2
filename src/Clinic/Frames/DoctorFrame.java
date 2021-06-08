package Clinic.Frames;

import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorFrame extends JFrame implements ActionListener {

    JButton bShowMyVisits, bSetSchedule,bAddNewReferral,bAddNewPrescription;
    Doctor doctor1 ;
    public DoctorFrame(Doctor doctor){
        doctor1=doctor;



        setSize(500,500);
        setTitle("Zalogowany jako lekarz: "+doctor.firstName+" "+doctor.lastName);
        setLayout(null);



        bShowMyVisits =new JButton("Pokaż zaplanowane wizyty");
        bShowMyVisits.setBounds(20,20,200,20);
        bShowMyVisits.addActionListener(this);
        add(bShowMyVisits);

        bSetSchedule= new JButton("Edytuj swój grafik");
        bSetSchedule.setBounds(20,40,200,20);
        bSetSchedule.addActionListener(this);
        add(bSetSchedule);

        bAddNewPrescription =new JButton("Wystaw Receptę");
        bAddNewPrescription.setBounds(20,60,200,20);
        bAddNewPrescription.addActionListener(this);
        add(bAddNewPrescription);

        bAddNewReferral = new JButton("Wystaw skierowanie");
        bAddNewReferral.setBounds(20,80,200,20);
        bAddNewReferral.addActionListener(this);
        add(bAddNewReferral);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == bSetSchedule){
            SetScheduleFrame setScheduleFrame = new SetScheduleFrame(doctor1);
            setScheduleFrame.setVisible(true);

        }

    }
}
