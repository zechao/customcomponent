/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcomponent;

import javax.swing.JButton;
import java.awt.Graphics;

public class CustomButton extends JButton {

    private static final long serialVersionUID = 1L;

    public CustomButton(String s) {
        super(s);
    }

    @Override
    public void paint(Graphics g) {
        g.fillOval(0, 0, 10, 10);
    }
}
