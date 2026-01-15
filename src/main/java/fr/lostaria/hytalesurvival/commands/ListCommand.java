package fr.lostaria.hytalesurvival.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ListCommand extends CommandBase {

    public ListCommand() {
        super("list", "Aficher la liste des joueurs en ligne");
    }

    @Override
    protected void executeSync(@NonNullDecl CommandContext commandContext) {
        Universe universe = Universe.get();
        String connectedPlayers = "Liste des joueurs en ligne :\n";
        for(PlayerRef plsR : universe.getPlayers()) {
            connectedPlayers += "- " + plsR.getUsername() + "\n";
        }
        connectedPlayers += "\nTotal : " + universe.getPlayers().size() + " joueurs";
        commandContext.sendMessage(Message.raw(connectedPlayers));
    }

}
