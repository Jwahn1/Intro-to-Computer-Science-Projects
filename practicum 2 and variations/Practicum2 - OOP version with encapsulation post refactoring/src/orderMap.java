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
                rightMost= getRightMost(rightMost,i,j,orderMap);
                leftMost= getLeftMost(leftMost,i,j,orderMap);
                northMost= getNorthMost(northMost,i,j,orderMap);
                southMost= getSouthMost(southMost,i,j,orderMap);
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
            for (int j = 0; j < width; j++) {
                orderMap[i][j] = in.nextInt();
            }
        }
    }

    //function finds the rightmost column boundary filled with numbers!= 0
    public static int getRightMost(int rightMost,int i, int j,int[][] orderMap) {
        if(orderMap[i][j] != 0){
            if(j > rightMost){ //default rightMost value is 0 meaning j will be found starting from the second column
                rightMost = j;//it essentially keeps looking until it finds the largest j(column) value and stores it
            }
        }
        return rightMost;
    }

    //function finds the leftmost column boundary filled with numbers!= 0
    public static int getLeftMost(int leftMost, int i, int j, int[][] orderMap) {
        if(orderMap[i][j] != 0){
            if(j < leftMost){ //default leftMost  value is MAX_VALUE meaning j will be found starting from the first column
                leftMost = j; //it essentially keeps looking until it finds the first possible j(column) value and stores it
            }
        }
        return leftMost;
    }
    //function finds the highest row boundary filled with numbers!= 0
    public static int getNorthMost(int northMost, int i, int j, int[][] orderMap) {
        if(orderMap[i][j] != 0){
            if(i < northMost){ //default northMost value is MAX_VALUE meaning i will be found starting from the first row
                northMost = i;//it essentially keeps looking until it finds the first possible i(row) value and stores it
            }
        }
        return northMost;
    }

    //function finds the lowest row boundary filled with numbers!= 0
    public static int getSouthMost(int southMost, int i, int j, int[][] orderMap) {
        if(orderMap[i][j] != 0) {
            if (i > southMost) {//default southMost value is 0 meaning j will be found starting from the second column
                southMost = i;//it essentially keeps looking until it finds the largest i(row) value and stores it
            }
        }
        return southMost;
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
