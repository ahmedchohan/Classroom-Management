/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.csworkshop.admissionmanagment.session.classscedule;

import com.csworkshop.admissionmanagment.entity.ClassScheduleEntity;
import javax.ejb.Remote;

/**
 *
 * @author arahman
 */
@Remote
public interface ClassScheduleManagerRemote {
    public ClassScheduleEntity getClassScheduleById(int scheduleId) throws ScheduleNotFoundException;
}
