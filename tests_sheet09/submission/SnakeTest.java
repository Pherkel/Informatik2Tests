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
    void addPieceAtTail() {
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
    void getPieceAtPos() {
    }

    @Test
    void computeNextPosition() {
    }

    @Test
    void moveTowards() {
    }

    @Test
    void reverse() {
    }

    @Test
    void cutTailAt() {
    }
}