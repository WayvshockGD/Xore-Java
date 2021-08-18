package com.wayv.xore.events;

import com.wayv.xore.annotations.DefineEvent;
import com.wayv.xore.bases.BaseEvent;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;

@DefineEvent(name="ReadyEvent", description="Runs on bot/gateway startup.")
public class BotReadyEvent extends BaseEvent {

    public BotReadyEvent(GatewayDiscordClient client) {
        super(client);
    }

    @Override
    public void runEvent(ReadyEvent event) {
        var self = event.getSelf();
        System.out.println("Connected to the discord gateway as " + self.getUsername());
    }
}
