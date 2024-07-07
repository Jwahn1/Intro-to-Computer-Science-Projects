/*
Author:Javier Wahn
ID: B00935618
Function:
*/

import java.util.Scanner;
public class Problem3{
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        int menuSize = in.nextInt();
        in.nextLine(); // buffer
        String SENTINEL = " ";
        String[][] details = new String[menuSize][5]; // 5 items per menu line
        String[] order = new String[3];
        String[] orderChange = new String[2];
        Double multiplier = 0.00;


        //creates the menu
        for(int i = 0; i<menuSize ; i++){
            //in.next auto seperates all the order items so using a 5 step for loop fills the details[] array
            for(int j = 0; j<5 ; j++){
                details[i][j]= in.next();

            }
        }

        //with the menu completed we can then ask for orders with the loop condition being if there is more terminal inputs left
        while(in.hasNext()){
            //first we send all the data and take the orders
            orderTake(order,details,SENTINEL,menuSize);

            //stops the loop before it goes out of bounds
            if(!in.hasNext()){
                break;
            }

            //if the program still has more input we ask what menu item is having its price changed
            for(int i =0 ; i<2 ; i++){
                orderChange[i] = in.next();
            }

            //we extract how much the special item price changes
            multiplier = Double.parseDouble(orderChange[1]);
            //turns number into correct percentage format
            multiplier = multiplier/100;

            //now program checks which item needs to be modified in price
            for(int i = 0; i<menuSize;i++){
                if(details[i][0].equals(orderChange[0])){
                    double price1 = Double.parseDouble(details[i][2]);
                    double price2 = Double.parseDouble(details[i][3]);
                    double price3 = Double.parseDouble(details[i][4]);
                    //multiplies with percentage
                    price1 = price1*multiplier;
                    price2 = price2*multiplier;
                    price3 = price3*multiplier;
                    //stores new prices in menu
                    details[i][2]= String.valueOf(price1);
                    details[i][3]= String.valueOf(price2);
                    details[i][4]= String.valueOf(price3);
                    //print here the new prices
                    System.out.printf("Price for %s are now $%.2f/$%.2f/$%.2f\n",orderChange[0],price1,price2,price3);
                }
            }


        }


    }

    //function for taking orders and calculating the income/SHU average
    public static void orderTake(String[] order, String[][] details,String SENTINEL,int menuSize){

        //SHU and income
        double income = 0.00;
        double SHUaverage = 0.00;
        double average = 0.00;

        while(!(SENTINEL.equals("ORDERS COMPLETE"))){
            //resets conidtion
            boolean exists = false;

            //takes and stores food order in order[]
            for(int i = 0; i<3 ; i++){
                order[i] = in.next();  //takes 1 order at a time
                //it detects before hand when the order is going to end in preparation for second break
                if(order[i].equals("COMPLETE")){//finishes before eating further inputs
                    break;
                }
            }

            //stops loop
            if (order[0].equals("ORDERS")){
                break;
            }
            //prints the 1 order
            for(int i = 0 ; i<menuSize ; i++){
                if(details[i][0].equals(order[2])){ //checks whether the item in the order exists in the menu
                    System.out.println(order[0] + " order - " + order[1] + " " + order[2] + " Wings");

                    //stats check
                    double wings = Double.parseDouble(order[1]);
                    double amount = Double.parseDouble(order[0]);

                    //finds how many orders where made and locates it in the array
                    int temp = Integer.parseInt(order[1]);// this is for locating the price of the order amount
                    if(temp == 6){
                        temp = 1;
                    }else if(temp == 12){
                        temp = 2;
                    }else{
                        temp = 3;
                    }

                    SHUaverage += Double.parseDouble(details[i][1])*(wings*amount);//find how to multiply this number by amount ordered
                    income += Double.parseDouble(details[i][temp+1])*amount; //find how to multiply this number by amount ordered
                    average += Double.parseDouble(order[1])*amount;

                    //System.out.println(SHUaverage);

                    //changes boolean so it doesnt print this item is not on the menu
                    exists = true;

                }
            }
            if(!exists){ // if the menu item is not found to match the menu this condition is not satisfied
                System.out.println("This item is not on the menu.");
            }


        }
        //here program should print what the the price in total was and the average spice of the order
        SHUaverage = SHUaverage/average;
        System.out.printf("The income was $%.2f and the order averaged %.2f Scovilles per a wing served\n",income,SHUaverage);
    }


}