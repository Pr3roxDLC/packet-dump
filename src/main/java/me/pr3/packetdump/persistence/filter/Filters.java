package me.pr3.packetdump.persistence.filter;

import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import me.pr3.packetdump.persistence.model.AbstractPacketEntity;

import java.util.Map;

/**
 * @author tim
 */
public class Filters {
    public static Map<PacketTypeCommon, IPacketEntityFilter<? extends AbstractPacketEntity>> FILTERS = Map.ofEntries(
            Map.entry(PacketType.Play.Client.PLAYER_POSITION, new PlayClientPlayerPositionEntityFilter())
    );
}
