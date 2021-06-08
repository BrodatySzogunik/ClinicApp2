package Clinic.baseOfVisits;

import Clinic.VisitManagementSystem;
import Clinic.baseOfPrescription.BaseOfPrescriptions;
import Clinic.baseOfRecommendations.Recommendations;
import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.Spec;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;
import Clinic.baseOfVisits.Visit;
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

    JComboBox cChoseVisit,cChoseSpecialist,cChoseDoctor,cShowVisits;

    JButton bAccept,bRemoveVisit,bViewVisitsDetail;


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

       if(type.equals("showVisits")){

           cShowVisits =new JComboBox();
           cShowVisits.setBounds(20,20,200,20);
           cShowVisits.addActionListener(this);

           bRemoveVisit =new JButton("Odwołaj wizytę");
           bRemoveVisit.setBounds(20,40,200,20);
           bRemoveVisit.addActionListener(this);

           bViewVisitsDetail=new JButton("wyświetl szczegóły wizyty");
           bViewVisitsDetail.setBounds(220,40,200,20);
           bViewVisitsDetail.addActionListener(this);

           add(bRemoveVisit);
           add(bViewVisitsDetail);



           for(Map.Entry<Integer, Visit>visitsEntry:Visits.visits.entrySet()){
               if(user1.phoneNumber==visitsEntry.getValue().patientId) cShowVisits.addItem(visitsEntry.getValue());
           }
           add(cShowVisits);



       }





    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Doctor doc=null;
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

       if(source==bRemoveVisit){
           for(Doctor doctor: Users.doctors){
               if(doctor.phoneNumber==((Visit)cShowVisits.getSelectedItem()).doctorId)doc=doctor;
           }
           if(doc!=null)doc.schedule.resignFromVisit(((Visit)cShowVisits.getSelectedItem()).date);
           Recommendations.removeRecommendation(((Visit)cShowVisits.getSelectedItem()).recommendationsNumber);
           BaseOfPrescriptions.removePrescription(((Visit)cShowVisits.getSelectedItem()).prescriptionNumber);
           Visits.removeVisit(((Visit) cShowVisits.getSelectedItem()).visitNumber);
           cShowVisits.removeAllItems();
           remove(cShowVisits);
           for(Map.Entry<Integer, Visit>visitsEntry:Visits.visits.entrySet()){
               if(user1.phoneNumber==visitsEntry.getValue().patientId) cShowVisits.addItem(visitsEntry.getValue());
           }
           Visits.saveVisitsToFile();
           BaseOfPrescriptions.savePrescriptionsToFile();
           Recommendations.saveRecommendationsToFile();

           add(cShowVisits);
       }

       if(source==bViewVisitsDetail){
           VisitDetailsFrame visitDetailsFrame=new VisitDetailsFrame(user1,(Visit)cShowVisits.getSelectedItem());
           visitDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           visitDetailsFrame.setVisible(true);


       }
    }

}
