/*
Author:Javier Wahn
ID: B00935618
Function: Displays the Wings menu 
*/

import java.util.Scanner;
public class Problem1{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String[] details = new String[5];

        int orderSize = in.nextInt();
        in.nextLine(); // buffer
        String temp = "";
        String strength = "";

        for(int i = 0; i<orderSize ; i++){

            //in.next auto seperates all the order items so using a 5 step for loop fills the details[] array
            for(int j = 0; j<5 ; j++){
                details[j]= in.next();
            }

            //here change details[1] (spice level) to int to check if mild <= 10 000 / hot! < 1 000 000 / danger !! > 1 000 000
            int spice = Integer.parseInt(details[1]);
            if(spice <= 10000){
                strength = "(mild)";
            }else if ((spice >10000)&&(spice <1000000)){
                strength = "(hot!)";
            }else if (spice >= 1000000){
                strength = "(DANGER!!!)";
            }

            //changing the prices from string to double
            double price1 = Double.parseDouble(details[2]);
            double price2 = Double.parseDouble(details[3]);
            double price3 = Double.parseDouble(details[4]);

            //menu printout one line at a time
            System.out.printf("%s Wings cost $%.2f/$%.2f/$%.2f and have %s Scovilles %s \n",details[0],price1,price2,price3,details[1],strength);
        }


    }
}