package me.pr3.packetdump.persistence.adapter;

import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import me.pr3.packetdump.persistence.model.AbstractPacketEntity;

public interface IPacketAdapter<O extends AbstractPacketEntity> {
    O adapt(ProtocolPacketEvent<?> i);
}
