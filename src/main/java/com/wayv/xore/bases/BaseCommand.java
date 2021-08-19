package com.wayv.xore.bases;

import com.wayv.xore.Resolver;
import com.wayv.xore.exception.CommandException;
import com.wayv.xore.interfaces.CommandContext;
import com.wayv.xore.interfaces.CommandDefinitions;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.MessageCreateSpec;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class BaseCommand implements CommandDefinitions {

    public String name() {
        return "None";
    }

    public String description() {
        return "No description";
    }

    public CommandException getExceptions() {
        return new CommandException();
    }

    public Resolver getResolvers() {
        return new Resolver();
    }

    public Mono<Message> sendWsMessage(MessageChannel channel, Consumer<? super MessageCreateSpec> content) {
        return channel.createMessage(content);
    }

    public void executeCommand(CommandContext ctx) {}
}
