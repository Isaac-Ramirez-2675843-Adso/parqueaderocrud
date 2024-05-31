/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author User
 */
public class VehiculoDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vehiculo v =new Vehiculo(); 
    
    @Override
    public List listar() {
        ArrayList<Vehiculo>list=new ArrayList<>();
        String sql="select * from vehiculo";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            Vehiculo veh=new Vehiculo();
            veh.setId(rs.getInt("id"));
            veh.setPlaca(rs.getString("placa"));
            veh.setTipo(rs.getString("tipo"));
            veh.setColor(rs.getString("color"));
            veh.setModelo(rs.getString("modelo"));
            list.add(veh);
            }
            
        } catch (Exception e) {
            System.out.println("Error al listar" +e.toString());
        }
        return list;
    }

    @Override
    public Vehiculo list(int id) {
        ArrayList<Vehiculo>list=new ArrayList<>();
        String sql="select * from vehiculo where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            
            v.setId(rs.getInt("id"));
            v.setPlaca(rs.getString("placa"));
            v.setTipo(rs.getString("tipo"));
            v.setColor(rs.getString("color"));
            v.setModelo(rs.getString("modelo"));
            
            }
            
        } catch (Exception e) {
            System.out.println("Error al listar" +e.toString());
        }
        return v;
    }

    @Override
    public boolean agregar(Vehiculo veh) {
        String sql="insert into vehiculo(placa, tipo, color, modelo)values('"+veh.getPlaca()+"', '"+veh.getTipo()+"', '"+veh.getColor()+"', '"+veh.getModelo()+"')";
        try {
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al guardar" +e.toString());
        }
        return false;
        
    }

    @Override
    public boolean editar(Vehiculo veh) {
        String sql="update vehiculo set placa='"+veh.getPlaca()+"', tipo='"+veh.getTipo()+"', color='"+veh.getColor()+"', modelo='"+veh.getModelo()+"' where id="+veh.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from vehiculo where id="+id;
        try {
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
