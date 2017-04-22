package terrails.ingotter.config;

import java.nio.file.*;
import java.util.List;

import static terrails.ingotter.config.ConfigOreHandler.configIngotter;
import static terrails.ingotter.config.ConfigOreHandler.configWorld;

public class ConfigWatch {

    public static void testForConfigChange(Path myDir) {
        System.out.println("The Directory is: " + myDir.toString());
        while (true) {
            try {
                WatchService watcher = myDir.getFileSystem().newWatchService();
                myDir.register(watcher,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE,
                        StandardWatchEventKinds.ENTRY_MODIFY);

                WatchKey watchKey = watcher.take();

                List<WatchEvent<?>> events = watchKey.pollEvents();
                for (WatchEvent event : events) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.println("Created: " + event.context().toString());
                    }
                    if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                        System.out.println("Deleted: " + event.context().toString());
                    }
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("Modified: " + event.context().toString());
                        configWorld.save();
                        configIngotter.save();
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
    }
}

/*
        try {
            Boolean isFolder = (Boolean) Files.getAttribute(myDir,
                    "basic:isDirectory", LinkOption.NOFOLLOW_LINKS);
            if (!isFolder) {
                throw new IllegalArgumentException("Path: " + myDir + " is not a folder");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Watching path: " + myDir);

        FileSystem fileSystem = myDir.getFileSystem();

        try(WatchService service = fileSystem.newWatchService()){

            myDir.register(service, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_MODIFY}, SensitivityWatchEventModifier.HIGH);

            WatchKey key = null;
            while (true) {
                key = service.take();

                WatchEvent.Kind<?> kind = null;
                for(WatchEvent<?> watchEvent : key.pollEvents()){

                    kind = watchEvent.kind();
                    if(StandardWatchEventKinds.OVERFLOW == kind){
                        continue;
                    }
                    else if (StandardWatchEventKinds.ENTRY_MODIFY == kind){
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();

                        System.out.println("The file has changed: " + newPath);
                    }
                }
                if(!key.reset()){
                    break;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
*/