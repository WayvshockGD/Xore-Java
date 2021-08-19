package com.wayv.xore;

import com.wayv.xore.interfaces.CommandDefinitions;
import com.wayv.xore.modules.core.PingCommand;
import com.wayv.xore.modules.core.StatsCommand;
import com.wayv.xore.modules.information.WhoisCommand;

public class CommandManager {


    public static CommandDefinitions[] all() {
        return new CommandDefinitions[]{
                new PingCommand(),
                new StatsCommand(),
                new WhoisCommand()
        };
    }
}
