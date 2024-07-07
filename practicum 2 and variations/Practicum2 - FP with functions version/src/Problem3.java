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
        int[][] orderMap = new int[height][width];

        //fills the array with 0s
        arrayFill(height, width, orderMap);

        //delivery map creation

        for(int i = 0; i<height ; i++){
            for(int j =0 ; j<width ; j++){
                orderMap[i][j] = in.nextInt();
            }
        }

        //done with the refactoring option in the IDE

        //finds the right most col filled with non zero numbers
        rightMost = getRightMost(rightMost, height, width, orderMap);

        //finds the left most col filled with non zero numbers
        leftMost = getLeftMost(leftMost, height, width, orderMap);

        //finds the north most row filled with non zero numbers
        northMost = getNorthMost(northMost, height, width, orderMap);

        //finds the south most row filled with non zero numbers
        southMost = getSouthMost(southMost, height, width, orderMap);


        //minimum cube
        minimumSizedMap(rightMost, leftMost, northMost, southMost, orderMap);

    }

    private static void minimumSizedMap(int rightMost, int leftMost, int northMost, int southMost, int[][] orderMap) {
        for(int i = northMost; i< southMost +1 ; i++){
            for(int j = leftMost; j< rightMost +1 ; j++){
                if(orderMap[i][j] == 0){
                    System.out.print(".");
                }else if((orderMap[i][j] > 0) && (orderMap[i][j] <10)){
                    System.out.print("*");
                }else if(orderMap[i][j]>=10){
                    System.out.print("$");
                }
            }
            System.out.println("");
        }
    }

    private static void arrayFill(int height, int width, int[][] orderMap) {
        for(int i = 0; i< height; i++){
            for(int j = 0; j< width; j++){
                orderMap[i][j] = 0;
            }
        }
    }

    private static int getRightMost(int rightMost, int height, int width, int[][] orderMap) {
        for(int i = 0; i< height; i++){
            for(int j = 0; j< width; j++){
                if(orderMap[i][j] != 0){
                    if(j > rightMost){
                        rightMost = j;
                    }
                }
            }
        }
        return rightMost;
    }

    private static int getLeftMost(int leftMost, int height, int width, int[][] orderMap) {
        for(int i = 0; i< height; i++){
            for(int j = 0; j< width; j++){
                if(orderMap[i][j] != 0){
                    if(j < leftMost){
                        leftMost = j;
                    }
                }
            }
        }
        return leftMost;
    }

    private static int getNorthMost(int northMost, int height, int width, int[][] orderMap) {
        for(int i = 0; i< height; i++){
            for(int j = 0; j< width; j++){
                if(orderMap[i][j] != 0){
                    if(i < northMost){
                        northMost = i;
                    }
                }
            }
        }
        return northMost;
    }


    private static int getSouthMost(int southMost, int height, int width, int[][] orderMap) {
        for(int i = 0; i< height; i++){
            for(int j = 0; j< width; j++){
                if(orderMap[i][j] != 0){
                    if(i > southMost){
                        southMost = i;
                    }
                }
            }
        }
        return southMost;
    }
}

