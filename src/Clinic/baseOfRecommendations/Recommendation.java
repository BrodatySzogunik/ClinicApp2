package Clinic.baseOfRecommendations;

import Clinic.baseOfUsers.User;

import java.util.Date;

public class Recommendation {
    public Date dateOfIssue;
    public String recommendations;
    public int patientId;

    public Recommendation(String recommendation, Date dateOfIssue, int patientId){
        this.dateOfIssue=dateOfIssue;
        this.recommendations=recommendation;
        this.patientId=patientId;
    }
}
