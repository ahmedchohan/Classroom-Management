/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csworkshop.admissionmanagment.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SEHRISH AZMAT
 */
@Entity
@Table(name = "batch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchEntity.findAll", query = "SELECT b FROM BatchEntity b"),
    @NamedQuery(name = "BatchEntity.findByBatchId", query = "SELECT b FROM BatchEntity b WHERE b.batchId = :batchId"),
    @NamedQuery(name = "BatchEntity.findByBatchCode", query = "SELECT b FROM BatchEntity b WHERE b.batchCode = :batchCode"),
    @NamedQuery(name = "BatchEntity.findByBatchYear", query = "SELECT b FROM BatchEntity b WHERE b.batchYear = :batchYear"),
    @NamedQuery(name = "BatchEntity.findByPassedOut", query = "SELECT b FROM BatchEntity b WHERE b.passedOut = :passedOut")})
public class BatchEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "batch_id")
    private Integer batchId;
    @Size(max = 45)
    @Column(name = "batch_code")
    private String batchCode;
    @Column(name = "batch_year")
    private Integer batchYear;
    @Column(name = "passed_out")
    private Short passedOut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchId")
    private Collection<StudentClassEntity> studentClassEntityCollection;

    public BatchEntity() {
    }

    public BatchEntity(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public Integer getBatchYear() {
        return batchYear;
    }

    public void setBatchYear(Integer batchYear) {
        this.batchYear = batchYear;
    }

    public Short getPassedOut() {
        return passedOut;
    }

    public void setPassedOut(Short passedOut) {
        this.passedOut = passedOut;
    }

    @XmlTransient
    public Collection<StudentClassEntity> getStudentClassEntityCollection() {
        return studentClassEntityCollection;
    }

    public void setStudentClassEntityCollection(Collection<StudentClassEntity> studentClassEntityCollection) {
        this.studentClassEntityCollection = studentClassEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batchId != null ? batchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchEntity)) {
            return false;
        }
        BatchEntity other = (BatchEntity) object;
        if ((this.batchId == null && other.batchId != null) || (this.batchId != null && !this.batchId.equals(other.batchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.ClassRoomManagement.session.BatchManager.BatchEntity[ batchId=" + batchId + " ]";
    }
    
}
