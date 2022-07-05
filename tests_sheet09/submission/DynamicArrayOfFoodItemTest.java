package submission;

import org.junit.jupiter.api.Test;

import static org.hamcrest.collection.ArrayMatching.arrayContainingInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.collection.ArrayMatching.arrayContaining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

class DynamicArrayOfFoodItemTest {

    @Test
    void getVal() {
    }

    @Test
    void putVal() {
    }

    @Test
    void putValLast_test() {
        DynamicArrayOfFoodItem array = new DynamicArrayOfFoodItem();
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 10), new Position(10, 10)));

        FoodItem[] test_array = {new FoodItem(new Food(FoodType.BANANA, 10), new Position(10, 10))};

        assertThat(array.getArray(), arrayContainingInAnyOrder(test_array));
    }

    @Test
    void removeVal() {
        DynamicArrayOfFoodItem array = new DynamicArrayOfFoodItem();
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 10), new Position(10, 10)));
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 9), new Position(10, 10)));
        array.putValLast(new FoodItem(new Food(FoodType.BANANA, 11), new Position(10, 10)));

        Food remove = new Food(FoodType.BANANA, 9);
        for (int index = 0; index < array.getTotalLength(); index++) {
            if (remove.getType() == array.getVal(index).getFood().getType() && remove.getBestBefore() == array.getVal(index).getFood().getBestBefore()) {
                array.removeVal(index);
                break;
            }
        }
        
        assertThat(array.getArray(), arrayContaining());
    }
}