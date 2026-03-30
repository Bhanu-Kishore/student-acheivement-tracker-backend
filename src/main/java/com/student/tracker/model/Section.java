package com.student.tracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sections")
@Getter @Setter @NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // e.g., "Section A"
}