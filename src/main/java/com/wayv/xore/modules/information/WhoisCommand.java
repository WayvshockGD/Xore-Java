package com.wayv.xore.modules.information;

import com.wayv.xore.bases.BaseCommand;
import com.wayv.xore.interfaces.CommandContext;
import com.wayv.xore.interfaces.CommandDefinitions;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WhoisCommand extends BaseCommand implements CommandDefinitions {

    @Override
    public String name() {
        return "whois";
    }

    @Override
    public void executeCommand(CommandContext ctx) {
        final MessageChannel channel = (MessageChannel) ctx.getEvent().getMessage().getChannel().block();
        final User user = this.getResolvers().getMessageUser(ctx);

        if (user == null) {

            if (channel != null) {
                this.getExceptions()
                        .createCommandException(channel,
                                "The user you mentioned was either missing or null."
                        );
            }
        }

        if (channel != null) {
            this.sendWsMessage(channel, message -> message.addEmbed(embed -> {
                if (user != null) {
                    List<String> roles = new ArrayList<String>();
                    var avatar = user.getAvatarUrl();
                    var memberUser = user.asMember(Objects.requireNonNull(ctx
                            .getEvent()
                            .getGuild()
                            .block())
                            .getId())
                            .block();

                    if (memberUser != null) {
                        memberUser.getRoles().subscribe(role -> {
                            roles.add("<@&" + role.getId().toString() + ">");
                        });
                    }

                    embed.setTitle("User: " + user.getTag());
                    embed.addField("Is Bot", user.isBot() ? "Yes" : "No", true);
                    embed.addField("Roles", roles.toString(), true);
                    embed.setThumbnail(avatar);
                }
            })).block();
        }
    }
}
