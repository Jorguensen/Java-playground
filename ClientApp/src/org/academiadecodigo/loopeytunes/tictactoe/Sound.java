package org.academiadecodigo.loopeytunes.tictactoe;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Sound {

    private Clip clip;

    public Sound(String path) {
        initClip(path);
    }

    public void play(boolean fromStart) {

        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    private void initClip(String path) {

        URL soundURL = Sound.class.getResource(path);
        AudioInputStream inputStream;

        try {

            if (soundURL == null) {
                File file = new File(path);
                soundURL = file.toURI().toURL();
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



