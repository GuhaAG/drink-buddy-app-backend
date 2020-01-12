package DrinkBuddy.poc.available.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "available",schema = "public")
public
class AvailableEntity {


    private @Id
    @GeneratedValue
    Long id;
    private Long buddyId;
    private String barName;
    private double longitude;
    private double latitude;
    private Long lastSeen;


    public AvailableEntity(){}
    public AvailableEntity(Long buddyId,String barName,  double longitude, double latitude, Long lastSeen) {
        this.buddyId = buddyId;
        this.barName = barName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.lastSeen = lastSeen;
    }
}