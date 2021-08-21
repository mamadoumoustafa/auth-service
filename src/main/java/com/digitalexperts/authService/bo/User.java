package com.digitalexperts.authService.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @NotNull @Email
    private String email;

    @NotNull
    @Size(min = 5,max = 10)
    private String password;

    @NotNull
    @Size(min = 9,max = 9)
    private String telephone;

    @OneToMany
    private List<Role> roles = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
