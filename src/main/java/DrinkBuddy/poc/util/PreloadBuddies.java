package DrinkBuddy.poc.util;


import DrinkBuddy.poc.available.AvailableRepository;
import DrinkBuddy.poc.available.entity.AvailableEntity;
import DrinkBuddy.poc.profile.entity.BuddyProfile;
import DrinkBuddy.poc.profile.BuddyRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class PreloadBuddies {

    @Bean
    CommandLineRunner initDatabase(BuddyRepository repository,AvailableRepository availableRepository) {
        return args -> {
            log.info("Preloading " + repository.save(new BuddyProfile("Nikhil ", "Gulumkar","nikhil.gulumkar@gmail.com","9421170572","I wish I was drinking tonight")));
            log.info("Preloading " + repository.save(new BuddyProfile("Arghya ", "Guha","","9421170572","I am drinking. Cheers!")));
            log.info("Updating Availability " + availableRepository.save(new AvailableEntity(1L,"Hub-Roppongi",35.662222, 139.734098,new DateTime().getMillis())));

        };
    }

/*    @Bean
    CommandLineRunner initDatabase(AvailableRepository availableRepository) {
        return args -> {
            log.info("Preloading " + availableRepository.save(new AvailableEntity(1L,"Hub-Roppongi",35.662222, 139.734098,new DateTime().getMillis())));
        };
    }*/
}