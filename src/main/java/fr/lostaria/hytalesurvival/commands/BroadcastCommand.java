package fr.lostaria.hytalesurvival.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.awt.*;

public class BroadcastCommand extends AbstractPlayerCommand {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public BroadcastCommand() {
        super("broadcast", "Envoyer un broadcast à tous les joueurs");
        addAliases("bc");
        setAllowsExtraArguments(true);
    }


    @Override
    protected void execute(@NonNullDecl CommandContext context, @NonNullDecl Store<EntityStore> store, @NonNullDecl Ref<EntityStore> ref, @NonNullDecl PlayerRef playerRef, @NonNullDecl World world) {
        String input = context.getInputString();
        String message = input.replaceFirst("^\\S+\\s*", "").trim();
        if(message.isEmpty()) {
            playerRef.sendMessage(Message.raw("Vous ne pouvez pas envoyer une annonce vide !\nUsage : /broadcast <message>").color(Color.RED));
            return;
        }
        LOGGER.atInfo().log("Broadcasting '" + message + "' to all players");
        Universe universe = Universe.get();
        for(PlayerRef plsR : universe.getPlayers()) {
            EventTitleUtil.showEventTitleToPlayer(plsR, Message.raw(message), Message.raw("ANNONCE DE " + playerRef.getUsername()), true, null, 10f, 0.1f, 0.1f);
        }
    }
}
