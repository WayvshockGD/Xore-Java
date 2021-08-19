package com.wayv.xore.structures;

import com.wayv.xore.interfaces.CommandContext;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;

public class Command implements CommandContext {
    public GatewayDiscordClient client;
    public MessageCreateEvent event;

    public Command(GatewayDiscordClient client, MessageCreateEvent event) {
        this.client = client;
        this.event = event;
    }

    @Override
    public MessageCreateEvent getEvent() {
        return this.event;
    }

    @Override
    public GatewayDiscordClient getClient() {
        return this.client;
    }
}
