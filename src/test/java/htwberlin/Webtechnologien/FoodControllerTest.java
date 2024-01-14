package htwberlin.Webtechnologien;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodControllerTest {

    private FoodService mockService;
    private FoodController controller;

    @BeforeEach
    public void setUp() {
        mockService = mock(FoodService.class);
        controller = new FoodController(mockService);
    }

    @Test
    public void testCreateFood() {
        // Arrange
        Food foodToCreate = new Food("Pizza", 15, "pizza-link");
        Food createdFood = new Food("Pizza", 15, "pizza-link");
        createdFood.setId(1L);

        when(mockService.save(foodToCreate)).thenReturn(createdFood);

        // Act
        Food result = controller.createFood(foodToCreate);

        // Assert
        assertNotNull(result);
        assertEquals(createdFood, result);
        assertEquals(1L, result.getId());
    }
}
