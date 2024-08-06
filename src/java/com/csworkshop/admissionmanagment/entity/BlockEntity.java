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
@Table(name = "block")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlockEntity.findAll", query = "SELECT b FROM BlockEntity b"),
    @NamedQuery(name = "BlockEntity.findByBlockId", query = "SELECT b FROM BlockEntity b WHERE b.blockId = :blockId"),
    @NamedQuery(name = "BlockEntity.findByBlockName", query = "SELECT b FROM BlockEntity b WHERE b.blockName = :blockName")})
public class BlockEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "block_id")
    private Integer blockId;
    @Size(max = 45)
    @Column(name = "block_name")
    private String blockName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blockId")
    private List<DepartmentEntity> departmentEntityList;

    public BlockEntity() {
    }

    public BlockEntity(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    @XmlTransient
    public List<DepartmentEntity> getDepartmentEntityList() {
        return departmentEntityList;
    }

    public void setDepartmentEntityList(List<DepartmentEntity> departmentEntityList) {
        this.departmentEntityList = departmentEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blockId != null ? blockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlockEntity)) {
            return false;
        }
        BlockEntity other = (BlockEntity) object;
        if ((this.blockId == null && other.blockId != null) || (this.blockId != null && !this.blockId.equals(other.blockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.BlockEntity[ blockId=" + blockId + " ]";
    }
    
}
