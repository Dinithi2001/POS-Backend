package com.springbootacademy.batch8.pos.dto;

import com.springbootacademy.batch8.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double suplierPrice;
    private double sellingPrice;

}
