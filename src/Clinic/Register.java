package Clinic;

import Clinic.baseOfUsers.Spec;
import Clinic.baseOfUsers.User;
import Clinic.baseOfUsers.Users;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static Scanner in = new Scanner(System.in);

//    public static void register(Users baseOfUsers){
//        switch (in.nextInt()){
//            case 1->registerPatient(baseOfUsers);
//            case 2->registerDoctor(baseOfUsers);
//            case 3->registerAdmin(baseOfUsers);
//            case 4->registerReceptionist(baseOfUsers);
//        }
//    }

//dodać mechanizm sprawdzania czy dany użytkownik już istnieje
    public static boolean registerPatient(String firstName, String lastName, int phoneNumber, String login, String password){
        if(Users.users.keySet().contains("Patients")) {
            for (User user : Users.users.get("Patients")) {
                if (user.phoneNumber == phoneNumber || user.login.equals(login)) {
                    return false;
                }
            }
        }
            Users.addPatient(firstName, lastName, phoneNumber, login, password);
            Users.saveListOfUsersToFile();
            return true;


    }
    public static boolean registerDoctor(String firstName, String lastName, int phoneNumber, String login, String password, Spec spec){
        if(Users.users.keySet().contains("Doctors")) {
            for (User user : Users.users.get("Doctors")) {
                if (user.phoneNumber == phoneNumber || user.login.equals(login)) {
                    Users.saveListOfUsersToFile();
                    return false;
                }
            }
        }
        Users.addDoctor(firstName,lastName,phoneNumber,login,password,spec);
        Users.saveListOfUsersToFile();
        return true;
    }
    public static boolean registerAdmin(String firstName, String lastName, int phoneNumber, String login, String password){
        if(Users.users.keySet().contains("Admins")) {
            for (User user : Users.users.get("Admins")) {
                if (user.phoneNumber == phoneNumber || user.login.equals(login)) {
                    return false;
                }
            }
        }
        Users.addAdmin(firstName, lastName, phoneNumber, login, password);
        Users.saveListOfUsersToFile();
        return true;
    }

    public static boolean registerReceptionist(String firstName, String lastName, int phoneNumber, String login, String password){
        if(!Users.users.keySet().contains("Receptionists")) {
            Users.users.put("Receptionists",new ArrayList<>());
        }
        for (User user : Users.users.get("Receptionists")) {
            if (user.phoneNumber == phoneNumber || user.login.equals(login)) {
                return false;
            }
        }
        Users.addReceptionist(firstName, lastName, phoneNumber, login, password);
        Users.saveListOfUsersToFile();
        return true;
    }

    }


