/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de Record
 */
public class RecordController implements IRecordController {

    private DBRecord dbr = new DBRecord();
    
    @Override
    public void insert(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es nulo");
        } 
        
        if("".equals(record.getDateRecord()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        
        if("".equals(record.getStartTime()))
        {
            throw new Exception("La hora de salida es obligatoria");
        }
        
        //FK
        if(record.getEmployee() == null)
        {
            throw new Exception("El documento empleado es obligatorio");
        }
        
        if(record.getKey() == null)
        {
            throw new Exception("El id de la llave es obligatoria");
        }
        
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estdo es obligatoria");
        }
        
        //insertar
        dbr.insert(record);
    }

    @Override
    public void update(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es nulo");
        } 
        
        if(record.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(record.getDateRecord()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        
        if("".equals(record.getStartTime()))
        {
            throw new Exception("La hora de salida es obligatoria");
        }
        
        //FK
        if(record.getEmployee() == null)
        {
            throw new Exception("El documento empleado es obligatorio");
        }
        
        if(record.getKey() == null)
        {
            throw new Exception("El id de la llave es obligatoria");
        }
        
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estdo es obligatoria");
        }
        
        //Consultar si existe en la bd
        Record recordExists = dbr.findById(record.getId());
        if (recordExists == null) 
        {
            throw new Exception("El registro no existe");
        }
        
        //Actualizar
        dbr.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Record recordExists = dbr.findById(id);
        if (recordExists == null) 
        {
            throw new Exception("El registro no existe");
        }
        
        //Eliminar
        dbr.delete(id);
    }

    @Override
    public List<Record> findAll() throws Exception {
       return dbr.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
       if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
       
       return dbr.findById(id);
    }
    
}
