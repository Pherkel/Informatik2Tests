package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FoodItemsTest {

    @Test
    @DisplayName("getFoodAtPos - food not in list")
    void getFoodAtPos_null() {
        FoodItems obj = new FoodItems();
        Food test_food = new Food(FoodType.BANANA, 10);
        obj.addFood(test_food, new Position(10, 5));

        assertThat(obj.getFoodAtPos(new Position(10, 10))).usingRecursiveComparison().isEqualTo(null);
    }

    @Test
    @DisplayName("getFoodAtPos - only food in list")
    void getFoodAtPos_1() {
        FoodItems obj = new FoodItems();
        Food test_food = new Food(FoodType.BANANA, 10);
        obj.addFood(test_food, new Position(10, 5));

        assertThat(obj.getFoodAtPos(new Position(10, 5))).usingRecursiveComparison().isEqualTo(test_food);
    }

    @Test
    void spoilAndRemoveOldFood() {
    }
}