package Clinic.baseOfUsers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    Map<Date, Integer> schedule= new HashMap<>();

    public void addDate(Date date)
    {
        if(schedule.containsKey(date))return;
        schedule.put(date, 0);
    }

    public Map<Date,Integer> returnSchedule(){
        return schedule;
    }

    public void removeDate(Date date)
    {
        if(!schedule.containsKey(date))return;
        schedule.remove(date);
    }

    public boolean containsDate(Date date)
    {
        if(schedule.containsKey(date))return true;
        return false;
    }

    public void assignVisit(Date date, int visitNmbr)
    {
        schedule.replace(date, visitNmbr);
    }

    public void resignFromVisit(Date date)
    {
        schedule.replace(date, 0);
    }
}
