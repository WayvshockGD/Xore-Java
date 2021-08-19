package com.wayv.xore.interfaces;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;

public interface CommandContext {
    MessageCreateEvent getEvent();
    GatewayDiscordClient getClient();
}
