/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.csworkshop.admissionmanagment.session.DepartmentManager;

import com.csworkshop.admissionmanagment.session.BlockManager.BlockManagerSessionRemote;
import com.csworkshop.admissionmanagment.entity.DepartmentEntity;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author SEHRISH AZMAT
 */
@Stateless
public class DepartmentManagerSession implements DepartmentManagerSessionRemote {

    @PersistenceContext(unitName = "ClassRoomManagementPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB 
    private BlockManagerSessionRemote block;
public DepartmentEntity addDepartment(int departmentId, String departmentName,int blockId, int status )throws DepartmentAlreadyExistsException, InvalidDepartmentException {
        if (departmentName == null || departmentName.isEmpty()) {
            throw new InvalidDepartmentException("Department name cannot be null or empty.");
        }

        DepartmentEntity existingDepartment = getDepartmentbyDepartmentId(departmentId);
        if (existingDepartment != null) {
            throw new DepartmentAlreadyExistsException("Department with ID " + departmentId + " already exists.");
        }
        DepartmentEntity department = new DepartmentEntity();
        
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setBlockId();
        department.setStatus(status);

        persist(department);
        return department;
    }

    public void getDepartmentbyName()throws DepartmentNotFoundException {
       TypedQuery<DepartmentEntity> query = em.createNamedQuery("DepartmentEntity.findByName", DepartmentEntity.class);
        query.setParameter("departmentName", departmentName);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DepartmentNotFoundException("Department with name " + departmentName + " not found.");
        }
    }

public void updateDepartmentStatus(){
    
}

public void getDepartmentbyBlockId (){
    
}

public void getDepartmentbyDepartmentId(){
    
}
public void getAllDepartment (){
    
}

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void addDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getallDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getDepartmentbyBlock_Id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   

}
