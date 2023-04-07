package com.tankwars.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * @Author yangmingquan
 * @Date 2023/4/7 9:05
 * @PackageName:com.tankwars.utils
 * @ClassName: MusicUtil
 * @Description: TODO
 * @Version 1.0
 */
public class MusicUtil {
    String fireMusic = "music/fire.wav";
    String startMusic = "music/start.wav";
    String boomMusic = "music/boom.wav";

    public void fire() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fireMusic));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void startMusic() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(startMusic));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void boomMusic() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(boomMusic));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
