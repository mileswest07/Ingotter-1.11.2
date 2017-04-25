package terrails.ingotter.config;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import terrails.ingotter.Constants;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;
import static terrails.ingotter.config.ConfigHandler.config;
import static terrails.ingotter.config.ConfigHandler.mainConfig;
import static terrails.ingotter.config.ConfigOreHandler.configIngotter;
import static terrails.ingotter.config.ConfigOreHandler.configOreVariables;
import static terrails.ingotter.config.ConfigOreHandler.configWorld;

public class ConfigWatch implements Runnable{

    private Path configDir;

    public ConfigWatch(Path dir) {
        this.configDir = dir;
    }

    @Override
    public void run() {
        configWatch(configDir);
    }

    private void configWatch(Path dir){
        Constants.LOGGER.info("Config directory currently being monitored: " + dir);
        for (;;) {
            try {
                WatchService watcher = dir.getFileSystem().newWatchService();
                dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

                WatchKey watckKey = watcher.take();

                List<WatchEvent<?>> events = watckKey.pollEvents();
                for (WatchEvent event : events) {
                    if (event.kind() == ENTRY_CREATE) {
                        continue;
                    //    System.out.println("Created: " + event.context().toString());
                    }
                    if (event.kind() == ENTRY_DELETE) {
                        continue;
                        //     System.out.println("Deleted: " + event.context().toString());
                    }
                    if (event.kind() == ENTRY_MODIFY) {
                        if(event.context().toString().contains("Custom")){
                            Constants.LOGGER.info(event.context().toString() + " has been modified and synced with game");
                            configWorld.load();
                            configWorld.save();
                            configOreVariables();
                        }
                        else if(event.context().toString().contains("Ingotter-")){
                            Constants.LOGGER.info(event.context().toString() + " has been modified and synced with game");
                            configIngotter.load();
                            configIngotter.save();
                            configOreVariables();
                        }
                        else if(event.context().toString().contains("er.cfg")){
                            Constants.LOGGER.info(event.context().toString() + " has been modified and synced with game");
                            config.load();
                            config.save();
                            mainConfig();
                        }
                    }
                    if (event.kind() == OVERFLOW) {
                        continue;
                        //    System.out.println("Overflowing is happening");
                    }
                }
                boolean valid = watckKey.reset();
                if (!valid) {
                    break;
                }
            } catch (Exception e) {
                Constants.LOGGER.info("Error: " + e.toString());
            }
        }
    }
/*
    private void walkAndRegisterDirectories(final Path start) {
        // register directory and sub-directories
        try {
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
                        configWatch(dir);
                        return FileVisitResult.CONTINUE;
                }
            });
        }
        catch (IOException e){}
    }*/
}
