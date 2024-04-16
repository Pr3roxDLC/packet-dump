package me.pr3.packetdump;

import com.github.retrooper.packetevents.event.PacketEvent;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientChatMessage;
import me.pr3.packetdump.cache.Cache;
import org.bukkit.plugin.java.JavaPlugin;

import static me.pr3.packetdump.persistence.PersistenceHandler.PERSISTENCE_HANDLER;

public final class PacketDump extends JavaPlugin {

    public final static Cache<ProtocolPacketEvent<?>> CACHE = new Cache<>(200, PERSISTENCE_HANDLER::persist);

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
