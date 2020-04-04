package com.moses.framework.samples.flipchess;

/**
 * 规则
 *
 * @author Moses
 */
public class Rule {
    //棋盘
    Checkerboard checkerboard;

    public Rule(Checkerboard checkerboard) {
        this.checkerboard = checkerboard;
    }

    /**
     * 获取规则
     *
     * @param piece 棋子
     * @param x
     * @param y
     * @return
     */
    public boolean getRule(Piece piece, int x, int y) {
        boolean rule = false;
        Piece target = checkerboard.pieceList[x][y];
        int start = 0, end = 0;
        if (piece.getX() != x && piece.getY() != y) {
            return false;
        } else if (piece.getX() == x) {
            if (piece.getY() > y) {
                start = y;
                end = piece.getY();
            } else {
                start = piece.getY();
                end = y;
            }
        } else if (piece.getY() == y) {
            if (piece.getX() > x) {
                start = x;
                end = piece.getX();
            } else {
                start = piece.getX();
                end = x;
            }
        }
        //炮或砲
        if (piece.getLevel() == 1) {
            //不同阵营或未翻
            if (target != null && (target.isCamp() != piece.isCamp() || "".equals(target.getName()))) {
                int num = 0;
                if (piece.getX() == x) {
                    for (int i = start + 1; i < end; i++) {
                        if (checkerboard.pieceList[x][i] != null) {
                            num++;
                        }
                    }
                } else if (piece.getY() == y) {
                    for (int i = start + 1; i < end; i++) {
                        if (checkerboard.pieceList[i][y] != null) {
                            num++;
                        }
                    }
                }
                if (num == 1) {
                    return true;
                }
            }
        } else if (end - start == 1) {
            if (target == null) {
                return true;
            } else if (target.isCamp() != piece.isCamp()) {
                return (piece.getLevel() == 0 && target.getLevel() == 6) || (target.getLevel() == 0 && target.getLevel() < 6) || (piece.getLevel() >= target.getLevel());
            }
        }
        return rule;
    }
}
