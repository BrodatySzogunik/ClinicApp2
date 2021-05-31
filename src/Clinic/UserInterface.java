package Clinic;

import java.util.Scanner;

public class UserInterface {
    static Scanner in = new Scanner(System.in);


     public static void showUserInterface(){
         System.out.println("Wybierz opcję:\n1-Umów się na wizytę\n2-Wyświetl zaplanowane wizyty\n3-Odwołaj wizytę\n4-Wyświetlanie recept\n"); // wyświetlanie panelu użytkownika
         chooseOption();
     }

    public static void showAdminInterface(){}

    public static void showReceptionistInterface(){}

    public static void showDoctorInterface(){}

     public static void chooseOption(){
         switch (in.nextInt()){
//             case 1 -> addVisit();
//             case 2 -> showVisits();
//             case 3 -> removeVisit();
//             case 4 -> showPrescriptions();
         };
     }
//
//     public static void option1(){
//         //umawianie się na wizytę na razie nie działa bo nie ma kurwa bazy wizyt ani nic
//     }
//
//    public static void option2(){
//        //umawianie się na wizytę na razie nie działa bo nie ma kurwa bazy wizyt ani nic
//    }
//
//    public static void option3(){
//        //umawianie się na wizytę na razie nie działa bo nie ma kurwa bazy wizyt ani nic
//    }

}
