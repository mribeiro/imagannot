/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.aribeiro.imagannot.shapes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.Border;

/**
 *
 * @author Miguel
 */
public class SquareLabel extends CommonLabel {

    public SquareLabel(String text, Color bgColor, Color textColor, Border border) {
        super(text, bgColor, textColor, border, new Dimension(20, 20));
    }

    
    
}
