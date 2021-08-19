package com.wayv.xore.service;

import com.wayv.xore.Config;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.rest.util.Color;

import java.util.Arrays;

public class HelpService {

    public static void initService(Message message) {

        final MessageChannel channel = message.getChannel().block();

        assert channel != null;
        channel.createMessage(messageCreateSpec -> messageCreateSpec.addEmbed(embedCreateSpec -> {
            embedCreateSpec.setTitle("Help Menu");
            embedCreateSpec.addField(
                    "Core Commands",
                    Arrays.toString(getCommandList_Core()),
                    true
            );
            embedCreateSpec.setColor(Color.TAHITI_GOLD);
        })).block();
        }

    private static String[] getCommandList_Core() {
        var config = new Config();
        return new String[]{
                config.getPrefix() + "ping",
                config.getPrefix() + "help"
        };
    }
}
