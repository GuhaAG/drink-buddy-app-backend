package DrinkBuddy.poc.profile.entity;


import org.springframework.data.jpa.repository.JpaRepository;

 interface BuddyRepository extends JpaRepository<BuddyProfile, Long> {

}