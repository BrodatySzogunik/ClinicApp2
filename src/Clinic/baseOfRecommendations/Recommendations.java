package Clinic.baseOfRecommendations;

import Clinic.baseOfPrescription.Prescription;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Recommendations {
    public static Map<Integer, Recommendation> recommendations=new HashMap<>();

    public static void newRecommendation(int key, String recommendation, Date date, int patientId)
    {
        recommendations.put(key, new Recommendation(recommendation,date,patientId));
    }

    public static void removeRecommendation(int key)
    {
        recommendations.remove(key);
    }

    public static void loadRecommendationsFromFile()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        String path = "recommendations.txt";
        DataInputStream inputStream= null;
        Date date=null;
        char[] reco,tmpDateStr;
        int patientId,tmp,key;
        try{
            try {
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch(FileNotFoundException e){
                System.out.println("nie znaleziono pliku z zaleceniami");
                return;
            }
            try {
                while (inputStream.readChar() == 'R')
                {
                    key=inputStream.readInt();
                    tmp=inputStream.readInt();
                    reco=new char[tmp];
                    for (int i=0;i<tmp;i++) reco[i]=inputStream.readChar();
                    patientId=inputStream.readInt();
                    tmp=inputStream.readInt();
                    tmpDateStr=new char[tmp];
                    for(int i=0;i<tmp;i++)tmpDateStr[i]= inputStream.readChar();
                    try {
                        date = sdf.parse(new String(tmpDateStr));
                    }catch(ParseException e){e.printStackTrace();}
                    newRecommendation(key, new String(reco), date,patientId);    
                }
            }catch (IOException e){
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

    public static void saveRecommendationsToFile()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        String path = "recommendations.txt",tmpDateStr;
        DataOutputStream outputStream= null;
        try{
            try{
                outputStream=new DataOutputStream(new FileOutputStream(path));
            }catch (FileNotFoundException e){
                e.printStackTrace();
                return;
            }
            try{
                for(Map.Entry<Integer,Recommendation> reco:recommendations.entrySet()) {
                    outputStream.writeChar('R');
                    outputStream.writeInt(reco.getKey());
                    outputStream.writeInt(reco.getValue().recommendations.length());
                    outputStream.writeChars(reco.getValue().recommendations);
                    outputStream.writeInt(reco.getValue().patientId);
                    tmpDateStr = sdf.format(reco.getValue().dateOfIssue);
                    outputStream.writeInt(tmpDateStr.length());
                    outputStream.writeChars(tmpDateStr);
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
}
