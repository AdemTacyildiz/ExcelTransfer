package com.example.calctransfer.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notes")

public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "baslik")
    private String baslik;
    @Column(name = "aciklama")
    private String aciklama;

}