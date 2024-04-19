package me.pr3.packetdump.persistence.adapter;

import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;

import java.util.Map;

public class Adapters {
    public static final Map<PacketTypeCommon, IPacketAdapter<?>> ADAPTERS = Map.ofEntries(
            Map.entry(PacketType.Play.Client.CHAT_MESSAGE, new PlayClientChatMessageAdapter()),
            Map.entry(PacketType.Play.Client.PLAYER_POSITION, new PlayClientPlayerPositionAdapter()),
            Map.entry(PacketType.Play.Server.WINDOW_ITEMS, new PlayServerWindowItemsAdapter())
    );
}
