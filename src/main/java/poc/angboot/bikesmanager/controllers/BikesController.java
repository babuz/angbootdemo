package poc.angboot.bikesmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import poc.angboot.bikesmanager.api.BikesService;
import poc.angboot.bikesmanager.entity.Bike;
import poc.angboot.bikesmanager.repositories.BikeRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController implements BikesService {

    @Autowired
    BikeRepository bikeRepository;

    @GetMapping
    @Override
    public List<Bike> list() {
        return bikeRepository.getAllBikes();
    }

    @GetMapping("/{id}")
    @Override
    public Bike findBikeById(long id) {
        Optional<Bike> bike =  bikeRepository.getBike(id);
        return bike.orElseGet(() -> null);
    }

    @PutMapping
    @Override
    @ResponseStatus(HttpStatus.OK)
    public Bike updateBikeDetail(Bike bike) {
        bikeRepository.updateBike(bike);
        return bike;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void addNewBikeDetail(@RequestBody Bike bike) {
        bikeRepository.createBike(bike);
    }
}
