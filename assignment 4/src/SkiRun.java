public class SkiRun {
    private String name;
    private String symbol;
    private int difficultyLevel;

    //constructor
    public SkiRun(String name, String symbol, int difficultyLevel){
        this.name = name;
        this.symbol = symbol;
        this.difficultyLevel = difficultyLevel;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    @Override
    public String toString() {
        return "SkiRun{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                '}';
    }
}