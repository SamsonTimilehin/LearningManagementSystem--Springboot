package com.example.learningmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LearningParty {

    @Id
    @SequenceGenerator(
            name = "learning_sequence",
            sequenceName = "learning_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "learning_sequence"
    )
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private boolean enabled;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @OneToMany
    private List<Authority> authorities;
}
