/*
author:Javier
B00:935618
Function: Program will be able to store car model info, client car info, and by using the data from those two objects
will be able to tell whether the car is capable to traversing an inputted distance. Also, the program is able to keep
on memory the car's fuel quantity in memory or refill it the fuel tank with a command.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final Scanner in = new Scanner(System.in);
    //to avoid having to transfer too many variables
    static boolean itsOver = true;
    //instance variables
    private static int plateNumber = 0;
    private static double tripDistance = 0.0;
    private static String modelName = "";
    private static double fuelEconomy = 0.0;
    private static double tankCapacity = 0.0;
    public static ArrayList<Car> carList = new ArrayList<>();
    public static ArrayList<CarModel> modelList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------\n" +
                "Welcome to the information database");
        while(itsOver){
            //prints the visual menu
            CommandLineInterfacePrintout();
            //command menu
            String keyWord = in.next();
            //POSSIBLE COMMANDS
            switch (keyWord) {
                case "MODEL" -> modelCommand();
                case "CAR" -> carCommand();
                case "TRIP" -> tripCommand();
                case "REFILL" -> refillCommand();
                case "FINISH" -> itsOver = false;//exits while loop outside
                case "LONGTRIPS" -> longTripsCommand();
                case "DATA" -> printDatabase();
            }
            System.out.println("\n\n");//every loop it cleans up the terminal
        }
    }

    private static void CommandLineInterfacePrintout() {
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println("""

                to access the submenus type either one of these commands
                MODEL: store a new car model and its characteristics in our database
                CAR:  Store a client's car and it's characteristics in our database
                TRIP: calculates whether a client's car is able to travel a certain distance
                REFILL: Refills a client's car's fuel tank to full capacity
                LONGTRIPS: Shows how many trips has the client's car been able to do successfully in the past
                DATA: Shows all models and cars in the data base""");
    }

    //function resets the specified car's fuel into the maximum
    // possible using its equivalent model object's tankCapacity variable
    private static void refillCommand(){
        int i;
        try{
            System.out.println("Input the car's plate number");
            plateNumber = in.nextInt();
        }catch(Exception wrongInput){
            System.out.println("Wrong input, returning to Main menu");
        }

        //finds car with the give plate number
        i = findCar(plateNumber);
        if(i>=0){
            for(int j = 0; j< modelList.size(); j++){
                if(carList.get(i).getModelName().equals(modelList.get(j).modelName())){ //(car.getModelName()).equals(model.getModelName()) it cross-references both databases
                    carList.get(i).setTankCapacity(modelList.get(j).tankCapacity()); // car.setTankCapacity(model.getTankCapacity) resets to default value
                    j = modelList.size();//exits loop
                }
            }
        }else{
            System.out.println("This car Doesn't exist");
        }
    }

    //function calculates whether the car from specified is able to travel the inputted distance
    // and then stores the remaining car fuel into the specified car object
    private static void tripCommand() {
        try{
            System.out.println("input the car's plate number");
            plateNumber = in.nextInt();
            System.out.println("Input the distance that will be travelled by the car(double)");
            tripDistance = in.nextDouble();
        }catch(Exception wrongInput){
            System.out.println("Wrong input, returning to Main menu");
        }
        int i;

        //finds car
        i = findCar(plateNumber);
        //
        if(i>=0){

            //performs the math and then stores the leftover gas in the tank of the client's car
            // remainingFuel = car.getTankCapacity() - car.tripPossible(tripDistance)
            double remainingFuel = carList.get(i).getTankCapacity() - carList.get(i).tripPossible(tripDistance);
            carList.get(i).setTankCapacity(remainingFuel); //the fuel in the car is now the what's left after the trip

            //performs the car trip
            if(remainingFuel >=0){ //checks whether there was enough fuel in the tankCapacity variable to make the trip
                System.out.println("Trip completed successfully for #" + plateNumber);
                carList.get(i).setTrips(tripDistance); //stores successful trip
            }else{
                System.out.println("Not enough fuel for #" + plateNumber);
            }
        }else if(i==-1){
            System.out.println("This car Doesn't exist");
        }
    }

    //function stores the car info inputted into the database
    private static void carCommand() {
        try{
            System.out.println("Input the car's model name");
            modelName = in.next();
            System.out.println("Input the car's plate number");
            plateNumber = in.nextInt();
        }catch(Exception wrongInput){
            System.out.println("Wrong input, returning to Main menu");
        }

        //checks whether the car has been inputed already
        if(findCar(plateNumber) >=0){
            System.out.println("This car is already in our database");
            return;
        }

        //checks whether the car's model is in our database
        for (CarModel carModel : modelList) {
            if (!modelName.equals(carModel.modelName())) {
                System.out.println("This car model is missing from our database, returning to Main menu");
                return;
            }
        }
        //special case
        if(modelList.size() == 0){
            System.out.println("this model is missing from our database");
            return;
        }

        //creates a new Car Object
        Car myCar = new Car(modelName,plateNumber);
        //stores it
        carList.add(myCar);

        //carlist.size()-1(the last one added)
        //this brings out the missing info from the newly stored car, cross-referencing with the model database
        for(int i = 0; i< modelList.size(); i++){

            if(modelList.get(i).modelName().equals(modelName)){ //(car.getModelName).equals(modelName)
                carList.get(carList.size()-1).setFuelEconomy(modelList.get(i).fuelEconomy()); //car.setFuelEconomy(model.getFuelEconomy)
                carList.get(carList.size()-1).setTankCapacity(modelList.get(i).tankCapacity()); //car.setTankCapacity(model.getTankCapacity)
                i = modelList.size(); //exits loop
            }
        }

    }

    //function stores the car model info inputted into the database
    private static void modelCommand() {
        boolean modelExist = false;

        try{
            System.out.println("Input the name of the car model");
            modelName = in.next();
            System.out.println("Input the car model's fuel economy(double)");
            fuelEconomy = in.nextDouble();
            System.out.println("Input the car model's max tank capacity(double)");
            tankCapacity = in.nextDouble();
        }catch(Exception wrongInput){
            System.out.println("Wrong input, returning to Main menu");
        }

        //check if model has been inputted in the past
        for(int i =0; i<modelList.size();){
            if (modelName.equals(modelList.get(i).modelName())) {
                modelExist = true;
                break;
            }
        }
        //if the model name inputted isn't already stored then we can proceed to store it in an object
        if(modelExist){
            System.out.println("this model is already in the database");
        }else{
            //creates a new CarModel object
            CarModel myModel = new CarModel(modelName,fuelEconomy,tankCapacity);
            //stores it
            modelList.add(myModel);
        }
    }

    //Function prints out how many successful trip a car has done where the distance was >= to the amount inputted
    private static void longTripsCommand(){
        int plateNumber = 0;
        double tripDistance = 0.0;
        int counter =0;
        int i;

        try{
            System.out.println("Input plate number(int only)");
            plateNumber = in.nextInt();
            System.out.println("Input the distance travelled to compare to");
            tripDistance = in.nextDouble();
        }catch (Exception wrongInput){
            System.out.println("Wrong input, returning to Main Menu");
        }

        //finds car with the give plate number
        i = findCar(plateNumber);
        if(i >= 0){
            for(int j = 0; j<carList.get(i).getTrips().size(); j++){//j<trips.size(); //model matches carlist model
                if(carList.get(i).getTrips().get(j) >= tripDistance){//trips.get(j) >= tripDistance
                    //essentially we check on the trips arraylist(which each car object has) which trips are >= to the tripsDistance inputted
                    //and then up the counter since each of those was successful
                    counter++;
                }
            }
        }else{
            System.out.println("This car Doesn't exist");
        }

        //checks how many trips were successful beforehand
        //printout
        System.out.println("#" + plateNumber + " made " + counter + " trips longer than " + (int)tripDistance);
    }

    //function finds care in the database to avoid repetition
    private static int  findCar(int plateNumber) {

        for(int i = 0; i<carList.size();i++){//car match
            if(carList.get(i).getPlateNumber() == plateNumber){//car.getPlateNumber == plateNumber
                return i;//position in the car Arraylist where the client's car is located in
            }
        }
        return -1; // incorrect car
    }

    //function prints out all objects stored in the arraylists
    private static void printDatabase(){
        System.out.println("Models in memory:");
        for (CarModel carModel : modelList) {
            System.out.println(carModel);
        }


        System.out.println("Cars in memory:");
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    //making it possible to return to the main menu at anytime
    //make it possible to delete a car object or model object

}


