package com.wayv.xore.bases;

import com.wayv.xore.interfaces.CommandCtx;

public class BaseCommand {

    public String name;
    public String description;
    public boolean enabled;
    public String[] limitTo;

    public void define() {}

    public void executeCommand(CommandCtx ctx) {}
}
