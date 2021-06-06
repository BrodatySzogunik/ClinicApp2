package Clinic.baseOfVisits;

import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.Spec;
import Clinic.baseOfUsers.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Visits {
    Map<Integer, Visit> visits= new HashMap<>();


    public void addVisit(int key, User patient, Date date, Spec typeOfVisit, Doctor doctor, int prescriptionNumber, int recommendationsNumber)
    {
        if(visits.containsKey(key))return;
        visits.put(key, new Visit(patient,date,typeOfVisit,doctor,prescriptionNumber,recommendationsNumber,key));
    }

//    public void editVisit(int key)
//    {
//
//    }

    public void removeVisit(int key)
    {
        if(!visits.containsKey(key))return;
        visits.remove(key);
    }
}
