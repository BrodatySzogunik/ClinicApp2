package Clinic.baseOfVisits;

import Clinic.baseOfUsers.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {
    int patientId;
    Date date;
    Spec typeOfVisit;
    int doctorId;
    int prescriptionNumber;
    int recommendationsNumber;
    int visitNumber;
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public Visit(User patient, Date date, Spec typeOfVisit, Doctor doctor, int prescriptionNumber, int recommendationsNumber, int visitNumber)
    {
        this.patientId=patient.phoneNumber;
        this.date=date;
        this.typeOfVisit=typeOfVisit;
        this.doctorId=doctor.phoneNumber;
        this.prescriptionNumber=prescriptionNumber;
        this.recommendationsNumber=recommendationsNumber;
        this.visitNumber=visitNumber;
    }

    public Visit(int patientId, Date date, Spec typeOfVisit, int doctorId, int prescriptionNumber, int recommendationsNumber, int visitNumber)
    {
        this.patientId=patientId;
        this.date=date;
        this.typeOfVisit=typeOfVisit;
        this.doctorId=doctorId;
        this.prescriptionNumber=prescriptionNumber;
        this.recommendationsNumber=recommendationsNumber;
        this.visitNumber=visitNumber;
    }


    public void selectPatient(User patient)
    {
        this.patientId=patient.phoneNumber;
    }

    public void chooseDate(Date date)
    {
        this.date=date;
    }

    public void chooseTypeOfVisit(Spec typeOfVisit)
    {
        this.typeOfVisit=typeOfVisit;
    }

    public void chooseDoctor(Doctor doc)
    {
        this.doctorId=doc.phoneNumber;
    }

    public void modifyPrescriptionNumber(int newNumber)
    {
        this.prescriptionNumber=newNumber;
    }

    public void modifyRecommendationsNumber(int newNumber)
    {
        this.recommendationsNumber=newNumber;
    }

    @Override
    public String toString(){
        return  sdf1.format(date)+" "+Users.returnUserByPhoneNumber("Patients",patientId);

    }
}
