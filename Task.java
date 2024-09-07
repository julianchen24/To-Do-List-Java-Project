public class Task
{
    private String event;
    private int month;
    private int day;
    private int year;
    private String priority;
    private String currentDate;
    int yearsRemaining;
    int monthsRemaining;
    int daysRemaining;
    int currentYear;
    int currentDay;
    int currentMonth;
    String date;
    
    public Task(String eventName, String priorityLevel, int monthNum, int dayNum, int yearNum, String currentDate)
    {
        event = eventName;
        priority = priorityLevel;
        month = monthNum;
        day = dayNum;
        year = yearNum;

        this.currentDate = currentDate;
    }
    public String todayPrint()
    {
        currentYear = Integer.parseInt(this.currentDate.substring(6));
        currentDay = Integer.parseInt(this.currentDate.substring(3,5));
        currentMonth = Integer.parseInt(this.currentDate.substring(0,2));
        return "Reminder/Task: " + event + "\n" + "This is due by " + currentMonth + "/" + currentDay + "/" + currentYear + "\n";
    }
    public String tomorrowPrint()
    {
        currentYear = Integer.parseInt(this.currentDate.substring(6));
        currentDay = Integer.parseInt(this.currentDate.substring(3,5));
        currentMonth = Integer.parseInt(this.currentDate.substring(0,2));
        // FUTURE NOTE: if you add at end of month ie Jan 31, does not move to next month!
        return "Reminder/Task: " + event + "\n" + "This is due by " + currentMonth + "/" + (currentDay+1) + "/" + currentYear + "\n" + "Time Remaining: 1 day" + "\n";
    }
    // used for printing both long and short term lists

    public String shortAndLongTermPrint()
    {

        currentYear = Integer.parseInt(this.currentDate.substring(6));
        currentDay = Integer.parseInt(this.currentDate.substring(3,5));
        currentMonth = Integer.parseInt(this.currentDate.substring(0,2));
        yearsRemaining = year - currentYear;
        monthsRemaining = month - currentMonth;
        daysRemaining = day - currentDay;
        
        // doesnt work if date is before current date
        if(yearsRemaining > 0)
        {
            if(monthsRemaining < 0)
            {
                yearsRemaining -= 1;
                monthsRemaining += 12;
            }
            if(daysRemaining < 0)
            {
                monthsRemaining -= 1;
                daysRemaining += 30;
                if(monthsRemaining < 0)
                {
                    yearsRemaining -= 1;
                    monthsRemaining += 12;
                }
            }
        }
        else
        {
            if(daysRemaining < 0)
            {
                monthsRemaining -= 1;
                daysRemaining += 30;
            }
        }
        
        
         //yearsRemaining > 0
        
        //if(daysRemaining > 5)
       // int yearsRemaining = year - 2024;
        ///int monthsRemaining = month - 1;
        //int daysRemaining = day - 26;
        
    
        return "Reminder/Task: " + event + "\n" + "This is due by " + month + "/" + day + "/" + year + "\n" + "Time Remaining: " + yearsRemaining + " years " + monthsRemaining + " months " + daysRemaining + " days. " + "\n";
    }
    
    public String toString()
    {
        return "\n" + "Reminder/Task: " + event + "\n" + "This is due by " + month + "/" + day + "/" + year + "\n" + "Time Remaining: " + "\n";
    }
    
    
    
    
    
    
}