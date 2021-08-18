package com.wayv.xore.interfaces;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Message;

public interface CommandCtx {
    GatewayDiscordClient getClient();
    Message getMessage();
}
