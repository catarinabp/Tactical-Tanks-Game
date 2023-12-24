package org.example.viewer.menu;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordViewer extends Viewer<Menu> {
    private static final String TITLE_COLOR = "#43A6C6";
    private static final String DEFAULT_COLOR = "#FFFFFF";
    private static final int TITLE_X_POS = 9;
    private static final int Instr_X_POS = 1;
    private static final int TITLE_Y_POS = 3;

    public RecordViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
        displayHighScores(gui);
    }

    private void drawTitle(GUI gui) {
        gui.drawText(new Position(TITLE_X_POS, TITLE_Y_POS), "Tactical Tanks", TITLE_COLOR);
    }

    private void displayHighScores(GUI gui) {
        File scoreFile = new File("highscore.dat");
        if (!scoreFile.exists()) {
            gui.drawText(new Position(Instr_X_POS, TITLE_Y_POS + 5), "No high scores available yet.", DEFAULT_COLOR);
            return;
        }

        List<String> highScores = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(scoreFile));
            String line;
            while ((line = reader.readLine()) != null) {
                highScores.add(line);
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

        // Sort the high scores by elapsed time (fewer seconds)
        highScores.sort((score1, score2) -> {
            long time1 = Long.parseLong(score1.substring(score1.lastIndexOf(":") + 1, score1.lastIndexOf(" seconds")));
            long time2 = Long.parseLong(score2.substring(score2.lastIndexOf(":") + 1, score2.lastIndexOf(" seconds")));
            return Long.compare(time1, time2);
        });

        // Display sorted high scores
        gui.drawText(new Position(Instr_X_POS, TITLE_Y_POS + 5), "High Scores:", DEFAULT_COLOR);
        int lineNumber = 1;
        for (String score : highScores) {
            gui.drawText(new Position(Instr_X_POS, TITLE_Y_POS + 5 + lineNumber), score, DEFAULT_COLOR);
            lineNumber++;
        }
    }

}