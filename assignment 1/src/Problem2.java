/*
Author:Javier Wahn
ID: B00935618
Function: Displays the daily recommended Cauliflower Wings option
*/

import java.util.Scanner;
public class Problem2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int orderSize = in.nextInt();
        in.nextLine(); // buffer
        String[][] details = new String[orderSize][5]; // 5 items per menu line

        for(int i = 0; i<orderSize ; i++){
            //in.next auto seperates all the order items so using a 5 step for loop fills the details[] array
            for(int j = 0; j<5 ; j++){
                details[i][j]= in.next();
            }
        }

        //after all the data is stored we can now change the item of the day to its new price

        String specialItem = in.next(); //cauliflower variant

        for(int i = 0; i<orderSize ; i++){
            for(int j = 0; j<5; j++){
                if(details[i][j].equals(specialItem)){
                    //changing the prices from string to double
                    double price1 = Double.parseDouble(details[i][2]);
                    double price2 = Double.parseDouble(details[i][3]);
                    double price3 = Double.parseDouble(details[i][4]);
                    //50% increase in price
                    price1 += (price1/2);
                    price2 += (price2/2);
                    price3 += (price3/2);
                    //menu printout one line at a time
                    System.out.printf("%s Cauliflower Wings cost $%.2f/$%.2f/$%.2f\n",details[i][0],price1,price2,price3);
                }
            }
        }

    }
}
