import java.util.List;

public class LiveCell extends Cell {

    @Override
    public Cell nextGeneration(Neighbourhood neighbourhood) {
        if (neighbourhood.isStableNeighborhood()) return Cell.live();
        return Cell.dead();
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
