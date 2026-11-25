package ITSD.Service;

import ITSD.Entity.Equipment;
import ITSD.Model.EquipmentEditForm;
import ITSD.Repository.EquipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository repository;

    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    public List<Equipment> findAll() {
        return repository.findAllByOrderByAssetTagAsc();
    }

    public Optional<Equipment> findById(long id) {
        return repository.findById(id);
    }

    @Transactional
    public boolean update(long id, EquipmentEditForm form) {
        Optional<Equipment> result = repository.findById(id);
        if (result.isEmpty()) {
            return false;
        }

        Equipment existing = result.get();
        existing.setName(form.getName());
        existing.setQuantity(form.getQuantity());
        repository.save(existing);
        return true;
    }
}
