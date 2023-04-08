package com.clock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;


public class Window extends JFrame{

    private JLabel heading;

    private JLabel clockLabel;
    private Font font = new FontUIResource("Ariel", WIDTH, 35);


     Window(){
        super.setTitle("Digital Clock");
        super.setSize(400, 400);
        super.setLocation(500,200);
        this.GUI();
        this.startclock();
        super.setVisible(true);
     }
     public void GUI(){
        heading  = new JLabel("Digital Clock");
        clockLabel = new JLabel("clock");
        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
     }

     public void startclock(){
        Thread t = new Thread(){
            public void run(){
                try{
                    while(true){
                        Date d = new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat();
                        String dateTime = sfd.format(d);
                        clockLabel.setText(dateTime);

                        Thread.sleep(1000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
        
     }
}
