package com.wayv.xore.command;

import com.wayv.xore.bases.BaseCommand;
import com.wayv.xore.interfaces.CommandCtx;

public class Test extends BaseCommand {

    @Override
    public void define() {
        this.name = "test";
        this.description = "Just some testing...";
    }

    @Override
    public void executeCommand(CommandCtx ctx) {
        var channel = ctx
                .getMessage()
                .getChannel()
                .block();

        if (channel != null) {
            channel.createMessage("HI!").block();
        }
    }
}
