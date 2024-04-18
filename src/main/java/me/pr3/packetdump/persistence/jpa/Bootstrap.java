package me.pr3.packetdump.persistence.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import me.pr3.packetdump.persistence.model.PlayClientChatMessagePacketEntity;
import me.pr3.packetdump.persistence.model.PlayClientPlayerPositionPacketEntity;

import java.util.HashMap;

/**
 * @author tim
 */
public class Bootstrap {
    public static EntityManagerFactory getEntityManagerFactory() {
        //TODO dynamically collect all entity classes here
        return new JpaEntityManagerFactory(new Class[]{PlayClientChatMessagePacketEntity.class, PlayClientPlayerPositionPacketEntity.class}).getEntityManagerFactory();
    }
}
