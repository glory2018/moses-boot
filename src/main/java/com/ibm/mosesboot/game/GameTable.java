package com.ibm.mosesboot.game;

public class GameTable//��Ϸ��
{
    public static int[][] myTable;//�����־
    public static int x;//������
    public static int y;//������

    public GameTable() {
    }

    public GameTable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String args[]) {
        new GameTable();
    }
}