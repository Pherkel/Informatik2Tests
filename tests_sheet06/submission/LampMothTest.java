package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LampMothTest {

    @Test
    @DisplayName("Update Forces Simple")
    void updateForcesSimple() {

        LampMoth lamp_moth = new LampMoth(10, 10);
        MothSimulation sim = new MothSimulation();
        StaticLamp lamp = new StaticLamp(0,0);

        sim.addLamp(lamp);
        lamp_moth.updateForces(sim);

        assertEquals(lamp_moth.acceleration.x, lamp.computeAttraction(lamp_moth).x);
        assertEquals(lamp_moth.acceleration.y, lamp.computeAttraction(lamp_moth).y);
    }

    @Test
    @DisplayName("Update Forces No Lamp")
    void updateForcesNoLamp() {

        LampMoth lamp_moth = new LampMoth(10, 10);
        MothSimulation sim = new MothSimulation();

        lamp_moth.updateForces(sim);

        assertEquals(lamp_moth.acceleration.x, 0);
        assertEquals(lamp_moth.acceleration.y, 0);
    }

    @Test
    @DisplayName("Update Forces Two Lamps")
    void updateForcesTwoLamps() {

        LampMoth lamp_moth = new LampMoth(10, 10);
        MothSimulation sim = new MothSimulation();
        StaticLamp lamp1 = new StaticLamp(0, 0);
        StaticLamp lamp2 = new StaticLamp(5,5);
        sim.addLamp(lamp1);
        sim.addLamp(lamp2);

        lamp_moth.updateForces(sim);
        float brightness = lamp1.getBrightness();
        assertEquals(lamp2.computeAttraction(lamp_moth).x,  lamp_moth.acceleration.x);
        assertEquals(lamp2.computeAttraction(lamp_moth).y, lamp_moth.acceleration.y);
    }
}