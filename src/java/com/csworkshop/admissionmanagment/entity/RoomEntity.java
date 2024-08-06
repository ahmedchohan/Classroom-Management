/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csworkshop.admissionmanagment.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arahman
 */
@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomEntity.findAll", query = "SELECT r FROM RoomEntity r"),
    @NamedQuery(name = "RoomEntity.findByRoomId", query = "SELECT r FROM RoomEntity r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "RoomEntity.findByRoomNumber", query = "SELECT r FROM RoomEntity r WHERE r.roomNumber = :roomNumber")})
public class RoomEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "room_id")
    private Integer roomId;
    @Size(max = 45)
    @Column(name = "room_number")
    private String roomNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomRoomId")
    private List<TimeTableEntity> timeTableEntityList;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private DepartmentEntity departmentId;
    @JoinColumn(name = "floor_id", referencedColumnName = "floor_id")
    @ManyToOne(optional = false)
    private FloorEntity floorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private List<ClassScheduleEntity> classScheduleEntityList;

    public RoomEntity() {
    }

    public RoomEntity(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @XmlTransient
    public List<TimeTableEntity> getTimeTableEntityList() {
        return timeTableEntityList;
    }

    public void setTimeTableEntityList(List<TimeTableEntity> timeTableEntityList) {
        this.timeTableEntityList = timeTableEntityList;
    }

    public DepartmentEntity getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentEntity departmentId) {
        this.departmentId = departmentId;
    }

    public FloorEntity getFloorId() {
        return floorId;
    }

    public void setFloorId(FloorEntity floorId) {
        this.floorId = floorId;
    }

    @XmlTransient
    public List<ClassScheduleEntity> getClassScheduleEntityList() {
        return classScheduleEntityList;
    }

    public void setClassScheduleEntityList(List<ClassScheduleEntity> classScheduleEntityList) {
        this.classScheduleEntityList = classScheduleEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomEntity)) {
            return false;
        }
        RoomEntity other = (RoomEntity) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.RoomEntity[ roomId=" + roomId + " ]";
    }
    
}
