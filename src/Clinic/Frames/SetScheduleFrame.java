package Clinic.Frames;

import Clinic.baseOfPrescription.Prescription;
import Clinic.baseOfUsers.Doctor;
import Clinic.baseOfUsers.User;

import javax.print.Doc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class SetScheduleFrame extends JFrame implements ActionListener {

    User doctor1;

    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    SimpleDateFormat sdf2 =new SimpleDateFormat("MM");
    SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");

    JLabel lChoseDays,lChoseHours;
    JComboBox cChoseDays,cChoseHours,cShowSchedule;
    JButton bAccept;

    Date date = new Date();
    String tempDate;
    Integer dayOfWeek;


    public static int getDayNumberOld(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public SetScheduleFrame(User doctor)  {
        doctor1=doctor;
        setSize(500,500);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        tempDate="25-10-2021 15:20";
//


        cChoseDays = new JComboBox();
        cChoseDays.setBounds(20,20,120,20);


        cChoseHours = new JComboBox();
        cChoseHours.setBounds(20,40,120,20);

//        try {
//            date = sdf1.parse(tempDate);
        Integer month =Integer.parseInt(sdf2.format(date))+1;
        try {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                for (int i = 1; i <= 31; i++) {
                    if (i > 0 && i < 10) {
                        tempDate = "0" + i + "-" + month + "-2021";

                    } else {
                        tempDate = i + "-" + month + "-2021";


                    }
                    date = sdf3.parse(tempDate);
                    System.out.println(date);
                    dayOfWeek = getDayNumberOld(date);
                    System.out.println(dayOfWeek);
                    if(dayOfWeek!=7&&dayOfWeek!=1) {
                        cChoseDays.addItem(tempDate);
                    }
                }
            }


            for(int i=8;i<=15;i++){
                for(int j=1;j<=2;j++){
                    if (i > 0 && i < 10) {
                        if (j == 1) {
                            tempDate = "0"+ i + ":" + "00";
                        } else {
                            tempDate = "0"+ i + ":" + "30";
                        }
                    }else{
                        if (j == 1) {
                            tempDate = i + ":" + "00";
                        } else {
                            tempDate = i + ":" + "30";
                        }
                    }
                    cChoseHours.addItem(tempDate);
                }

            }


        }catch(ParseException e ){

        }



        bAccept = new JButton("Dodaj");
        bAccept.setBounds(20,60,120,20);
        bAccept.addActionListener(this);



        cShowSchedule = new JComboBox();
        cShowSchedule.setBounds(180,20,120,20);





        add(bAccept);
        add(cChoseDays);
        add(cChoseHours);


//        }catch (ParseException e){
//            e.printStackTrace();
//        }



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.add(cShowSchedule);
        this.repaint();
        System.out.println((String)(cChoseDays.getSelectedItem())+" "+(String)(cChoseHours.getSelectedItem()));
        /*try{
        date= sdf1.parse((String)(cChoseDays.getSelectedItem())+" "+(String)(cChoseHours.getSelectedItem()));
        if(!((Doctor)doctor1).schedule.containsDate(date)){
            for()
            ((Doctor)doctor1).schedule.addDate(date);
        }
            for(Map.Entry<Date, Integer>scheduleEntry:((Doctor)doctor1).schedule.returnSchedule().entrySet()){
                cShowSchedule.addItem(scheduleEntry.getKey());
            }
        }catch(ParseException x){
            x.printStackTrace();


        }
        */


    }
}
