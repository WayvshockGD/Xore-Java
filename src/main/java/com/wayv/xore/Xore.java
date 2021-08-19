package com.wayv.xore;

import com.wayv.xore.events.BotMessageEvent;
import com.wayv.xore.events.BotReadyEvent;
import com.wayv.xore.service.BotService;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;

public class Xore {

    public static void main(String[] args) {
        Config config = new Config();
        GatewayDiscordClient client;
        client = DiscordClientBuilder.create(config.getToken())
                .build()
                .gateway()
                .login()
                .block();

        assert client != null;
        initEvents(client);
        BotService.runBot(client);
    }

    public static void initEvents(GatewayDiscordClient client) {
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe((event) -> {
                    new BotReadyEvent(client).runEvent(event);
                });
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .subscribe((event) -> {
                    new BotMessageEvent(client).runEvent(event);
                });
    }
}
