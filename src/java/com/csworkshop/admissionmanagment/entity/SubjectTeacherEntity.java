/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csworkshop.admissionmanagment.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arahman
 */
@Entity
@Table(name = "subject_teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubjectTeacherEntity.findAll", query = "SELECT s FROM SubjectTeacherEntity s"),
    @NamedQuery(name = "SubjectTeacherEntity.findBySubjectTeacherId", query = "SELECT s FROM SubjectTeacherEntity s WHERE s.subjectTeacherId = :subjectTeacherId")})
public class SubjectTeacherEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "subject_teacher_id")
    private Integer subjectTeacherId;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private SubjectEntity subjectId;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false)
    private TeacherEntity teacherId;

    public SubjectTeacherEntity() {
    }

    public SubjectTeacherEntity(Integer subjectTeacherId) {
        this.subjectTeacherId = subjectTeacherId;
    }

    public Integer getSubjectTeacherId() {
        return subjectTeacherId;
    }

    public void setSubjectTeacherId(Integer subjectTeacherId) {
        this.subjectTeacherId = subjectTeacherId;
    }

    public SubjectEntity getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(SubjectEntity subjectId) {
        this.subjectId = subjectId;
    }

    public TeacherEntity getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherEntity teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectTeacherId != null ? subjectTeacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectTeacherEntity)) {
            return false;
        }
        SubjectTeacherEntity other = (SubjectTeacherEntity) object;
        if ((this.subjectTeacherId == null && other.subjectTeacherId != null) || (this.subjectTeacherId != null && !this.subjectTeacherId.equals(other.subjectTeacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.SubjectTeacherEntity[ subjectTeacherId=" + subjectTeacherId + " ]";
    }
    
}
