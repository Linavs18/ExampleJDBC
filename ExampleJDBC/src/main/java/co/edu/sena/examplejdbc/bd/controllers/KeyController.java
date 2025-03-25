/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de Key
 */
public class KeyController implements IKeyController {
    
    private DBKey dbk = new DBKey();
    
    @Override
    public void insert(Key key) throws Exception {
        if(key == null)
        {
             throw new Exception("La llave es nula");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(key.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta, debe ser minimo 1");
        }
        
        //Insertar
        dbk.insert(key);
    }

    @Override
    public void update(Key key) throws Exception {
        if(key == null)
        {
             throw new Exception("La llave es nula");
        }
        
        if (key.getId() == 0) 
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(key.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta, debe ser minimo 1");
        }
        
        //Consultar si existe en la bd
        Key keyExists = dbk.findById(key.getId());
        if(keyExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Actualizar
        dbk.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
         if (id == 0) 
        {
            throw new Exception("El id es obligatorio");
        }
        
        //Consultar si existe en la bd
        Key keyExists = dbk.findById(id);
        if(keyExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Actualizar
        dbk.delete(id);
    }

    @Override
    public List<Key> findAll() throws Exception {
        return dbk.findAll();
    }

    @Override
    public Key findById(int id) throws Exception {
         if (id == 0) 
        {
            throw new Exception("El id es obligatorio");
        }
        
         return dbk.findById(id);
    }
    
}
