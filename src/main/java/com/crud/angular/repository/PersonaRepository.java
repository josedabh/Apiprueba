package com.crud.angular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.angular.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
