package com.wayv.xore.interfaces;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

public interface CommandDefinitions {
    String name();
    String description();
    public void executeCommand(CommandContext ctx);
}
