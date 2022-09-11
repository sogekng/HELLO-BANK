package com.hellobank.hellobank.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import com.hellobank.hellobank.dao.AdministradorDAO;
import com.hellobank.hellobank.model.Administrador;

@Service
public class AdministradorService implements IAdministradorService {
    @Autowired
    private AdministradorDAO dao;

    @Override
    public ArrayList<Administrador> listarTodos() {
        return (ArrayList<Administrador>)dao.findAll();

    }

    @Override
    public Administrador toCreate(Administrador administrador) {
        if (administrador != null){
            return dao.save(administrador);
        }
        return null;
    }

    @Override
    public void toDelete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Administrador toSearch(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Administrador toUpdate(Administrador dados) {
        if (dados.getId() != null && dados != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public boolean Toexist(Integer id) {
        return dao.existsById(id);
    }
}