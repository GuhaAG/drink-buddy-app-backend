package app.drinkbuddy.api.users.controllers;


import app.drinkbuddy.api.users.services.UsersRepository;
import app.drinkbuddy.api.users.entities.UsersEntity;
import app.drinkbuddy.api.users.exceptions.UsersNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class UsersController {

    private final UsersRepository repository;

    UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<UsersEntity> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    UsersEntity newUsers(@RequestBody UsersEntity newUsersEntity) {
        return repository.save(newUsersEntity);
    }

    @GetMapping("/users/{id}")
    UsersEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    UsersEntity replaceUsers(@RequestBody UsersEntity newUsersEntity, @PathVariable Long id) {

        return repository.findById(id)
                .map(UsersEntity -> {
                    UsersEntity.setFirstName(newUsersEntity.getFirstName());
                    UsersEntity.setLastName(newUsersEntity.getLastName());
                    UsersEntity.setEmail(newUsersEntity.getEmail());
                    UsersEntity.setPhone(newUsersEntity.getPhone());
                    UsersEntity.setAbout(newUsersEntity.getAbout());
                    return repository.save(UsersEntity);
                })
                .orElseGet(() -> {
                    newUsersEntity.setId(id);
                    return repository.save(newUsersEntity);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUsers(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
