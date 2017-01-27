/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.aribeiro.imagannot.shapes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Miguel
 */
public class CommonLabel extends JLabel {
    
    public CommonLabel(String text, Color bgColor, Color textColor, Border border, Dimension size) {
        super(text);
        setSize(size);
        setOpaque(true);
        setBorder(border);
        setBackground(bgColor);
        setForeground(textColor);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);
    }
    
}
