package me.SuperRonanCraft.BetterRTPAddons.addons.rtpqueue;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import me.SuperRonanCraft.BetterRTP.player.commands.RTPCommand;
import me.SuperRonanCraft.BetterRTPAddons.Addon;
import me.SuperRonanCraft.BetterRTP.BetterRTP;
import org.bukkit.Bukkit;

public class AddonQueue implements Addon {

    private final List<Player> queue = new ArrayList<>();
    
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void load() {
        Bukkit.getScheduler().runTaskTimer(BetterRTP.getInstance(), () -> {
            if (!queue.isEmpty()) {
                Player p = queue.remove(0);
                if (p != null && p.isOnline()) {
                    Bukkit.dispatchCommand(p, "rtp");
                }
            }
        }, 100L, 100L);
    }

    @Override
    public void unload() {
        queue.clear();
    }

    @Override
    public RTPCommand getCmd() {
        return new CmdQueue(this);
    }
    
    public void addPlayer(Player p) {
        if (!queue.contains(p)) {
            queue.add(p);
            p.sendMessage("You have joined the RTP Queue. Position: " + queue.size());
        }
    }
}
