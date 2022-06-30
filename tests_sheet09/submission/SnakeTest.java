package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

class SnakeTest {

    @Test
    @DisplayName("end tail at empty snake")
    void addPieceAtTail_empty() {
        Snake snake = new Snake();
        Position pos = new Position(1, 1);
        Food food = new Food(FoodType.BANANA, 10);
        snake.addPieceAtTail(pos, food);

        Snake test_snake = new Snake();
        test_snake.head = new SnakePiece(food, pos, null);
        test_snake.tail = test_snake.head;

        // comparing actual value of object instead of reference
        assertThat(snake).usingRecursiveComparison().isEqualTo(test_snake);
    }

    @Test
    @DisplayName("getPieceAtPos - snake is not at position (simple)")
    void getPieceAtPos_simple() {
        Position test_pos = new Position(10, 10);
        Snake snake = new Snake();

        assertThat(snake.getPieceAtPos(test_pos)).usingRecursiveComparison().isEqualTo(null);
    }

    @Test
    @DisplayName("getPieceAtPos - snake is not at position")
    void getPieceAtPos_false() {
        Position test_pos = new Position(10, 10);
        Position snake_pos = new Position(1, 50);
        Food food = new Food(FoodType.BANANA, 10);
        Snake snake = new Snake();

        snake.addPieceAtTail(snake_pos, food);
        assertThat(snake.getPieceAtPos(test_pos)).usingRecursiveComparison().isEqualTo(null);
    }

    @Test
    @DisplayName("getPieceAtPos - snake is at position")
    void getPieceAtPos_true() {
        Position test_pos = new Position(1, 50);

        Position snake_pos = new Position(1, 50);
        Food food = new Food(FoodType.BANANA, 10);
        Snake snake = new Snake();
        snake.addPieceAtTail(snake_pos, food);

        SnakePiece test_piece = new SnakePiece(food, test_pos, null);

        assertThat(test_piece).usingRecursiveComparison().isEqualTo(snake.getPieceAtPos(test_pos));
    }

    @Test
    void computeNextPosition() {
    }

    @Test
    @DisplayName("moveTowards - shift snake along")
    void moveTowards() {
        Food food = new Food(FoodType.BANANA, 10);

        Snake snake = new Snake();
        // adding a few nodes to the snake
        snake.addPieceAtTail(new Position(1, 1), food);
        snake.addPieceAtTail(new Position(2, 1), food);
        snake.addPieceAtTail(new Position(3, 1), food);
        snake.setDirection(TravelDirection.UP);

        Position nextPos = snake.computeNextPosition();
        snake.moveTowards(nextPos, food);

        // expected result
        Snake test_snake = new Snake();
        test_snake.addPieceAtTail(new Position(1, 0), food);
        test_snake.addPieceAtTail(new Position(1, 1), food);
        test_snake.addPieceAtTail(new Position(2, 1), food);
        test_snake.setDirection(TravelDirection.UP);

        assertThat(test_snake).usingRecursiveComparison().isEqualTo(snake);
    }

    @Test
    @DisplayName("moveTowards - shift snake along")
    void moveTowards_2() {
        Food food = new Food(FoodType.BANANA, 10);

        Snake snake = new Snake();
        // adding a few nodes to the snake
        snake.addPieceAtTail(new Position(10, 25), food);
        snake.addPieceAtTail(new Position(11, 25), food);
        snake.addPieceAtTail(new Position(11, 26), food);
        snake.setDirection(TravelDirection.LEFT);

        Position nextPos = snake.computeNextPosition();
        snake.moveTowards(nextPos, food);

        // expected result
        Snake test_snake = new Snake();
        test_snake.addPieceAtTail(new Position(9, 25), food);
        test_snake.addPieceAtTail(new Position(10, 25), food);
        test_snake.addPieceAtTail(new Position(11, 25), food);
        test_snake.setDirection(TravelDirection.LEFT);

        assertThat(test_snake).usingRecursiveComparison().isEqualTo(snake);
    }

    @Test
    @DisplayName("reverse - more than one piece")
    void reverse_2_pieces() {
        Snake snake = new Snake();

        Food food = new Food(FoodType.BANANA, 10);
        // adding two pieces
        Position pos1 = new Position(0, 0);
        snake.addPieceAtTail(pos1, food);

        Position pos2 = new Position(1, 0);
        snake.addPieceAtTail(pos2, food);

        snake.setDirection(TravelDirection.UP);

        snake.reverse();

        // should not change direction
        assertEquals(TravelDirection.UP, snake.getDirection());

    }

    @Test
    @DisplayName("reverse - zero pieces")
    void reverse_zero_pieces() {
        Snake snake = new Snake();

        Food food = new Food(FoodType.BANANA, 10);

        snake.setDirection(TravelDirection.UP);

        snake.reverse();

        // should not change direction
        assertEquals(TravelDirection.DOWN, snake.getDirection());

    }

    @Test
    void cutTailAt() {
    }
}