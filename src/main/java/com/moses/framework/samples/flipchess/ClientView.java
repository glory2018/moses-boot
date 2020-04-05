package com.moses.framework.samples.flipchess;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author Moses
 */
@SuppressWarnings("serial")
public class ClientView extends JFrame implements ActionListener {
    //创建棋盘;
    Checkerboard checkerboard = new Checkerboard();
    //创建规则类
    Rule rule = new Rule(checkerboard);
    //判断用户阵营,默认红方
    public boolean userCamp = true;
    ClientView clientView = this;
    //上一步位置
    int preX, preY;

    public ClientView() {
        initCheckerboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * 初始化棋盘
     */
    private void initCheckerboard() {
        //点击
        addClickListener();
        //关闭
        addCloseListener();
        add(checkerboard);
        setTitle("中国象棋");
        // 设置此窗口是否可由用户调整大小
        setResizable(false);
        //设置窗口显示状态
        setVisible(true);
        //根据窗口里面的布局及组件的preferredSize来确定frame的最佳大小。
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * 添加一个关闭事件
     */
    private void addCloseListener() {
        //添加消息对话框
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(clientView, "是否要退出游戏?", "退出游戏", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    // 退出
                    System.exit(0);
                }
            }
        });
    }

    private void addClickListener() {
        //添加鼠标点击事件
        checkerboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (e.getX() - Checkerboard.HALF_METER) / Checkerboard.DIAMETER;
                int y = (e.getY() - Checkerboard.HALF_METER) / Checkerboard.DIAMETER;
                if (0 <= x && x <= 7 && y >= 5 && y <= 8) {
                    //起子
                    Piece upChess = isStep();
                    //落子
                    Piece downChess = checkerboard.pieceList[x][y];
                    if (upChess == null) {
                        if (downChess != null) {
                            //翻棋
                            if ("".equals(downChess.getName())) {
                                downChess.setName(downChess.getHiddenName());
                                //交换先后手
                                userCamp = !userCamp;
                            } else {
                                //阵营相同
                                if (downChess.isCamp() == userCamp) {
                                    //切换选中状态
                                    downChess.setSelection(true);
                                    preX = x;
                                    preY = y;
                                } else {
                                    popInfo(userCamp ? "该红方走棋！" : "该黑方走棋！");
                                }
                            }
                        }
                    } else if (downChess != null && downChess.isSelection()) {
                        downChess.setSelection(false);
                    } else {
                        //走棋
                        movePiece(upChess, x, y);
                    }
                    checkerboard.repaint();
                }
            }
        });
    }

    /**
     * @param upChess 起子
     * @param x
     * @param y
     */
    private void movePiece(Piece upChess, int x, int y) {
        Piece downChess = checkerboard.pieceList[x][y];
        //是否符合规则
        if (rule.getRule(upChess, x, y)) {
            checkerboard.pieceList[upChess.getX()][upChess.getY()] = null;
            //级别相同，兑子
            if (downChess != null && downChess.getLevel() == upChess.getLevel() && upChess.getLevel() != 1 && !"".equals(downChess.getName())) {
                checkerboard.pieceList[x][y] = null;
            } else {
                checkerboard.pieceList[x][y] = upChess;
                checkerboard.pieceList[x][y].setX(x);
                checkerboard.pieceList[x][y].setY(y);
                checkerboard.pieceList[x][y].setSelection(false);
            }
            // 判断是否分出胜负
            isWinning(downChess);
            userCamp = !userCamp;
        } else {
            if (downChess == null) {
                popInfo("不符合走动规则！");
            } else {
                popInfo("不符合移动规则！");
            }
        }
    }

    /**
     * 消息提示
     *
     * @param message
     */
    private void popInfo(String message) {
        JOptionPane.showMessageDialog(clientView, message, "提示", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * @return 相同阵营被选中的棋子
     */
    public Piece isStep() {
        Piece item;
        for (int i = 0; i < checkerboard.pieceList.length; i++) {
            for (int j = 0; j < checkerboard.pieceList[i].length; j++) {
                item = checkerboard.pieceList[i][j];
                if (item != null && item.isSelection() && item.isCamp() == userCamp) {
                    return item;
                }
            }
        }
        return null;
    }

    /**
     * 判断是否分出胜负
     *
     * @return
     */
    public void isWinning(Piece target) {
        if (target != null && target.getLevel() == 6) {
            JOptionPane.showMessageDialog(this, target.isCamp() ? "黑方胜利" : "红方胜利", "游戏结束", JOptionPane.PLAIN_MESSAGE);
            checkerboard.initPiece(false);
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        ClientView view = new ClientView();
    }
}
