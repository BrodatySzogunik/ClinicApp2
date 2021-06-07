package Clinic;

import Clinic.baseOfPrescription.Medicine;
import Clinic.baseOfPrescription.Payment;
import Clinic.baseOfUsers.User;

import java.io.*;
import java.util.Date;
import java.util.List;

import static Clinic.baseOfPrescription.BaseOfPrescriptions.newPrescription;

public class PrescriptionsManagementSystem {
    public static int newestKey=-1;


    public static void createNewPrescription(List<Medicine> medicines, Payment payment, Date date, User patient)
    {
        int patientId=patient.phoneNumber;
        newPrescription(updateNewestKey(), medicines, payment, date, patientId,"");
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
