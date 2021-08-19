package com.wayv.xore.modules.core;

import com.wayv.xore.Config;
import com.wayv.xore.bases.BaseCommand;
import com.wayv.xore.interfaces.CommandContext;
import com.wayv.xore.interfaces.CommandDefinitions;
import discord4j.rest.util.Color;

import java.util.Objects;

public class StatsCommand extends BaseCommand implements CommandDefinitions {

    @Override
    public String name() {
        return "stats";
    }

    @Override
    public void executeCommand(CommandContext ctx) {
        Config config = new Config();
        var self = Objects.requireNonNull(ctx.getClient().getSelf().block());
        var guilds = ctx.getEvent().getClient().getGuilds();
        var owner = config.getBotOwner(Objects.requireNonNull(self.getClient().getApplicationInfo().block()));

        Objects.requireNonNull(ctx.getEvent()
                .getMessage()
                .getChannel()
                .block())
                .createMessage(message -> message.addEmbed(embed -> {
                    embed.setTitle(self.getUsername() + " Stats");
                    embed.setDescription("Currently viewing **Core** stats");
                    embed.setColor(Color.TAHITI_GOLD);
                    embed.addField("Bot Version", config.getBotVersion(), false);
                    embed.addField("Discord4j Version", config.getD4JVersion(), false);
                    embed.addField("Owner", owner, false);
                    embed.addField("Current Guilds", String.valueOf(guilds.count().block()), false);
                }))
                .block();
    }
}
