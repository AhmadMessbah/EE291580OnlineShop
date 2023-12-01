package com.mftplus.javaee04.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity(name = "stuffEntity")
@Table(name = "stuff_tbl")

public class Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "s_name", length = 20)
    private String name;

    @Column(name = "s_brand", length = 20)
    private String brand;

    @Column(name="s_group", length = 20)
    private String group;
}
