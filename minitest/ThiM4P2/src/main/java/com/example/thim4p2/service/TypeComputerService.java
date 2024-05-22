package com.example.thim4p2.service;

import com.example.thim4p2.model.TypeComputer;
import com.example.thim4p2.repository.IComputer;
import com.example.thim4p2.repository.ITypeComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeComputerService implements ITypeComputerService {
    @Autowired
    ITypeComputer typeComputer;

    @Override
    public List<TypeComputer> listTypeComputer() {
        return typeComputer.findAll();
    }
}
