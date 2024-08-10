/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.csworkshop.admissionmanagment.session;

import javax.ejb.Stateless;

/**
 *
 * @author SEHRISH AZMAT
 */
@Stateless
public class RoomManagerSession implements RoomManagerSessionRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void addRoom(){
        
    }
    public void getRoombyDepartmentId(){
        
    }
    public void getRoombyFloorId(){
        
    }

    @Override
    public void getRoombyDepartment_Id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getRoombyFloor_Id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
