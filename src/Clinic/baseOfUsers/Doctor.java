package Clinic.baseOfUsers;

import javax.print.Doc;
import java.util.Scanner;

public class Doctor extends User{

    public Spec spec;
    Scanner in= new Scanner(System.in);
    public Schedule schedule=new Schedule();

    public Doctor(String firstName,String lastName,int phoneNumber,String login,String password,Spec spec) {
        super(firstName,lastName,phoneNumber,login,password);
        this.spec = spec;
    }

    public Doctor(String firstName,String lastName,int phoneNumber,String login,String password,Spec spec,Schedule schedule) {
        super(firstName,lastName,phoneNumber,login,password);
        this.spec = spec;
        this.schedule=schedule;
    }
}