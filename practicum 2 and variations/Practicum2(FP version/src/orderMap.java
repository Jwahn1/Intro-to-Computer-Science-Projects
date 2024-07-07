import java.util.Scanner;

public class orderMap {

    int height;
    int width;
    int[][] orderMap;
    int rightMost;
    int leftMost;
    int northMost;
    int southMost;


    //constructor
    public orderMap(Scanner in,int newheight, int newwidth, int newrightMost,int newleftMost, int newnorthMost, int newsouthMost){
        this.height = newheight;this.width = newwidth;
        orderMap = new int[height][width];
        this.rightMost = newrightMost;
        this.leftMost = newleftMost;
        this.northMost = newnorthMost;
        this.southMost = newsouthMost;

        //fill map with 0s
        arrayFill(height,width,orderMap);

        //input array
        mapCreation(in,height,width,orderMap);

        //get minimal cube size
        rightMost =getRightMost(rightMost,height,width,orderMap);
        leftMost = getLeftMost(leftMost,height,width,orderMap);
        northMost= getNorthMost(northMost,height,width,orderMap);
        southMost= getSouthMost(southMost,height,width,orderMap);

    }




    public static void arrayFill(int height, int width, int[][] orderMap) {
        for(int i = 0; i< height; i++){
            for(int j = 0; j< width; j++){
                orderMap[i][j] = 0;
            }
        }
    }

    public static void mapCreation(Scanner in, int height, int width, int[][] orderMap) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                orderMap[i][j] = in.nextInt();
            }
        }
    }


    public static int getRightMost(int rightMost, int height, int width, int[][] orderMap) {
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

    public static int getLeftMost(int leftMost, int height, int width, int[][] orderMap) {
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

    public static int getNorthMost(int northMost, int height, int width, int[][] orderMap) {
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


    public static int getSouthMost(int southMost, int height, int width, int[][] orderMap) {
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

    public static void minimumSizedMap(int rightMost, int leftMost, int northMost, int southMost, int[][] orderMap) {
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
}
