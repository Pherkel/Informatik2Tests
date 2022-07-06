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
    @DisplayName("putValLast - Array Equality test")
    void putValLast_test() {
        FoodItems obj = new FoodItems();
        obj.addFood(new Food(FoodType.BANANA, 10), new Position(10, 10));
        obj.addFood(new Food(FoodType.STRAWBERRY, 900), new Position(0, 0));

        Food[] foodArray = {new Food(FoodType.BANANA, 10),
                new Food(FoodType.STRAWBERRY, 900)
        };

        Position[] posArray = {new Position(10, 10), new Position(0, 0)};

        for (int i = 0; i < obj.getNumFoodItems(); i++) {
            assertThat(obj.getFoodArray()[i]).usingRecursiveComparison().isEqualTo(foodArray[i]);
        }

        for (int i = 0; i < obj.getNumFoodItems(); i++) {
            assertThat(obj.getPosArray()[i]).usingRecursiveComparison().isEqualTo(posArray[i]);
        }
    }

    @Test
    @DisplayName("removeVal")
    void removeVal() {
        FoodItems obj = new FoodItems();
        obj.addFood(new Food(FoodType.BANANA, 10), new Position(10, 10));
        obj.addFood(new Food(FoodType.BANANA, 9), new Position(10, 10));
        obj.addFood(new Food(FoodType.BANANA, 11), new Position(10, 10));

        obj.removeFood(new Food(FoodType.BANANA, 9));

        Food[] foodArray = new Food[obj.getFoodArray().length];
        foodArray[0] = new Food(FoodType.BANANA, 10);
        foodArray[1] = new Food(FoodType.BANANA, 11);

        for (int i = 0; i < foodArray.length; i++) {
            assertThat(obj.getFoodArray()).usingRecursiveComparison().isEqualTo(foodArray);
        }
    }

    @Test
    @DisplayName("spoilAndRemoveOldFood")
    void spoilAndRemoveOldFood() {
        FoodItems foods = new FoodItems();

        foods.addFood(new Food(FoodType.STRAWBERRY, 10), new Position(0, 0));
        foods.addFood(new Food(FoodType.BANANA, 14), new Position(0, 0));
        foods.addFood(new Food(FoodType.CABBAGE, 9), new Position(0, 0));

        foods.spoilAndRemoveOldFood(8);
        foods.spoilAndRemoveOldFood(11);

        foods.spoilAndRemoveOldFood(110);
        System.out.println("test finished");
    }
}