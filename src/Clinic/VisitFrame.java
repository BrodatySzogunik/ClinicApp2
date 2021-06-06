package Clinic;

import Clinic.baseOfUsers.Spec;

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
    }



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
