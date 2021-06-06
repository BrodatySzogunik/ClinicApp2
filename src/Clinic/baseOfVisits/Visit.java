package Clinic.baseOfVisits;

import Clinic.baseOfUsers.*;

import java.util.Date;

public class Visit {
    User patient;
    Date date;
    Spec typeOfVisit;
    Doctor doctor;
    int prescriptionNumber;
    int recommendationsNumber;
    int visitNumber;

    public Visit(User patient, Date date, Spec typeOfVisit, Doctor doctor, int prescriptionNumber, int recommendationsNumber, int visitNumber)
    {
        this.patient=patient;
        this.date=date;
        this.typeOfVisit=typeOfVisit;
        this.doctor=doctor;
        this.prescriptionNumber=prescriptionNumber;
        this.recommendationsNumber=recommendationsNumber;
        this.visitNumber=visitNumber;
    }

    public void selectPatient(User patient)
    {
        this.patient=patient;
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
        this.doctor=doc;
    }

    public void modifyPrescriptionNumber(int newNumber)
    {
        this.prescriptionNumber=newNumber;
    }

    public void modifyRecommendationsNumber(int newNumber)
    {
        this.recommendationsNumber=newNumber;
    }
}
