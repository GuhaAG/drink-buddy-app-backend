package app.drinkbuddy.api.availableUsers.controllers;


import app.drinkbuddy.api.availableUsers.entities.AvailableUsersEntity;
import app.drinkbuddy.api.availableUsers.exceptions.AvailableUsersNotFoundException;
import app.drinkbuddy.api.availableUsers.services.AvailableUsersRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
class AvailableUsersController {

    private final AvailableUsersRepository availableUsersRepository;

    AvailableUsersController(AvailableUsersRepository availableUsersRepository) {
        this.availableUsersRepository = availableUsersRepository;
    }

    @GetMapping("/available")
    public List<AvailableUsersEntity> find() {
        return availableUsersRepository.findAll();
    }

    @GetMapping("/available/{id}")
    AvailableUsersEntity findById(@PathVariable Long id) {

        return availableUsersRepository.findById(id)
                .orElseThrow(() -> new AvailableUsersNotFoundException(id));
    }

    @PostMapping("/available")
    AvailableUsersEntity make(@RequestBody AvailableUsersEntity newAvailableUsersEntity) {
        newAvailableUsersEntity.setLastSeen(new Timestamp(System.currentTimeMillis()));
        return availableUsersRepository.save(newAvailableUsersEntity);
    }

    @PutMapping("/available/{id}")
    AvailableUsersEntity update(@RequestBody AvailableUsersEntity newAvailableUsersEntity, @PathVariable Long id) {

        return availableUsersRepository.findById(id)
                .map(user -> {
                    user.setBarName(newAvailableUsersEntity.getBarName());
                    user.setLatitude(newAvailableUsersEntity.getLatitude());
                    user.setLongitude(newAvailableUsersEntity.getLongitude());
                    user.setLastSeen(newAvailableUsersEntity.getLastSeen());
                    return availableUsersRepository.save(user);
                })
                .orElseGet(() -> {
                    newAvailableUsersEntity.setId(id);
                    return availableUsersRepository.save(newAvailableUsersEntity);
                });
    }

    @DeleteMapping("/available/{id}")
    void remove(@PathVariable Long id) {
        availableUsersRepository.deleteById(id);
    }
}
