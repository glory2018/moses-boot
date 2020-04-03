package com.moses.framework.samples.flipchess;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class Checkerboard extends JPanel {
    //棋盘宽
    public static final int GAME_WIDTH = 630;
    //格宽，直径
    public static final int DIAMETER = GAME_WIDTH / 9;
    //格宽的一半
    public static final int HALF_METER = DIAMETER / 2;
    //棋盘高
    public static final int GAME_HEIGHT = DIAMETER * 10;
    //棋子
    public Piece[][] pieceList;
    //黑棋
    public String[] blackChess = {"車", "馬", "象", "士", "帥", "士", "象", "馬", "車", "砲", "砲", "卒", "卒", "卒", "卒", "卒"};
    //红棋
    public String[] redChess = {"車", "馬", "相", "仕", "将", "仕", "相", "馬", "車", "炮", "炮", "兵", "兵", "兵", "兵", "兵"};

    /**
     * 棋盘
     */
    public Checkerboard() {
        //设置宽高
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        //初始化棋子
        initPiece(false);
    }

    /**
     * 初始化棋子
     */
    public void initPiece(boolean turnAround) {
        List<Piece> list = new ArrayList<Piece>();
        for (int i = 0; i < blackChess.length; i++) {
            list.add(new Piece(false, blackChess[i]));
        }
        for (int i = 0; i < redChess.length; i++) {
            list.add(new Piece(true, redChess[i]));
        }
        pieceList = new Piece[9][10];
        Random ra = new Random();
        int num;
        for (int i = 0; i < 9; i++) {
            for (int j = 5; j <= 8; j++) {
                if (list.size() > 0) {
                    num = ra.nextInt(list.size());
                    pieceList[i][j] = new Piece(i, j, list.get(num).isCamp(), list.get(num).getName());
                    initLevel(pieceList[i][j]);
                    list.remove(num);
                }
            }
        }
        this.repaint();
    }

    /**
     * 初始棋子级别
     *
     * @param piece
     */
    private void initLevel(Piece piece) {
        switch (piece.getHiddenName()) {
            case "兵":
                piece.setLevel(0);
                break;
            case "卒":
                piece.setLevel(0);
                break;
            case "砲":
                piece.setLevel(1);
                break;
            case "炮":
                piece.setLevel(1);
                break;
            case "車":
                piece.setLevel(2);
                break;
            case "馬":
                piece.setLevel(3);
                break;
            case "象":
                piece.setLevel(4);
                break;
            case "相":
                piece.setLevel(4);
                break;
            case "士":
                piece.setLevel(5);
                break;
            case "仕":
                piece.setLevel(5);
                break;
            case "帥":
                piece.setLevel(6);
                break;
            case "将":
                piece.setLevel(6);
                break;
        }
    }

    /**
     * @param g1
     */
    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;  //g是Graphics对象
        drawboard(g);
        //画棋子
        g.setColor(Color.black);// 设置画笔颜色
        Piece piece;
        int x, y;
        for (int i = 0; i < pieceList.length; i++) {
            for (int j = 0; j < pieceList[i].length; j++) {
                // 如果棋子存活
                if (pieceList[i][j] != null) {
                    piece = pieceList[i][j];
                    x = piece.getX();
                    y = piece.getY();
                    if (x == i && y == j) {
                        if (piece.isSelection()) {
                            g.setColor(Color.white);
                        } else {
                            g.setColor(new Color(200, 100, 50)); // 设为桔黄色
                        }
                        g.fillOval(DIAMETER * x + HALF_METER, DIAMETER * y + HALF_METER, DIAMETER, DIAMETER);
                        g.setStroke(new BasicStroke(3.0f));
                        g.setColor(Color.black);
                        g.drawArc(DIAMETER * x + HALF_METER, DIAMETER * y + HALF_METER, 70, 70, 0, 360);
                        g.setStroke(new BasicStroke(1.0f));
                        g.drawArc(DIAMETER * x + HALF_METER + 4, DIAMETER * y + HALF_METER + 4, 62, 62, 0, 360);
                        // 判断阵营
                        if (piece.isCamp()) {
                            g.setColor(Color.red);
                        } else {
                            g.setColor(Color.black);
                        }
                        g.drawString(piece.getName(), DIAMETER * x + HALF_METER + 8, DIAMETER * y + HALF_METER + 50);
                    }
                }
            }
        }
    }

    private void drawboard(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);//打开抗锯齿
        g.setColor(new Color(255, 255, 255)); //设置棋盘的颜色
        g.fillRect(0, 0, 630, 700); // 填充棋盘
        g.setStroke(new BasicStroke(2.0f));//设置粗度
        g.setColor(Color.red); // 设为红色
        //画两边竖线
        g.drawLine(HALF_METER, HALF_METER, HALF_METER, DIAMETER * 9 + HALF_METER);
        g.drawLine(HALF_METER + DIAMETER * 8, HALF_METER, HALF_METER + DIAMETER * 8, DIAMETER * 9 + HALF_METER);
        // 画竖线
        for (int i = HALF_METER; i <= GAME_WIDTH - (HALF_METER); i += DIAMETER) {
            g.drawLine(i, HALF_METER, i, (DIAMETER * 4 + HALF_METER));
            g.drawLine(i, (DIAMETER * 5 + HALF_METER), i, GAME_HEIGHT - HALF_METER);
        }
        // 画横线
        for (int i = HALF_METER; i <= GAME_HEIGHT - (HALF_METER); i += DIAMETER) {
            g.drawLine(HALF_METER, i, GAME_WIDTH - HALF_METER, i);
        }
        //画楚河汉界
        g.setFont(new Font("楷体", Font.BOLD, 50));
        g.drawString("楚河", 120, 365);//绘制楚河汉界
        g.drawString("汉界", 400, 365);
        //画小斜线
        g.drawLine(245, 35, 385, 175);
        g.drawLine(385, 35, 245, 175);
        g.drawLine(385, 525, 245, 665);
        g.drawLine(245, 525, 385, 665);
        //画小卒子和炮标记
        drawSmallLine(g, 0, 3);
        drawSmallLine(g, 2, 3);
        drawSmallLine(g, 4, 3);
        drawSmallLine(g, 6, 3);
        drawSmallLine(g, 8, 3);
        drawSmallLine(g, 0, 6);
        drawSmallLine(g, 2, 6);
        drawSmallLine(g, 4, 6);
        drawSmallLine(g, 6, 6);
        drawSmallLine(g, 8, 6);
        drawSmallLine(g, 1, 2);
        drawSmallLine(g, 7, 2);
        drawSmallLine(g, 1, 7);
        drawSmallLine(g, 7, 7);
        //画外围粗线
        g.setStroke(new BasicStroke(8.0f));
        g.drawLine(25, 25, GAME_WIDTH - 25, 25);
        g.drawLine(25, 25, 25, GAME_HEIGHT - 25);
        g.drawLine(GAME_WIDTH - 25, 25, GAME_WIDTH - 25, GAME_HEIGHT - 25);
        g.drawLine(25, GAME_HEIGHT - 25, GAME_WIDTH - 25, GAME_HEIGHT - 25);
    }

    /**
     * 画卒和炮旁边的短线
     */
    public void drawSmallLine(Graphics g, int i, int j) {
        int x = i * DIAMETER + 35;
        int y = j * DIAMETER + 35;
        //左边
        if (i > 0) {
            //左上
            g.drawLine(x - 16, y - 6, x - 6, y - 6);
            g.drawLine(x - 6, y - 6, x - 6, y - 16);
            //左下
            g.drawLine(x - 16, y + 6, x - 6, y + 6);
            g.drawLine(x - 6, y + 6, x - 6, y + 16);
        }
        //右边
        if (i < 8) {
            //右上
            g.drawLine(x + 16, y - 6, x + 6, y - 6);
            g.drawLine(x + 6, y - 16, x + 6, y - 6);
            //右下
            g.drawLine(x + 16, y + 6, x + 6, y + 6);
            g.drawLine(x + 6, y + 6, x + 6, y + 16);
        }
    }
}
