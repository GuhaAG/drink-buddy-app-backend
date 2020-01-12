package DrinkBuddy.poc.available;


import DrinkBuddy.poc.available.entity.AvailableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableRepository extends JpaRepository<AvailableEntity, Long> {

}