/*
function:creates a delivery map representing how many deliveries are to be made in each city block and then finds the minimum array area to be printed
 */

import java.util.Scanner;
public class Problem3 {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);

        //minimum array boundaries
        int rightMost = 0;
        int leftMost = Integer.MAX_VALUE;
        int northMost = Integer.MAX_VALUE;
        int southMost = 0;

        //array size input
        int height;
        int width; //in km

        do{ // how do you restrict string inputs? look up
            System.out.println("input array height and width");
            height = in.nextInt();
            width =1 in.nextInt();
        }while((height <0) || (width <0));

        //create map object
        orderMap delivery = new orderMap(in,height, width, rightMost,leftMost,northMost,southMost);

        //we could have a full array printout here as well+

        //print minimal possible map 0="." , between 0 and 9="*" and >=10 ="$"
        orderMap.minimumSizedMap(delivery.getRightMost(),delivery.getLeftMost(),delivery.getNorthMost(),delivery.getSouthMost(), delivery.getOrderMap());
    }
}

