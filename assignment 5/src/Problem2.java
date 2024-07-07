import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
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

        }//bottle list printout
        for(int i = 0 ; i<bottleList.size();i++){
            System.out.println(bottleList.get(i).problem2fix());
        }



        //bottle traversal begins here
        //sidenote start with only one bottle for now
        int landingsCounter = 0;
        boolean travelsFinished = false;
        ArrayList<String> landedBottles = new ArrayList<>();
        while(!travelsFinished){

            //moving bottle positions
            for(int i =0; i<bottleList.size();i++){

                int posY = bottleList.get(i).getPositionY();
                int posX = bottleList.get(i).getPositionX();

                String current = earth.getMap()[posY][posX].getCurrent();
                boolean notLanded = true;

                //checks if the current bottle has already landed so it may be ignored
                //specialcase
                if(landingsCounter == 0){
                    notLanded = true;
                }else{
                    for(int j = 0; j<landedBottles.size();j++) {
                        //if the landed bottle is found in the array then this loop turn is ignored
                        if (bottleList.get(i).getName().equals(landedBottles.get(j))) {
                            notLanded = false;
                            break;
                        }
                    }
                }
                //moves bottls around since the current bottleList.get(i) has not landed
                if(notLanded){
                    //current position printout
                    System.out.print(bottleList.get(i).getMovementCounter() + ": "+ bottleList.get(i).getName() + " at (" + posY + ", " + posX + "): ");
                    //find if its on land or water
                    String surfaceStatus = earth.getMap()[posY][posX].getSurface();
                    switch(surfaceStatus){
                        case "O":{//on water
                            System.out.println("In ocean, current taking it " + current+".");
                            //updates position
                            switch(current){
                                case "N":{
                                    bottleList.get(i).setNewPosition(posY-1,posX);
                                    break;
                                }
                                case "S":{
                                    bottleList.get(i).setNewPosition(posY+1,posX);
                                    break;
                                }
                                case "E":{
                                    bottleList.get(i).setNewPosition(posY,posX+1);
                                    break;
                                }
                                case "W":{
                                    bottleList.get(i).setNewPosition(posY,posX-1);
                                    break;
                                }
                            }
                            bottleList.get(i).increaseCounter();
                            break;
                        }
                        case "L":{//on land
                            System.out.println("LANDED!");
                            landingsCounter++;
                            landedBottles.add(bottleList.get(i).getName());
                            //message
                            System.out.println("<<MESSAGE RECEIVED: "+ bottleList.get(i).getMessage() + ">>");
                            bottleList.get(i).increaseCounter();
                            break;
                        }
                    }
                }
            }
            if(landingsCounter == bottleAmount){
                travelsFinished = true;
            }

        }
    }
}
