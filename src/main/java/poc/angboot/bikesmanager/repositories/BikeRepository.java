package poc.angboot.bikesmanager.repositories;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.stereotype.Repository;
import poc.angboot.bikesmanager.entity.Bike;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class BikeRepository {
    private static Set<Bike> bikes = new HashSet<> ();

    static {
        bikes.add(new Bike(100,"first name","g@g.com", new BigDecimal(100.45), new Date(),false));
        bikes.add(new Bike(101,"Second name","a@aa.com", new BigDecimal(500.50), new Date(),true));
    }

    public List<Bike> getAllBikes(){
        return new ArrayList<Bike>(bikes);
    }

    public Optional<Bike> getBike(long id){
        return bikes.stream()
                .filter(bike -> bike.getId() == id)
                .findFirst();
    }


    public void createBike(Bike bike){
        if(!bikes.contains(bike))
            bikes.add(bike);
    }

    public void updateBike(Bike bike){
        bikes.removeIf(b -> b.getEmail().equals(bike.getEmail()));
        bikes.add(bike);
    }

    public void deleteBike(long id){
        bikes.removeIf(b -> b.getId() == id);
    }
}
