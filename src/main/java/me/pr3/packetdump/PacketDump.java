package me.pr3.packetdump;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketEvent;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientChatMessage;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import me.pr3.packetdump.cache.Cache;
import me.pr3.packetdump.listener.ConfigurablePacketListener;
import org.bukkit.plugin.java.JavaPlugin;

import static me.pr3.packetdump.persistence.PersistenceHandler.PERSISTENCE_HANDLER;

public final class PacketDump extends JavaPlugin {

    public final static Cache<ProtocolPacketEvent<?>> CACHE = new Cache<>(200, PERSISTENCE_HANDLER::persist);

    @Override
    public void onEnable() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().getSettings().reEncodeByDefault(false)
                .checkForUpdates(true)
                .bStats(true);
        PacketEvents.getAPI().load();
        PacketEvents.getAPI().getEventManager().registerListener(new ConfigurablePacketListener(),
                PacketListenerPriority.HIGHEST);
        PacketEvents.getAPI().init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
