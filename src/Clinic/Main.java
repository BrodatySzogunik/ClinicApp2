package Clinic;


import Clinic.Frames.LoginFrame;
import Clinic.baseOfPrescription.BaseOfMedicines;
import Clinic.baseOfPrescription.BaseOfPrescriptions;
import Clinic.baseOfUsers.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args){


        LoginFrame app = new LoginFrame();
        Users.loadListOfUsersFromFile();
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible(true);
        System.out.println(Users.listUsers(Users.users.get("Patients")));
//        BaseOfMedicines.loadMedicinesFromFile();
//        BaseOfMedicines.saveMedicinesToFile();
        Users.addAdmin("aa","aa",72813,"aa","aa");
    }







































//
//    public static void main(String[] args) {
//        boolean exit = true; // coś nie tak z nazwą zmiennej - do poprawki
//        Scanner scanner = new Scanner(System.in);
//        String user = "none";
//        int userChoice;
//        String login;
//        String password;
//
//        while(exit){
//            System.out.println("1. Przejdź do panelu użytkownika");
//            System.out.println("2. Dodaj urzytkownika");
//            System.out.println("3. Wyjście z programu");
//            userChoice = scanner.nextInt();
//
//            switch(userChoice) {
//                case 1 -> {
//                    if (user.equals("none")) {
//                        System.out.println("Wybierz typ konta");
//                        System.out.println("1. Lekarz");
//                        System.out.println("2. Pacjent");
//                        System.out.println("3. Recepcjonista");
//                        System.out.println("4. Admin");
//                        userChoice = scanner.nextInt();
//                        switch (userChoice) {
//                            case 1 -> {
//                                if (Doctor.login(login, password)) {
//
//                                }
//                            }
//
//
//                            case 2 -> Customer.login(login, password);
//                            case 3 -> Recepcionist.login(login, password);
//                            case 4 -> Admin.login(login, password);
//
//                        }
//
//                    }
//                }
//
//                case 2 -> {
//                    System.out.println("Podaj typ urzytkownika\n 1-lekarz\n 2-pacjent\n 3-admin\n 4-recepcjonista");
//                    String userType;
//                    userChoice = scanner.nextInt();
//                    String fName;
//                    String sName;
//                    int pesel;
//                    int phoneNumber;
//                    String spec;
//
//
//                    Map<String,User> baseOfUsers = new HashMap<>();
//                    switch (userChoice){
//
//                        case 1 -> {
////                            System.out.println("Podaj imię");
////                            fName=scanner.nextLine();
////                            System.out.println("podaj nazwisko");
////                            sName = scanner.nextLine();
////                            System.out.println("Podaj pesel");
////                            pesel=Integer.valueOf(scanner.nextLine());
////                            System.out.println("Podaj nr telefonu");
////                            phoneNumber=Integer.valueOf(scanner.nextLine());
////                            System.out.println("podaj specjalizację");
////                            spec = scanner.nextLine();
////                            System.out.println("Pdoaj login");
////                            login=scanner.nextLine();
////                            System.out.println("Podaj hasło");
////                            password = scanner.nextLine();
////                           User doctor = new User(fName,sName,pesel,phoneNumber,spec,login,password);
////                            baseOfUsers.put("Doctor",doctor);
//                        }
//
//                        case 2 -> userType = "Customer";
//                        case 3 -> userType = "Admin";
//                        case 4 -> userType = "Recepcionist";
//                        }
//                    }
//
//                case 3 -> {
//                    exit = false;
//                }
//
//            }
//            }
//
//        }
//
//    }
}
