package htwberlin.Webtechnologien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void testFoodConstructor() {
        Food food = new Food("Burger", 10, "burger-link");
        assertEquals("Burger", food.getName());
        assertEquals(10, food.getPrice());
        assertEquals("burger-link", food.getLink());
    }

    @Test
    public void testSettersAndGetters() {
        Food food = new Food();

        food.setName("Pizza");
        assertEquals("Pizza", food.getName());

        food.setPrice(15);
        assertEquals(15, food.getPrice());

        food.setLink("pizza-link");
        assertEquals("pizza-link", food.getLink());
    }
}
