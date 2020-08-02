import java.util.List;

public class DeadCell extends Cell {

    @Override
    public Cell nextGeneration(Neighbourhood neighbourhood) {
        if (neighbourhood.isFertileNeighborhood()) return Cell.live();
        return Cell.dead();
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
