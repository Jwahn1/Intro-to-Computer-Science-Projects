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
        int height = in.nextInt();
        int width = in.nextInt(); //in km

        //create map object
        orderMap delivery = new orderMap(in,height, width, rightMost,leftMost,northMost,southMost);

        //print minimal possible map 0="." , between 0 and 9="*" and >=10 ="$"
        orderMap.minimumSizedMap(delivery.getRightMost(),delivery.getLeftMost(),delivery.getNorthMost(),delivery.getSouthMost(), delivery.getOrderMap());
    }
}

