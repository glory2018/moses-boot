package com.moses.framework.samples.game;

public class One extends Root//��һ������ ����
{
    private GameTable gTable;//������Ϸ����
    private int x, y;//�����Ͻ������������ϵ�λ��
    private int direct = 1;//��һ���Ƕ�
    private int[] store;//������жϷ����Ƿ�����ƶ��������־

    public One() {
        store = new int[15];//15�㹻����
    }

    public boolean begin()//��ʼ����ʾ
    {
        //�ж����ڳ�ʼ���������Ƿ�ռ��
        if ((gTable.myTable[(gTable.x - 1) / 2][0] == 0) && (gTable.myTable[(gTable.x - 1) / 2][1] == 0) &&
                (gTable.myTable[(gTable.x - 1) / 2][2] == 0) && (gTable.myTable[(gTable.x - 1) / 2][3] == 0)) {
            x = (gTable.x - 1) / 2;//��¼���Ͻ�����
            y = 0;
            gTable.myTable[x][y] = 1;//����ռ�ñ�־
            gTable.myTable[x][y + 1] = 1;
            gTable.myTable[x][y + 2] = 1;
            gTable.myTable[x][y + 3] = 1;
            return true;
        } else {
            return false;//��ʼ��ʧ��
        }
    }

    public boolean down()//�����ƶ�
    {
        switch (direct)//���ݽǶȱ�־�����������е���2���Ƕȣ��е���4���Ƕ�
        {
            case 1:
                if (y <= gTable.y - 5)//�Ƿ��ڱ�Ե
                {
                    store[0] = gTable.myTable[x][y + 4];//������ж�����
                    if (isGo(1))//�ж��Ƿ����
                    {
                        gTable.myTable[x][y] = 0;//�����ƶ�������0
                        gTable.myTable[x][y + 4] = 1;//��Ŀ��������1
                        y += 1;//���Ͻ������ƶ�
                        return true;
                    } else {
                        return false;//�ƶ�ʧ��
                    }
                } else {
                    return false;//�ƶ�ʧ��
                }
            case 2:
                if (y <= gTable.y - 2)//ͬcase 1
                {
                    store[0] = gTable.myTable[x][y + 1];
                    store[1] = gTable.myTable[x + 1][y + 1];
                    store[2] = gTable.myTable[x + 2][y + 1];
                    store[3] = gTable.myTable[x + 3][y + 1];
                    if (isGo(4)) {
                        gTable.myTable[x][y] = 0;
                        gTable.myTable[x + 1][y] = 0;
                        gTable.myTable[x + 2][y] = 0;
                        gTable.myTable[x + 3][y] = 0;
                        gTable.myTable[x][y + 1] = 1;
                        gTable.myTable[x + 1][y + 1] = 1;
                        gTable.myTable[x + 2][y + 1] = 1;
                        gTable.myTable[x + 3][y + 1] = 1;
                        y += 1;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public boolean left()//ͬdown()
    {
        switch (direct) {
            case 1:
                if (x >= 1) {
                    store[0] = gTable.myTable[x - 1][y];
                    store[1] = gTable.myTable[x - 1][y + 1];
                    store[2] = gTable.myTable[x - 1][y + 2];
                    store[3] = gTable.myTable[x - 1][y + 3];
                    if (isGo(4)) {
                        gTable.myTable[x][y] = 0;
                        gTable.myTable[x][y + 1] = 0;
                        gTable.myTable[x][y + 2] = 0;
                        gTable.myTable[x][y + 3] = 0;
                        gTable.myTable[x - 1][y] = 1;
                        gTable.myTable[x - 1][y + 1] = 1;
                        gTable.myTable[x - 1][y + 2] = 1;
                        gTable.myTable[x - 1][y + 3] = 1;
                        x -= 1;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case 2:
                if (x >= 1) {
                    store[0] = gTable.myTable[x - 1][y];
                    if (isGo(1)) {
                        gTable.myTable[x + 3][y] = 0;
                        gTable.myTable[x - 1][y] = 1;
                        x -= 1;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public boolean right()//ͬdown()
    {
        switch (direct) {
            case 1:
                if (x <= gTable.x - 2) {
                    store[0] = gTable.myTable[x + 1][y];
                    store[1] = gTable.myTable[x + 1][y + 1];
                    store[2] = gTable.myTable[x + 1][y + 2];
                    store[3] = gTable.myTable[x + 1][y + 3];
                    if (isGo(4)) {
                        gTable.myTable[x][y] = 0;
                        gTable.myTable[x][y + 1] = 0;
                        gTable.myTable[x][y + 2] = 0;
                        gTable.myTable[x][y + 3] = 0;
                        gTable.myTable[x + 1][y] = 1;
                        gTable.myTable[x + 1][y + 1] = 1;
                        gTable.myTable[x + 1][y + 2] = 1;
                        gTable.myTable[x + 1][y + 3] = 1;
                        x += 1;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case 2:
                if (x <= gTable.x - 5) {
                    store[0] = gTable.myTable[x + 4][y];
                    if (isGo(1)) {
                        gTable.myTable[x][y] = 0;
                        gTable.myTable[x + 4][y] = 1;
                        x += 1;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public boolean change()//ͬdown()
    {
        switch (direct) {
            case 1:
                if (x <= gTable.x - 4) {
                    store[0] = gTable.myTable[x + 1][y];
                    store[1] = gTable.myTable[x + 1][y + 1];
                    store[2] = gTable.myTable[x + 1][y + 2];
                    store[3] = gTable.myTable[x + 1][y + 3];
                    store[4] = gTable.myTable[x + 2][y];
                    store[5] = gTable.myTable[x + 2][y + 1];
                    store[6] = gTable.myTable[x + 2][y + 2];
                    store[7] = gTable.myTable[x + 2][y + 3];
                    store[8] = gTable.myTable[x + 3][y];
                    store[9] = gTable.myTable[x + 3][y + 1];
                    store[10] = gTable.myTable[x + 3][y + 2];
                    store[11] = gTable.myTable[x + 3][y + 3];
                    if (isGo(12)) {
                        gTable.myTable[x][y] = 0;
                        gTable.myTable[x][y + 1] = 0;
                        gTable.myTable[x][y + 2] = 0;
                        gTable.myTable[x + 1][y + 3] = 1;
                        gTable.myTable[x + 2][y + 3] = 1;
                        gTable.myTable[x + 3][y + 3] = 1;
                        y += 3;
                        direct = 2;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case 2:
                if (true) {
                    store[0] = gTable.myTable[x][y - 1];
                    store[1] = gTable.myTable[x][y - 2];
                    store[2] = gTable.myTable[x][y - 3];
                    store[3] = gTable.myTable[x + 1][y - 1];
                    store[4] = gTable.myTable[x + 1][y - 2];
                    store[5] = gTable.myTable[x + 1][y - 3];
                    store[6] = gTable.myTable[x + 2][y - 1];
                    store[7] = gTable.myTable[x + 2][y - 2];
                    store[8] = gTable.myTable[x + 2][y - 3];
                    store[9] = gTable.myTable[x + 3][y - 1];
                    store[10] = gTable.myTable[x + 3][y - 2];
                    store[11] = gTable.myTable[x + 3][y - 3];
                    if (isGo(12)) {
                        gTable.myTable[x + 1][y] = 0;
                        gTable.myTable[x + 2][y] = 0;
                        gTable.myTable[x + 3][y] = 0;
                        gTable.myTable[x][y - 3] = 1;
                        gTable.myTable[x][y - 2] = 1;
                        gTable.myTable[x][y - 1] = 1;
                        y -= 3;
                        direct = 1;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public void downTo()//һ�µ���
    {
        boolean canDown = true;
        while (canDown) {
            canDown = down();//ѭ�������ƶ�һ��
        }
    }

    public boolean isGo(int n) {
        for (int i = 0; i <= (n - 1); i++) {
            if (store[i] != 0)//�����ռλ��ʧ��
                return false;
        }
        return true;
    }
}






























































