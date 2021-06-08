package Clinic;

import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;

import java.util.ArrayList;
//import java.util.Scanner;
//
//import static Clinic.UserInterface.*;

public class Login {
//    //static private boolean;
//    static String login,password,loggedUser;
//
//    static Scanner userInput = new Scanner(System.in);
////
//
//    public static void Login(User user){
//        switch (loggedUser){
//            case "Patient" -> showUserInterface();
//            case "Doctor" -> showDoctorInterface();
//            case "Admin" -> showAdminInterface();
//            case "Receptionist" -> showReceptionistInterface();
//        }
//    }



//    public static User checkUserType(String login,String password){
//        System.out.println("wybierz typ konta: \n1-Lekarz \n2-Pacjent\n3-Recepcjonista\n4-Admin");
//        switch (userInput.nextInt()){
//            case 1 -> {
//                loggedUser ="Doctor";
//                Login(checkCredentials(Users.users.get("Doctors"),login,password));
//            }
//            case 2 -> {
//                loggedUser ="Patient";
//                Login(checkCredentials(Users.users.get("Patients"),login,password));
//            }
//            case 3 -> {
//                loggedUser ="Admin";
//                Login(checkCredentials(Users.users.get("Admins"),login,password));
//            }
//            case 4 -> {
//                loggedUser ="Receptionist";
//                Login(checkCredentials(Users.users.get("Receptionists"),login,password));
//            }
//        } return null;
//
//    }


    public static User checkCredentials(ArrayList<User> users,String login,String password) {
            for (User user : users) {
                if (login.equals(user.login)&&password.equals(user.password)) {
                    return user;
                }
            }
            return null;
    }

    public static Doctor checkCredentialsD(ArrayList<Doctor> doc, String login, String password,boolean a) {
        //Users.loadListOfUsersFromFile();
        for (Doctor user : doc) {
            if (login.equals(user.login)&&password.equals(user.password)) {
                return user;
            }
        }
        return null;
    }

}
