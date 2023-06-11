package org.example;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class WorkWithOS {

    public void openZip(String filename) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("C:\\Games\\GunRunner\\savegames\\zip0.zip"))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                filename = entry.getName();
                System.out.printf("File name: %s \n", filename);
                FileOutputStream fout = new FileOutputStream("C:\\Games\\GunRunner\\savegames\\" + filename);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void deserializeFile(String path) {
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream("C:\\Games\\GunRunner\\savegames\\" + path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(gameProgress);

    }
}
