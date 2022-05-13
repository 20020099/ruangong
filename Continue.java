package com.cbs.look;

import javax.swing.*;
import java.awt.*;

public class Continue extends Thread {

    private JFrame jFrame;
    private Graphics2D g;
    public static boolean stop = true;

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
        g = (Graphics2D) jFrame.getGraphics();
    }

    @Override
    public void run() {
        while (stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Algorithm a = new Algorithm();
            GameLook.array = a.evolve(GameLook.array);
            jFrame.repaint();
        }
    }
}
