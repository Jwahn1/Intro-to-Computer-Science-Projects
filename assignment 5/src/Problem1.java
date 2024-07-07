import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int height = in.nextInt();
        int width = in.nextInt();


        EarthMap earth = new EarthMap(height,width);
        in.nextLine(); //consumes missing line break
        String land = in.nextLine();
        String[] coordinates = land.split(" ");

        //change map quadrants to land
        for(int i = 0; i< coordinates.length; i++){
            //uses split to further seperate the coordinates in case of 2 or higher digit numbers
            String[] numbers = coordinates[i].split(",");
            int cordY = Integer.parseInt(numbers[0]);
            int cordX = Integer.parseInt(numbers[1]);
            //changes the map quadrant value to land
            earth.getMap()[cordY][cordX].setSurface("L");
        }


        //goes through all of the array cells and check if its ocean
        //if true in.next() with it being the current direction for that quadrant
        for(int i = 0; i<height ; i++){
            for(int j =0; j<width;j++){
                if(earth.getMap()[i][j].getSurface().equals("O")){//checks if its ocean or not
                    earth.getMap()[i][j].setCurrent(in.next());//i.e in.next() = E or W = east or west
                }
            }
        }

        //bottle creation
        ArrayList<Bottle> bottleList = new ArrayList<>();
        int bottleAmount = in.nextInt();
        for(int i = 0; i<bottleAmount;i++){
            int posY = in.nextInt();
            int posX = in.nextInt();
            String temp = in.nextLine();
            String name = temp.substring(1);
            String message = in.nextLine();

            Bottle bottle = new Bottle(posY,posX,name,message);
            bottleList.add(bottle);

        }


        for(int i = 0; i<height ; i++){
            for(int j =0; j<width;j++){
                String label = earth.getMap()[i][j].getSurface();
                if(label.equals("L")){
                    System.out.print("X");
                }else{
                    System.out.print(earth.getMap()[i][j].getCurrent());
                }
            }
            System.out.println();
        }

        for(int i = 0 ; i<bottleList.size();i++){
            System.out.println(bottleList.get(i));
        }
    }
}
