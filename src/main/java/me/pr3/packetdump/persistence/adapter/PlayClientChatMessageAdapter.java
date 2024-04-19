package me.pr3.packetdump.persistence.adapter;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientChatMessage;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerWindowItems;
import me.pr3.packetdump.persistence.model.PlayClientChatMessagePacketEntity;

import java.time.Instant;

public class PlayClientChatMessageAdapter implements IPacketAdapter<PlayClientChatMessagePacketEntity> {
    @Override
    public PlayClientChatMessagePacketEntity adapt(ProtocolPacketEvent<?> packetEvent) {
        WrapperPlayClientChatMessage packet = new WrapperPlayClientChatMessage((PacketReceiveEvent) packetEvent);
        return new PlayClientChatMessagePacketEntity(
                Instant.now(),
                packetEvent.getUser().getUUID(),
                packet.getMessage());
    }
}
