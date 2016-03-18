/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcomponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.*;

public class OneTwoThree implements Runnable {

    private String testS;
    private JFrame frame = new JFrame("frameTitle");
    private JScrollPane tblS = new JScrollPane();
    private JTable tbl;
    private Vector<String> rOrH;
    private long t1 = 0L;
    private long t2 = 0L;
    private AlphaChars aChars = new AlphaChars();
    private GradientViewPortOriginal tableViewPort;
    private JViewport viewport = new JViewport();
    private Random random = new Random();
    private Vector<Vector<Integer>> vec = new Vector<Vector<Integer>>();
    private boolean bolo = false;

    public OneTwoThree() {
        t1 = System.currentTimeMillis();
        int regLenght = 3500;
        int chars = 0;
        testS = aChars.getNext(regLenght);
        rOrH = new Vector<String>();
        Vector<Vector<String>> rowD = new Vector<Vector<String>>();
        for (int e = 0; e < regLenght;) {
            chars++;
            if (chars > 50) {
                chars = 1;
                rowD.add(rOrH);
                rOrH = new Vector<String>();
            }
            String str = (testS.substring(e, (e + 1))).toString();
            if (str != null) {
                rOrH.add(str);
            } else {
                rOrH.add("");
            }
            e++;
        }
        rOrH = new Vector<String>();
        for (int i = 0; i < 50; i++) {
            rOrH.add(String.valueOf(i + 1));
        }
        tbl = new JTable(rowD, rOrH);
        TableColumnModel tcm = tbl.getColumnModel();
        for (int i = 0; i < (tcm.getColumnCount()); i++) {
            tcm.getColumn(i).setPreferredWidth(4);
        }
        tbl.setGridColor(tbl.getBackground());
        tbl.setRowHeight(10);
        tbl.setTableHeader(null);
        tbl.setPreferredScrollableViewportSize(tbl.getPreferredSize());
        tbl.setRowSelectionAllowed(false);
        tbl.setColumnSelectionAllowed(false);
        tableViewPort = new GradientViewPortOriginal(tbl);
        viewport = tableViewPort.getViewport();
        RepaintManager.setCurrentManager(new RepaintManager() {

            @Override
            public void addDirtyRegion(JComponent c, int x, int y, int w, int h) {
                Container con = c.getParent();
                while (con instanceof JComponent) {
                    if (!con.isVisible()) {
                        return;
                    }
                    if (con instanceof GradientViewPortOriginal) {
                        c = (JComponent) con;
                        x = 0;
                        y = 0;
                        w = con.getWidth();
                        h = con.getHeight();
                    }
                    con = con.getParent();
                }
                super.addDirtyRegion(c, x, y, w, h);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tableViewPort, BorderLayout.CENTER);
        frame.setLocation(20, 20);
        frame.pack();
        frame.setVisible(true);
        addColumnRenderes();
        for (int i = 0; i < 35; i++) {
            Star star = new Star(new Point(random.nextInt(490), random.nextInt(490)));
            star.setColor(new Color(100 + random.nextInt(155), 100 + random.nextInt(155), 100 + random.nextInt(155)));
            star.setxIncr(-3 + random.nextInt(7));
            star.setyIncr(-3 + random.nextInt(7));
            tableViewPort.add(star);
        }
    }

    private void addColumnRenderes() {
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            RowColorRenderer rowRenderer = new RowColorRenderer(i);
            TableColumn column = tbl.getColumnModel().getColumn(i);
            column.setCellRenderer(rowRenderer);
        }
        addTableData();
    }

    private void addTableData() {
        tbl.setValueAt("8", 4, 25);tbl.setValueAt("4", 5, 24);tbl.setValueAt("1", 5, 25);tbl.setValueAt("4", 5, 26);
        tbl.setValueAt("4", 6, 23);tbl.setValueAt("4", 6, 25);tbl.setValueAt("1", 6, 26);tbl.setValueAt("4", 6, 27);
        tbl.setValueAt("1", 6, 28);tbl.setValueAt("1", 7, 21);tbl.setValueAt("4", 7, 22);tbl.setValueAt("1", 7, 23);
        tbl.setValueAt("4", 7, 24);tbl.setValueAt("1", 7, 27);tbl.setValueAt("8", 7, 28);tbl.setValueAt("4", 8, 23);
        tbl.setValueAt("1", 8, 24);tbl.setValueAt("1", 8, 25);tbl.setValueAt("8", 8, 26);tbl.setValueAt("8", 8, 27);
        tbl.setValueAt("7", 9, 24);tbl.setValueAt("1", 9, 26);tbl.setValueAt("4", 9, 25);tbl.setValueAt("4", 10, 24);
        tbl.setValueAt("1", 10, 25);tbl.setValueAt("8", 10, 26);tbl.setValueAt("4", 11, 23);tbl.setValueAt("4", 11, 27);
        tbl.setValueAt("1", 12, 21);tbl.setValueAt("4", 12, 22);tbl.setValueAt("8", 12, 28);tbl.setValueAt("4", 13, 21);
        tbl.setValueAt("8", 13, 29);tbl.setValueAt("1", 14, 19);tbl.setValueAt("4", 14, 20);tbl.setValueAt("8", 14, 30);
        tbl.setValueAt("4", 15, 19);tbl.setValueAt("4", 15, 20);tbl.setValueAt("4", 15, 21);tbl.setValueAt("1", 15, 22);
        tbl.setValueAt("4", 15, 23);tbl.setValueAt("1", 15, 31);tbl.setValueAt("1", 15, 32);tbl.setValueAt("4", 16, 22);
        tbl.setValueAt("4", 17, 21);tbl.setValueAt("4", 18, 20);tbl.setValueAt("4", 19, 20);tbl.setValueAt("4", 20, 19);
        tbl.setValueAt("4", 21, 17);tbl.setValueAt("4", 21, 18);tbl.setValueAt("4", 22, 16);tbl.setValueAt("4", 22, 17);
        tbl.setValueAt("4", 22, 18);tbl.setValueAt("4", 22, 19);tbl.setValueAt("4", 22, 20);tbl.setValueAt("4", 24, 18);
        tbl.setValueAt("4", 25, 17);tbl.setValueAt("4", 25, 17);tbl.setValueAt("4", 26, 16);tbl.setValueAt("4", 27, 15);
        tbl.setValueAt("4", 27, 16);tbl.setValueAt("4", 27, 18);tbl.setValueAt("4", 28, 17);tbl.setValueAt("4", 29, 16);
        tbl.setValueAt("4", 30, 15);tbl.setValueAt("4", 31, 14);tbl.setValueAt("4", 32, 13);tbl.setValueAt("4", 33, 12);
        tbl.setValueAt("4", 33, 13);tbl.setValueAt("4", 33, 14);tbl.setValueAt("4", 33, 18);tbl.setValueAt("4", 34, 17);
        tbl.setValueAt("4", 35, 16);tbl.setValueAt("4", 36, 15);tbl.setValueAt("4", 37, 14);tbl.setValueAt("4", 38, 13);
        tbl.setValueAt("4", 39, 12);tbl.setValueAt("4", 40, 11);tbl.setValueAt("4", 41, 10);tbl.setValueAt("4", 42, 9);
        tbl.setValueAt("4", 42, 10);tbl.setValueAt("4", 42, 11);tbl.setValueAt("4", 38, 18);tbl.setValueAt("4", 39, 18);
        tbl.setValueAt("4", 40, 18);tbl.setValueAt("4", 41, 17);tbl.setValueAt("4", 42, 16);tbl.setValueAt("4", 43, 15);
        tbl.setValueAt("4", 44, 14);tbl.setValueAt("4", 46, 13);tbl.setValueAt("4", 47, 12);tbl.setValueAt("4", 48, 11);
        tbl.setValueAt("4", 49, 10);tbl.setValueAt("4", 50, 9);tbl.setValueAt("4", 51, 8);tbl.setValueAt("4", 52, 7);
        tbl.setValueAt("4", 53, 6);tbl.setValueAt("4", 54, 5);tbl.setValueAt("4", 55, 4);tbl.setValueAt("4", 56, 6);
        tbl.setValueAt("4", 56, 8);tbl.setValueAt("4", 56, 9);tbl.setValueAt("4", 56, 10);tbl.setValueAt("4", 56, 12);
        tbl.setValueAt("4", 56, 13);tbl.setValueAt("4", 58, 10);tbl.setValueAt("4", 59, 11);tbl.setValueAt("4", 59, 12);
        tbl.setValueAt("4", 60, 13);tbl.setValueAt("4", 61, 15);tbl.setValueAt("4", 61, 16);tbl.setValueAt("4", 59, 17);
        tbl.setValueAt("4", 58, 18);tbl.setValueAt("4", 57, 19);tbl.setValueAt("4", 62, 18);tbl.setValueAt("4", 63, 19);
        tbl.setValueAt("4", 63, 20);tbl.setValueAt("3", 62, 23);tbl.setValueAt("3", 63, 23);tbl.setValueAt("3", 64, 23);
        tbl.setValueAt("3", 65, 23);tbl.setValueAt("3", 66, 23);tbl.setValueAt("3", 67, 23);tbl.setValueAt("3", 62, 28);
        tbl.setValueAt("3", 63, 28);tbl.setValueAt("3", 64, 28);tbl.setValueAt("3", 65, 28);tbl.setValueAt("3", 66, 28);
        tbl.setValueAt("3", 67, 28);tbl.setValueAt("8", 14, 26);tbl.setValueAt("8", 14, 27);tbl.setValueAt("8", 16, 27);
        tbl.setValueAt("8", 16, 28);tbl.setValueAt("8", 17, 29);tbl.setValueAt("8", 18, 30);tbl.setValueAt("8", 19, 31);
        tbl.setValueAt("8", 20, 32);tbl.setValueAt("8", 21, 31);tbl.setValueAt("8", 22, 30);tbl.setValueAt("8", 22, 29);
        tbl.setValueAt("3", 20, 27);tbl.setValueAt("3", 21, 26);tbl.setValueAt("3", 22, 25);tbl.setValueAt("3", 23, 24);
        tbl.setValueAt("3", 24, 24);tbl.setValueAt("3", 24, 25);tbl.setValueAt("3", 24, 26);tbl.setValueAt("8", 22, 32);
        tbl.setValueAt("8", 23, 33);tbl.setValueAt("8", 24, 34);tbl.setValueAt("8", 25, 35);tbl.setValueAt("8", 26, 36);
        tbl.setValueAt("8", 27, 37);tbl.setValueAt("8", 29, 34);tbl.setValueAt("8", 29, 35);tbl.setValueAt("8", 28, 36);
        tbl.setValueAt("8", 30, 32);tbl.setValueAt("8", 31, 33);tbl.setValueAt("8", 32, 34);tbl.setValueAt("8", 33, 35);
        tbl.setValueAt("8", 34, 36);tbl.setValueAt("8", 34, 37);tbl.setValueAt("3", 27, 30);tbl.setValueAt("3", 28, 29);
        tbl.setValueAt("3", 29, 28);tbl.setValueAt("3", 30, 28);tbl.setValueAt("3", 31, 29);tbl.setValueAt("3", 32, 30);
        tbl.setValueAt("3", 31, 24);tbl.setValueAt("3", 32, 23);tbl.setValueAt("3", 33, 22);tbl.setValueAt("3", 34, 22);
        tbl.setValueAt("3", 34, 23);tbl.setValueAt("3", 34, 24);tbl.setValueAt("3", 37, 20);tbl.setValueAt("3", 38, 19);
        tbl.setValueAt("3", 39, 18);tbl.setValueAt("3", 40, 18);tbl.setValueAt("3", 41, 19);tbl.setValueAt("3", 42, 20);
        tbl.setValueAt("3", 36, 34);tbl.setValueAt("3", 37, 33);tbl.setValueAt("3", 38, 32);tbl.setValueAt("3", 39, 32);
        tbl.setValueAt("3", 39, 33);tbl.setValueAt("3", 39, 34);tbl.setValueAt("3", 40, 24);tbl.setValueAt("3", 41, 23);
        tbl.setValueAt("3", 42, 22);tbl.setValueAt("3", 43, 22);tbl.setValueAt("3", 43, 23);tbl.setValueAt("3", 43, 24);
        tbl.setValueAt("3", 42, 30);tbl.setValueAt("3", 43, 29);tbl.setValueAt("3", 44, 28);tbl.setValueAt("3", 45, 28);
        tbl.setValueAt("3", 46, 29);tbl.setValueAt("3", 47, 30);tbl.setValueAt("3", 50, 21);tbl.setValueAt("3", 51, 20);
        tbl.setValueAt("3", 52, 19);tbl.setValueAt("3", 53, 19);tbl.setValueAt("3", 53, 20);tbl.setValueAt("3", 53, 21);
        tbl.setValueAt("3", 50, 31);tbl.setValueAt("3", 51, 30);tbl.setValueAt("3", 52, 29);tbl.setValueAt("3", 53, 29);
        tbl.setValueAt("3", 53, 30);tbl.setValueAt("3", 53, 31);tbl.setValueAt("3", 47, 15);tbl.setValueAt("3", 48, 14);
        tbl.setValueAt("3", 49, 13);tbl.setValueAt("3", 50, 13);tbl.setValueAt("3", 51, 14);tbl.setValueAt("3", 52, 15);
        tbl.setValueAt("3", 51, 25);tbl.setValueAt("3", 52, 24);tbl.setValueAt("3", 53, 23);tbl.setValueAt("3", 54, 23);
        tbl.setValueAt("3", 55, 24);tbl.setValueAt("3", 46, 25);tbl.setValueAt("3", 50, 38);tbl.setValueAt("3", 51, 37);
        tbl.setValueAt("3", 52, 36);tbl.setValueAt("3", 53, 36);tbl.setValueAt("3", 54, 37);tbl.setValueAt("3", 55, 38);
        tbl.setValueAt("3", 58, 28);tbl.setValueAt("3", 59, 27);tbl.setValueAt("3", 60, 26);tbl.setValueAt("3", 58, 26);
        tbl.setValueAt("3", 59, 27);tbl.setValueAt("3", 60, 28);tbl.setValueAt("8", 37, 36);tbl.setValueAt("8", 38, 37);
        tbl.setValueAt("8", 38, 38);tbl.setValueAt("8", 40, 39);tbl.setValueAt("8", 41, 40);tbl.setValueAt("8", 42, 41);
        tbl.setValueAt("8", 43, 41);tbl.setValueAt("8", 44, 38);tbl.setValueAt("8", 44, 39);tbl.setValueAt("8", 44, 40);
        tbl.setValueAt("8", 43, 35);tbl.setValueAt("8", 44, 36);tbl.setValueAt("8", 45, 37);tbl.setValueAt("8", 46, 38);
        tbl.setValueAt("8", 47, 39);tbl.setValueAt("8", 48, 40);tbl.setValueAt("8", 49, 41);tbl.setValueAt("8", 50, 42);
        tbl.setValueAt("8", 51, 43);tbl.setValueAt("8", 52, 44);tbl.setValueAt("8", 53, 45);tbl.setValueAt("8", 54, 43);
        tbl.setValueAt("8", 55, 42);tbl.setValueAt("8", 56, 41);tbl.setValueAt("8", 59, 31);tbl.setValueAt("8", 60, 32);
        tbl.setValueAt("8", 61, 33);tbl.setValueAt("8", 62, 34);tbl.setValueAt("8", 58, 36);tbl.setValueAt("8", 59, 37);
        tbl.setValueAt("8", 60, 38);tbl.setValueAt("8", 61, 39);tbl.setValueAt("8", 62, 40);tbl.setValueAt("8", 62, 41);
        tbl.setValueAt("8", 60, 35);tbl.setValueAt("8", 61, 36);tbl.setValueAt("8", 62, 37);tbl.setValueAt("8", 58, 45);
        tbl.setValueAt("8", 59, 42);tbl.setValueAt("8", 59, 43);tbl.setValueAt("8", 59, 44);tbl.setValueAt("8", 62, 40);
        frame.setTitle(" - - >   Merry Christmast   < - - ");
        t2 = System.currentTimeMillis();
        System.out.println("miliSec:" + (t2 - t1)); //aver. 32 miliSec.
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!bolo) {
                for (int i = 0; i < 30; i++) {
                    Vector<Integer> vecLocal = new Vector<Integer>();
                    final int r1 = random.nextInt(tbl.getRowCount() - 1);
                    final int c1 = random.nextInt(tbl.getColumnCount() - 1);
                    vecLocal.add(r1);
                    vecLocal.add(c1);
                    vec.add(vecLocal);
                    addSnowFlag();
                    try {
                        Thread.sleep(250);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                bolo = true;
            } else {
                Vector<Integer> vecLocal = new Vector<Integer>();
                final int r = random.nextInt(tbl.getRowCount() - 1);
                final int c = random.nextInt(tbl.getColumnCount() - 1);
                vecLocal.add(r);
                vecLocal.add(c);
                vec.add(vecLocal);
                addSnowFlag();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addSnowFlag() {
        if (vec.size() > -1) {
            Vector<Integer> vecLocal = vec.elementAt(vec.size() - 1);
            final int r = vecLocal.elementAt(0);
            final int c = vecLocal.elementAt(1);
            String str = String.valueOf(tbl.getValueAt(r, c));
            if (!str.isEmpty()) {
                if (!Pattern.compile("\\d").matcher(str).find()) {
                    if (!Pattern.compile("[123456789]").matcher(str).find()) {
                        Runnable doRun = new Runnable() {

                            @Override
                            public void run() {
                                tbl.setValueAt("9", r, c);
                            }
                        };
                        SwingUtilities.invokeLater(doRun);
                        if (bolo) {
                            Vector<Integer> vecLocal1 = vec.elementAt(0);
                            final int r1 = vecLocal1.elementAt(0);
                            final int c1 = vecLocal1.elementAt(1);
                            Runnable doRun1 = new Runnable() {

                                @Override
                                public void run() {
                                    tbl.setValueAt(aChars.getNext(1), r1, c1);
                                    vec.removeElementAt(0);
                                }
                            };
                            SwingUtilities.invokeLater(doRun1);
                        }
                    }
                }
            }
        }
    }

    private class GradientViewPortOriginal extends JScrollPane {

        private static final long serialVersionUID = 1L;
        private final int h = 80;
        private BufferedImage img = null;
        private BufferedImage shadow = new BufferedImage(1, h, BufferedImage.TYPE_INT_ARGB);
        private JViewport viewPort;
        private ArrayList<Star> stars = new ArrayList<Star>();

        public GradientViewPortOriginal(JComponent com) {
            super(com);
            viewPort = this.getViewport();
            viewPort.setScrollMode(JViewport.BLIT_SCROLL_MODE);
            viewPort.setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
            viewPort.setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
            setPreferredSize(this.getPreferredSize());
            paintBackGround(new Color(250, 250, 150));
        }

        public void add(Star star) {
            stars.add(star);
        }
        //
        private Timer timer = new Timer(33, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Star star : stars) {
                    star.move();
                }
                repaint();
            }
        });

        public void startAnimation() {
            if (!timer.isRunning()) {
                timer.start();
            }
        }

        @Override
        public void addNotify() {
            super.addNotify();
            timer.start();
        }

        private void paintBackGround(Color g) {
            Graphics2D g2 = shadow.createGraphics();
            g2.setPaint(g);
            g2.fillRect(0, 0, 1, h);
            g2.setComposite(AlphaComposite.DstIn);
            g2.setPaint(new GradientPaint(0, 0, new Color(0, 0, 0, 0f), 0, h,
                    new Color(0.8f, 0.8f, 0.8f, 0.5f)));
            g2.fillRect(0, 0, 1, h);
            g2.dispose();
        }

        @Override
        public void paint(Graphics g) {
            if (img == null || img.getWidth() != getWidth() || img.getHeight() != getHeight()) {
                img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            }
            Graphics2D g2 = img.createGraphics();
            super.paint(g2);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Rectangle bounds = getViewport().getVisibleRect();
            g2.scale(bounds.getWidth(), -1);
            int y = (getColumnHeader() == null) ? 0 : getColumnHeader().getHeight();
            g2.drawImage(shadow, bounds.x, -bounds.y - y - h, null);
            g2.scale(1, -1);
            g2.drawImage(shadow, bounds.x, bounds.y + bounds.height - h + y, null);
            g2.dispose();
            g.drawImage(img, 0, 0, null);
            for (Star star : stars) {
                g.setColor(star.getColor());
                g.fillPolygon(star);
            }
        }
    }

    private class RowColorRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;
        private int colNo = 0;

        RowColorRenderer(int col) {
            colNo = col;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
            if (!isSelected) {
                if (table.getValueAt(row, colNo) != null) {
                    String str = table.getValueAt(row, colNo).toString();
                    if (!str.isEmpty()) {
                        if (Pattern.compile("\\d").matcher(str).find()) {
                            if (((Pattern.compile("[9]").matcher(str).find()))) {
                                setBackground(new Color(250, 250, 150));
                                setForeground(new Color(250, 250, 150));
                                setFont(new Font("Serif", Font.BOLD, 9));
                            } else if (((Pattern.compile("[1]").matcher(str).find()))) {
                                setBackground(tbl.getBackground());
                                setForeground(Color.orange);
                                setFont(new Font("Serif", Font.BOLD, 8));
                            } else {
                                setBackground(tbl.getBackground());
                                setForeground(Color.gray);
                                setFont(new Font("Serif", Font.BOLD, 9));
                            }
                        } else {
                            setBackground(tbl.getBackground());
                            setForeground(Color.lightGray);
                            setFont(new Font("Serif", Font.PLAIN, 6));
                        }
                    }
                }
            }
            setHorizontalAlignment(CENTER);
            return this;
        }
    }

    private class AlphaChars {

        public static final int MIN_LENGTH = 2000;
        private java.util.Random rand = new java.util.Random();
        private char[] AlphaChars = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
        /*'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '-', '*', '/', '<', '>', '&',
        '#', '@', '{', '}', '?', ':', '_', '"', '!', ')', '('};*/

        public String getNext() {
            StringBuilder strbuf = new StringBuilder();
            for (int i = 0; i < MIN_LENGTH; i++) {
                strbuf.append(getAlphaChars()[getRand().nextInt(getAlphaChars().length)]);
            }
            return strbuf.toString();
        }

        public String getNext(int reqLenght) {
            StringBuilder strbuf = new StringBuilder();
            for (int i = 0; i < reqLenght; i++) {
                strbuf.append(getAlphaChars()[getRand().nextInt(getAlphaChars().length)]);
            }
            return strbuf.toString();
        }

        public java.util.Random getRand() {
            return rand;
        }

        public void setRand(java.util.Random aRand) {
            rand = aRand;
        }

        public char[] getAlphaChars() {
            return AlphaChars;
        }

        public void setAlphaChars(char[] aAlphaChars) {
            AlphaChars = aAlphaChars;
        }
    }

    private class Star extends Polygon {

        private static final long serialVersionUID = 1L;
        private Point location = null;
        private Color color = Color.YELLOW;
        private int xIncr, yIncr;
        static final int WIDTH = 500, HEIGHT = 500;

        Star(Point location) {
            int x = location.x;
            int y = location.y;
            this.location = location;
            this.addPoint(x, y + 8);
            this.addPoint(x + 8, y + 8);
            this.addPoint(x + 11, y);
            this.addPoint(x + 14, y + 8);
            this.addPoint(x + 22, y + 8);
            this.addPoint(x + 17, y + 12);
            this.addPoint(x + 21, y + 20);
            this.addPoint(x + 11, y + 14);
            this.addPoint(x + 3, y + 20);
            this.addPoint(x + 6, y + 12);
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void move() {
            if (location.x < 0 || location.x > WIDTH) {
                xIncr = -xIncr;
            }
            if (location.y < 0 || location.y > WIDTH) {
                yIncr = -yIncr;
            }
            translate(xIncr, yIncr);
            location.setLocation(location.x + xIncr, location.y + yIncr);
        }

        public void setxIncr(int xIncr) {
            this.xIncr = xIncr;
        }

        public void setyIncr(int yIncr) {
            this.yIncr = yIncr;
        }

        public Color getColor() {
            return color;
        }
    }

    public static void main(String args[]) {
        Runnable doRun = new Runnable() {

            @Override
            public void run() {
                OneTwoThree hnvit = new OneTwoThree();
            }
        };
        SwingUtilities.invokeLater(doRun);
    }
}
