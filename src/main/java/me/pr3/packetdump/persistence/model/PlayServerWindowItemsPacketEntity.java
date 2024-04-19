package me.pr3.packetdump.persistence.model;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * @author tim
 */
@Entity
public class PlayServerWindowItemsPacketEntity extends AbstractPacketEntity{

    @ElementCollection
    List<byte[]> content;

    public PlayServerWindowItemsPacketEntity(Instant instant, UUID playerUUID, List<byte[]> content) {
        super(instant, playerUUID);
        this.content = content;
    }

    public PlayServerWindowItemsPacketEntity() {
        //JPA
    }
}
