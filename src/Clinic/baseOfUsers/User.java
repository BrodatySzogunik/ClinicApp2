package Clinic.baseOfUsers;


import java.util.Scanner;

public class User {

    public String  firstName;
    public String  lastName;
    public int phoneNumber;
    public String login ;
    public String password;
    Scanner in = new Scanner(System.in);

    public void setLogin(String login) {
        this.login = login;
    }

    public User(String firstName, String lastName, int phoneNumber, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

        public User() {
        System.out.println("Podaj imię");
        this.firstName=in.nextLine();
        System.out.println("podaj nazwisko");
        this.lastName = in.nextLine();
        System.out.println("Podaj nr telefonu");
        this.phoneNumber=Integer.parseInt(in.nextLine());
        System.out.println("Pdoaj login");
        this.login=in.nextLine();
        System.out.println("Podaj hasło");
        this.password = in.nextLine();

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return  firstName+""+lastName;
    }


}
