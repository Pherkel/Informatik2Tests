package submission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.setMaxStackTraceElementsDisplayed;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("moveTowards - empty snake")
    void moveTowards_null() {

        Snake snake = new Snake();
        snake.setDirection(TravelDirection.UP);

        Position nextPos = snake.computeNextPosition();
        snake.moveTowards(nextPos, null);

        // expected result
        Snake test_snake = new Snake();
        //test_snake.addPieceAtTail(new Position(1, 0), food);
        test_snake.setDirection(TravelDirection.UP);

        assertThat(test_snake).usingRecursiveComparison().isEqualTo(snake);
    }

    @Test
    @DisplayName("moveTowards - shift snake along (length 1)")
    void moveTowards_0() {
        Food food = new Food(FoodType.BANANA, 10);

        Snake snake = new Snake();
        // adding a few nodes to the snake
        snake.addPieceAtTail(new Position(1, 1), food);
        snake.setDirection(TravelDirection.UP);

        Position nextPos = snake.computeNextPosition();
        snake.moveTowards(nextPos, food);

        // expected result
        Snake test_snake = new Snake();
        test_snake.addPieceAtTail(new Position(1, 0), food);
        test_snake.setDirection(TravelDirection.UP);

        assertThat(test_snake).usingRecursiveComparison().isEqualTo(snake);
    }

    @Test
    @DisplayName("moveTowards - shift snake along")
    void moveTowards_1() {
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
        ISnake test_snake = new Snake();
        test_snake.addPieceAtTail(new Position(1, 0), food);
        test_snake.addPieceAtTail(new Position(1, 1), food);
        test_snake.addPieceAtTail(new Position(2, 1), food);
        test_snake.addPieceAtTail(new Position(3, 1), food);
        test_snake.setDirection(TravelDirection.UP);

        Assertions.assertTrue(snake.getHead().equals((SnakePiece) test_snake.getHead()));
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
    @DisplayName("reverse - direction")
    void reverse_2_pieces() {
        Snake snake = new Snake();

        Food food = new Food(FoodType.BANANA, 10);
        // adding two pieces
        Position pos1 = new Position(0, 0);
        snake.addPieceAtTail(pos1, food);

        Position pos2 = new Position(1, 0);
        snake.addPieceAtTail(pos2, food);

        snake.setDirection(TravelDirection.RIGHT);

        snake.reverse();

        // should not change direction
        assertEquals(TravelDirection.RIGHT, snake.getDirection());
    }

    @Test
    @DisplayName("reverse - listorder")
    void reverse_listorder() {
        Snake snake = new Snake();

        Food food = new Food(FoodType.BANANA, 10);
        // adding two pieces
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);
        Position pos3 = new Position(1, 1);
        Position pos4 = new Position(1, 2);

        snake.addPieceAtTail(pos1, food);
        snake.addPieceAtTail(pos2, food);
        snake.addPieceAtTail(pos3, food);
        snake.addPieceAtTail(pos4, food);
        snake.setDirection(TravelDirection.RIGHT);

        snake.reverse();

        Snake expected_snake = new Snake();
        expected_snake.addPieceAtTail(pos4, food);
        expected_snake.addPieceAtTail(pos3, food);
        expected_snake.addPieceAtTail(pos2, food);
        expected_snake.addPieceAtTail(pos1, food);
        snake.setDirection(TravelDirection.DOWN);

        ISnakePiece current = snake.getHead();
        ISnakePiece current_exp = expected_snake.getHead();

        while (current != null && current_exp != null) {
            assertTrue(current.getPosition().equals(current_exp.getPosition()));
            assertTrue(current.getNext().equals(current_exp.getNext()));
            current = current.getNext();
            current_exp = current_exp.getNext();
        }
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
    void addPieceAtTail_1() {
        Snake snake = new Snake();
        snake.addPieceAtTail(new Position(0, 0), new Food(FoodType.STRAWBERRY, 10));
        snake.addPieceAtTail(new Position(1, 0), new Food(FoodType.BANANA, 11));
        snake.addPieceAtTail(new Position(2, 0), new Food(FoodType.CABBAGE, 12));
        snake.addPieceAtTail(new Position(3, 0), new Food(FoodType.STRAWBERRY, 13));


        SnakePiece test_snake_head = new SnakePiece(new Food(FoodType.STRAWBERRY, 10), new Position(0, 0),
                new SnakePiece(new Food(FoodType.BANANA, 11), new Position(1, 0),
                        new SnakePiece(new Food(FoodType.CABBAGE, 12), new Position(2, 0),
                                new SnakePiece(new Food(FoodType.STRAWBERRY, 13), new Position(3, 0), null))));

        Assertions.assertTrue(snake.getHead().equals(test_snake_head));
    }

    @Test
    @DisplayName("cutTailAt")
    void cutTailAt() {
        Snake snake = new Snake();
        snake.addPieceAtTail(new Position(0, 0), new Food(FoodType.STRAWBERRY, 10));
        snake.addPieceAtTail(new Position(1, 0), new Food(FoodType.BANANA, 11));
        snake.addPieceAtTail(new Position(2, 0), new Food(FoodType.CABBAGE, 12));
        snake.addPieceAtTail(new Position(3, 0), new Food(FoodType.STRAWBERRY, 13));

    }
}