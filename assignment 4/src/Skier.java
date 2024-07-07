public class Skier {

    private String name;
    private int skierLevel;

    public Skier(String name, int skierLevel) {
        this.name = name;
        this.skierLevel = skierLevel;
    }

    public String getName() {
        return name;
    }

    public int getSkierLevel() {
        return skierLevel;
    }

    public boolean canSki(Assignments.A3.A3.SkiRun skiRun) {
        boolean canSkiRun = false;
        if (this.skierLevel >= skiRun.getDifficultyLevel()) {
            canSkiRun = true;
        }
        return canSkiRun;
    }
}