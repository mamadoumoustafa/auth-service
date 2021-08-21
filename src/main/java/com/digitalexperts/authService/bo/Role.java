package com.digitalexperts.authService.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private String name;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

}
