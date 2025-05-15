package com.talentvistas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class IdeaDto {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private String category;

    @NotNull(message = "Required investment amount is required")
    @Positive(message = "Required investment must be positive")
    private Double requiredInvestment;

    private String businessPlan;
    private String marketAnalysis;
    private Double expectedReturn;
    private Integer estimatedTimeMonths;
} 