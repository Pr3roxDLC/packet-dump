package me.pr3.packetdump.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;

@Entity
public class PlayClientPlayerPositionPacketEntity extends AbstractPacketEntity{
    @Basic
    public Double x;
    @Basic
    public Double y;
    @Basic
    public Double z;
    @Basic
    public Boolean onGround;

}
