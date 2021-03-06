package pl.onlinestore.pet.adapters.mysql.accessories;

import lombok.*;
import pl.onlinestore.pet.domain.accessory.Accessory;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * SuperClass for Accessories object
 */
@Entity(name = "accessories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "accessory_type", discriminatorType = DiscriminatorType.STRING)
public class AccessoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String petType;
    private byte[] image;
    private String description;
    private BigDecimal price;

    public Accessory asAccessory() {
        return new Accessory(
                id,
                name,
                petType,
                image,
                description,
                price
        );
    }
}
