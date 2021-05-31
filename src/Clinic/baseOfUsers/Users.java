package Clinic.baseOfUsers;

import java.io.*;
import java.util.*;

public class Users {
    public static Map<String,ArrayList<User>> users= new HashMap<>();
    Scanner scanner=new Scanner(System.in);


//    public  ArrayList<User> getDoctors() +{
//        return users.get("Doctors");
//    }
//    public  ArrayList<User> getPatients() {
//        return users.get("Patients");
//    }

    public static String listUsers(ArrayList<User> users){
        String output ="";
        for(User user:users){
            output += user.toString();
        }
        return output;

    }

    public static ArrayList<User> returnUsers(String userType){
        if(!users.get(userType).isEmpty())return users.get(userType);
        else return null;
    }
    public static User returnUser(ArrayList<User> users,int phoneNumber,String firstName,String lastName){
        for(User user:users){
            if(user.phoneNumber==phoneNumber && user.firstName.equals(firstName) && user.lastName.equals(lastName)){
                return user;
            }
        }
        return null;
    }

    public static User returnUser(ArrayList<User> users,int index){
        return users.get(index);
    }


    public static boolean removeUser(String userType,int phoneNumber,String firstName,String lastName){
        User user = Users.returnUser(Users.returnUsers(userType), phoneNumber, firstName, lastName);
        if(Users.returnUsers(userType).remove(user))return true;
        else return false;
    }

    public static boolean removeUser(String userType,User user){
       if(Users.returnUsers(userType).remove(user))return true;
        return false;
    }


    public static void  listAllUsers(){
        System.out.println("Patients\n");
        System.out.println(listUsers(users.get("Patients")));
        System.out.println("Doctors\n");
        System.out.println(listUsers(users.get("Doctors")));
        System.out.println("Receptionists\n");
        System.out.println(listUsers(users.get("Receptionist")));
        System.out.println("Admins\n");
        System.out.println(listUsers(users.get("Admins")));

    }

    public static void addDoctor(String firstName, String lastName, int phoneNumber, String login, String password,Spec spec){
        if(!(users.keySet().contains("Doctors")))
            {
            users.put("Doctors",new ArrayList<>());
            }
        users.get("Doctors").add(new Doctor(firstName,lastName,phoneNumber,login,password,spec));
    }

    public static void addPatient(String firstName, String lastName, int phoneNumber, String login, String password){
        if(!(users.keySet().contains("Patients")))
        {
            users.put("Patients",new ArrayList<>());
        }
        users.get("Patients").add(new User(firstName,lastName,phoneNumber,login,password));

    }

    public static void addAdmin(String firstName, String lastName, int phoneNumber, String login, String password){
        if(!(users.keySet().contains("Admins")))
        {
            users.put("Admins",new ArrayList<>());
        }
        users.get("Admins").add(new User(firstName,lastName,phoneNumber,login,password));

    }

    public static void addReceptionist(String firstName, String lastName, int phoneNumber, String login, String password){
        if(!(users.keySet().contains("Patients")))
        {
            users.put("Receptionists",new ArrayList<>());
        }
        users.get("Receptionists").add(new User(firstName,lastName,phoneNumber,login,password));
    }


    public static void loadListOfUsersFromFile()
    {
        char[] firstName;
        char[] lastName;
        int phone,tmp;
        char[] login;
        char[] password;
        String path = "users.txt";
        DataInputStream inputStream= null;
        try{
            try {
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch(FileNotFoundException e){
                System.out.println("nie znaleziono pliku z uzytkownikami");
                return;
            }
            try{
                if(inputStream.readChar()=='P'&&inputStream.readChar()=='Y')
                {
                    if(!users.containsKey("Patients"))
                    {
                        users.put("Patients",new ArrayList<>());
                    }
                    while (inputStream.readChar()=='p')
                    {
                        tmp=inputStream.readInt();
                        firstName=new char[tmp];
                        for(int i=0;i<tmp;i++)firstName[i]=inputStream.readChar();
                        lastName=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)lastName[i]=inputStream.readChar();
                        phone=inputStream.readInt();
                        login=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)login[i]=inputStream.readChar();
                        password=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)password[i]=inputStream.readChar();
                        ((ArrayList)users.get("Patients")).add(new User(new String(firstName), new String(lastName), phone, new String(login), new String(password)));
                    }
                }
                if(inputStream.readChar()=='Y')
                {
                    if(!users.containsKey("Doctors"))
                    {
                        users.put("Doctors",new ArrayList<>());
                    }
                    while (inputStream.readChar()=='d')
                    {
                        tmp=inputStream.readInt();
                        firstName=new char[tmp];
                        for(int i=0;i<tmp;i++)firstName[i]=inputStream.readChar();
                        lastName=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)lastName[i]=inputStream.readChar();
                        phone=inputStream.readInt();
                        login=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)login[i]=inputStream.readChar();
                        password=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)password[i]=inputStream.readChar();
                        ((ArrayList)users.get("Doctors")).add(new User(new String(firstName), new String(lastName), phone, new String(login), new String(password)));
                    }
                }
                if(inputStream.readChar()=='Y')
                {
                    if(!users.containsKey("Receptionists"))
                    {
                        users.put("Receptionists",new ArrayList<>());
                    }
                    while (inputStream.readChar()=='r')
                    {
                        tmp=inputStream.readInt();
                        firstName=new char[tmp];
                        for(int i=0;i<tmp;i++)firstName[i]=inputStream.readChar();
                        lastName=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)lastName[i]=inputStream.readChar();
                        phone=inputStream.readInt();
                        login=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)login[i]=inputStream.readChar();
                        password=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)password[i]=inputStream.readChar();
                        ((ArrayList)users.get("Receptionists")).add(new User(new String(firstName), new String(lastName), phone, new String(login), new String(password)));
                    }
                }
                if(inputStream.readChar()=='Y')
                {
                    if(!users.containsKey("Admins"))
                    {
                        users.put("Admins",new ArrayList<>());
                    }
                    while (inputStream.readChar()=='a')
                    {
                        tmp=inputStream.readInt();
                        firstName=new char[tmp];
                        for(int i=0;i<tmp;i++)firstName[i]=inputStream.readChar();
                        lastName=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)lastName[i]=inputStream.readChar();
                        phone=inputStream.readInt();
                        login=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)login[i]=inputStream.readChar();
                        password=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)password[i]=inputStream.readChar();
                        ((ArrayList)users.get("Admins")).add(new User(new String(firstName), new String(lastName), phone, new String(login), new String(password)));
                    }
                }
            }
            catch (IOException e)
            {

            }
        }
        finally {
            if(inputStream!=null)
            {
                try {
                    inputStream.close();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveListOfUsersToFile()
    {
        String path = "users.txt";
        DataOutputStream outputStream= null;
        try {
            try {
                outputStream = new DataOutputStream(new FileOutputStream(path));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
                return;
            }
            if (users.keySet().contains("Patients")) {
                try {
                    outputStream.writeChar('P');
                    outputStream.writeChar('Y');
                    for (User user : users.get("Patients")) {
                        outputStream.writeChar('p');
                        outputStream.writeInt(user.firstName.length());
                        outputStream.writeChars(user.firstName);
                        outputStream.writeInt(user.lastName.length());
                        outputStream.writeChars(user.lastName);
                        outputStream.writeInt(user.phoneNumber);
                        outputStream.writeInt(user.login.length());
                        outputStream.writeChars(user.login);
                        outputStream.writeInt(user.password.length());
                        outputStream.writeChars(user.password);
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else
            {
                try {
                    outputStream.writeChar('P');
                    outputStream.writeChar('N');
                }
                catch (IOException e){}
            }
            if (users.keySet().contains("Doctors"))
            {
                try {
                    outputStream.writeChar('D');
                    outputStream.writeChar('Y');
                    for (User user : users.get("Doctors")) {
                        outputStream.writeChar('d');
                        outputStream.writeInt(user.firstName.length());
                        outputStream.writeChars(user.firstName);
                        outputStream.writeInt(user.lastName.length());
                        outputStream.writeChars(user.lastName);
                        outputStream.writeInt(user.phoneNumber);
                        outputStream.writeInt(user.login.length());
                        outputStream.writeChars(user.login);
                        outputStream.writeInt(user.password.length());
                        outputStream.writeChars(user.password);
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                try {
                    outputStream.writeChar((char) 'D');
                    outputStream.writeChar('N');
                }
                catch (IOException e){}
            }
            if (users.keySet().contains("Receptionists"))
            {
                try {
                    outputStream.writeChar('R');
                    outputStream.writeChar('Y');
                    for (User user : users.get("Receptionists")) {
                        outputStream.writeChar((char) 'r');
                        outputStream.writeInt(user.firstName.length());
                        outputStream.writeChars(user.firstName);
                        outputStream.writeInt(user.lastName.length());
                        outputStream.writeChars(user.lastName);
                        outputStream.writeInt(user.phoneNumber);
                        outputStream.writeInt(user.login.length());
                        outputStream.writeChars(user.login);
                        outputStream.writeInt(user.password.length());
                        outputStream.writeChars(user.password);
                    }
                }
                catch (IOException e){}
            }
            else
            {
                try {
                    outputStream.writeChar('R');
                    outputStream.writeChar('N');
                }catch (IOException e){}
            }
            if (users.keySet().contains("Admins"))
            {
                try {
                    outputStream.writeChar('A');
                    outputStream.writeChar('Y');
                    for (User user : users.get("Admins")) {
                        outputStream.writeChar('a');
                        outputStream.writeInt(user.firstName.length());
                        outputStream.writeChars(user.firstName);
                        outputStream.writeInt(user.lastName.length());
                        outputStream.writeChars(user.lastName);
                        outputStream.writeInt(user.phoneNumber);
                        outputStream.writeInt(user.login.length());
                        outputStream.writeChars(user.login);
                        outputStream.writeInt(user.password.length());
                        outputStream.writeChars(user.password);
                    }
                }
                catch (IOException e){}
            }
            else
            {
                try {
                    outputStream.writeChar('A');
                    outputStream.writeChar('N');
                }
                catch (IOException e){}
            }
        }
        finally {
            if(outputStream!=null)
            {
                try {
                    outputStream.close();
                }catch (IOException e){}
            }
        }
    }




}
