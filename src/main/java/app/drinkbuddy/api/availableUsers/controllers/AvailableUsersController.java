package app.drinkbuddy.api.availableUsers.controllers;


import app.drinkbuddy.api.availableUsers.services.AvailableUsersRepository;
import app.drinkbuddy.api.availableUsers.entities.AvailableUsersEntity;
import app.drinkbuddy.api.availableUsers.exceptions.AvailableUsersNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class AvailableUsersController {

    private final AvailableUsersRepository availableUsersRepository;

    AvailableUsersController(AvailableUsersRepository availableUsersRepository) {
        this.availableUsersRepository = availableUsersRepository;
    }

    // Aggregate root

    @GetMapping("/available")
    public List<AvailableUsersEntity> all() {
        return availableUsersRepository.findAll();
    }

    @PostMapping("/available")
    AvailableUsersEntity newAvailableUsers(@RequestBody AvailableUsersEntity newAvailableUsersEntity) {
        return availableUsersRepository.save(newAvailableUsersEntity);
    }

    // Single item

    @GetMapping("/available/{id}")
    AvailableUsersEntity one(@PathVariable Long id) {

        return availableUsersRepository.findById(id)
                .orElseThrow(() -> new AvailableUsersNotFoundException(id));
    }

    @PutMapping("/available/{id}")
    AvailableUsersEntity replaceAvailableUsers(@RequestBody AvailableUsersEntity newAvailableUsersEntity, @PathVariable Long id) {

        return availableUsersRepository.findById(id)
                .map(BuddyProfile -> {
                    BuddyProfile.setBarName(newAvailableUsersEntity.getBarName());
                    BuddyProfile.setLatitude(newAvailableUsersEntity.getLatitude());
                    BuddyProfile.setLongitude(newAvailableUsersEntity.getLongitude());
                    BuddyProfile.setLastSeen(newAvailableUsersEntity.getLastSeen());
                    return availableUsersRepository.save(BuddyProfile);
                })
                .orElseGet(() -> {
                    newAvailableUsersEntity.setId(id);
                    return availableUsersRepository.save(newAvailableUsersEntity);
                });
    }

    @DeleteMapping("/available/{id}")
    void deleteAvailableUsers(@PathVariable Long id) {
        availableUsersRepository.deleteById(id);
    }
}
