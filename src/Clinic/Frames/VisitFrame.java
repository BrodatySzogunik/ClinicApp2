package Clinic.Frames;

import Clinic.VisitManagementSystem;
import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.Spec;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;
import Clinic.baseOfVisits.Visits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class VisitFrame extends JFrame implements ActionListener {

    JComboBox cChoseVisit,cChoseSpecialist,cChoseDoctor;
    JButton bAccept;

    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    User user1;
    Doctor doctor;


   public VisitFrame(String type,User user){
    user1=user;
       setSize(500,500);
       setTitle("wizyty");
       setLayout(null);


    if(type.equals("addVisit")){
        Spec[] array=(Spec.values());
        cChoseSpecialist =new JComboBox(array);
        cChoseSpecialist.setBounds(20,20,120,20);
        cChoseSpecialist.addActionListener(this);
        add(cChoseSpecialist);

        cChoseDoctor = new JComboBox();
        cChoseDoctor.setBounds(20,40,120,20);
        cChoseDoctor.addActionListener(this);


        cChoseVisit = new JComboBox();
        cChoseVisit.setBounds(20,60,120,20);
        cChoseVisit.addActionListener(this);

        bAccept = new JButton("Umów wizytę");
        bAccept.setBounds(20,80,120,20);
        bAccept.addActionListener(this);


    }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       if(source == cChoseSpecialist){
           add(cChoseDoctor);
           cChoseDoctor.removeAllItems();
           for(Doctor doctor: Users.doctors){
               if(doctor.spec==cChoseSpecialist.getSelectedItem()) {
                   cChoseDoctor.addItem(doctor);
               }
           }
        }

       if(source == cChoseDoctor){
           cChoseVisit.removeAllItems();
           add(cChoseVisit);
            doctor =(Doctor)cChoseDoctor.getSelectedItem();
            for (Map.Entry<Date, Integer> scheduleEntry : doctor.schedule.returnSchedule().entrySet()) {
                if(scheduleEntry.getValue()==0){cChoseVisit.addItem(sdf1.format(scheduleEntry.getKey()));}
            }
            this.add(bAccept);


       }

       if(source == bAccept){
           try {
               VisitManagementSystem.setAppointment(user1,doctor,sdf1.parse((String)cChoseVisit.getSelectedItem()));
               Visits.saveVisitsToFile();
           } catch (ParseException parseException) {
               parseException.printStackTrace();
           }
           this.dispose();
       }
       this.repaint();
    }

}
