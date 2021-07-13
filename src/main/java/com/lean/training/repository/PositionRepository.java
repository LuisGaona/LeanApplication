package com.lean.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lean.training.persitence.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
