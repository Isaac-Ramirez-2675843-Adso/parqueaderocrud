/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author User
 */
public interface CRUD {
    public List listar();
    public Vehiculo list(int id);
    public boolean agregar(Vehiculo veh);
    public boolean editar(Vehiculo veh);
    public boolean eliminar(int id);
}
