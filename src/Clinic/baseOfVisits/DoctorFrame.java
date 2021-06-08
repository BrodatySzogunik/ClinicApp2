package Clinic.baseOfVisits;

import Clinic.Frames.SetScheduleFrame;
import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Map;

public class DoctorFrame extends JFrame implements ActionListener {

    JButton bShowMyVisits, bSetSchedule,bAddNewReferral,bAddNewPrescription,bGetDetails;
    JComboBox cVisits;
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

        cVisits=new JComboBox();
        cVisits.setBounds(220,20,270,20);

        bGetDetails=new JButton("Szczegoly wizyty");
        bGetDetails.setBounds(340,40,150,20);
        bGetDetails.addActionListener(this);



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
        User user1=null;
        Object source = e.getSource();
        if(source == bSetSchedule){
            SetScheduleFrame setScheduleFrame = new SetScheduleFrame(doctor1);
            setScheduleFrame.setVisible(true);
        }

        if(source==bShowMyVisits){
            cVisits.removeAllItems();
            for(Map.Entry<Integer,Visit> entry:Visits.visits.entrySet())
            {

                if(doctor1.phoneNumber==entry.getValue().doctorId&&Users.returnUserByPhoneNumber("Patients",entry.getValue().patientId)!=null){
                    cVisits.addItem(entry.getValue());
                }


            }
            add(cVisits);
            add(bGetDetails);
        }

        if(source==bGetDetails)
        {
            for(User user:Users.users.get("Patients"))
            {
                if(user.phoneNumber==((Visit)cVisits.getSelectedItem()).patientId)user1=user;
            }
            if(user1!=null)
            {
                VisitDetailsFrame visitDetailsFrame=new VisitDetailsFrame(user1,(Visit)cVisits.getSelectedItem());
                visitDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                visitDetailsFrame.setVisible(true);
            }
        }
        this.repaint();

    }
}
