package com.gatekka.hychess.Commands;

import javax.annotation.Nonnull;

import com.gatekka.hychess.Pages.HychessPage;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class Hychess extends AbstractPlayerCommand {

    public Hychess() {
        super("hychess", "Opens HyChess UI", false);
    }

    @Override
    protected void execute(@Nonnull CommandContext ctx,
        @Nonnull Store<EntityStore> store,
        @Nonnull Ref<EntityStore> ref,
        @Nonnull PlayerRef playerRef,
        @Nonnull World world
    ) {
        Player player = store.getComponent(ref, Player.getComponentType());
        if (player == null) {
            throw new IllegalArgumentException("Player is null");
        }
        HychessPage page = new HychessPage(playerRef);
        player.getPageManager().openCustomPage(ref, store, page);
    }
    
}
