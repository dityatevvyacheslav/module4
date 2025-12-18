package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Укажите имя")
    @Size(min = 2, max = 100, message = "От 2 до 100 символов")
    private String name;

    @NotBlank(message = "Укажите почту")
    @Email(message = "Почта должна быть в корректном виде")
    @Column(unique = true)
    private String email;

    @Min(value = 0, message = "Возраст должен быть больше 0")
    @Max(value = 150, message = "Возраст должен быть меньше 150")
    private Integer age;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}