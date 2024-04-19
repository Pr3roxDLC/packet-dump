package me.pr3.packetdump.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;

import java.time.Instant;
import java.util.UUID;

@Entity
public class PlayClientChatMessagePacketEntity extends AbstractPacketEntity{

    @Basic
    public String message;


    public PlayClientChatMessagePacketEntity(Instant instant, UUID playerUUID, String message) {
        super(instant, playerUUID);
        this.message = message;
    }

    public PlayClientChatMessagePacketEntity() {
        //JPA
    }
}
