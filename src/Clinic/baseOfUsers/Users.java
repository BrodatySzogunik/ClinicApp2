package Clinic.baseOfUsers;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Users {
    public static Map<String,ArrayList<User>> users= new HashMap<>();
    public static ArrayList<Doctor> doctors= new ArrayList<Doctor>();
//    Scanner scanner=new Scanner(System.in);


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
        if(users.get(userType)!=null) {
            if (!users.get(userType).isEmpty()) return users.get(userType);
            else return null;
        }else return null;
    }

    public static ArrayList<Doctor> returnDoctors(){
        if(!doctors.isEmpty())return doctors;
        else return null;
    }

    public static User returnUserByPhoneNumber(String userType,int phoneNumber){
        for(User user: returnUsers(userType)){
            if(user.phoneNumber==phoneNumber)return user;
        }
            return null;

    }

//    public static Doctor returnDoctor(int phoneNumber){
//        for(Doctor doctor: doctors){
//            if(doctor.phoneNumber==phoneNumber){
//                return doctor;
//            }
//        }
//        return null;
//
//    }

    public static Doctor returnDoctor(int index){
        return doctors.get(index);
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


//    public static boolean removeUser(String userType,int phoneNumber,String firstName,String lastName){
//        User user = Users.returnUser(Users.returnUsers(userType), phoneNumber, firstName, lastName);
//        if(Users.returnUsers(userType).remove(user))return true;
//        else return false;
//    }

    public static boolean removeUser(String userType,User user){
       if(Users.returnUsers(userType).remove(user))return true;
        return false;
    }

    public static boolean removeDoctor(Doctor doc)
    {
        if(doctors.remove(doc))return true;
        return false;
    }


//    public static void  listAllUsers(){
//        System.out.println("Patients\n");
//        System.out.println(listUsers(users.get("Patients")));
//        System.out.println("Doctors\n");
//        System.out.println(listUsers(users.get("Doctors")));
//        System.out.println("Receptionists\n");
//        System.out.println(listUsers(users.get("Receptionist")));
//        System.out.println("Admins\n");
//        System.out.println(listUsers(users.get("Admins")));
//
//    }

    public static void addDoctor(String firstName, String lastName, int phoneNumber, String login, String password,Spec spec){
        doctors.add(new Doctor(firstName,lastName,phoneNumber,login,password,spec));
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
        if(!(users.keySet().contains("Receptionists")))
        {
            users.put("Receptionists",new ArrayList<>());
        }
        users.get("Receptionists").add(new User(firstName,lastName,phoneNumber,login,password));
    }


    public static void loadListOfUsersFromFile()
    {
        char[] firstName;
        char[] lastName;
        int phone,tmp,size,val;
        char[] login;
        char[] password;
        char[] spec;
        String path = "users.txt";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        Date date=null;
        char[] date1;
        DataInputStream inputStream= null;
        Schedule schedule=new Schedule();
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
                        spec=new char[tmp=inputStream.readInt()];
                        for(int i=0;i<tmp;i++)spec[i]=inputStream.readChar();
                        size=inputStream.readInt();
                        schedule=new Schedule();
                        for(int i=0;i<size&&inputStream.readChar()=='S';i++) {
                            tmp = inputStream.readInt();
                            date1=new char[tmp];
                            for (int x = 0; x < tmp; x++)date1[x]=inputStream.readChar();
                            try {
                                date = sdf.parse(new String(date1));
                            }catch(ParseException e)
                            {
                                e.printStackTrace();
                            }
                            val=inputStream.readInt();
                            schedule.schedule.put(date,val);
                        }
                        doctors.add(new Doctor(new String(firstName), new String(lastName), phone, new String(login), new String(password),Spec.valueOf(new String(spec)),schedule));

                    }
                }

                if(inputStream.readChar()=='R')
                inputStream.readChar();
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        String path = "users.txt",tmpDateStr;
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
            if (!doctors.isEmpty())
            {
                try {
                    outputStream.writeChar('D');
                    outputStream.writeChar('Y');
                    for (Doctor user : doctors) {
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
                        outputStream.writeInt(user.spec.name().length());
                        outputStream.writeChars(user.spec.name());

                        outputStream.writeInt(user.schedule.schedule.size());
                        for(Map.Entry<Date, Integer> entry:user.schedule.schedule.entrySet())
                        {
                            outputStream.writeChar('S');
                            tmpDateStr=sdf.format(entry.getKey());
                            outputStream.writeInt(tmpDateStr.length());
                            outputStream.writeChars(tmpDateStr);
                            outputStream.writeInt(entry.getValue());
                        }
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
