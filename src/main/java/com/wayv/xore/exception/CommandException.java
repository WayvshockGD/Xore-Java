package com.wayv.xore.exception;

import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.rest.util.Color;

public class CommandException {

    public CommandException() {}

    public void createCommandException(MessageChannel channel, String content) {
        channel.createMessage(message -> message.addEmbed(embed -> {
            embed.setDescription("Exception: " + content);
            embed.setColor(Color.RUBY);
        })).block();
    }
}
