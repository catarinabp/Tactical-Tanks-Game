package org.example.states;

import org.example.controller.Controller;
import org.example.controller.game.MapController;
import org.example.model.game.map.Map;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

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

        // Initialize TreeMap to store high scores
        TreeMap<String, Long> highScores = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        BufferedReader reader = null;

        try {
            // Read existing high scores into the TreeMap
            reader = new BufferedReader(new FileReader(scoreFile));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    highScores.put(parts[0], Long.parseLong(parts[1].split("\\s+")[0])); // Extract the numeric part
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Get the lowercase version of the provided high score
        String lowercaseHighscore = highscore.split(":")[0].toLowerCase();

        // Check if the TreeMap contains the key (Case insensitive)
        if (highScores.containsKey(lowercaseHighscore)) {
            long storedTime = highScores.get(lowercaseHighscore);
            if (storedTime > lastTime) {
                highScores.put(lowercaseHighscore, lastTime);
            }
        } else {
            highScores.put(lowercaseHighscore, lastTime);
        }

        // Write the updated high scores to the file
        FileWriter writeFile = null;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(scoreFile);
            writer = new BufferedWriter(writeFile);

            // Write each high score entry to the file
            for (String key : highScores.keySet()) {
                writer.write(key + ":" + highScores.get(key) + " seconds"); // Include the 'seconds' label
                writer.newLine();
            }
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