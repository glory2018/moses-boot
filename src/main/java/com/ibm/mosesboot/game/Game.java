package com.ibm.mosesboot.game;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;

public class Game extends Applet {
    private GameTable gTable;//����һ����Ϸ��
    private Image myImage0, myImage1, myImage2, myImage3, myImage4, myImage5, myImage6, myImage7, myImage8, myImage9;//���ؾŸ�ͼƬ���������Ǳ�������ɷ���
    private AudioClip myAudio, myAudio1, myAudio2, myAudio3, myAudio4, myAudio5, myAudio6;//���ر������� AudioClip��������Java Applet�ڲ���������������java.Applet�����ж���
    //ʹ��Applet��������ʱ�����ȶ���AudioClip����GetAudioClip�����ܰ���������AudioClip��������������������һ�飬Ӧ����AudioClip���play�����������ѭ��������������Ӧѡ��AudioClip���loop������
    private JButton btStart, btRestart, Start_music, Stop_music;//�����ĸ���ť���ֱ��ǿ�ʼ�����¿�ʼ���������֡���ͣ����
    private StartListener startlistener;//��ʼ��ť�¼�������
    private int number = 8;//��������
    private int nTime = 1000;//�ٶȣ�������ʱ��ʱʹ��
    private int nWhich;//��־����Ҫ����ķ���
    private int tempnWhich;//��־��һ��Ҫ����ķ���
    private boolean canMove = false;//��־�Ƿ���Ӧ����
    private Root root;//Ҫ���µķ�������ã�������
    private Timer timer;//��ʱ�������ڿ�������ʱ����
    private Label scorelabel;//��ʾ�ɼ��Ŀؼ�
    private int nScore = 0;//ÿ��һ�м�10�֣�������¼�ܷ���
    private JComboBox speedcombobox, illustrate;//ѡ���ٶȵĿؼ�����Ϸ˵��
    private String[] choices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};//JComboBox��ѡ�
    private String[] shuoming = {"   X �� ��һ�µ���", "������ϣ��������", "������£������½�", "������������ƶ�", "������ң������ƶ�", "��Ա��", "�Զ", "������", "Ϳ��", "�����", "���ʷ�", "������"};

    public void init() {
        btStart = new JButton("��ʼ");
        btRestart = new JButton("����");
        Start_music = new JButton("��������");
        //���ò��ֹ��������Ա��Լ��趨��ťλ��
        setLayout(null);
        btStart.setBounds(520, 335, 90, 30);
        btRestart.setBounds(520, 400, 90, 30);
        Start_music.setBounds(515, 40, 100, 30);
        //��Ӱ�ť
        add(btStart);
        add(btRestart);
        add(Start_music);
        //Ϊ��ť��Ӽ�����
        startlistener = new StartListener();
        btStart.addActionListener(startlistener);
        btRestart.addActionListener(new RestartListener());
        btRestart.setEnabled(false);//��ʼ�ؿ�ʼ��ť������
        Start_music.addActionListener(new MusicListener());
        //����ͼƬ������
        myImage0 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b0.jpg");
        myImage1 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b1.jpg");
        myImage2 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b2.jpg");
        myImage3 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b3.jpg");
        myImage4 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b4.jpg");
        myImage5 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b5.jpg");
        myImage6 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b6.jpg");
        myImage7 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b7.jpg");
        myImage8 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b8.jpg");
        myImage9 = getImage(getCodeBase(), "com/ibm/mosesboot/game/b9.jpg");
        myAudio = getAudioClip(getCodeBase(), "com/ibm/mosesboot/game/ReadyGo.wav");
        myAudio1 = getAudioClip(getCodeBase(), "com/ibm/mosesboot/game/ReadyGo.wav");
        myAudio2 = getAudioClip(getCodeBase(), "com/ibm/mosesboot/game/ReadyGo.wav");
        myAudio3 = getAudioClip(getCodeBase(), "com/ibm/mosesboot/game/ReadyGo.wav");
        myAudio4 = getAudioClip(getCodeBase(), "com/ibm/mosesboot/game/ReadyGo.wav");
        myAudio5 = getAudioClip(getCodeBase(), "com/ibm/mosesboot/game/ReadyGo.wav");
        myAudio6 = getAudioClip(getCodeBase(), "com/ibm/mosesboot/game/ReadyGo.wav");
        //��ʼ�ٶȿؼ�
        speedcombobox = new JComboBox(choices);
        speedcombobox.addItemListener(new SpeedListener());
        speedcombobox.setEditable(false);
        speedcombobox.setBounds(520, 150, 90, 30);
        add(speedcombobox);
        //��ʼ��Ϸ˵���ؼ�
        illustrate = new JComboBox(shuoming);
        illustrate.setEditable(false);
        illustrate.setBounds(495, 470, 140, 30);
        add(illustrate);
        //��ʼ�ɼ��ؼ�
        scorelabel = new Label("0");
        scorelabel.setBounds(520, 90, 90, 30);
        add(scorelabel);
        //����һ��15*20�����ӣ�0�����޷���
        gTable = new GameTable(15, 20);
        gTable.myTable = new int[gTable.x][gTable.y];
        for (int i = 0; i < gTable.x; i++)
            for (int j = 0; j < gTable.y; j++)
                gTable.myTable[i][j] = 0;
        //�����������
        nWhich = (((int) Math.round(Math.random() * 100)) % number) + 1;
        switch (nWhich)//��ʼ�������ķ���
        {
            case 1:
                root = new One();
                break;
            case 2:
                root = new Two();
                break;
            case 3:
                root = new Three();
                break;
            case 4:
                root = new Four();
                break;
            case 5:
                root = new Five();
                break;
            case 6:
                root = new Six();
                break;
            case 7:
                root = new Seven();
                break;
            case 8:
                root = new Eight();
                break;
            default:
                break;
        }
        root.begin();//��ʼ�� ռ������
        tempnWhich = (((int) Math.round(Math.random() * 100)) % number) + 1;//������һ����ǰ��ʾ�ķ���
        nWhich = tempnWhich;
        timer = new Timer(nTime, new MyRun());//������ʱ��������MyRun
        //Timer(int delay, ActionListener listener)  �� javax.swing.Timer �Ĺ��췽�� ����һ��ÿ delay ���뽫֪ͨ���������� Timer��
        //Ϊ��ť��Ӽ��̼�����
        Start_music.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (canMove)
                    judgement(e);
            }
        });
        btStart.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (canMove)
                    judgement(e);
            }
        });
        btRestart.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (canMove)
                    judgement(e);
            }
        });
    }

    public void paint(Graphics g) {
        //��������ܣ�������ɫ�ʵĴ󳤷��� ѭ����Ϊ�����Ӻ��
        g.setColor(Color.red);
        for (int i = 0; i < 10; i++)
            g.drawRect(20 + i, 20 + i, 640 - 2 * i, 548 - 2 * i);
        g.setColor(Color.orange);
        for (int i = 0; i < 5; i++)
            g.drawRect(85 + i, 68 + i, 340 - 2 * i, 452 - 2 * i);
        g.drawImage(myImage9, 663, 23, this);
        //���������ϵı�Ǿ��������ַ���
        for (int i = 0; i < gTable.x; i++)
            for (int j = 0; j < gTable.y; j++) {
                if (gTable.myTable[i][j] == 0)//���׷���
                {
                    g.drawImage(myImage0, 92 + i * (20 + 2), 75 + j * (20 + 2), this);//��ת���˸���ͼ��ʱҪ֪ͨ�Ķ���Ϊ��ǰ����
                } else if (gTable.myTable[i][j] == 1)//��������
                {
                    g.drawImage(myImage1, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                } else if (gTable.myTable[i][j] == 2) {
                    g.drawImage(myImage2, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                } else if (gTable.myTable[i][j] == 3) {
                    g.drawImage(myImage3, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                } else if (gTable.myTable[i][j] == 4) {
                    g.drawImage(myImage4, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                } else if (gTable.myTable[i][j] == 5) {
                    g.drawImage(myImage5, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                } else if (gTable.myTable[i][j] == 6) {
                    g.drawImage(myImage6, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                } else if (gTable.myTable[i][j] == 7) {
                    g.drawImage(myImage7, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                } else {
                    g.drawImage(myImage8, 92 + i * (20 + 2), 75 + j * (20 + 2), this);
                }
            }
        //ˢ��
        btStart.repaint();
        btRestart.repaint();
        Start_music.repaint();
        speedcombobox.repaint();
        illustrate.repaint();
        //���³ɼ�
        scorelabel.setText(Integer.toString(nScore));
        scorelabel.setBackground(Color.green);
        scorelabel.repaint();
        g.setColor(Color.magenta);
        g.drawString("Ŀǰ�÷�:", 450, 110);
        g.drawString("�ٶ�1--9:", 450, 170);
        g.drawString("��һ������:", 450, 230);
        nextTo(g);
    }

    public void update(Graphics g) {
        paint(g);//��ֹ��˸
    }

    //����һ����ǰ��ʾ�ķ���
    public void nextTo(Graphics g) {
        for (int i = 0; i < 3; i++)//��ȫ���ð׷��鸲��
            for (int j = 0; j < 4; j++)
                g.drawImage(myImage0, 533 + i * (20 + 2), 215 + j * (20 + 2), this);
        switch (tempnWhich)//���ݱ�־�������ĸ�����
        {
            case 1:
                g.drawImage(myImage1, 555, 215, this);//����
                g.drawImage(myImage1, 555, 237, this);
                g.drawImage(myImage1, 555, 259, this);
                g.drawImage(myImage1, 555, 281, this);
                break;
            case 2:
                g.drawImage(myImage2, 533, 237, this);//����
                g.drawImage(myImage2, 533, 259, this);
                g.drawImage(myImage2, 555, 237, this);
                g.drawImage(myImage2, 555, 259, this);
                break;
            case 3:
                g.drawImage(myImage3, 555, 237, this);//��z
                g.drawImage(myImage3, 533, 259, this);
                g.drawImage(myImage3, 555, 215, this);
                g.drawImage(myImage3, 533, 237, this);
                break;
            case 4:
                g.drawImage(myImage4, 533, 215, this);//��z
                g.drawImage(myImage4, 533, 237, this);
                g.drawImage(myImage4, 555, 237, this);
                g.drawImage(myImage4, 555, 259, this);
                break;
            case 5:
                g.drawImage(myImage5, 577, 215, this);//����
                g.drawImage(myImage5, 555, 237, this);
                g.drawImage(myImage5, 555, 259, this);
                g.drawImage(myImage5, 555, 215, this);
                break;
            case 6:
                g.drawImage(myImage6, 533, 215, this);//����
                g.drawImage(myImage6, 555, 215, this);
                g.drawImage(myImage6, 555, 237, this);
                g.drawImage(myImage6, 555, 259, this);
                break;
            case 7:
                g.drawImage(myImage7, 555, 237, this);//��
                g.drawImage(myImage7, 533, 259, this);
                g.drawImage(myImage7, 555, 259, this);
                g.drawImage(myImage7, 577, 259, this);
                break;
            case 8:
                g.drawImage(myImage8, 533, 237, this);//��һ����
                break;
            default:
                break;
        }
    }

    public void judgement(KeyEvent e)//�ж���������ĸ�������������Ӧ
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_X://�����X������һ�µ���
            {
                root.downTo();
                myAudio3.play();//ʹ��AudioClip���play���� ��������һ��		
            }
            lineOver();//��ȥ������һ�У�����10��
            switch (nWhich)//�����µķ���
            {
                case 1:
                    root = new One();
                    break;
                case 2:
                    root = new Two();
                    break;
                case 3:
                    root = new Three();
                    break;
                case 4:
                    root = new Four();
                    break;
                case 5:
                    root = new Five();
                    break;
                case 6:
                    root = new Six();
                    break;
                case 7:
                    root = new Seven();
                    break;
                case 8:
                    root = new Eight();
                    break;
                default:
                    break;
            }
            tempnWhich = (((int) Math.round(Math.random() * 100)) % number) + 1;
            nWhich = tempnWhich;
            if (!root.begin())//����µķ������ʧ�ܣ�����Ϸ����
            {
                repaint();
                gameover();
            } else {
                repaint();
            }
            break;
            case KeyEvent.VK_DOWN:
                root.down();
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                root.left();
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                root.right();
                repaint();
                break;
            case KeyEvent.VK_UP: {
                root.change();
                myAudio5.play();
                repaint();
                break;
            }
            default:
                break;
        }
    }

    public void lineOver()//��ȥ������һ�У�����10��
    {
        boolean isCan;//��־�Ƿ�ѭ����һ��
        boolean isContinue = true;//��־�Ƿ��д�������
        int k = gTable.y - 1;
        while (isContinue) {
            isCan = true;
            while (isCan) {
                for (int i = 0; i < gTable.x; i++) {
                    if (gTable.myTable[i][k] == 0)
                        isCan = false;
                }
                if (isCan)//������������ʼ����
                {
                    for (int i = 0; i < gTable.x; i++)
                        gTable.myTable[i][k] = 0;
                    myAudio2.play();
                    for (int j = k - 1; j >= 0; j--)
                        for (int i = 0; i < gTable.x; i++) {
                            if (gTable.myTable[i][j] != 0) {
                                gTable.myTable[i][j + 1] = 1;
                                gTable.myTable[i][j] = 0;
                            }
                        }
                    repaint();
                    nScore += 10;//�ӳɼ�
                }
            }
            k--;
            if (k < 1)
                isContinue = false;
        }
    }

    public void gameover()//��Ϸ����
    {
        myAudio1.play();
        Start_music.setLabel("��������");
        timer.stop();//��ʱ����ͣ
        JOptionPane anOptionPane = new JOptionPane();//�����Ի���
        anOptionPane.showMessageDialog(this, "           ���ź� ��Ϸ����!", "sorry", JOptionPane.WARNING_MESSAGE);
        over();//��������������Ա����¿�ʼ
    }

    public void over()//��Ϸ�����󣬴�������������Ա����¿�ʼ
    {
        for (int i = 0; i < gTable.x; i++)//���¸���Ϸ����0��־
            for (int j = 0; j < gTable.y; j++) {
                gTable.myTable[i][j] = 0;
            }
        timer.stop();
        repaint();
        nScore = 0;
        switch (nWhich)//�����µķ���
        {
            case 1:
                root = new One();
                break;
            case 2:
                root = new Two();
                break;
            case 3:
                root = new Three();
                break;
            case 4:
                root = new Four();
                break;
            case 5:
                root = new Five();
                break;
            case 6:
                root = new Six();
                break;
            case 7:
                root = new Seven();
                break;
            case 8:
                root = new Eight();
                break;
            default:
                break;
        }
        tempnWhich = (((int) Math.round(Math.random() * 100)) % number) + 1;
        nWhich = tempnWhich;
        root.begin();
        repaint();
        btStart.setLabel("��ʼ");
        btStart.setEnabled(true);
        speedcombobox.setEnabled(true);
        btRestart.setEnabled(false);
        startlistener.setisRun(true);
        canMove = false;
    }

    public class MyRun implements ActionListener//��ʱ�����õļ�����
    {
        public void actionPerformed(ActionEvent e) {
            if (!root.down())//����������һ������������½��ˣ��͵����������
            {
                lineOver();//����
                switch (nWhich)//�����µķ���
                {
                    case 1:
                        root = new One();
                        break;
                    case 2:
                        root = new Two();
                        break;
                    case 3:
                        root = new Three();
                        break;
                    case 4:
                        root = new Four();
                        break;
                    case 5:
                        root = new Five();
                        break;
                    case 6:
                        root = new Six();
                        break;
                    case 7:
                        root = new Seven();
                        break;
                    case 8:
                        root = new Eight();
                        break;
                    default:
                        break;
                }
                tempnWhich = (((int) Math.round(Math.random() * 100)) % number) + 1;
                nWhich = tempnWhich;
                if (!root.begin())//���ʧ�ܣ���Ϸ����
                {
                    repaint();
                    gameover();
                } else
                    repaint();
            } else {
                repaint();
            }
        }
    }

    public class StartListener implements ActionListener//��ʼ��ť������
    {
        private boolean isRun = true;//��־�ǿ�ʼ������ͣ��һť����

        public void setisRun(boolean run) {
            isRun = run;
        }

        public void actionPerformed(ActionEvent e) {
            btRestart.setEnabled(true);
            if (isRun)//�ǿ�ʼ
            {
                myAudio6.play();
                speedcombobox.setEnabled(false);
                btStart.setLabel("ֹͣ");
                timer.start();
                isRun = !isRun;
                canMove = true;//������Ӧ����
            } else//����ͣ
            {
                speedcombobox.setEnabled(true);
                btStart.setLabel("��ʼ");
                timer.stop();
                isRun = !isRun;
                canMove = false;//��������Ӧ����
            }
        }
    }

    public class MusicListener implements ActionListener//���ְ�ť������
    {
        private boolean music = true;//��־�ǿ�ʼ������ͣ��һť����

        public void actionPerformed(ActionEvent e) {
            if (music)//�ǿ�ʼ
            {
                myAudio.loop();//ѭ�����ű�������
                Start_music.setLabel("��ͣ����");
                music = !music;
            } else//����ͣ
            {
                myAudio.stop();//ֹͣ����
                Start_music.setLabel("��������");
                music = !music;
            }
        }
    }

    public class RestartListener implements ActionListener//���¿�ʼ��ť������
    {
        public void actionPerformed(ActionEvent e) {
            over();//���³�ʼ����������
        }
    }

    public class SpeedListener implements ItemListener//�ٶȿؼ�������
    {
        public void itemStateChanged(ItemEvent e) {
            nTime = 1000 - (new Integer(speedcombobox.getSelectedItem().toString()).intValue()) * 110;
            timer = new Timer(nTime, new MyRun());//����ѡ���nTime����������ü�ʱ�����Ա任�ٶ�
            myAudio4.play();
        }
    }
}//�������