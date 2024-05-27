package com.example.thim4p2.repository;

import com.example.thim4p2.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface IComputer extends JpaRepository<Computer, Integer> {
    @Query(value = "SELECT COUNT(*) FROM computer WHERE code_computer = :code", nativeQuery = true)
    Long  countByCode(@Param("code") String code);
    @Query(value = "select * from computer where name_computer like :search ", nativeQuery = true)
    Page<Computer> searchByOwn(@Param("search") String search, Pageable pageable);


}
