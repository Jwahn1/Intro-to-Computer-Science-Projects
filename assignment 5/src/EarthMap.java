public class EarthMap {
    private MapArea[][] map;
    private int height;
    private int width;

    public EarthMap(int height, int width){
        this.height = height;
        this.width = width;
        map = new MapArea[height][width];
        //map creation
        for(int i = 0; i< height; i++){
            for(int j = 0; j< width; j++){
                MapArea quadrant = new MapArea(i, j);//
                map[i][j] = quadrant;//fills the entire map with default ocean quadrants
            }
        }
    }

    public MapArea[][] getMap() {
        return map;
    }


}
