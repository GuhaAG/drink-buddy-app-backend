package DrinkBuddy.poc.util;


import DrinkBuddy.poc.profile.entity.BuddyProfile;
import DrinkBuddy.poc.profile.BuddyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class PreloadBuddies {

    @Bean
    CommandLineRunner initDatabase(BuddyRepository repository) {
        return args -> {
            repository.getOne((long) 3);
            log.info("Preloading " + repository.save(new BuddyProfile("Nikhil ", "Gulumkar","nikhil.gulumkar@gmail.com","9421170572","I wish I was drinking tonight")));
            log.info("Preloading " + repository.save(new BuddyProfile("Arghya ", "Guha","","9421170572","I am drinking. Cheers!")));
        };
    }
}