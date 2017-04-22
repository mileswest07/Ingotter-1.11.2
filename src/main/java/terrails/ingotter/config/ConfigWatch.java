package terrails.ingotter.config;

import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class ConfigWatch {

    public ConfigWatch(Path dir) {
        try {
            WatchService watcher = dir.getFileSystem().newWatchService();
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            WatchKey watckKey = watcher.take();

            List<WatchEvent<?>> events = watckKey.pollEvents();
            for (WatchEvent event : events) {
                if (event.kind() == ENTRY_CREATE) {
                    System.out.println("Created: " + event.context().toString());
                }
                if (event.kind() == ENTRY_DELETE) {
                    System.out.println("Deleted: " + event.context().toString());
                }
                if (event.kind() == ENTRY_MODIFY) {
                    System.out.println("Modified: " + event.context().toString());
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}