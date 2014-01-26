/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.aribeiro.imagannot.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Miguel
 */
public final class ImageExporter {
    
    private ImageExporter() {
        
    }
    
    public static BufferedImage panelToImage(JPanel panel) {
        Border b = panel.getBorder();
        panel.setBorder(null);
        BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) img.getGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        panel.paintComponents(graphics);
        panel.setBorder(b);
        return img;
    }
    
    public static void savePanelAsImage(JPanel panel, String path) {
        try {
            ImageIO.write(ImageExporter.panelToImage(panel), "png", new File(path));
            System.out.println("panel saved as image");

        } catch (Exception e) {
            System.out.println("panel not saved" + e.getMessage());
        }
    }
    
}
