/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Fecha: 20/03/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: permite consultas y transacciones en la tabla record
 */
public class DBRecord extends DBConnection{
    public void insert (Record record){
        try {
            connect();
            String sql = "INSERT INTO record (date_record, start_time, end_time, employee_id, key_id, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDateRecord());
            preparedStatement.setString(2, record.getStartTime());
            preparedStatement.setString(3, record.getEndTime());
            preparedStatement.setLong(4, record.getEmployee().getDocument());
            preparedStatement.setInt(5, record.getKey().getId());
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) 
        {
            MessageUtils.ShowErrorMessage("Error al insertar el registro" + e.getMessage());
        }
        
        finally
        {
            disconnect();
        }
    }
    
    public void update (Record record){
        try {
            connect();
            String sql = "UPDATE `record` SET `date_record`= ?, `start_time`= ?, `end_time`= ?, `employee_id`= ?, `key_id`= ?, `status`= ? WHERE `id`= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDateRecord());
            preparedStatement.setString(2, record.getStartTime());
            preparedStatement.setString(3, record.getEndTime());
            preparedStatement.setLong(4, record.getEmployee().getDocument());
            preparedStatement.setInt(5, record.getKey().getId());
            preparedStatement.setString(6, record.getStatus());
             preparedStatement.setInt(7, record.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) 
        {
            MessageUtils.ShowErrorMessage("Error al actualizar el registro" + e.getMessage());
        }
        
        finally
        {
            disconnect();
        }
    }
    
    public void delete (int id){
        try {
            connect();
            String sql = "delete from record where id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) 
        {
            MessageUtils.ShowErrorMessage("Error al eliminar el registro " + e.getMessage());
        }
        
        finally
        {
            disconnect();
        }
    }
    
    public List<Record> findAll(){
        List<Record> results = new ArrayList<>();
        DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();
        
        try {
             connect();
            String sql = "select * from record";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDateRecord(resultSet.getString("date_record"));
                record.setStartTime(resultSet.getString("start_time"));
                record.setEndTime(resultSet.getString("end_time"));
                //FK
                Employee employee = dbe.findById(resultSet.getLong("employee_id"));
                Key key = dbk.findById(resultSet.getInt("key_id"));
                record.setEmployee(employee);
                record.setKey(key);
                results.add(record);
            }
            resultSet.close();
            
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al consultar registros" + e.getMessage() );
        }
        
        finally 
        {
            disconnect();
        }
        
        return results;
    }
    
    public Record findById(int id)
    {
        Record record = null;
         DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();
        
        try {
            connect();
            String sql = "select * from record where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDateRecord(resultSet.getString("date_record"));
                record.setStartTime(resultSet.getString("start_time"));
                record.setEndTime(resultSet.getString("end_time"));
                //FK
                Employee employee = dbe.findById(resultSet.getLong("employee_id"));
                Key key = dbk.findById(resultSet.getInt("key_id"));
                record.setEmployee(employee);
                record.setKey(key);
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al consultar el registro " + e.getMessage());
        }
        
        finally 
        {
            disconnect();
        }
        
        return record;
    }
}
