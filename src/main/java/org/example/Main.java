package org.example;

public class Main {
    public static void main(String[] args) {
        String path = "save0.dat";
        WorkWithOS workWithOS = new WorkWithOS();
        workWithOS.openZip(path);
        workWithOS.deserializeFile(path);

    }
}