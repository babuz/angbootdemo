package poc.angboot.bikesmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import poc.angboot.bikesmanager.api.BikesService;
import poc.angboot.bikesmanager.entity.Bike;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController implements BikesService {

    @GetMapping
    @Override
    public List<Bike> list() {
        List<Bike> bikes = new ArrayList<>();
        return bikes;
    }

    @GetMapping("/{id}")
    @Override
    public Bike findBikeById(Integer id) {
        return new Bike();
    }

    @Override
    public Bike updateBikeDetail(Bike bike) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void addNewBikeDetail(@RequestBody Bike bike) {

    }
}
