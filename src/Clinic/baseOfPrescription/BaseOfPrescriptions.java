package Clinic.baseOfPrescription;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BaseOfPrescriptions {

    static Map<Integer,Prescription> prescriptions = new HashMap<>();

    public static void removePrescription(int key){
        prescriptions.remove(key);
    }

    public static void newPrescription(int key,ArrayList<Medicine> medicines, Payment payment,Date date, int patientId, int visibility,String recommendation){
        prescriptions.put(key,new Prescription(medicines,payment,date,patientId,visibility));
    }

    public static Prescription returnPrescription(int key)
    {
        return prescriptions.get(key);
    }

    public static void putPrescritpion(int key,Prescription prescription)
    {
        prescriptions.put(key,prescription);
    }

    public static void savePrescriptionsToFile()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        String path = "prescriptions.txt",tmpDateStr;
        DataOutputStream outputStream= null;
        try {
            try{
                outputStream=new DataOutputStream(new FileOutputStream(path));
            }catch (FileNotFoundException e){
                System.out.println("nie znaleziono pliku z receptami");
                e.printStackTrace();
                return;
            }
            try {
                outputStream.writeInt(prescriptions.size());
                for(Map.Entry<Integer, Prescription>prescriptionEntry:prescriptions.entrySet())
                {
                    outputStream.writeChar('P');

                    outputStream.writeInt(prescriptionEntry.getKey());

                    outputStream.writeInt(prescriptionEntry.getValue().a);

                    outputStream.writeInt(prescriptionEntry.getValue().medicines.size());
                    for (Medicine med:prescriptionEntry.getValue().medicines)
                    {
                        outputStream.writeInt(med.payment.name().length());
                        outputStream.writeChars(med.payment.name());
                        outputStream.writeInt(med.medicineName.length());
                        outputStream.writeChars(med.medicineName);
                        outputStream.writeDouble(med.price);
                    }

                    outputStream.writeInt(prescriptionEntry.getValue().payment.name().length());
                    outputStream.writeChars(prescriptionEntry.getValue().payment.name());

                    tmpDateStr= sdf.format(prescriptionEntry.getValue().date);
                    outputStream.writeInt(tmpDateStr.length());
                    outputStream.writeChars(tmpDateStr);

                    outputStream.writeInt(prescriptionEntry.getValue().patientId);
                }
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

    public static void loadPrescriptionsFromFile()
    {
        int size1,size2,strSize,key,visibility,patient;
        char[] medicineName;
        char[] payment;
        char[] date1;
        Payment payment1;
        double price;
        Date date=null;
        ArrayList<Medicine> medicines;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");

        String path = "users.txt";
        DataInputStream inputStream= null;
        try {
            try {
                inputStream = new DataInputStream(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                System.out.println("nie znaleziono pliku z uzytkownikami");
                return;
            }
            try{
                size1=inputStream.readInt();
                for(int i=0;i<size1&&inputStream.readChar()=='P';i++)
                {
                    key=inputStream.readInt();
                    visibility=inputStream.readInt();
                    size2= inputStream.readInt();
                    medicines=new ArrayList<>();
                    for(int j=0;j<size2;j++)
                    {
                        strSize=inputStream.readInt();
                        payment=new char[strSize];
                        for (int x=0;x<strSize;x++) payment[x]=inputStream.readChar();
                        payment1=Payment.valueOf(new String(payment));
                        strSize=inputStream.readInt();
                        medicineName=new char[strSize];
                        for (int x=0;x<strSize;x++) medicineName[x]=inputStream.readChar();
                        price=inputStream.readDouble();
                        medicines.add(new Medicine(new String(medicineName),price,payment1));
                    }
                    strSize=inputStream.readInt();
                    payment=new char[strSize];
                    for(int x=0;i<strSize;x++)payment[x]=inputStream.readChar();
                    payment1=Payment.valueOf(new String(payment));

                    strSize=inputStream.readInt();
                    date1=new char[strSize];
                    for(int x=0;i<strSize;x++)date1[x]=inputStream.readChar();
                    try{
                        date=sdf.parse(new String(date1));
                    }catch(ParseException e){
                        e.printStackTrace();
                    }

                    patient=inputStream.readInt();
                    newPrescription(key,medicines,payment1,date,patient,visibility,"");
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
