package me.pr3.packetdump.persistence.filter;

import me.pr3.packetdump.persistence.model.AbstractPacketEntity;

/**
 * @author tim
 */
public interface IPacketEntityFilter<T extends AbstractPacketEntity> {
    boolean filter(T t);

    @SuppressWarnings("unchecked")
    default boolean filterInternal(AbstractPacketEntity abstractPacketEntity){
        return filter((T) abstractPacketEntity);
    }
}
