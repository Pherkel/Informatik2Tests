package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreenMonkeyTest {

    @Test
    @DisplayName("Plant > Mass * 0.3")
    void eatPlant() {
        Plant plant = new Plant(1, 0.5f);
        GreenMonkey monkey = new GreenMonkey();
        monkey.eatPlant(plant);
        assertEquals(1.035, monkey.getMassInKg(), 0.05);
    }
}