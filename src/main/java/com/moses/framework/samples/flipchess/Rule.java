package com.moses.framework.samples.flipchess;

import java.util.HashMap;
import java.util.Map;

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
     * @param upChess 起子
     * @param x
     * @param y
     * @return
     */
    public boolean getRule(Piece upChess, int x, int y) {
        boolean rule = false;
        Piece downChess = checkerboard.pieceList[x][y];
        Map<String, Integer> map = getDirection(upChess.getX(), upChess.getY(), x, y);
        //在直线方向
        if (map.size() > 0) {
            //炮或砲
            if (upChess.getLevel() == 1) {
                //不同阵营或未翻
                if (downChess != null && (downChess.isCamp() != upChess.isCamp() || "".equals(downChess.getName()))) {
                    return getDistance(map, x, y) == 1;
                }
            } else if (1 == map.get("space")) {
                //走步
                if (downChess == null) {
                    return true;
                } else if (!"".equals(downChess.getName()) && downChess.isCamp() != upChess.isCamp()) {
                    //已翻且不同阵营
                    return (upChess.getLevel() == 0 && downChess.getLevel() == 6) || (downChess.getLevel() == 0 && downChess.getLevel() < 6) || (upChess.getLevel() >= downChess.getLevel());
                }
            }
        }
        return rule;
    }

    /**
     * 获取走棋方向
     * <p>
     *
     * @param x1 起点
     * @param y1 起点
     * @param x  落点
     * @param y  落点
     * @return
     */
    private Map<String, Integer> getDirection(int x1, int y1, int x, int y) {
        Map<String, Integer> map = new HashMap();
        if (x == x1) {
            map.put("direction", 2);
            map.put("start", y > y1 ? y1 : y);
            map.put("end", y > y1 ? y : y1);
            map.put("space", Math.abs(y - y1));
        } else if (y == y1) {
            map.put("direction", 1);
            map.put("start", x > x1 ? x1 : x);
            map.put("end", x > x1 ? x : x1);
            map.put("space", Math.abs(x - x1));
        }
        return map;
    }

    /**
     * 获取棋子间隔
     *
     * @param map
     * @param x   落点
     * @param y   落点
     * @return
     */
    private int getDistance(Map<String, Integer> map, int x, int y) {
        int num = 0;
        int start = map.get("start"), end = map.get("end");
        if (2 == map.get("direction")) {
            for (int i = start + 1; i < end; i++) {
                if (checkerboard.pieceList[x][i] != null) {
                    num++;
                }
            }
        } else if (1 == map.get("direction")) {
            for (int i = start + 1; i < end; i++) {
                if (checkerboard.pieceList[i][y] != null) {
                    num++;
                }
            }
        }
        return num;
    }
}
