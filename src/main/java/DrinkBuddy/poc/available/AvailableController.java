package DrinkBuddy.poc.available;


import DrinkBuddy.poc.available.entity.AvailableEntity;
import DrinkBuddy.poc.available.exceptions.AvailableNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class AvailableController {

    private final AvailableRepository availableRepository;

    AvailableController(AvailableRepository availableRepository) {
        this.availableRepository = availableRepository;
    }

    // Aggregate root

    @GetMapping("/Available")
    public  List<AvailableEntity> all() {
        return availableRepository.findAll();
    }

    @PostMapping("/Available")
    AvailableEntity newAvailable(@RequestBody AvailableEntity newAvailableEntity) {
        return availableRepository.save(newAvailableEntity);
    }

    // Single item

    @GetMapping("/Available/{id}")
    AvailableEntity one(@PathVariable Long id) {

        return availableRepository.findById(id)
                .orElseThrow(() -> new AvailableNotFoundException(id));
    }

    @PutMapping("/Available/{id}")
    AvailableEntity replaceAvailable(@RequestBody AvailableEntity newAvailableEntity, @PathVariable Long id) {

        return availableRepository.findById(id)
                .map(BuddyProfile -> {
                    BuddyProfile.setBarName(newAvailableEntity.getBarName());
                    BuddyProfile.setLatitude(newAvailableEntity.getLatitude());
                    BuddyProfile.setLongitude(newAvailableEntity.getLongitude());
                    BuddyProfile.setLastSeen(newAvailableEntity.getLastSeen());
                    return availableRepository.save(BuddyProfile);
                })
                .orElseGet(() -> {
                    newAvailableEntity.setId(id);
                    return availableRepository.save(newAvailableEntity);
                });
    }

    @DeleteMapping("/Available/{id}")
    void deleteBuddy(@PathVariable Long id) {
        availableRepository.deleteById(id);
    }
}
