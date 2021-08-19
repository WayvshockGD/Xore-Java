package com.wayv.xore.events;

import com.wayv.xore.annotations.DefineEvent;
import com.wayv.xore.bases.BaseEvent;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.presence.Activity;
import discord4j.core.object.presence.Presence;
import discord4j.discordjson.json.gateway.StatusUpdate;

@DefineEvent(name="ReadyEvent", description="Runs on bot/gateway startup.")
public class BotReadyEvent extends BaseEvent {

    public BotReadyEvent(GatewayDiscordClient client) {
        super(client);
    }

    @Override
    public void runEvent(ReadyEvent event) {
        var self = event.getSelf();
        var clientGuilds = event.getClient().getGuilds().count().block();
        System.out.println("Connected to the discord gateway as " + self.getUsername());
        event.getClient().updatePresence(
                Presence.idle(
                        Activity.watching(
                                "Mod-Logs and " + clientGuilds + " guilds"
                        )
                )
        ).block();
    }

    @Override
    public void runEvent(MessageCreateEvent event) {}
}
