package Clinic.Frames;

import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.Spec;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisitFrame extends JFrame implements ActionListener {

    JComboBox cChoseVisit,cChoseSpecialist;



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
           for(User doctor: Users.returnUsers("Doctors")){
               if(((Doctor)doctor).spec==cChoseSpecialist.getSelectedItem()){
//                   for()
//                   cChoseVisit.add()

               }
           }
       }

    }
}
