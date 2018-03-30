package com.company;

import java.applet.Applet;
import java.awt.*;

public class HelloWorldApplet extends Applet{

    @Override
    public void paint(Graphics graphics) {
        //super.paint(graphics);

        graphics.drawString("Hello Applet",  20, 80);
    }
}
