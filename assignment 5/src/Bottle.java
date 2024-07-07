import java.util.ArrayList;

public class Bottle {
    private String message;
    private int positionY;
    private int positionX;
    private String name;
    private int movementCounter;
    private ArrayList<String> visitedPlaces;
    //constructor
    public Bottle(int positionY,int positionX, String name, String message){
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        this.message = message;
        movementCounter = 0; // tracks how many times it has moved in the map
        visitedPlaces = new ArrayList<>();//tracker of visited locations in the map
    }

    public String getName() {
        return name;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getMessage() {
        return message;
    }

    public int getMovementCounter() {
        return movementCounter;
    }
    //gets array holding which quadrants the bottle has visited
    public ArrayList<String> getVisitedPlaces() {
        return visitedPlaces;
    }

    //function changes the current bottle's position in the map
    public void setNewPosition(int positionY, int positionX) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    //keeps track of its movement amount
    public void increaseCounter(){
        movementCounter++;
    }

  //function goes through the visitedPlaces array and if it matches where the bottle currently is, then it returns true
    public boolean repeatedArea(String position){
        for(int i =0; i<visitedPlaces.size();i++){
            if(visitedPlaces.get(i).equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bottle named\""  + name +"\" starting at " + "(" + positionY + ", " + positionX + ")";
    }
    //print out required in problem 2 and 3 is different for some reason
    public String problem2fix(){
        return name + ": Starting at (" + positionY + ", " + positionX + ")";
    }
}
