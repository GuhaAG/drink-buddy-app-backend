package app.drinkbuddy.api.availableUsers.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "available_users", schema = "public")
public class AvailableUsersEntity {

    private @Id
    @GeneratedValue
    Long id;
    private Long userId;
    private String barName;
    private double longitude;
    private double latitude;
    private Long lastSeen;


    public AvailableUsersEntity() {
    }

    public AvailableUsersEntity(Long userId, String barName, double longitude, double latitude, Long lastSeen) {
        this.userId = userId;
        this.barName = barName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.lastSeen = lastSeen;
    }
}