package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class Line_LROD {
    JLabel jlb;
    JPanel jpan;

    public Line_LROD(){
    JFrame jfrm = new JFrame("move Line");
    //jfrm.setLayout(new FlowLayout());
    jfrm.setSize(500,500);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton jbtnUP = new JButton("UP");
    JButton jbtnDOWN = new JButton("DOWN");
    JButton jbtnLEFT = new JButton("LEFT");
    JButton jbtnRIGHT = new JButton("RIGHT");
    JButton jbtnDARK = new JButton("Темнее");
    JButton jbtnLIGTH = new JButton("Светлее");
        PaintLine pl = new PaintLine();

        jbtnDARK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pl.c = pl.c.darker();
                jfrm.repaint();
                jlb.setText("ТЕМНЕЕ was pressed");
            }
        });
        jbtnLIGTH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pl.c = pl.c.brighter();
                jfrm.repaint();
                jlb.setText("СВЕТЛЕЕ was pressed");
            }
        });

    jbtnUP.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jlb.setText("UP was pressed");
            //pl.x1 += 5;
            pl.y1 -= 5;
            //pl.x2 += 5;
            pl.y2 -= 5;

            jfrm.repaint();
        }
    });
    jbtnDOWN.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jlb.setText("DOWN was pressed");
            //pl.x1 += 5;
            pl.y1 += 5;
            //pl.x2 += 5;
            pl.y2 += 5;
            jfrm.repaint();
        }
    });
    jbtnLEFT.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jlb.setText("LEFT was pressed");
            pl.x1 -= 5;
            pl.x2 -= 5;

            jfrm.repaint();
        }
    });
    jbtnRIGHT.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jlb.setText("RIGHT was pressed");
            pl.x1 += 5;

            pl.x2 += 5;

            jfrm.repaint();
        }
    });

    jpan = new JPanel();

    jpan.add(jbtnDOWN);
    jpan.add(jbtnLEFT);
    jpan.add(jbtnRIGHT);
    jpan.add(jbtnUP);
    jpan.add(jbtnDARK);
    jpan.add(jbtnLIGTH);
    jfrm.add(jpan, BorderLayout.NORTH);

    jlb = new JLabel("press button");
    jfrm.add(jlb, BorderLayout.SOUTH);

    //PaintLine pl = new PaintLine();
    //pl.setLayout(new BorderLayout());
    jfrm.add(pl, BorderLayout.CENTER);

       jfrm.setVisible(true);
    }
}

class PaintLine extends JPanel{
    protected int  x1 = 200;
    protected int y1 = 200;
    protected int x2 = 350;
    protected int y2 = 350;
    Color c = new Color(10, 10, 100);


    PaintLine() {
    setBorder(BorderFactory.createLineBorder(Color.RED, 5));
    }
    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D) g;
        BasicStroke b = new BasicStroke(10);
        gr.setStroke(b);
       // c = new Color(10, 10, 100);
       // c.RGBtoHSB(10, 10, 100, null);

        gr.setColor(c.brighter());
        gr.draw(new Line2D.Double(x1,y1,x2,y2));
    }
}