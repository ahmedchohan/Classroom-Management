/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.csworkshop.admissionmanagment.session.classscedule;

import com.csworkshop.admissionmanagment.entity.ClassScheduleEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author arahman
 */
@Stateless
public class ClassScheduleManager implements ClassScheduleManagerRemote {

    @PersistenceContext(unitName = "ClassRoomManagementPU")
    private EntityManager em;

    @Override
    public ClassScheduleEntity getClassScheduleById(int scheduleId) throws ScheduleNotFoundException {
        
        ClassScheduleEntity schedule=em.find(ClassScheduleEntity.class, scheduleId);
        if(schedule==null){
            throw new ScheduleNotFoundException("No schedule found with Id : "+scheduleId);
        }
        return schedule;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
