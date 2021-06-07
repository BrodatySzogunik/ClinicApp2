package Clinic.baseOfVisits;

import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.Spec;
import Clinic.baseOfUsers.User;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Visits {
    static Map<Integer, Visit> visits= new HashMap<>();


    public static void addVisit(int key, User patient, Date date, Spec typeOfVisit, Doctor doctor, int prescriptionNumber, int recommendationsNumber)
    {
        if(visits.containsKey(key))return;
        visits.put(key, new Visit(patient,date,typeOfVisit,doctor,prescriptionNumber,recommendationsNumber,key));
    }


//    public void editVisit(int key)
//    {
//
//    }

    public static void removeVisit(int key)
    {
        if(!visits.containsKey(key))return;
        visits.remove(key);
    }

    public static void saveVisitsToFile()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        String path = "visits.txt",tmpDateStr;
        DataOutputStream outputStream=null;
        try {
            try {
                outputStream = new DataOutputStream(new FileOutputStream(path));
            } catch (FileNotFoundException e) {
                System.out.println("nie znaleziono pliku z wizytami");
                e.printStackTrace();
                return;
            }
            try {
                outputStream.writeInt(visits.size());
                for(Map.Entry<Integer,Visit> entry:visits.entrySet())
                {
                    outputStream.writeChar('v');
                    outputStream.writeInt(entry.getKey());
                    outputStream.writeChar('p');
                    outputStream.writeInt(entry.getValue().patient.firstName.length());
                    outputStream.writeChars(entry.getValue().patient.firstName);
                    outputStream.writeInt(entry.getValue().patient.lastName.length());
                    outputStream.writeChars(entry.getValue().patient.lastName);
                    outputStream.writeInt(entry.getValue().patient.phoneNumber);
                    outputStream.writeInt(entry.getValue().patient.login.length());
                    outputStream.writeChars(entry.getValue().patient.login);
                    outputStream.writeInt(entry.getValue().patient.password.length());
                    outputStream.writeChars(entry.getValue().patient.password);
                    outputStream.writeChar('d');
                    tmpDateStr=sdf.format(entry.getValue().date);
                    outputStream.writeInt(tmpDateStr.length());
                    outputStream.writeChars(tmpDateStr);
                    outputStream.writeChar('s');
                    outputStream.writeInt(entry.getValue().typeOfVisit.name().length());
                    outputStream.writeChars(entry.getValue().typeOfVisit.name());
                    outputStream.writeChar('d');
                    outputStream.writeInt(entry.getValue().doctor.firstName.length());
                    outputStream.writeChars(entry.getValue().doctor.firstName);
                    outputStream.writeInt(entry.getValue().doctor.lastName.length());
                    outputStream.writeChars(entry.getValue().doctor.lastName);
                    outputStream.writeInt(entry.getValue().doctor.phoneNumber);
                    outputStream.writeInt(entry.getValue().doctor.login.length());
                    outputStream.writeChars(entry.getValue().doctor.login);
                    outputStream.writeInt(entry.getValue().doctor.password.length());
                    outputStream.writeChars(entry.getValue().doctor.password);
                    outputStream.writeInt(entry.getValue().doctor.spec.name().length());
                    outputStream.writeChars(entry.getValue().doctor.spec.name());

                    outputStream.writeInt(entry.getValue().doctor.schedule.returnSchedule().size());
                    for(Map.Entry<Date, Integer> entry2:entry.getValue().doctor.schedule.returnSchedule().entrySet())
                    {
                        outputStream.writeChar('S');
                        tmpDateStr=sdf.format(entry2.getKey());
                        outputStream.writeInt(tmpDateStr.length());
                        outputStream.writeChars(tmpDateStr);
                        outputStream.writeInt(entry2.getValue());
                    }

                    outputStream.writeChar('i');
                    outputStream.writeInt(entry.getValue().prescriptionNumber);
                    outputStream.writeInt(entry.getValue().recommendationsNumber);
                    outputStream.writeInt(entry.getValue().visitNumber);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }finally {
            if(outputStream!=null)
            {
                try {
                    outputStream.close();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loadVisitsFromFile()
    {
        int size1,size2,key;
        int prescriptionNumber;
        int recommendationsNumber;
        int visitNumber;
        User patient;
        Date date;
        Spec typeOfVisit;
        Doctor doctor;
        String path = "visits.txt";
        DataInputStream inputStream= null;
        try {
            try {
                inputStream = new DataInputStream(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                System.out.println("nie znaleziono pliku z wizytami");
                return;
            }
            try {
                size1=inputStream.readInt();
                for(int i=0;i<size1&&inputStream.readChar()=='v';i++)
                {
                    key=inputStream.readInt();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }finally {
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
}
