/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aribeiro.imagannot.utils;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.CellRendererPane;

/**
 *
 * @author Miguel
 */
public final class ImageExporter {

    private ImageExporter() {

    }

    public static void savePanelAsImage(Component component, String path) {
        try {
            ImageIO.write(ImageExporter.componentToImage(component, true), "png", new File(path));
            System.out.println("panel saved as image");
        } catch (IOException e) {
            System.out.println("panel not saved" + e.getMessage());
        }
    }

    public static BufferedImage componentToImage(Component component, boolean visible) {
        if (visible) {
            BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
            Graphics2D g2d = (Graphics2D) img.getGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            component.paintAll(g2d);
            return img;
        } else {
            component.setSize(component.getPreferredSize());
            layoutComponent(component);
            BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
            CellRendererPane crp = new CellRendererPane();
            crp.add(component);
            crp.paintComponent(img.createGraphics(), component, crp, component.getBounds());
            return img;
        }
    }

    private static void layoutComponent(Component c) {
        synchronized (c.getTreeLock()) {
            c.doLayout();
            if (c instanceof Container) {
                for (Component child : ((Container) c).getComponents()) {
                    layoutComponent(child);
                }
            }
        }
    }
}
