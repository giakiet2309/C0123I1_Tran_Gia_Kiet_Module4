package com.example.thim4p2.service;

import com.example.thim4p2.model.Computer;
import com.example.thim4p2.repository.IComputer;
import com.example.thim4p2.repository.ITypeComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return iComputer.findById(id).get();
    }

    @Override
    public Page<Computer> search(String name, Pageable pageable) {
        return iComputer.searchByOwn("%" + name + "%", pageable);
    }
}
