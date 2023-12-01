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

@Entity(name = "storageEntity")
@Table(name = "storage_tbl")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Stuff stuff;

    private int count;
}
