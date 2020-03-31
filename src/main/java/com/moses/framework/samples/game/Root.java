package com.moses.framework.samples.game;

public class Root//8����ĸ���,����һ����
{
    public boolean begin()//��ʼ����ʾ
    {
        return true;
    }

    public boolean down()//�����ƶ�
    {
        return true;
    }

    public boolean left()//�����ƶ�
    {
        return true;
    }

    public boolean right()//�����ƶ�
    {
        return true;
    }

    public boolean change()//�任�Ƕ�
    {
        return true;
    }

    public void downTo()//һ�µ���
    {
    }

    public boolean isGo(int n)//���Ϻ������õĺ���,�����ж��Ƿ�����ƶ�
    {
        return true;
    }

    public static void main(String args[]) {
        new Root();
    }
}