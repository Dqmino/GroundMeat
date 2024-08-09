package codes.domino.serializer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public abstract class MapSerializer<K, V> {

    public void save() throws IOException {
        Path path = Paths.get(getDirectoryPath() + File.separator + "ground-meat" + File.separator + "records.txt");
        try (FileOutputStream myFileOutStream = new FileOutputStream(path.toString())) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(myFileOutStream)) {
                outputStream.writeObject(getMapToSerialize());
            }
        }

    }

    public Map<K, V> load() throws IOException, ClassNotFoundException {
        String dirPath = getDirectoryPath() + File.separator + "ground-meat";
        String path = dirPath + File.separator + "records.txt";
        new File(dirPath).mkdirs();
        File theFile = new File(path);
        theFile.createNewFile();
        if (theFile.length() == 0) {
            return null;
        }
        try (FileInputStream fileInput = new FileInputStream(path)) {
            try (ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
                return (HashMap<K, V>) objectInput.readObject();
            }
        }
    }

    abstract Map<K, V> getMapToSerialize();

    abstract String getDirectoryPath();
}
