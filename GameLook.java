package com.cbs.look;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameLook extends JFrame implements LookConfig {

    public static int[][] array = new int[30][30];// 数组用于保存界面的信息
    public static  JTextField number;
    public static int NUMBER = 450;
    public static JLabel rate;


    public static void main(String[] args) throws InterruptedException {
        GameLook g = new GameLook();
        g.showUI();
    }

    public void showUI() throws InterruptedException {
        setTitle("生命游戏");
        setSize(900, 750);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(null);
        setResizable(false);
        JButton startJB = new JButton("随机生成生命方块");
        startJB.setBounds(700, 50, 150, 40);
        startJB.setBorderPainted(false);
        startJB.setFocusable(false);
        startJB.setContentAreaFilled(false);
        this.add(startJB);
        JButton evolve = new JButton("演化下一步");
        evolve.setFocusable(false);
        evolve.setBounds(710, 150, 100, 40);
        evolve.setBorderPainted(false);
        evolve.setContentAreaFilled(false);
        this.add(evolve);
        JButton Endless = new JButton("一直演化");
        Endless.setFocusable(false);
        Endless.setBounds(700,250,100,40);
        Endless.setBorderPainted(false);
        Endless.setContentAreaFilled(false);
        this.add(Endless);
        JButton stopEvolve = new JButton("停止演化");
        stopEvolve.setFocusable(false);
        stopEvolve.setBounds(700,350,100,40);
        stopEvolve.setBorderPainted(false);
        stopEvolve.setContentAreaFilled(false);
        this.add(stopEvolve);
        JLabel jLabel = new JLabel("请输入初始化生命方块的数量:");
        jLabel.setBounds(700,450,200,40);
        this.add(jLabel);
        number = new JTextField(20);
        number.setBounds(700,490,150,20);
        this.add(number);
        JButton confirm = new JButton("确认");
        confirm.setBounds(700,520,80,20);
        confirm.setBorderPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.setFocusable(false);
        this.add(confirm);
        JButton Reset = new JButton("重置");
        Reset.setBounds(780,520,80,20);
        Reset.setBorderPainted(false);
        Reset.setContentAreaFilled(false);
        Reset.setFocusable(false);
        this.add(Reset);
        rate = new JLabel("存活率：");
        rate.setBounds(700,600,150,20);
        this.add(rate);
        setVisible(true);
        GameListener gl = new GameListener();
        startJB.addActionListener(gl);
        evolve.addActionListener(gl);
        Endless.addActionListener(gl);
        stopEvolve.addActionListener(gl);
        confirm.addActionListener(gl);
        Reset.addActionListener(gl);
        gl.setFrame(this);
        SurvivalRate sr = new SurvivalRate();
        sr.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffPaint(g);
    }

    public void buffPaint(Graphics g) {
        Image i = createImage(space + (size + space) * array[0].length, space
                + (size + space) * array.length);
        Graphics2D g2d = (Graphics2D) i.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // 绘制背景矩形
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0, 0, space + (size + space) * array[0].length, space
                + (size + space) * array.length, arc, arc);
        // 绘制背景方格
        g2d.setColor(new Color(245, 245, 220));
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                g2d.fillRect(space + (size + space) * c, space + (size + space)
                        * r, size, size);
            }
        }
        // 绘制图片
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("宋体", Font.BOLD, 30));
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                if (array[r][c] != 0) {
                    ImageIcon icon = new ImageIcon("src\\com\\cbs\\look\\1.png");
                    Image image = icon.getImage();
                    g2d.drawImage(image, space + (size + space) * c, space
                            + (size + space) * r, size, size, null);
                }
            }
        }
        g.drawImage(i, x, y, this);
    }
}