package com.wayv.xore.service;

import discord4j.core.GatewayDiscordClient;

public class BotService {
    /**
     * As you may expect, it runs the bot.
     */
    public static void runBot(GatewayDiscordClient client) {
        client.onDisconnect().block();
    }
}
