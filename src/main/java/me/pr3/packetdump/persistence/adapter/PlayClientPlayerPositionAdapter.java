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
        PlayClientPlayerPositionPacketEntity entity = new PlayClientPlayerPositionPacketEntity();
        entity.instant = Instant.now();
        entity.playerUUID = packetReceiveEvent.getUser().getUUID();
        entity.x = packet.getPosition().x;
        entity.y = packet.getPosition().y;
        entity.z = packet.getPosition().z;
        entity.onGround = packet.isOnGround();
        return entity;
    }
}
