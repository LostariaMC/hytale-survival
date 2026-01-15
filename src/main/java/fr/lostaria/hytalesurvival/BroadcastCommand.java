package fr.lostaria.hytalesurvival;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class BroadcastCommand extends CommandBase {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public BroadcastCommand() {
        super("broadcast", "Envoyer un broadcast à tous les joueurs");
        this.addAliases("bc");
        this.setAllowsExtraArguments(true);
    }

    @Override
    protected void executeSync(@NonNullDecl CommandContext commandContext) {
        if(!commandContext.isPlayer()) return;
        Player player = commandContext.senderAs(Player.class);
        String input = commandContext.getInputString();
        String message = input.replaceFirst("^\\S+\\s*", "").trim();
        if(message.isEmpty()) {
            player.sendMessage(Message.raw("Vous pouvez pas envoyer une annonce vide !\nUsage : /broadcast <message>"));
            return;
        }
        LOGGER.atInfo().log("Broadcasting '" + message + "' to all players");
        for(PlayerRef plsR : player.getWorld().getPlayerRefs()) {
            EventTitleUtil.showEventTitleToPlayer(plsR, Message.raw(message), Message.raw("ANNONCE DE " + player.getDisplayName()), true, null, 10f, 0.1f, 0.1f);
        }
    }
}
