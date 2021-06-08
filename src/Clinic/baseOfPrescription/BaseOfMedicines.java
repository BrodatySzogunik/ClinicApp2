package Clinic.baseOfPrescription;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseOfMedicines {

    static ArrayList<Medicine> medicines=new ArrayList<>();
    public static void saveMedicinesToFile()
    {
        String path = "medicines.txt";
        DataOutputStream outputStream= null;
        try{
            try{
                outputStream=new DataOutputStream(new FileOutputStream(path));
            }catch (FileNotFoundException e){
                System.out.println("nie znaleziono pliku z lekami");
                e.printStackTrace();
                return;
            }
            try {
                outputStream.writeInt(medicines.size());
                for (Medicine med:medicines)
                {
                    outputStream.writeChar('m');
                    outputStream.writeInt(med.payment.name().length());
                    outputStream.writeChars(med.payment.name());
                    outputStream.writeInt(med.medicineName.length());
                    outputStream.writeChars(med.medicineName);
                    outputStream.writeDouble(med.price);
                }
            }catch(IOException e){
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

    public static void loadMedicinesFromFile()
    {
        int tmp, size;
        char[] payment1;
        Payment payment;
        char[] name;
        double price;
        String path = "medicines.txt";
        DataInputStream inputStream=null;
        try {
            try {
                inputStream = new DataInputStream(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                System.out.println("nie znaleziono pliku z lekami");
                return;
            }
            try {
                size=inputStream.readInt();
                for (int i =0; i<size&&inputStream.readChar()=='m';i++)
                {
                    tmp=inputStream.readInt();
                    payment1=new char[tmp];
                    for(int x=0;x<tmp;x++)payment1[x]=inputStream.readChar();
                    payment = Payment.valueOf(new String(payment1));
                    tmp=inputStream.readInt();
                    name=new char[tmp];
                    for(int x=0;x<tmp;x++)name[x]=inputStream.readChar();
                    price=inputStream.readDouble();
                    medicines.add(new Medicine(new String(name), price,payment));
                }
            }catch(IOException e){
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

