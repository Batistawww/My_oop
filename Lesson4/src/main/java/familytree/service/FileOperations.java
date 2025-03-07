package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.*;

public class FileOperations implements IFileOperations {
    @Override
    public void saveToFile(String fileName, FamilyTree<?> familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream(fileName)))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<?> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                    new FileInputStream(fileName)))) {
            return (FamilyTree<?>) ois.readObject();
        }
    }
}