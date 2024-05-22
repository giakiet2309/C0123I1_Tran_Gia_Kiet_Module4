package com.example.thim4p2.dto;

import com.example.thim4p2.model.TypeComputer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDTO {
    int id;

    @Pattern(regexp = "^CG.{6}$", message = " Code bắt đầu bằng chữ CG và có 8 ký tự")
    String codeComputer;
    @NotBlank(message = " không được để trống")
    String nameComputer;
    @NotBlank(message = " không được để trống")
    String producer;

    TypeComputer typeComputer;

}
