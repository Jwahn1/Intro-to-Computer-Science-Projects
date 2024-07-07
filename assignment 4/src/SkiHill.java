import java.util.ArrayList;

public class SkiHill {
    private String name;
    private ArrayList<SkiRun> skiRuns;

    //constructor
    public SkiHill(String name){
        this.name = name;
        skiRuns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<SkiRun> getSkiRuns() {
        return skiRuns;
    }

    public void addSkiRun(SkiRun newRun){
        skiRuns.add(newRun);
    }

    public int numberSkiRuns(){
        return skiRuns.size();
    }
}