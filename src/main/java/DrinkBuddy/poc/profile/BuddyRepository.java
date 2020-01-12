package DrinkBuddy.poc.profile;


import DrinkBuddy.poc.profile.entity.BuddyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface BuddyRepository extends JpaRepository<BuddyProfile, Long> {

}