package com.wayv.xore;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CommandManager {

    public static void load() throws IOException {
        Path current = Paths.get(System.getProperty("user.dir"));

        Path dir = Paths.get(current.toString(),
                "src",
                "main",
                "java",
                "com",
                "wayv",
                "xore",
                "command"
        );

        try (Stream<Path> paths = Files.walk(Path.of(dir.toString()))) {
            paths.filter(Files::isRegularFile)
                 .forEach((file) -> {
                 });
        }
    }
}
