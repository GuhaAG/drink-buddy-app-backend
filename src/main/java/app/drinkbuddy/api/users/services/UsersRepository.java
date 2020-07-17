package app.drinkbuddy.api.users.services;


import app.drinkbuddy.api.users.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

}