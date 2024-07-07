public class MapArea {
    private String surface;
    private String current;
    private final int positionY;
    private final int positionX;

    public MapArea(int positionY, int positionX){
        this.positionX = positionX;
        this.positionY = positionY;
        surface = "O"; //default is ocean space
        current = "";
    }
    //setters post creation of object
    public void setCurrent(String current) {
        this.current = current;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getSurface() {
        return surface;
    }

    public String getCurrent() {
        return current;
    }
}
