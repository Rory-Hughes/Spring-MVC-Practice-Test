package ITSD.Service;

import ITSD.Entity.Equipment;
import ITSD.Model.EquipmentEditForm;
import ITSD.Repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository repository;

    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    public List<Equipment> findAll() {
        // TODO Read the equipment in asset-tag order.
        return List.of();
    }

    public Optional<Equipment> findById(long id) {
        // TODO Look up the requested equipment.
        return Optional.empty();
    }

    public boolean update(long id, EquipmentEditForm form) {
        // TODO Update the existing record and report whether it was found.
        return false;
    }
}
