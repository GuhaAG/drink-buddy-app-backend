package DrinkBuddy.poc.profile.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "buddy_profile",schema = "public")
public
class BuddyProfile {

    private @Id
    @GeneratedValue
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String aboutMe;

    public BuddyProfile() {
    }

    public BuddyProfile(String firstName, String lastName, String email, String phone, String aboutMe) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.aboutMe = aboutMe;
    }
}