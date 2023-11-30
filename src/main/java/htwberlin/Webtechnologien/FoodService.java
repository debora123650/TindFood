package htwberlin.Webtechnologien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository repo;


    public Food save(Food food){
        return repo.save(food);
    }

    public Food get(Long id){
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Food> getAll(){
        return (List<Food>) repo.findAll();
    }

}
