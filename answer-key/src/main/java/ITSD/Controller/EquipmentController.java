package ITSD.Controller;

import ITSD.Entity.Equipment;
import ITSD.Model.EquipmentEditForm;
import ITSD.Service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("equipmentList", service.findAll());
        return "equipment/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Equipment existing = service.findById(id).orElseThrow(this::equipmentNotFound);
        EquipmentEditForm form = new EquipmentEditForm();
        form.setName(existing.getName());
        form.setQuantity(existing.getQuantity());

        model.addAttribute("equipmentForm", form);
        model.addAttribute("equipmentRecord", existing);
        return "equipment/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable long id,
                         @Valid @ModelAttribute("equipmentForm") EquipmentEditForm form,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            Equipment existing = service.findById(id).orElseThrow(this::equipmentNotFound);
            model.addAttribute("equipmentRecord", existing);
            return "equipment/edit";
        }

        if (!service.update(id, form)) {
            throw equipmentNotFound();
        }
        return "redirect:/equipment";
    }

    private ResponseStatusException equipmentNotFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment not found");
    }
}
