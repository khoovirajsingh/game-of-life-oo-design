import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameOfLifeShould {
    @Test
    public void two_worlds_with_a_cell_in_a_different_location_are_not_equals() {
        World world = aWorld();
        world.add(new Location(1, 1), Cell.live());

        World anotherWorld = aWorld();
        anotherWorld.add(new Location(2, 2), Cell.live());

        assertThat(anotherWorld, is(not(world)));
    }

    @Test
    public void two_worlds_with_a_cell_in_the_same_location_are_equals() {
        World world = aWorld();
        world.add(new Location(1, 1), Cell.live());

        World anotherWorld = aWorld();
        anotherWorld.add(new Location(1, 1), Cell.live());

        assertThat(anotherWorld, is(world));
    }

    @Test
    public void simple_evolution() {
        World world = aWorld();
        world.add(new Location(0, 0), Cell.live());
        world.add(new Location(0, 1), Cell.live());
        world.add(new Location(0, 2), Cell.live());

        World newWorld = world.evolve();

        World evolved = aWorld();
        evolved.add(new Location(0, 1), Cell.live());
        evolved.add(new Location(1, 1), Cell.live());

        assertThat(evolved, is(newWorld));
    }

    @Test
    void when_all_neighbours_are_dead_the_dead_cell_will_die() {
        List<Cell> neighbours = asList(
                Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead(),
                Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead()
        );

        Cell nextGeneration = Cell.dead().nextGeneration(new Neighbourhood(neighbours));

        assertThat(Cell.dead(), is(nextGeneration));
    }

    @Test
    void when_all_neighbours_are_dead_the_alive_cell_will_die() {
        List<Cell> neighbours = asList(
                Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead(),
                Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead()
        );

        Cell nextGeneration = Cell.live().nextGeneration(new Neighbourhood(neighbours));

        assertThat(Cell.dead(), is(nextGeneration));
    }

    @Test
    public void a_dead_cell_with_exactly_three_live_neighbours_becomes_a_live_cell() {
        List<Cell> neighbors = asList(
                Cell.live(), Cell.live(), Cell.live(),
                Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead()
        );
        Cell nextGenerationCell = Cell.dead().nextGeneration(new Neighbourhood(neighbors));

        assertThat(Cell.live(), is(nextGenerationCell));
    }

    @Test
    public void a_dead_cell_with_two_live_neighbours_remains_dead() {
        List<Cell> neighbors = asList(
                Cell.live(), Cell.live(), Cell.dead(),
                Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead(), Cell.dead()
        );
        Cell nextGenerationCell = Cell.dead().nextGeneration(new Neighbourhood(neighbors));

        assertThat(Cell.dead(), is(nextGenerationCell));
    }

    private static World aWorld() {
        return new World(3, 3);
    }
}
