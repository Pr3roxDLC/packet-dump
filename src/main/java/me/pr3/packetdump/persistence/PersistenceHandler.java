package me.pr3.packetdump.persistence;

import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import me.pr3.packetdump.persistence.adapter.Adapters;
import me.pr3.packetdump.persistence.adapter.IPacketAdapter;
import me.pr3.packetdump.persistence.filter.Filters;
import me.pr3.packetdump.persistence.filter.IPacketEntityFilter;
import me.pr3.packetdump.persistence.jpa.Bootstrap;
import me.pr3.packetdump.persistence.model.AbstractPacketEntity;

import java.util.Set;

public class PersistenceHandler {

    public static final PersistenceHandler PERSISTENCE_HANDLER = new PersistenceHandler();
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Bootstrap.getEntityManagerFactory();

    public void persist(Set<ProtocolPacketEvent<?>> packetEvents){
        System.out.println("Persisting Packets: ");
        Thread thread = new Thread(() -> {
            EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
            entityManager.getTransaction().begin();
            for  (ProtocolPacketEvent<?> packetEvent: packetEvents) {
                IPacketAdapter<?> adapter = Adapters.ADAPTERS.get(packetEvent.getPacketType());
                IPacketEntityFilter<?> filter = Filters.FILTERS.get(packetEvent.getPacketType());
                if (adapter == null) continue;
                AbstractPacketEntity entity = adapter.adapt(packetEvent);
                if(filter != null && !filter.filterInternal(entity)) continue;
                entityManager.persist(entity);
            }
            entityManager.getTransaction().commit();
        });
        thread.start();
    }

}
