/*
By: Javier Wahn
Date: 30/1/2023
Function:Calculates total salary of all employees inputed into program
*/
import java.util.Scanner;

public class Problem1 {
    public static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        //static variables
        System.out.println("Please input the number of employees:");
        int numberOfEmployees = in.nextInt();
        int[][] employeeStats = new int[numberOfEmployees][4]; // input requires 4 stats for each employee
        System.out.println("Please input the data of each employee:");

        //obtains employee data
        for(int i = 0; i<numberOfEmployees ; i++){
            for(int j = 0 ; j<4 ; j++){
                // the order of inputted stats are
                //[0] normal work hours ; [1]  pay per normal work hour ; [2] pay per overtime hour; [3] actual worktime done
                employeeStats[i][j] = in.nextInt();
            }
        }

        //calculates each employee payment
        totalSalaryCalculator(employeeStats,numberOfEmployees);
    }

    //function uses the employee array to give the total sum of employee payment
    public static void totalSalaryCalculator(int[][] employeeStats,int numberOfEmployees){
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
        System.out.println(totalPay);
    }
}

