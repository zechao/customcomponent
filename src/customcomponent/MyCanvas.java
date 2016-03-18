/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcomponent;
//Test  modified wtf
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author zechao
 */
public class MyCanvas extends JComponent implements MouseListener{
 
    public MyCanvas(){
         this.addMouseListener(this);
         InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
         
         KeyStroke teclaAmaillo=KeyStroke.getKeyStroke("ctrl A");
         
         mapaEntrada.put(teclaAmaillo, "fondoAmarillo");
         
         ActionMap mapaActionMap=getActionMap();
         
         //mapaActionMap.put("fondoAmarillo", );
    }  
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
         
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.setColor(new Color(0,0,0,100));
        g2d.drawString("hello world", 60, 60);
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Cliked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
