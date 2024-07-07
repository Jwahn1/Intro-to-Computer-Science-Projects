import java.util.Scanner;

public class Problem3 {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);

        int rightMost = 0;
        int leftMost = 100;
        int northMost = 100;
        int southMost = 0;

        //array creation
        int height = in.nextInt();
        int width = in.nextInt(); //in km


        //create map object
        orderMap delivery = new orderMap(in,height, width, rightMost,leftMost,northMost,southMost);

        //print map
        delivery.minimumSizedMap(delivery.rightMost,delivery.leftMost,delivery.northMost,delivery.southMost, delivery.orderMap);



    }




}

