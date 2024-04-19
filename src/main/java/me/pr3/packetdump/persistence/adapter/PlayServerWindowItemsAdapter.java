package me.pr3.packetdump.persistence.adapter;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerWindowItems;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.pr3.packetdump.persistence.model.PlayServerWindowItemsPacketEntity;
import org.bukkit.inventory.ItemStack;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

/**
 * @author tim
 */
public class PlayServerWindowItemsAdapter implements IPacketAdapter<PlayServerWindowItemsPacketEntity> {
    @Override
    public PlayServerWindowItemsPacketEntity adapt(ProtocolPacketEvent<?> packetEvent) {
        WrapperPlayServerWindowItems packet = new WrapperPlayServerWindowItems((PacketSendEvent) packetEvent);
        List<byte[]> content = packet.getItems().stream()
                .map(SpigotConversionUtil::toBukkitItemStack)
                .filter(not(ItemStack::isEmpty))
                .map(ItemStack::serializeAsBytes)
                .toList();
        return new PlayServerWindowItemsPacketEntity(
                Instant.now(),
                packetEvent.getUser().getUUID(),
                content);

    }
}
