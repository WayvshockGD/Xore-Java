package com.wayv.xore;

import com.wayv.xore.events.BotReadyEvent;
import com.wayv.xore.service.BotService;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Xore {

    public static void main(String[] args) throws IOException {
        GatewayDiscordClient client = DiscordClientBuilder.create(Config.getToken(true))
                .build()
                .login()
                .block();

        assert client != null;
        initEvents(client);
        loadCommands();
        BotService.runBot(client);
    }

    public static void loadCommands() throws IOException {
        CommandManager.load();
    }

    public static void initEvents(GatewayDiscordClient client) {
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe((event) -> {
                    new BotReadyEvent(client).runEvent(event);
                });
    }
}
