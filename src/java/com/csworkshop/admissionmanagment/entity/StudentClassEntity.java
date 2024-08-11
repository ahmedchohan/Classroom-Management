/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csworkshop.admissionmanagment.entity;

import com.csworkshop.admissionmanagment.entity.BatchEntity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SEHRISH AZMAT
 */
@Entity
@Table(name = "student_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentClassEntity.findAll", query = "SELECT s FROM StudentClassEntity s"),
    @NamedQuery(name = "StudentClassEntity.findByStudentClassId", query = "SELECT s FROM StudentClassEntity s WHERE s.studentClassId = :studentClassId"),
    @NamedQuery(name = "StudentClassEntity.findByClassSection", query = "SELECT s FROM StudentClassEntity s WHERE s.classSection = :classSection")})
public class StudentClassEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_class_id")
    private Integer studentClassId;
    @Size(max = 45)
    @Column(name = "class_section")
    private String classSection;
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
    @ManyToOne(optional = false)
    private BatchEntity batchId;

    public StudentClassEntity() {
    }

    public StudentClassEntity(Integer studentClassId) {
        this.studentClassId = studentClassId;
    }

    public Integer getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Integer studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getClassSection() {
        return classSection;
    }

    public void setClassSection(String classSection) {
        this.classSection = classSection;
    }

    public BatchEntity getBatchId() {
        return batchId;
    }

    public void setBatchId(BatchEntity batchId) {
        this.batchId = batchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentClassId != null ? studentClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentClassEntity)) {
            return false;
        }
        StudentClassEntity other = (StudentClassEntity) object;
        if ((this.studentClassId == null && other.studentClassId != null) || (this.studentClassId != null && !this.studentClassId.equals(other.studentClassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.ClassRoomManagement.session.BatchManager.StudentClassEntity[ studentClassId=" + studentClassId + " ]";
    }
    
}
