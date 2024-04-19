package me.pr3.packetdump.persistence.jpa;

import jakarta.persistence.EntityManagerFactory;
import me.pr3.packetdump.persistence.model.PlayClientChatMessagePacketEntity;
import me.pr3.packetdump.persistence.model.PlayClientPlayerPositionPacketEntity;
import me.pr3.packetdump.persistence.model.PlayServerWindowItemsPacketEntity;

/**
 * @author tim
 */
public class Bootstrap {
    public static EntityManagerFactory getEntityManagerFactory() {
        //TODO dynamically collect all entity classes here
        return new JpaEntityManagerFactory(new Class[]{PlayClientChatMessagePacketEntity.class, PlayClientPlayerPositionPacketEntity.class, PlayServerWindowItemsPacketEntity.class}).getEntityManagerFactory();
    }
}
