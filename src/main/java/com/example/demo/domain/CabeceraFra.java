package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CabeceraFra {
    @Id
    @GeneratedValue
    int id;
    double importeFra;

    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    List<LineasFra> lineas = new ArrayList<>();

    @ManyToOne
    Cliente cliente;


}
