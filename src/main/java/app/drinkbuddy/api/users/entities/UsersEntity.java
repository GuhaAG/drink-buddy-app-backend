package app.drinkbuddy.api.users.entities;

import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users", schema = "public")
public
class UsersEntity {

    private @Id
    @GeneratedValue
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String about;
    private Point geoPosition;

    public UsersEntity() {
    }

    public UsersEntity(String firstName, String lastName, String email, String phone, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.geoPosition = null;
    }
}