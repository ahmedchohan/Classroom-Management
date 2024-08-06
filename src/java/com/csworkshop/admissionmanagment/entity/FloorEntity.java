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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arahman
 */
@Entity
@Table(name = "floor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FloorEntity.findAll", query = "SELECT f FROM FloorEntity f"),
    @NamedQuery(name = "FloorEntity.findByFloorId", query = "SELECT f FROM FloorEntity f WHERE f.floorId = :floorId"),
    @NamedQuery(name = "FloorEntity.findByFloorName", query = "SELECT f FROM FloorEntity f WHERE f.floorName = :floorName")})
public class FloorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "floor_id")
    private Integer floorId;
    @Size(max = 20)
    @Column(name = "floor_name")
    private String floorName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "floorId")
    private List<RoomEntity> roomEntityList;

    public FloorEntity() {
    }

    public FloorEntity(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    @XmlTransient
    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public void setRoomEntityList(List<RoomEntity> roomEntityList) {
        this.roomEntityList = roomEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (floorId != null ? floorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FloorEntity)) {
            return false;
        }
        FloorEntity other = (FloorEntity) object;
        if ((this.floorId == null && other.floorId != null) || (this.floorId != null && !this.floorId.equals(other.floorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.FloorEntity[ floorId=" + floorId + " ]";
    }
    
}
