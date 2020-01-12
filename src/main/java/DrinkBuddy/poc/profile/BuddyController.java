package DrinkBuddy.poc.profile;



        import java.util.List;

        import DrinkBuddy.poc.profile.entity.BuddyProfile;
        import DrinkBuddy.poc.profile.exceptions.BuddyNotFoundException;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

@RestController
class BuddyController {

    private final BuddyRepository repository;

    BuddyController(BuddyRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/Buddys")
    public  List<BuddyProfile> all() {
        return repository.findAll();
    }

    @PostMapping("/Buddys")
    BuddyProfile newBuddy(@RequestBody BuddyProfile newBuddyProfile) {
        return repository.save(newBuddyProfile);
    }

    // Single item

    @GetMapping("/Buddys/{id}")
    BuddyProfile one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BuddyNotFoundException(id));
    }

    @PutMapping("/Buddys/{id}")
    BuddyProfile replaceBuddy(@RequestBody BuddyProfile newBuddyProfile, @PathVariable Long id) {

        return repository.findById(id)
                .map(BuddyProfile -> {
                    BuddyProfile.setFirstName(newBuddyProfile.getFirstName());
                    BuddyProfile.setLastName(newBuddyProfile.getLastName());
                    BuddyProfile.setEmail(newBuddyProfile.getEmail());
                    BuddyProfile.setPhone(newBuddyProfile.getPhone());
                    BuddyProfile.setAboutMe(newBuddyProfile.getAboutMe());
                    return repository.save(BuddyProfile);
                })
                .orElseGet(() -> {
                    newBuddyProfile.setId(id);
                    return repository.save(newBuddyProfile);
                });
    }

    @DeleteMapping("/Buddys/{id}")
    void deleteBuddy(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
