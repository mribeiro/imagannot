/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.aribeiro.imagannot.shapes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
/**
 *
 * @author Miguel
 */
public class RoundLabel extends CommonLabel {

    private final Color backgroundColor;
    
    public RoundLabel(String text, Color bgColor, Color textColor, Dimension dim) {
//        super(text, bgColor, textColor, null, new Dimension(21, 21));
        super(text, bgColor, textColor, null, dim);
        this.backgroundColor = bgColor;
        setOpaque(false);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        g.setColor(backgroundColor);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
//        g2d.draw(new Ellipse2D.Float(0, 0, 20, 20));
//        g2d.fill(new Ellipse2D.Float(1, 1, 19, 19));
        
        float width = Float.parseFloat(this.getSize().getWidth()+"");
        float height = Float.parseFloat(this.getSize().getHeight()+"");
        
        width-=1;
        height-=1;
        g2d.draw(new Ellipse2D.Double(0, 0, width, height));
        
        width-=1;
        height-=1;
        g2d.fill(new Ellipse2D.Double(1, 1, width, height));
        
        super.paintComponent(g);
    }
    
    
    
}
