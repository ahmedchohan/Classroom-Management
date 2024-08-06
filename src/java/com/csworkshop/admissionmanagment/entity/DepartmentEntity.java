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
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartmentEntity.findAll", query = "SELECT d FROM DepartmentEntity d"),
    @NamedQuery(name = "DepartmentEntity.findByDepartmentId", query = "SELECT d FROM DepartmentEntity d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "DepartmentEntity.findByDepartmentName", query = "SELECT d FROM DepartmentEntity d WHERE d.departmentName = :departmentName"),
    @NamedQuery(name = "DepartmentEntity.findByIsActive", query = "SELECT d FROM DepartmentEntity d WHERE d.isActive = :isActive")})
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "department_id")
    private Integer departmentId;
    @Size(max = 45)
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "is_active")
    private Short isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentEntity")
    private List<TeacherEntity> teacherEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private List<SubjectEntity> subjectEntityList;
    @JoinColumn(name = "block_id", referencedColumnName = "block_id")
    @ManyToOne(optional = false)
    private BlockEntity blockId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private List<RoomEntity> roomEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private List<ClassScheduleEntity> classScheduleEntityList;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<TeacherEntity> getTeacherEntityList() {
        return teacherEntityList;
    }

    public void setTeacherEntityList(List<TeacherEntity> teacherEntityList) {
        this.teacherEntityList = teacherEntityList;
    }

    @XmlTransient
    public List<SubjectEntity> getSubjectEntityList() {
        return subjectEntityList;
    }

    public void setSubjectEntityList(List<SubjectEntity> subjectEntityList) {
        this.subjectEntityList = subjectEntityList;
    }

    public BlockEntity getBlockId() {
        return blockId;
    }

    public void setBlockId(BlockEntity blockId) {
        this.blockId = blockId;
    }

    @XmlTransient
    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public void setRoomEntityList(List<RoomEntity> roomEntityList) {
        this.roomEntityList = roomEntityList;
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
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentEntity)) {
            return false;
        }
        DepartmentEntity other = (DepartmentEntity) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.DepartmentEntity[ departmentId=" + departmentId + " ]";
    }
    
}
