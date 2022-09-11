package com.hellobank.hellobank.services;

import java.util.ArrayList;

import com.hellobank.hellobank.model.Administrador;

public interface IAdministradorService {
    public ArrayList<Administrador> listarTodos();
    public Administrador toCreate(Administrador administrador);
    public void toDelete(int id);
    public Administrador toSearch(int id);
}