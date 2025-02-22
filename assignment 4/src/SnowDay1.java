/**
 * CSCI 1110 (W23)
 * @author Dr. Angela Siegel
 */

import java.util.Scanner;

public class SnowDay1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //System.out.print("What's the name of the ski hill? ");
        String skiHillName = in.nextLine();


        SkiHill skiHill = new SkiHill(skiHillName);

        //System.out.print("How many ski runs from top of hill? ");
        int numberRuns = in.nextInt(); in.nextLine();

        for (int i=1; i<=numberRuns; i++) {
            //System.out.print("Enter run " + i + " info - Level(1-3) Name: ");
            int difficulty = in.nextInt();
            String runName = in.nextLine().trim();
            if (difficulty == 1) {
                skiHill.addSkiRun(new EasyRun(runName));
            }
            else if (difficulty == 2) {
                skiHill.addSkiRun(new MediumRun(runName));
            }
            else {
                skiHill.addSkiRun(new HardRun(runName));
            }
        }

        System.out.println("Welcome to " + skiHill.getName() + "!");
        System.out.println("We hope you enjoy our " + skiHill.numberSkiRuns() + " runs:");
        int counter = 0;
        for (SkiRun run: skiHill.getSkiRuns()) {
            counter++;
            System.out.println(counter + ". " + run.getName() + " (" + run.getSymbol() + " - Level " + run.getDifficultyLevel() + ")");
        }
    }
}


/*
TEST INPUT:
Wentworth Southside
6
2 Beaver
2 Embree
2 Gambol
1 Garden Path
2 Giggletree
1 Horse Pastures
 */
