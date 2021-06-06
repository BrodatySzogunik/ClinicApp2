package Clinic.baseOfUsers;

import java.util.Scanner;

public class Doctor extends User{

    public Spec spec;
    Scanner in= new Scanner(System.in);


    public Doctor(String firstName,String lastName,int phoneNumber,String login,String password,Spec spec) {
        super(firstName,lastName,phoneNumber,login,password);
        this.spec = spec;
//        System.out.println("Wybierz specjalizację \n1-Kardiolog\n2-Okulista\n3-Laryngolog\n4-Pediatra\n5-Ogólny\n6-Ortopeda\n7-Dermatolog");
//        switch (in.nextInt()){
//            case 1 -> spec = Spec.HEART;
//            case 2 -> spec = Spec.EYES;
//            case 3 -> spec = Spec.EARS;
//            case 4 -> spec = Spec.KIDS;
//            case 5 -> spec = Spec.ADULTS;
//            case 6 -> spec = Spec.BONES;
//            case 7 -> spec = Spec.SKIN;
//        }

    }

    @Override
    public Spec getSpec(){
        return this.spec;
    }
}
