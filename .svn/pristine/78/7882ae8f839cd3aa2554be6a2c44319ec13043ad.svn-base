package com.edgedo.sequrity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JScrollPane;

public class One_Zero_Two_Four extends JFrame {
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        One_Zero_Two_Four frame = new One_Zero_Two_Four();
        frame.setVisible(true);
    }


    public One_Zero_Two_Four() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 844, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("宋体", Font.BOLD, 23));
        textPane.setBounds(14, 13, 798, 302);
        final boolean[] b = {true};
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    textPane.setText("你好,你叫什么名字呀? >_<" + "\r\n");
                    b[0] = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        if (b[0] != true) {
            t.stop();
        } else {
            t.start();
        }

        contentPane.add(textPane);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("宋体", Font.BOLD, 23));
        textArea.setBounds(14, 469, 798, 139);
        contentPane.add(textArea);


        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBounds(14, 13, 798, 402);
        //scrollPane.add(textPane);
        contentPane.add(scrollPane);

        JButton button = new JButton("\u53D1\u9001");
        button.setFont(new Font("宋体", Font.BOLD, 23));
        final int[] falg = {1};
        //这个是给按钮添加点击事件
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (falg[0] == 1) {
                    //1.需要获得textArea这个里面文本内容
                    String inputText = textArea.getText();
                    String s1 = textPane.getText();
                    String[] str = inputText.split("");
                    textPane.setText(s1 + "\r\n" + inputText + "\r\n");
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                String s2 = textPane.getText();
                                textPane.setText(s2 + "\r\n" + "oh~,你是" + str[2] + str[3] + str[4] + "呀,我叫Linux,以后请多关照呀 `(*∩_∩*)′" + "\r\n");
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    t.start();

                    //4.textArea清空
                    textArea.setText("");
                    falg[0]++;
                } else if (falg[0] == 3) {
                    String inputText = textArea.getText();
                    String s1 = textPane.getText();
                    textPane.setText(s1 + "\r\n" + inputText + "\r\n");
                    textArea.setText("");
                } else {
                    String inputText = textArea.getText();
                    String s1 = textPane.getText();
                    textPane.setText(s1 + "\r\n" + inputText + "\r\n");
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                String s3 = textPane.getText();
                                textPane.setText(s3 + "\r\n" + "哈哈哈哈哈哈,(o´ω`o)" + "\r\n");
                                Thread.sleep(3000);
                                String s4 = textPane.getText();
                                textPane.setText(s4 + "\r\n" + "对惹,今天是码农节嗷! 1024 ,节日快乐嗷 " + "\r\n");
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    t.start();
                    //4.textArea清空
                    textArea.setText("");
                    falg[0]++;
                }

            }
        });
        button.setBounds(687, 646, 113, 27);
        contentPane.add(button);

    }
}
