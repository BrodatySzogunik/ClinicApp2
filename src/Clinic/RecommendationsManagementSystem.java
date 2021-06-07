package Clinic;

import Clinic.baseOfRecommendations.Recommendation;
import Clinic.baseOfRecommendations.Recommendations;

import java.io.*;
import java.util.Date;

public class RecommendationsManagementSystem {
    static int newestKey=-1;

    public static int createEmptyRecommendation()
    {
        Recommendations.newRecommendation(updateNewestKey(),"",null,-1);
        return newestKey;
    }

    public static int createRecommendation(String reco, Date date, int patientId)
    {
        Recommendations.newRecommendation(updateNewestKey(), reco,date,patientId);
        return newestKey;
    }

    static int loadNewestKeyFromFile()
    {
        int key=-1;
        String path = "newestRecommendationsKey.txt";
        DataInputStream inputStream=null;
        try
        {
            try{
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch (FileNotFoundException e)
            {
                System.out.println("nie znaleziono pliku z kluczem zalecen");
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
        String path = "newestRecommendationsKey.txt";
        DataInputStream inputStream=null;
        try
        {
            try{
                inputStream = new DataInputStream(new FileInputStream(path));
            }catch (FileNotFoundException e)
            {
                System.out.println("nie znaleziono pliku z kluczem zalecen");
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
        String path="newestRecommendationsKey.txt";
        DataOutputStream outputStream=null;
        try{
            try {
                outputStream=new DataOutputStream(new FileOutputStream(path));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
                System.out.println("nie znaleziono pliku z kluczem zalecen");
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
