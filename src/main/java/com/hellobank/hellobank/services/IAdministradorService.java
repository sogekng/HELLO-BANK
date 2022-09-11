package com.hellobank.hellobank.services;

import java.util.ArrayList;
import com.hellobank.hellobank.model.Administrador;

public interface IAdministradorService {
    public ArrayList<Administrador> listarTodos();
    public Administrador toCreate(Administrador administrador);
    public void toDelete(Integer id);
    public Administrador toSearch(Integer id);
    public boolean Toexist(Integer id);
    public Administrador toUpdate(Administrador dados);

}