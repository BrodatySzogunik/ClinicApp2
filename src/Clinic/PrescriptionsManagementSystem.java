package Clinic;

import Clinic.baseOfPrescription.Medicine;
import Clinic.baseOfPrescription.Payment;
import Clinic.baseOfPrescription.Prescription;
import Clinic.baseOfUsers.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Clinic.baseOfPrescription.BaseOfPrescriptions.newPrescription;
import static Clinic.baseOfPrescription.BaseOfPrescriptions.returnPrescription;

public class PrescriptionsManagementSystem {
    static int newestKey=-1;

    public static int createEmptyPrescription()
    {
        ArrayList<Medicine> medicines=null;
        Payment payment=null;
        Date date=null;
        newPrescription(updateNewestKey(), medicines,payment,date,0,0,"");
        return newestKey;
    }

    public static int createNewPrescription(ArrayList<Medicine> medicines, Payment payment, Date date, User patient)
    {
        int patientId=patient.phoneNumber;
        newPrescription(updateNewestKey(), medicines, payment, date, patientId,1,"");
        return newestKey;
    }

    public static void editPrescription(int key)
    {
        Prescription prescription=returnPrescription(key);

    }

    static int loadNewestKeyFromFile()
    {
        int key=-1;
        String path = "newestPrescriptionsKey.txt";
        DataInputStream inputStream=null;
        try
        {
            try{
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch (FileNotFoundException e)
            {
                System.out.println("nie znaleziono pliku z kluczem recept");
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
        if(key!=-1)newestKey=key;
        return -2;
    }
    static int loadNewestKeyFromFile(int returnKeyAndDontUpdate)
    {
        int key=-1;
        String path = "newestPrescriptionsKey.txt";
        DataInputStream inputStream=null;
        try
        {
            try{
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch (FileNotFoundException e)
            {
                System.out.println("nie znaleziono pliku z kluczem recept");
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
        String path="newestPrescriptionsKey.txt";
        DataOutputStream outputStream=null;
        try{
            try {
                outputStream=new DataOutputStream(new FileOutputStream(path));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
                System.out.println("nie znaleziono pliku z kluczem recept");
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
