package com.wayv.xore.bases;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.GatewayLifecycleEvent;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;

public abstract class BaseEvent {

    public GatewayDiscordClient client;

    public BaseEvent(GatewayDiscordClient client) {
        this.client = client;
    }

    public void runEvent(GatewayLifecycleEvent event) {}

    public abstract void runEvent(ReadyEvent event);
    public abstract void runEvent(MessageCreateEvent event);
}
