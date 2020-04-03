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
    //是否轮到我走棋的标记
    public boolean isCanMove = true;
    //判断用户阵营
    public boolean userCamp = true;
    ClientView clientView = this;
    //上一步位置
    int preX, preY;

    public ClientView() {
        //初始化棋盘
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
                if (JOptionPane.showConfirmDialog(clientView, "是否要退出游戏?", "退出游戏",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
                    Piece pickChess = isStep();
                    Piece piece = checkerboard.pieceList[x][y];
                    //翻棋
                    if (piece != null && "".equals(piece.getName())) {
                        if (pickChess == null) {
                            piece.setName(piece.getHiddenName());
                        }
                    } else {
                        boolean isMove = checkPiece(pickChess, x, y);
                        movePiece(isMove, x, y);
                    }
                    //交换先后手
                    isCanMove = !isCanMove;
                    checkerboard.repaint();
                }
            }
        });
    }

    //判断和玩家相同阵营的棋子有没有被选中的
    public Piece isStep() {
        Piece item;
        for (int i = 0; i < checkerboard.pieceList.length; i++) {
            for (int j = 0; j < checkerboard.pieceList[i].length; j++) {
                item = checkerboard.pieceList[i][j];
                if (item != null) {
                    if (item.isSelection() && item.isCamp() == userCamp) {
                        return item;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param pickChess 选中的棋子
     * @param x
     * @param y
     * @return
     */
    private boolean checkPiece(Piece pickChess, int x, int y) {
        boolean isMove = false;
        //我方阵营有没有棋子被选中，是否轮到我走棋，是否可以落子
        if (pickChess != null && isCanMove && rule.getRule(pickChess, x, y)) {
            Piece target = checkerboard.pieceList[x][y];
            //走棋
            pieceMove(pickChess, target, x, y);
            //重绘
            checkerboard.repaint();
            userCamp = !userCamp;
            // 判断是否分出胜负
            if (target != null) {
                isWinning(target, x, y);
            }
            isMove = true;
        }
        return isMove;
    }

    private void movePiece(boolean isMove, int x, int y) {
        //判断是否落子，点击的地方是否为空
        if (!isMove && isEmtry(x, y) != null) {
            Piece piece = checkerboard.pieceList[x][y];
            // 判断该棋子阵营和玩家是否相同
            if (piece.isCamp() == userCamp) {
                // 设置棋子的选中状态
                piece.setSelection(!piece.isSelection());
                //上一步棋子取消选中
                if ((preX != x || preY != y) && checkerboard.pieceList[preX][preY] != null) {
                    checkerboard.pieceList[preX][preY].setSelection(false);
                }
                preX = x;
                preY = y;
            }
        }
    }

    /**
     * 判断是否分出胜负
     *
     * @return
     */
    public void isWinning(Piece target, int x, int y) {
        if (target.getName() == "将" || target.getName() == "帥") {
            String resultMessage = checkerboard.pieceList[x][y].isCamp() ? "红方胜利" : "黑方胜利";
            // 弹出消息框
            JOptionPane.showMessageDialog(this, resultMessage, "游戏结束", JOptionPane.PLAIN_MESSAGE);
            checkerboard.initPiece(false);
        }
    }

    /**
     * 走棋
     *
     * @return
     */
    public void pieceMove(Piece piece, Piece target, int x, int y) {
        checkerboard.pieceList[piece.getX()][piece.getY()] = null;
        //级别相同，兑子
        if (target != null && target.getLevel() == piece.getLevel()) {
            checkerboard.pieceList[x][y] = null;
        } else {
            checkerboard.pieceList[x][y] = piece;
            checkerboard.pieceList[x][y].setX(x);
            checkerboard.pieceList[x][y].setY(y);
            checkerboard.pieceList[x][y].setSelection(false);
        }
    }

    //判断鼠标点击的地方有没有棋子
    public Piece isEmtry(int x, int y) {
        Piece item;
        for (int i = 0; i < checkerboard.pieceList.length; i++) {
            for (int j = 0; j < checkerboard.pieceList[i].length; j++) {
                item = checkerboard.pieceList[i][j];
                if (item != null && item.getX() == x && item.getY() == y) {
                    return item;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        ClientView view = new ClientView();
    }
}
