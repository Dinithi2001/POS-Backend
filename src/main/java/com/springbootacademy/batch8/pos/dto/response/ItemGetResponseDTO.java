package com.springbootacademy.batch8.pos.dto.response;

import com.springbootacademy.batch8.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {
    private int item_id;
    private String itemName;
    private double balanceQty;
    private double suplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
