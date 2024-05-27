package com.example.thim4p2.service;


import com.example.thim4p2.model.Computer;
import com.example.thim4p2.repository.IComputer;
import com.example.thim4p2.repository.ITypeComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    IComputer iComputer;


    @Override
    public List<Computer> listComputer() {
        return iComputer.findAll();
    }

    @Override
    public void addComputer(Computer computer) {
        iComputer.save(computer);
    }

    @Override
    public void deleteComputer(int id) {
        iComputer.deleteById(id);
    }

    @Override
    public Computer info(int id) {
        Optional<Computer> computer = iComputer.findById(id);
        if (computer.isPresent()) {
            return computer.get();
        } else {
            throw new NoSuchElementException("Computer với  id " + id + " không tồn tại");
        }
    }

    @Override
    public Page<Computer> search(String name, Pageable pageable) {
        return iComputer.searchByOwn("%" + name + "%", pageable);
    }

    @Override
    public boolean isComputerNameExists(String name) {
        return iComputer.countByCode(name) > 0;
    }

}
