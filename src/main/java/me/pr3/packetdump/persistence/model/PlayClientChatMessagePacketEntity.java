package me.pr3.packetdump.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;

@Entity
public class PlayClientChatMessagePacketEntity extends AbstractPacketEntity{

    @Basic
    public String message;

}
