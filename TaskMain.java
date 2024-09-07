import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TaskMain
{
    public static void main(String[] args)
    {
        
        // gives the current date in mm/dd/yyyy format
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(currentDate);
        System.out.println(date);
        // Integer.pasrseInt() is a static method that converts String into int
        
        
        // Set as random numbers to pass the following if statements later on
        int month = 0;
        int day = 0;
        int year = 0;
        String time = "";
        boolean loop = true; 
        String currentTasks = "Current Tasks: " + "\n";
        String todayTasks = "\u001B[31m" + "Today's Tasks: " + "\033[0m" + "\n";
        String tomorrowTasks = "\u001B[38;5;208m" + "Tomorrow's Tasks:" + "\033[0m"+ "\n";
        String shortTermTasks =  "\u001B[33m"+"Short Term Tasks: " + "\033[0m" + "\n";
        String longTermTasks = "\u001B[32m" + "Long Term Tasks:" + "\033[0m" + "\n";
        String level = "";
        String check;

        //Asking for event details (create a For Loop later)
        Scanner input = new Scanner(System.in);
        // bolded text
        for(int i = 0; i<= 305; i++)
        {
            System.out.print("=");
        }
        System.out.println("\n"+"\033[0;1m" + "Welcome to your Todo list!" + "\033[0m" );
        for(int i = 0; i<= 305; i++)
        {
            System.out.print("=");
        }
        // just to move to next line
        System.out.println("");
        
        while(true)
        {
            // Italicized text, done for all questions to make more readable
            System.out.println("\033[3m" + "Would you like to add a reminder to your task list? (Enter valid yes or no):" + "\033[0m");
            check = input.nextLine();
            
            if(check.equalsIgnoreCase("yes"))
            {
                month = 0;
                day = 0;
                year = 0;
                time = "";
                level = "";
                System.out.println("\033[3m" + "What would you like to name your reminder?: " + "\033[0m");
                String name = input.nextLine();
                // colour coded priorities (red, orange, yellow, green)
                while(!(level.equalsIgnoreCase("td") || level.equalsIgnoreCase("tm") || level.equalsIgnoreCase("st") || level.equalsIgnoreCase("lt")))
                {
                    System.out.println("What priority is this? " + "\u001B[31m" +"(TD = Today, " + "\033[0m" + "\u001B[38;5;208m" +" TM = Tomorrow, " + "\033[0m"+"\u001B[33m" + "ST = Shortterm, " +"\033[0m"+"\u001B[32m"+ "LT = Longterm): " + "\033[0m");
                    level = input.nextLine();
                }
                
                if(level.equalsIgnoreCase("st") || level.equalsIgnoreCase("lt"))
                {
                    
                
                    while (month > 12 || month <= 0)
                    {
                        System.out.println("\033[3m" + "What month is this due? (Input a valid month as number): " + "\033[0m");
                        month = input.nextInt();
                    }
        // Change this later to limit days depending on the month
                    while (day > 31 || day <= 0)
                    {
                        System.out.println("\033[3m" +"What day is this due? (Input valid day as number): " + "\033[0m");
                        day = input.nextInt();
                    }
                    
                    // To not let it read the the last int value entered
                    
                    input.nextLine();
                    
                    while(year < 2024 || year >= 2150)
                    {
                        System.out.println("\033[3m" + "What year is this due? (Input valid year as number): " + "\033[0m");
                        year = input.nextInt();
                    }
                    input.nextLine();
                
                }
                
                
                // Making them an object
                Task taskAdd = new Task(name, level, month, day, year,date);
                // adds tasks to list
                
                while(true)
                {
                    if(level.equalsIgnoreCase("td"))
                    {
                        todayTasks += taskAdd.todayPrint();
                        todayTasks += "\n";
                        System.out.println(todayTasks);
                        break;
                    }
                    else if(level.equalsIgnoreCase("tm"))
                    {
                        tomorrowTasks += taskAdd.tomorrowPrint();
                        tomorrowTasks += "\n";
                        System.out.println(tomorrowTasks);
                        break;
                    }
                    else if(level.equalsIgnoreCase("st"))
                    {
                        shortTermTasks += taskAdd.shortAndLongTermPrint();
                        shortTermTasks += "\n";
                        System.out.println(shortTermTasks);
                        break;
                    }
                    else if(level.equalsIgnoreCase("lt"))
                    {
                        longTermTasks += taskAdd.shortAndLongTermPrint();
                        longTermTasks += "\n";
                        System.out.println(longTermTasks);
                        break;
                    }
                    
                    
                }
                // Adding them to a their given list
                
                // Organizing them in chronological/alphabetical order
                
                // Printing out list
                
                // Repeating loop to change list
            }        
            else if(check.equalsIgnoreCase("no"))
            {
                System.out.println("No more reminders to add." + "\n");
                for(int i = 0; i<= 305; i++)
                {
                    System.out.print("=");
                }
                System.out.println("");

                System.out.println("\033[0;1m"+ "Here is the list of your current reminders!:" + "\033[0m"+ "\n" + todayTasks + tomorrowTasks + shortTermTasks + longTermTasks);
                for(int i = 0; i<= 305; i++)
                {
                    System.out.print("=");
                }
                break;
            }
            else
            {
                System.out.println("Invalid input. Please enter 'yes' or 'no'");
                
            }
        

        }
        
        
        
        
        
        
        
        
        
        
        
        
        
    }   
}