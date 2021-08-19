package com.wayv.xore.modules.core;

import com.wayv.xore.bases.BaseCommand;
import com.wayv.xore.interfaces.CommandContext;
import com.wayv.xore.interfaces.CommandDefinitions;
import com.wayv.xore.util.Util;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.gateway.GatewayClient;
import discord4j.rest.util.Color;

import java.util.Objects;

public class PingCommand extends BaseCommand implements CommandDefinitions {

    @Override
    public String name() {
        return "ping";
    }

    @Override
    public void executeCommand(CommandContext ctx) {
        final MessageChannel channel = ctx.getEvent().getMessage().getChannel().block();
        final String shardPing =
                ctx.getClient().getGatewayClient(
                        ctx.getEvent().getShardInfo()
                                .getIndex()
                )
                        .map(GatewayClient::getResponseTime)
                        .map(Util::formatTime)
                        .orElse("null");

        assert channel != null;

        Objects.requireNonNull(channel.createMessage(messageCreateSpec -> {
            messageCreateSpec.addEmbed(embedCreateSpec -> {
                embedCreateSpec.setDescription("Pinging...");
                embedCreateSpec.setColor(Color.TAHITI_GOLD);
            });
        }).block()).edit(msg -> {
            try {
                Thread.sleep(700);
                msg.addEmbed(embed -> {
                    embed.setDescription("Pong! Gateway Ping: " + shardPing);
                    embed.setColor(Color.ORANGE);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
                msg.addEmbed(embed -> {
                    embed.setDescription("Something went wrong while pinging!");
                    embed.setColor(Color.RED);
                });
            }
        }).block();
    }
}
