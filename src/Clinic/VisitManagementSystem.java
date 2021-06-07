package Clinic;

import Clinic.baseOfUsers.*;
import Clinic.baseOfVisits.Visits;

import java.io.*;
import java.util.Date;

public class VisitManagementSystem {
    private static int newestKey=-1;

    public static void setAppointment(User patient,Doctor doctor, Date date)
    {
        int prescriptionNumber = PrescriptionsManagementSystem.createEmptyPrescription();
        int recommendationsNumber=RecommendationsManagementSystem.createEmptyRecommendation();
        Visits.addVisit(updateNewestKey(), patient, date, doctor.spec, doctor,prescriptionNumber,recommendationsNumber);
    }

    static void loadNewestKeyFromFile()
    {
        int key=-1;
        String path = "newestVisitsKey.txt";
        DataInputStream inputStream=null;
        try
        {
            try{
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch (FileNotFoundException e)
            {
                System.out.println("nie znaleziono pliku z kluczem wizyt");
                return;
            }
            try {
                key=inputStream.readInt();
            }catch (IOException e)
            {

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
        if(key!=-1)newestKey=key;
    }
    static int loadNewestKeyFromFile(int returnKeyAndDontUpdate)
    {
        int key=-1;
        String path = "newestVisitsKey.txt";
        DataInputStream inputStream=null;
        try
        {
            try{
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch (FileNotFoundException e)
            {
                System.out.println("nie znaleziono pliku z kluczem wizyt");
                return -1;
            }
            try {
                key=inputStream.readInt();
            }catch (IOException e)
            {

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
        return key;
    }
    static void saveNewestKeyToFile()
    {
        String path="newestVisitsKey.txt";
        DataOutputStream outputStream=null;
        try{
            try {
                outputStream=new DataOutputStream(new FileOutputStream(path));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
                System.out.println("nie znaleziono pliku z kluczem wizyt");
                return;
            }
            try {
                outputStream.writeInt(newestKey);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }finally {
            if(outputStream!=null)
            {
                try {
                    outputStream.close();
                }catch (IOException e){}
            }
        }
    }

    private static int updateNewestKey()
    {
        int tmpKey=loadNewestKeyFromFile(1);
        if(tmpKey>newestKey)newestKey=tmpKey;
        newestKey++;
        saveNewestKeyToFile();
        return newestKey;
    }
}
