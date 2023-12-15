package org.example.states;

import org.example.controller.Controller;
import org.example.controller.game.MapController;
import org.example.model.game.map.Map;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class GameState extends State<Map> {
    private static long startTime;
    private static long elapsedTime;
    private static String highscore = "";

    public GameState(Map map) {
        super(map);
        startTime = System.nanoTime();
        elapsedTime = 0;
    }

    public static long update() {
        // Calculate the elapsed time
        long currentTime = System.nanoTime();
        elapsedTime = currentTime - startTime;
        return elapsedTime;
    }

    public static long displayElapsedTime() {
        long seconds = update() / 1_000_000_000; // Convert nanoseconds to seconds
        return seconds;
    }


    public static void finishGame(int level) {
        long lastTime = displayElapsedTime();

        String name = JOptionPane.showInputDialog("You set a new highscore. What is your name?");
        String highscore = "Level " + level + " " + name + ":" + lastTime + " seconds";

        File scoreFile = new File("highscore.dat");
        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter writeFile = null;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(scoreFile, true); // Append mode
            writer = new BufferedWriter(writeFile);
            writer.write(highscore); // Write the highscore to the file
            writer.newLine(); // Add a newline for the next entry
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }
}