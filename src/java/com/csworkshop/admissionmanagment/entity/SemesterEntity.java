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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arahman
 */
@Entity
@Table(name = "semester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SemesterEntity.findAll", query = "SELECT s FROM SemesterEntity s"),
    @NamedQuery(name = "SemesterEntity.findBySemesterId", query = "SELECT s FROM SemesterEntity s WHERE s.semesterId = :semesterId"),
    @NamedQuery(name = "SemesterEntity.findBySemesterNumber", query = "SELECT s FROM SemesterEntity s WHERE s.semesterNumber = :semesterNumber")})
public class SemesterEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "semester_id")
    private Integer semesterId;
    @Column(name = "semester_number")
    private Integer semesterNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semesterId")
    private List<SubjectEntity> subjectEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semesterId")
    private List<TimeTableEntity> timeTableEntityList;

    public SemesterEntity() {
    }

    public SemesterEntity(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    @XmlTransient
    public List<SubjectEntity> getSubjectEntityList() {
        return subjectEntityList;
    }

    public void setSubjectEntityList(List<SubjectEntity> subjectEntityList) {
        this.subjectEntityList = subjectEntityList;
    }

    @XmlTransient
    public List<TimeTableEntity> getTimeTableEntityList() {
        return timeTableEntityList;
    }

    public void setTimeTableEntityList(List<TimeTableEntity> timeTableEntityList) {
        this.timeTableEntityList = timeTableEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semesterId != null ? semesterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemesterEntity)) {
            return false;
        }
        SemesterEntity other = (SemesterEntity) object;
        if ((this.semesterId == null && other.semesterId != null) || (this.semesterId != null && !this.semesterId.equals(other.semesterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.SemesterEntity[ semesterId=" + semesterId + " ]";
    }
    
}
