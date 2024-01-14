package htwberlin.Webtechnologien;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodServiceTest {

    @Test
    void testSaveFood() {

        FoodRepository mockRepo = mock(FoodRepository.class);


        FoodService foodService = new FoodService(mockRepo);


        Food foodToSave = new Food("Pizza", 15, "pizza-link");
        Food savedFood = new Food("Pizza", 20, "pizza-link");


        when(mockRepo.save(foodToSave)).thenReturn(savedFood);


        Food result = foodService.save(foodToSave);


        assertEquals(savedFood, result);
    }
}
