/*
By: Javier Wahn
Date: 30/1/2023
Function:Calculates total salary of all employees inputed into program
*/
import java.util.Scanner;
import java.lang.StringBuilder;

public class Problem2 {
    public static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        //static variables
        System.out.println("Please input the number of employees:");
        int numberOfEmployees = in.nextInt();
        int[][] employeeStats = new int[numberOfEmployees][4]; // input requires 4 stats for each employee
        System.out.println("Please input the data of each employee:");

        //takes input and stores the unorganized data where it belongs in the array
        store(numberOfEmployees,employeeStats);

        //calculates each employee payment
        int totalPay =  totalSalaryCalculator(employeeStats,numberOfEmployees);

        //find out totalPay Length
        int payLength = digits(totalPay);

        //final printout
        printingSign(totalPay,payLength);
    }

    //function uses the employee array to give the total sum of employee payment
    public static int totalSalaryCalculator(int[][] employeeStats,int numberOfEmployees){
        int totalPay = 0;
        for(int i = 0; i<numberOfEmployees ; i++){
            int normalHourDifference = 0;
            //make two scenarios, 1. employee did overtime 2. employee did under normal hours or equal
            if(employeeStats[i][0] >= employeeStats[i][3]){
                totalPay += employeeStats[i][1]*employeeStats[i][3]; //if no overtime actualHours*normalWage
            }else{ // if there was overtime
                normalHourDifference = employeeStats[i][3] - employeeStats[i][0]; //remaining hours will be overtime hours
                totalPay += employeeStats[i][0]*employeeStats[i][1]; //normal hour pay
                totalPay += employeeStats[i][2]*normalHourDifference; // overtime hour pay added
            }
        }
        return totalPay;
    }

    //function finds out the length of totalPay
    public static int digits(int totalPay){
        String store = Integer.toString(totalPay);
        int length = store.length();
        return length;
    }

    //function prints the required output
    public static void printingSign(int totalPay,int payLength){
        StringBuilder stars = new StringBuilder("********");//default amount of stars
        for(int i = 0; i< payLength ; i++){
            stars.append("*");//variable amount of stars printed dependent on totalPay length
        }
        System.out.println(stars+"\n"+totalPay+ " Dollars\n" + stars);
    }
    //function takes string input,extracts integer value and stores it
    public static void store(int numberOfEmployees, int[][] employeeStats){
        for(int i = 0; i<numberOfEmployees ; i++){
            for(int j = 0; j<4; j++){
                String temp = in.next(); //takes 1 input at a time and doesnt store it
                stringValueReader(employeeStats,temp,i); // sends current string temp to know which value to store
            }
        }
    }

    //function:reads substring and stores the value corresponding to the char
    public static void stringValueReader(int[][] employeeStats,String temp,int i){
        switch(temp.substring(0,1)){
            case "t": //[0] normal work hours
                employeeStats[i][0] = Integer.parseInt(temp.substring(2));// substring 2 means it skips element 0 and 1 of the string
                break;
            case "d"://1]  pay per normal work hour
                employeeStats[i][1] = Integer.parseInt(temp.substring(2));
                break;
            case "D"://[2] pay per overtime hour
                employeeStats[i][2] = Integer.parseInt(temp.substring(2));
                break;
            case "T"://[3] actual worktime done
                employeeStats[i][3] = Integer.parseInt(temp.substring(2));
                break;
        }
    }
}



