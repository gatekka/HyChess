package com.gatekka.hychess;

import com.gatekka.hychess.Commands.Hychess;
import com.gatekka.hychess.Commands.Test;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

/**
 * This class serves as the entrypoint for your plugin. Use the setup method to register into game registries or add
 * event listeners.
 */
public class Main extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public Main(@Nonnull JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from " + this.getName() + " version " + this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up plugin " + this.getName());
        this.getCommandRegistry().registerCommand(new Test(this.getName(), this.getManifest().getVersion().toString()));
        this.getCommandRegistry().registerCommand(new Hychess());
        this.getCodecRegistry(Interaction.CODEC).register("Chessboard", ChessboardInteraction.class, ChessboardInteraction.CODEC);
    }
}