/*
author:Javier
B00:935618
Function: Program will be able to store car model info, client car info, and by using the data from those two objects
will be able to tell whether the car is capable to traversing an inputted distance. Also, the program is able to keep
on memory the car's fuel quantity or refill the fuel tank with a command.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final Scanner in = new Scanner(System.in);
    //to avoid having to transfer too many variables
    static boolean itsOver = true;
    public static ArrayList<Car> carList = new ArrayList<>();
    public static ArrayList<CarModel> modelList = new ArrayList<>();

    public static void main(String[] args) {
        while(itsOver){
            String keyWord = in.next();
            //POSSIBLE COMMANDS
            switch (keyWord) {
                case "MODEL" -> modelCommand();
                case "CAR" -> carCommand();
                case "TRIP" -> tripCommand();
                case "REFILL" -> refillCommand();
                case "FINISH" -> itsOver = false;//exits while loop outside
                case "LONGTRIPS" -> longTripsCommand();
            }
        }
    }

    //function resets the specified car's fuel into the maximum possible using its equivalent model object's tankCapacity variable
    private static void refillCommand() {
        int plateNumber = in.nextInt();
        int i;

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

    //function calculates whether the car from specified is able to travel the inputted distance and then stores the remaining car fuel into the specified car object
    private static void tripCommand() {
        int plateNumber = in.nextInt();
        double tripDistance = in.nextDouble();

        int i;

        //finds car
        i = findCar(plateNumber);
        //
        if(i>=0){
            //performs the math and then stores the leftover gas in the tank of the client's car
            double remainingFuel = carList.get(i).getTankCapacity() - carList.get(i).tripPossible(tripDistance); // remainingFuel = car.getTankCapacity() - car.tripPossible(tripDistance)
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
        String modelName = in.next();
        int plateNumber = in.nextInt();

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
        String modelName = in.next();
        double fuelEconomy = in.nextDouble();
        double tankCapacity =in.nextDouble();

        //creates a new CarModel object
        CarModel myModel = new CarModel(modelName,fuelEconomy,tankCapacity);
        //stores it
        modelList.add(myModel);
    }

    //Function prints out how many successful trip a car has done where the distance was >= to the amount inputted
    private static void longTripsCommand(){
        int plateNumber = in.nextInt();
        double tripDistance = in.nextDouble();
        int counter =0;
        int i;

        //finds car with the give plate number
        i = findCar(plateNumber);

        //checks how many trips were successful beforehand
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

}


