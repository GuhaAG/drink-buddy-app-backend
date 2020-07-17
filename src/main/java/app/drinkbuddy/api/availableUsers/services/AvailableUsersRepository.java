package app.drinkbuddy.api.availableUsers.services;


import app.drinkbuddy.api.availableUsers.entities.AvailableUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableUsersRepository extends JpaRepository<AvailableUsersEntity, Long> {

}