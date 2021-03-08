package com.agriculture.agro.project.area.repository;

import com.agriculture.agro.project.area.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAreaRepository extends JpaRepository<Area, Long> {
}
