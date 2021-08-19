package com.wayv.xore;

import com.wayv.xore.interfaces.CommandContext;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.User;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.Set;

public class Resolver {

    public User getMessageUser(CommandContext ctx) {
        final Set<Snowflake> mentioned = ctx.getEvent().getMessage().getUserMentionIds();
        var mentionedID = mentioned.toArray();
        final Snowflake guildSelfID = Objects.requireNonNull(ctx
                .getEvent()
                .getMessage()
                .getAuthorAsMember()
                .block()
        ).getId();

        var isMentioned = mentioned.size() == 0;

        return ctx.getClient()
                .getUserById(isMentioned ? guildSelfID : (Snowflake) mentionedID[0])
                .block();
    }
}
