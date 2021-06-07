package Clinic.Frames;

import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.Spec;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class VisitFrame extends JFrame implements ActionListener {

    JComboBox cChoseVisit,cChoseSpecialist;

    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");



   public VisitFrame(String type){

       setSize(500,500);
       setTitle("wizyty");
       setLayout(null);


    if(type.equals("addVisit")){
        Spec[] array=(Spec.values());
        cChoseSpecialist =new JComboBox(array);
        cChoseSpecialist.setBounds(20,20,120,20);
        cChoseSpecialist.addActionListener(this);
        add(cChoseSpecialist);

        cChoseVisit = new JComboBox();
        cChoseVisit.setBounds(20,40,120,20);
        cChoseVisit.addActionListener(this);


    }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       if(source == cChoseSpecialist){
           add(cChoseVisit);
           for(Doctor doctor: Users.doctors){
               if(doctor.spec==cChoseSpecialist.getSelectedItem()) {
                   for (Map.Entry<Date, Integer> scheduleEntry : doctor.schedule.returnSchedule().entrySet()) {
                       cChoseVisit.addItem(sdf1.format(scheduleEntry.getKey()));
                   }
               }
           }
        }
       this.repaint();
    }
}
