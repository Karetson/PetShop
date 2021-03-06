package pl.onlinestore.pet.domain.accessory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.onlinestore.pet.adapters.mysql.accessories.AccessoryEntity;
import pl.onlinestore.pet.api.accessory.dto.CreateAccessoryRequest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Service class for Pet object
 * Initialized methods for Pet object with CRUD in PetController
 */
@Service
@RequiredArgsConstructor
public class AccessoryFacade {

    private final AccessoryRepository accessoryRepository;

    // Methods for Controller from Repository
    public Accessory getAccessory(long id) {
        return accessoryRepository.findById(id).map(AccessoryEntity::asAccessory).orElseThrow();
    }

    public List<Accessory> getAccessories() {
        return accessoryRepository.findAll().stream().map(AccessoryEntity::asAccessory).collect(Collectors.toList());
    }

    @Transactional
    public Accessory addAccessory(CreateAccessoryRequest accessory) {
        return accessoryRepository.save(accessory.asAccessory()).asAccessory();
    }

    @Transactional
    public Accessory putAccessory(long id, CreateAccessoryRequest accessory) {
        return accessoryRepository.save(accessory.asAccessory(id)).asAccessory();
    }

    @Transactional
    public void deleteAccessory(long id) {
        accessoryRepository.deleteById(id);
    }
}
