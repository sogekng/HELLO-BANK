package com.hellobank.hellobank.services;

import java.util.ArrayList;
import java.util.Optional;
import com.hellobank.hellobank.model.Administrador;

public interface IAdministradorService {
    public ArrayList<Administrador> listarTodos();
    public Administrador toCreate(Administrador administrador);
    public void toDelete(Integer id);
    public Optional<Administrador> toSearch(Integer id);
    public Administrador toUpdate(Administrador dados);
    public boolean toExistCpf(String cpf);
    public boolean toExistId(Integer id);
    public Administrador toExistLogin(String cpf, String senha);
}