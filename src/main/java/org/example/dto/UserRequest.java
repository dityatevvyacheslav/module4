package org.example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Укажите имя")
    @Size(min = 2, max = 100, message = "От 2 до 100 символов")
    private String name;

    @NotBlank(message = "Укажите почту")
    @Email(message = "Почта должна быть в корректном виде")
    private String email;

    @Min(value = 0, message = "Возраст должен быть больше 0")
    @Max(value = 150, message = "Возраст должен быть меньше 150")
    private Integer age;
}