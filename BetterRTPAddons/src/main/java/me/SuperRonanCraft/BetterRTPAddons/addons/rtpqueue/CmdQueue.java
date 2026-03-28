package me.SuperRonanCraft.BetterRTPAddons.addons.rtpqueue;

import me.SuperRonanCraft.BetterRTP.player.commands.RTPCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Collections;
import java.util.List;

public class CmdQueue implements RTPCommand {

    private final AddonQueue addon;

    public CmdQueue(AddonQueue addon) {
        this.addon = addon;
    }

    @Override
    public void execute(CommandSender sendi, String label, String[] args) {
        if (sendi instanceof Player) {
            addon.addPlayer((Player) sendi);
        } else {
            sendi.sendMessage("Only players can join the RTP Queue.");
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sendi, String[] args) {
        return Collections.emptyList();
    }

    @Override
    public boolean permission(CommandSender sendi) {
        return sendi.hasPermission("betterrtp.addon.queue");
    }

    @Override
    public String getName() {
        return "queue";
    }

    @Override
    public boolean isDebugOnly() {
        return false;
    }

    @Override
    public void usage(CommandSender sendi, String label) {
        sendi.sendMessage("Usage: /rtp queue");
    }
}
