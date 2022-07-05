package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.ArrayMatching.arrayContainingInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayOfFoodItemTest {

    @Test
    void growSize() {
        DynamicArrayOfFoodItem foodArray = new DynamicArrayOfFoodItem();
        foodArray.growSize();
        assertEquals(2, foodArray.getTotalLength());
    }

    @Test
    void putVal() {
        DynamicArrayOfFoodItem foodArray = new DynamicArrayOfFoodItem();
        Food food1 = new Food(FoodType.BANANA, 1);
        Food food2 = new Food(FoodType.BLUEBERRY, 1);
        Food food3 = new Food(FoodType.CABBAGE, 1);
        Food food4 = new Food(FoodType.STRAWBERRY, 1);

        foodArray.putValLast(new FoodItem(food1, new Position(0, 0)));
        foodArray.putValLast(new FoodItem(food2, new Position(0, 0)));
        // should now grow array
        foodArray.putValLast(new FoodItem(food3, new Position(0, 0)));
        foodArray.putValLast(new FoodItem(food4, new Position(0, 0)));

        assertEquals(4, foodArray.getTotalLength());

    }

    @Test
    @DisplayName("putValLast - add 4 Objects")
    void putValLast_0() {
        DynamicArrayOfFoodItem foodArray = new DynamicArrayOfFoodItem();
        Food food1 = new Food(FoodType.BANANA, 1);
        Food food2 = new Food(FoodType.BLUEBERRY, 1);
        Food food3 = new Food(FoodType.CABBAGE, 1);
        Food food4 = new Food(FoodType.STRAWBERRY, 1);

        foodArray.putValLast(new FoodItem(food1, new Position(0, 0)));
        foodArray.putValLast(new FoodItem(food2, new Position(0, 0)));
        // should now grow array
        foodArray.putValLast(new FoodItem(food3, new Position(0, 0)));
        foodArray.putValLast(new FoodItem(food4, new Position(0, 0)));

        assertEquals(4, foodArray.getTotalLength());
    }

    @Test
    @DisplayName("putValLast - add 5 Objects")
    void putValLast_1() {
        DynamicArrayOfFoodItem foodArray = new DynamicArrayOfFoodItem();
        Food food1 = new Food(FoodType.BANANA, 1);
        Food food2 = new Food(FoodType.BLUEBERRY, 1);
        Food food3 = new Food(FoodType.CABBAGE, 1);
        Food food4 = new Food(FoodType.STRAWBERRY, 1);

        foodArray.putValLast(new FoodItem(food1, new Position(0, 0)));
        foodArray.putValLast(new FoodItem(food2, new Position(0, 0)));
        // should now grow array
        foodArray.putValLast(new FoodItem(food3, new Position(0, 0)));
        foodArray.putValLast(new FoodItem(food4, new Position(0, 0)));
        // should now double array size again
        foodArray.putValLast(new FoodItem(food2, new Position(0, 0)));

        assertEquals(8, foodArray.getTotalLength());
    }

    @Test
    @DisplayName("putValLast - Array Equality test")
    void putValLast_test() {
        DynamicArrayOfFoodItem array = new DynamicArrayOfFoodItem();
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 10), new Position(10, 10)));
        array.putValLast(new FoodItem(new Food(FoodType.STRAWBERRY, 900), new Position(0, 0)));

        FoodItem[] test_array = {new FoodItem(new Food(FoodType.BANANA, 10), new Position(10, 10)),
                new FoodItem(new Food(FoodType.STRAWBERRY, 900), new Position(0, 0))
        };

        for (int i = 0; i < array.getTotalLength(); i++) {
            assertThat(array.getVal(i)).usingRecursiveComparison().isEqualTo(test_array[i]);
        }
    }

    @Test
    @DisplayName("removeVal")
    void removeVal() {
        DynamicArrayOfFoodItem array = new DynamicArrayOfFoodItem();
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 10), new Position(10, 10)));
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 9), new Position(10, 10)));
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 11), new Position(10, 10)));

        array.removeVal(1);

        FoodItem[] test_array = new FoodItem[array.getTotalLength()];
        test_array[0] = new FoodItem(new Food(FoodType.BANANA, 10), new Position(10, 10));
        test_array[1] = new FoodItem(new Food(FoodType.BANANA, 11), new Position(10, 10));

        for (int i = 0; i < array.getTotalLength(); i++) {
            assertThat(array.getVal(i)).usingRecursiveComparison().isEqualTo(test_array[i]);
        }
    }
}