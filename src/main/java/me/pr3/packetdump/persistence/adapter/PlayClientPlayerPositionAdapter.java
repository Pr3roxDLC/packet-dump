package me.pr3.packetdump.persistence.adapter;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPosition;
import me.pr3.packetdump.persistence.model.PlayClientPlayerPositionPacketEntity;

import java.time.Instant;

public class PlayClientPlayerPositionAdapter implements IPacketAdapter<PlayClientPlayerPositionPacketEntity> {
    @Override
    public PlayClientPlayerPositionPacketEntity adapt(ProtocolPacketEvent<?> packetReceiveEvent) {
        WrapperPlayClientPlayerPosition packet = new WrapperPlayClientPlayerPosition((PacketReceiveEvent) packetReceiveEvent);
        return new PlayClientPlayerPositionPacketEntity(
                Instant.now(),
                packetReceiveEvent.getUser().getUUID(),
                packet.getPosition().x,
                packet.getPosition().y,
                packet.getPosition().z,
                packet.isOnGround());
    }
}
