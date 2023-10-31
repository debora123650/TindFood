package htwberlin.Webtechnologien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {

    @Autowired
    FoodService service;

    @PostMapping("/food")
    public Food createFood(@RequestBody Food food){
        return service.save(food);
    }

    @GetMapping("/food/{id}")
    public Food fetFood(@PathVariable String id){
        long foodId = Long.parseLong(id);
        return service.get(foodId);
    }

}
