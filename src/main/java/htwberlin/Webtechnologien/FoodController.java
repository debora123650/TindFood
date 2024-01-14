package htwberlin.Webtechnologien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class FoodController {

    private final FoodService service;

    @Autowired
    public FoodController(FoodService service) {
        this.service = service;
    }


    @PostMapping("/foods")
    public Food createFood(@RequestBody Food food){
        return service.save(food);
    }

    @GetMapping("/foods/{id}")
    public Food fetFood(@PathVariable String id){
        long foodId = Long.parseLong(id);
        return service.get(foodId);
    }

    @GetMapping("/foods")
    public List<Food> fetFood(){
        return service.getAll();
    }

}