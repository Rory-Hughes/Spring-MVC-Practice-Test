package ITSD.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EquipmentEditForm {
    @NotBlank(message = "Enter an equipment name.")
    @Size(max = 60, message = "Use 60 characters or fewer.")
    private String name;

    @NotNull(message = "Enter a quantity.")
    @Min(value = 0, message = "Quantity must be at least 0.")
    @Max(value = 100, message = "Quantity must be at most 100.")
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
