/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.csworkshop.admissionmanagment.session.BlockManager;

import com.csworkshop.admissionmanagment.entity.BlockEntity;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SEHRISH AZMAT
 */
@Stateless

public class BlockManagerSession implements BlockManagerSessionRemote {

    @PersistenceContext(unitName = "ClassRoomManagementPU")
    private EntityManager em;

    @EJB
private BlockEntity block;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public BlockEntity addBlock (String BlockName ){
        block.setBlockName(BlockName);
        persist(block);
        return block;
    } 
    
    

    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
