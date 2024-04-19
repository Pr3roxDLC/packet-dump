package me.pr3.packetdump.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import me.pr3.packetdump.persistence.jpa.Bootstrap;

import java.time.Instant;
import java.util.UUID;

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

    public PlayClientPlayerPositionPacketEntity(Instant instant, UUID playerUUID, Double x, Double y, Double z, Boolean onGround) {
        super(instant, playerUUID);
        this.x = x;
        this.y = y;
        this.z = z;
        this.onGround = onGround;
    }

    public PlayClientPlayerPositionPacketEntity() {
        //JPA
    }
}
