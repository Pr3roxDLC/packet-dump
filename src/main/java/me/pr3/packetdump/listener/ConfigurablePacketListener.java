package me.pr3.packetdump.listener;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import me.pr3.packetdump.PacketDump;

public class ConfigurablePacketListener implements PacketListener {

    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        PacketDump.CACHE.add(event.clone());
    }
    @Override
    public void onPacketSend(PacketSendEvent event) {
        PacketDump.CACHE.add(event.clone());
    }
}
