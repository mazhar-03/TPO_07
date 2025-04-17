package org.example.tpo_07.service;

import org.example.tpo_07.model.FormattedVersion;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class StorageService {
    private static final Path STORAGE_PATH = Paths.get("storage");

    public StorageService() {
        try {
            Files.createDirectory(STORAGE_PATH);
        }catch (IOException e){}
    }

    public void save (FormattedVersion version) {
        File file = STORAGE_PATH.resolve(version.getId() + ".ser").toFile();
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(version);
        }catch (IOException e){
            e.printStackTrace();
        }
        automaticDeletion(file, version.getExpireInSeconds());
    }

    private void automaticDeletion(File file, int seconds) {
        new Timer().schedule(new TimerTask() {
            public void run() {
                file.delete();
            }
        }, seconds * 1000L);
    }
}
