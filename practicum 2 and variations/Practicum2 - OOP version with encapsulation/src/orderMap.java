import java.util.Scanner;
public class orderMap {

    private final int height;
    private final int width;
    private final int[][] orderMap;
    private int rightMost;
    private int leftMost;
    private int northMost;
    private int southMost;

    //constructor
    public orderMap(Scanner in,int newHeight, int newWidth, int newRightMost,int newLeftMost, int newNorthMost, int newSouthMost){
        this.height = newHeight;this.width = newWidth;
        orderMap = new int[height][width];
        this.rightMost = newRightMost;
        this.leftMost = newLeftMost;
        this.northMost = newNorthMost;
        this.southMost = newSouthMost;

        //input array
        mapCreation(in,height,width,orderMap);

        //get minimal cube size
        //for loop put here to avoid repetition
        for(int i = 0; i< height; i++) {
            for (int j = 0; j < width; j++) {
                getBoundaries(i,j,orderMap);

            }
        }
    }

    //getters
    public int getRightMost(){return rightMost;}
    public int getLeftMost(){return leftMost;}
    public int getNorthMost(){return northMost;}
    public int getSouthMost(){return southMost;}
    public int[][] getOrderMap(){return orderMap;}

    //function: creates array for the delivery map based on height and width
    public static void mapCreation(Scanner in, int height, int width, int[][] orderMap) {
        for (int i = 0; i < height; i++) {
            System.out.println("input  row");
            for (int j = 0; j < width; j++) {
                orderMap[i][j] = in.nextInt();
            }
        }
    }

    //function: finds the smallest possible sub array inside the delivery map provided and
    // returns the boundaries of said array(first column, last column, first row and last row)
    public void getBoundaries(int i, int j, int[][] orderMap){
        if(orderMap[i][j] !=0){
            if(j > this.rightMost){ //default rightMost value is 0 meaning j will be found starting from the second column
                this.rightMost = j;//it essentially keeps looking until it finds the largest j(column) value and stores it
            }
            if(j < this.leftMost){ //default leftMost  value is MAX_VALUE meaning j will be found starting from the first column
                this.leftMost = j; //it essentially keeps looking until it finds the first possible j(column) value and stores it
            }
            if(i < this.northMost){ //default northMost value is MAX_VALUE meaning i will be found starting from the first row
                this.northMost = i;//it essentially keeps looking until it finds the first possible i(row) value and stores it
            }
            if (i > this.southMost) {//default southMost value is 0 meaning j will be found starting from the second column
                this.southMost = i;//it essentially keeps looking until it finds the largest i(row) value and stores it
            }
        }
    }

    //function: using all four boundaries prints the smallest possible array without losing any data based on the original orderMap
    public static void minimumSizedMap(int rightMost, int leftMost, int northMost, int southMost, int[][] orderMap) {
        for(int i = northMost; i< southMost +1 ; i++){ //i=northMost since the starting point is the north boundary for (i,j) (northMost,leftMost)
            for(int j = leftMost; j< rightMost +1 ; j++){// j= leftMost since the starting point is the left boundary for (i,j) (northMost,leftmost)
                //replacement of numbers for strings
                if(orderMap[i][j] == 0){
                    System.out.print(".");
                }else if((orderMap[i][j] > 0) && (orderMap[i][j] <10)){
                    System.out.print("*");
                }else if(orderMap[i][j]>=10){
                    System.out.print("$");
                }
            }
            System.out.println();
        }
    }
}
