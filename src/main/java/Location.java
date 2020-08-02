public class Location {
    public static final Location NORTH_EAST = new Location(-1, -1);
    public static final Location NORTH = new Location(-1, 0);
    public static final Location NORTH_WEST = new Location(-1, +1);
    public static final Location WEST = new Location(0, -1);
    public static final Location EAST = new Location(0, +1);
    public static final Location SOUTH_WEST = new Location(+1, -1);
    public static final Location SOUTH = new Location(+1, 0);
    public static final Location SOUTH_EAST = new Location(+1, +1);

    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location at(Location anotherLocation) {
        return new Location(x + anotherLocation.x, y + anotherLocation.y);
    }
}
