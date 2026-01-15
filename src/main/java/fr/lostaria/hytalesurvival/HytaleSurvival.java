package fr.lostaria.hytalesurvival;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import fr.lostaria.hytalesurvival.commands.BroadcastCommand;
import fr.lostaria.hytalesurvival.commands.ListCommand;
import fr.lostaria.hytalesurvival.listeners.PlayerReadyListener;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class HytaleSurvival extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public HytaleSurvival(@NonNullDecl JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up plugin " + this.getName());
        this.getCommandRegistry().registerCommand(new BroadcastCommand());
        this.getCommandRegistry().registerCommand(new ListCommand());

        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, new PlayerReadyListener()::onPlayerReady);
    }
}
