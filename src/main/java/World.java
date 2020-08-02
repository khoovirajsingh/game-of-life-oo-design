import java.util.HashMap;
import static java.util.Arrays.asList;

public class World {
    private final Integer rows;
    private final Integer columns;
    private HashMap<Location, Cell> cells = new HashMap();

    public World(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        initialize();
    }

    public void add(Location location, Cell cell) {
        cells.put(location, cell);
    }

    public World evolve() {
        World evolved = new World(rows, columns);
        for (Location location : cells.keySet()) {
            Neighbourhood neighbourhood = neighborhoodOf(location);
            Cell cell = cellAt(location);
            Cell nextCell = cell.nextGeneration(neighbourhood);
            evolved.add(location, nextCell);
        }
        return evolved;
    }

    private Neighbourhood neighborhoodOf(Location location) {
        return new Neighbourhood(
                asList(
                        cellAt(location.at(Location.NORTH_EAST)),
                        cellAt(location.at(Location.NORTH)),
                        cellAt(location.at(Location.NORTH_WEST)),
                        cellAt(location.at(Location.WEST)),
                        cellAt(location.at(Location.EAST)),
                        cellAt(location.at(Location.SOUTH_WEST)),
                        cellAt(location.at(Location.SOUTH)),
                        cellAt(location.at(Location.SOUTH_EAST))
                )
        );
    }

    private Cell cellAt(Location location) {
        return cells.getOrDefault(location, Cell.dead());
    }

    private void initialize() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                add(new Location(i, j), Cell.dead());
            }

        }
    }

}
