package com.wayv.xore.events;

import com.wayv.xore.CommandManager;
import com.wayv.xore.Config;
import com.wayv.xore.annotations.DefineEvent;
import com.wayv.xore.bases.BaseEvent;
import com.wayv.xore.interfaces.CommandDefinitions;
import com.wayv.xore.service.HelpService;
import com.wayv.xore.structures.Command;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

import java.util.Objects;

@DefineEvent(name="BotReadyEvent", description="Activated whenever the bot receives a message.")
public class BotMessageEvent extends BaseEvent {

    public BotMessageEvent(GatewayDiscordClient client) {
        super(client);
    }

    @Override
    public void runEvent(ReadyEvent event) {}

    @Override
    public void runEvent(MessageCreateEvent event) {
        final Message message = event.getMessage();
        final String argument = message.getContent();
        final String[] args = argument.split(" ");
        final CommandDefinitions[] commands = CommandManager.all();
        final Command ctx = new Command(this.client, event);
        Config config = new Config();

        final boolean isBot = this.checkIfBot(
                Objects.requireNonNull(
                        message.getAuthorAsMember().block()
                )
        );

        if (isBot) return;

            if (args[0].equals(config.getPrefix() + "help")) {
                System.out.println(
                        "Help command executed by " + message.getUserData().username()
                );
                HelpService.initService(message);
            }

            for (CommandDefinitions command : commands) {
                if (args[0].equals(config.getPrefix() + command.name())) {
                    System.out.println(
                            command.name() + " Executed by user " + message.getUserData().username()
                    );
                    command.executeCommand(ctx);
                    return;
                }
            }
    }

    private boolean checkIfBot(User user) {
        return user.isBot();
    }
}
