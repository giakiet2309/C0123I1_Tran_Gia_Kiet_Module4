package com.example.thim4p2.repository;

import com.example.thim4p2.model.TypeComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeComputer extends JpaRepository<TypeComputer,Integer> {
}
