package com.example.buildFilterSpecification.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "Filter")
@Data
public class Filter {

    public static final String ZAMANPATTERIN = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TCKNO")
    private Long tckNo;

    @Column(name = "ISIM")
    private String name;

    @Column(name = "SOYISIM")
    private String lastname;

    @Column(name = "YAS")
    private Integer age;

    @Column(name = "IL")
    private String il;

    @Column(name = "ILCE")
    private String ilce;

    @Column(name = "ACIKADRES")
    private String acikAdres;

    @Column(name = "OLUSDURMATARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    private LocalDateTime createDate;

    @Column(name = "GUNCELLEMETARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    private LocalDateTime updateDate;

    // Getter and setters, constructors, other methods...
}
