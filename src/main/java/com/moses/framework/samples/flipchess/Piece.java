package com.moses.framework.samples.flipchess;

/**
 * 棋子类
 * 获取棋子坐标、存活状态、阵容等
 *
 * @author Moses
 */
public class Piece {
    private int x;
    private int y;
    //阵营 true是红棋,false是黑棋
    private boolean camp;
    //棋子名称
    private String name;
    //棋子的选中状态 true 选中  , false 未选中
    private boolean selection;
    //棋子隐藏名称
    private String hiddenName;
    //棋子级别
    private int level;

    public Piece(boolean camp, String name) {
        this.camp = camp;
        this.name = name;
    }

    public Piece(int x, int y, boolean camp, String hiddenName) {
        super();
        this.x = x;
        this.y = y;
        this.camp = camp;
        this.hiddenName = hiddenName;
        this.name = "";
        this.selection = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCamp() {
        return camp;
    }

    public void setCamp(boolean camp) {
        this.camp = camp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelection() {
        return selection;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    public String getHiddenName() {
        return hiddenName;
    }

    public void setHiddenName(String hiddenName) {
        this.hiddenName = hiddenName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
