package ITSD.Controller;

import ITSD.Service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        // TODO Put the equipment collection in the model.
        return "equipment/list";
    }

    // TODO Add a GET handler for /{id}/edit.

    // TODO Add a POST handler for /{id}/edit.
}
