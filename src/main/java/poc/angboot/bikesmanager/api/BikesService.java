package poc.angboot.bikesmanager.api;

import poc.angboot.bikesmanager.entity.Bike;

import java.math.BigDecimal;
import java.util.List;

public interface BikesService {
    List<Bike> list();
    Bike findBikeById(Integer id);
    Bike updateBikeDetail(Bike bike);
    void addNewBikeDetail(Bike bike);
}
