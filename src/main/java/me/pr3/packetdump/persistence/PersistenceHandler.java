package me.pr3.packetdump.persistence;

import com.github.retrooper.packetevents.event.PacketEvent;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import me.pr3.packetdump.persistence.adapter.Adapters;
import me.pr3.packetdump.persistence.model.AbstractPacketEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PersistenceHandler {

    public static final PersistenceHandler PERSISTENCE_HANDLER = new PersistenceHandler();

    public void persist(Set<ProtocolPacketEvent<?>> packetEvents){
        Thread thread = new Thread(() -> {
            List<AbstractPacketEntity> packetEntities = new ArrayList<>();
            for  (ProtocolPacketEvent<?> packetEvent: packetEvents) {
               AbstractPacketEntity entity =  Adapters.ADAPTERS.get(packetEvent.getPacketType()).adapt(packetEvent);
               packetEntities.add(entity);
            }
        });
        thread.start();
    }

}
