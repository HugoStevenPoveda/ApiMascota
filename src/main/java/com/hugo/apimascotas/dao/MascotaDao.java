package com.hugo.apimascotas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hugo.apimascotas.entity.Mascota;

public interface MascotaDao extends JpaRepository<Mascota, Long> {

}
