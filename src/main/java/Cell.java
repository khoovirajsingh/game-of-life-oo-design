public abstract class Cell {

    public static Cell dead() {
        return new DeadCell();
    }

    public static Cell live() {
        return new LiveCell();
    }

    public abstract Cell nextGeneration(Neighbourhood neighbourhood);

    public abstract boolean isAlive();

    @Override
    public boolean equals(Object o) {
        return getClass() == o.getClass();
    }

}
