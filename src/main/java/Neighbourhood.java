import java.util.List;

import static java.lang.Math.toIntExact;

public class Neighbourhood {
    private final List<Cell> neighbors;

    public Neighbourhood(List<Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isFertileNeighborhood() {
        return liveCellsIn() == 3;
    }

    public boolean isStableNeighborhood() {
        return liveCellsIn() == 2 || liveCellsIn() == 3;
    }

    public Integer liveCellsIn() {
        return toIntExact(neighbors.stream().filter(Cell::isAlive).count());
    }
}
