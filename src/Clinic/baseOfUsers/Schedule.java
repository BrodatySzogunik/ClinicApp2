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

    public void removeDate(Date date)
    {
        if(!schedule.containsKey(date))return;
        schedule.remove(date);
    }

    public int containsDate(Date date)
    {
        if(schedule.containsKey(date))return 1;
        return 0;
    }

}
