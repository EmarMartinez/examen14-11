package com.example.demo.repository;

import com.example.demo.domain.LineasFra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineaFraRepository extends JpaRepository<LineasFra, Integer> {
    List<LineasFra> findAllByCabeceraFraId(int id);
}
