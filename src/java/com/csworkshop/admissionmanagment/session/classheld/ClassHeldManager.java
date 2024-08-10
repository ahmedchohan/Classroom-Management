/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.csworkshop.admissionmanagment.session.classheld;

import com.csworkshop.admissionmanagment.entity.ClassHeldEntity;
import com.csworkshop.admissionmanagment.entity.ClassScheduleEntity;
import com.csworkshop.admissionmanagment.session.classscedule.ClassScheduleManagerRemote;
import com.csworkshop.admissionmanagment.session.classscedule.ScheduleNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author arahman
 */
@Stateless
public class ClassHeldManager implements ClassHeldManagerRemote {

    @PersistenceContext(unitName = "ClassRoomManagementPU")
    private EntityManager em;
    
    @EJB
    ClassScheduleManagerRemote scheduleManager;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public ClassHeldEntity addClassHeld(int scheduleId,int teacherId,int actualStartHr,
                int actualStartMin, int actualEndHr,int actualEndMin) throws ScheduleNotFoundException, InvalidHourValueException, InvalidMinuteValueException{
        if(actualStartHr<8 || actualStartHr>16){
            throw new InvalidHourValueException("The value of starting hour can be between 8 and 16");
        }
        if(actualStartHr<10 || actualStartHr>18){
            throw new InvalidHourValueException("The value of ending hour can be between 8 and 16");
        }
        if(actualStartMin<0 || actualStartMin>59){
            throw new InvalidMinuteValueException("The value of minutes can be between 0 and 59");
        }
        ClassHeldEntity classHeld=new ClassHeldEntity();
        ClassScheduleEntity schedule=scheduleManager.getClassScheduleById(scheduleId);
        classHeld.setClassScheduleId(schedule);
        
        classHeld.setActualStartTimeHour(actualStartHr);
        classHeld.setActualStartTimeMinutes(actualStartMin);
        classHeld.setActualEndTimeHours(actualEndHr);
        classHeld.setActualEndTimeMinutes(actualEndMin);
        classHeld.setClassHeldStatus(ClassHeldEntity.CLASS_HELD_STATUS_NOT_HELD);
        em.persist(classHeld);
        return classHeld;
    }
    
    

    public void persist(Object object) {
        em.persist(object);
    }
}
