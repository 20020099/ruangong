package com.cbs.look;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameListener extends MouseAdapter implements ActionListener {
    private JFrame frame;
    private Graphics2D g;

    public void setFrame(JFrame frame) {
        this.frame = frame;
        g = (Graphics2D) frame.getGraphics();
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if ("随机生成生命方块".equals(str)) {
            for (int i = 0; i < GameLook.array.length; i++) {
                Arrays.fill(GameLook.array[i], 0);
            }
            ArrayList<PointLocation> point = new ArrayList<>();
            int x, y;
            Random r1 = new Random();
            Random r2 = new Random();
            for (int i = 0; i < GameLook.NUMBER; i++) {
                x = r1.nextInt(30);
                y = r2.nextInt(30);
                while (GameLook.array[x][y] == 1) {
                    x = r1.nextInt(30);
                    y = r2.nextInt(30);
                }
                GameLook.array[x][y] = 1;
                PointLocation p = new PointLocation(x, y);
                point.add(p);

            }
            frame.repaint();
            frame.addMouseListener(this);
        } else if ("演化下一步".equals(str)) {
            Algorithm a = new Algorithm();
            GameLook.array = a.evolve(GameLook.array);
            frame.repaint();
        } else if ("一直演化".equals(str)) {
            Continue.stop = true;
            Continue c = new Continue();
            c.setjFrame(frame);
            c.start();
        } else if ("停止演化".equals(str)) {
            Continue.stop = false;
        } else if ("重置".equals(str)) {
            GameLook.number.setText("");
        } else if ("确认".equals(str)) {
            GameLook.NUMBER = Integer.parseInt(GameLook.number.getText());
            if (GameLook.NUMBER > 900 || GameLook.NUMBER <= 0) {
                JOptionPane.showMessageDialog(null, "输入的数量有问题，请重新输入");
                GameLook.NUMBER = 450;
                GameLook.number.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "已重置初始化生命方块数量");
            }
        }
    }
}