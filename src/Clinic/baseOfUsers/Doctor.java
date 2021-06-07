package Clinic.baseOfUsers;

import java.util.Scanner;

public class Doctor extends User{

    public Spec spec;
    Scanner in= new Scanner(System.in);
    Schedule schedule=new Schedule();

    public Doctor(String firstName,String lastName,int phoneNumber,String login,String password,Spec spec) {
        super(firstName,lastName,phoneNumber,login,password);
        this.spec = spec;
    }


}
//JD