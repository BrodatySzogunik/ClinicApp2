package Clinic.prescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Prescription {
    List<Medicine> medicines;
    int date;
    int patientId;
    String recommendation;


    public Prescription(List<Medicine> medicines, int date, int patientId, String recommendation) {
        this.medicines = medicines;
        this.date = date;
        this.patientId = patientId;
        this.recommendation = recommendation;

    }

}

