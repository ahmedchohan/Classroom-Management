/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.csworkshop.admissionmanagment.RoomManager.session;

import javax.ejb.Remote;

/**
 *
 * @author SEHRISH AZMAT
 */
@Remote

public interface RoomManagerSessionRemote {

    public void addRoom();

    public void getRoombyDepartment_Id();

    public void getRoombyFloor_Id();

    public void getRoombyDepartmentId();

    public void getRoombyFloorId();
    
}
