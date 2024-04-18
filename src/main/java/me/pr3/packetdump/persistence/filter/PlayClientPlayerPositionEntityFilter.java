package me.pr3.packetdump.persistence.filter;

import me.pr3.packetdump.persistence.model.PlayClientPlayerPositionPacketEntity;

/**
 * @author tim
 */
public class PlayClientPlayerPositionEntityFilter implements IPacketEntityFilter<PlayClientPlayerPositionPacketEntity>{
    @Override
    public boolean filter(PlayClientPlayerPositionPacketEntity playClientPlayerPositionPacketEntity) {
        return true;
    }
}
