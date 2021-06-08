package Clinic.baseOfVisits;

import Clinic.baseOfPrescription.Prescription;
import Clinic.baseOfRecommendations.Recommendation;
import Clinic.baseOfRecommendations.Recommendations;
import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;
import Clinic.baseOfVisits.Visit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Map;

public class VisitDetailsFrame extends JFrame implements ActionListener {
    JLabel lPatient, lDate, lType, lDoc, lReco, lPresc;
    User user1;
    Visit visit;
    Doctor doc;
    Recommendation reco;
    Prescription presc;
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    public  VisitDetailsFrame(User user, Visit visit)
    {
        this.user1=user;
        this.visit=visit;
        setLayout(null);
        setSize(500,500);
        setTitle("Szczegoly wizyty: "+visit.visitNumber);

        lPatient=new JLabel("Imie i nazwisko pacjenta: "+user.firstName+" "+user.lastName);
        lPatient.setBounds(20,20,300,20);

        lDate=new JLabel("Data i godzina wizyty: "+sdf1.format(visit.date));
        lDate.setBounds(20,40,300,20);

        lType=new JLabel("Specjalizacja: "+visit.typeOfVisit.toString());
        lType.setBounds(20,60,300,20);

        for(Doctor doctor: Users.doctors){
            if(doctor.phoneNumber==visit.doctorId)doc=doctor;
        }
        lDoc=new JLabel("Imie i nazwisko doktora: "+doc.firstName + " " + doc.lastName);
        lDoc.setBounds(20,80,300,20);

        for(Map.Entry<Integer, Recommendation> entry: Recommendations.recommendations.entrySet())
        {
            if(entry.getKey()==visit.recommendationsNumber)
            {
                reco=entry.getValue();
                break;
            }
        }
        if(reco!=null&&reco.recommendations!=null&&reco.recommendations!="") {
            lReco = new JLabel("Zalecenia z wizyty: "+reco.recommendations);
        }else {
            lReco= new JLabel("Zalecenia z wiztyty: obecnie brak");
        }
        lReco.setBounds(20,100,300,20);

        add(lPatient);
        add(lDate);
        add(lType);
        add(lDoc);
        add(lReco);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source=e.getSource();

    }
}
