package laba4;
import java.awt.BorderLayout;
import java.awt.geom.Rectangle2D;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.imageio.ImageIO; // обеспечивает простые операции загрузки и сохранения изображения
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import javax.swing.*;
import javax.swing.SwingWorker; // облегчает процесс организации фонового потока

public class FractalExplorer
{
    private int displaySize;
    private JImageDisplay image;
    private FractalGenerator gen;
    private Rectangle2D.Double range;
    private JComboBox<String> fractalChooser;
    private JButton saveBut;
    private JButton resetBut;
    private int rowsRemaining;

    private void enableUI(boolean val)
    {
        fractalChooser.setEnabled(val);
        saveBut.setEnabled(val);
        resetBut.setEnabled(val);
    }

    public FractalExplorer(int size)
    {
        displaySize = size;
        gen = new Mandelbrot();
        range = new Rectangle2D.Double();
        gen.getInitialRange(range);
    }

    public void createAndShowGUI()
    {
        JFrame frame = new JFrame("Фрактальный Исследователь");
        image = new JImageDisplay(displaySize, displaySize);
        resetBut = new JButton("Сброс дисплея");
        resetBut.setActionCommand("reset");
        FractalHandler handler = new FractalHandler();
        resetBut.addActionListener(handler);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(image, BorderLayout.CENTER);
        frame.getContentPane().add(resetBut, BorderLayout.SOUTH);
        JPanel buttonsPanel = new JPanel();
        JPanel fractalPanel = new JPanel();

        JLabel label = new JLabel("Фрактал: ");
        fractalPanel.add(label);

        fractalChooser = new JComboBox<String>();
        fractalChooser.addItem(Mandelbrot.getString());
        fractalChooser.addItem(Tricorn.getString());
        fractalChooser.addItem(BurningShip.getString());
        fractalChooser.addActionListener(handler);

        fractalPanel.add(fractalChooser);

        frame.getContentPane().add(fractalPanel, BorderLayout.NORTH);

        buttonsPanel.add(resetBut);
        saveBut = new JButton("Сохранить изображение");
        saveBut.setActionCommand("save");
        saveBut.addActionListener(handler);
        buttonsPanel.add(saveBut);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        frame.getContentPane().addMouseListener(new MouseHandler());


        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private class FractalHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (e.getSource() == fractalChooser) {
                String selectedItem = fractalChooser.getSelectedItem().toString();

                if (selectedItem.equals(Mandelbrot.getString())) {
                    gen = new Mandelbrot();
                } else if (selectedItem.equals(Tricorn.getString())) {
                    gen = new Tricorn();
                } else if (selectedItem.equals(BurningShip.getString())) {
                    gen = new BurningShip();
                } else {
                    JOptionPane.showMessageDialog(null, "Ошибка: Невозможно распознать выбор");
                    return;
                }

                range = new Rectangle2D.Double();
                gen.getInitialRange(range);
                drawFractal();

            } else if (cmd.equals("reset")) {
                image.clearImage();
                image.repaint();
                range = new Rectangle2D.Double();
                gen.getInitialRange(range);
                drawFractal();
                System.out.println("ok!");
            } else if (cmd.equals("save")) {
                JFileChooser chooser = new JFileChooser();

                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);


                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        File f = chooser.getSelectedFile();
                        String filePath = f.getPath();
                        if (!filePath.toLowerCase().endsWith(".png")) {
                            f = new File(filePath + ".png");
                        }

                        ImageIO.write(image.getImage(), "png", f);
                    } catch (IOException exc) {
                        JOptionPane.showMessageDialog(null, "Ошибка: Не удалось сохранить изображение( "
                                + exc.getMessage() + " )");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ошибка: Не удалось распознать действие");
            }
        }
    }

    private class MouseHandler extends MouseAdapter
    {

        public void mouseClicked(MouseEvent e)
        {
            if (rowsRemaining > 0)
                return;


            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width,
                    displaySize, e.getX());

            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height,
                    displaySize, e.getY());

            gen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();

        }
    }

    private class FractalWorker extends SwingWorker<Object, Object>
    {

        private int _y;

        private int[] _RGBVals;

        public FractalWorker(int y)
        {
            _y = y;
        }

        public Object doInBackground()
        {
            _RGBVals = new int[displaySize];

            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, _y);

            for (int x = 0; x < displaySize; x++) {

                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
                int numIters;
                int rgbColor = 0;
                float hue;

                numIters = gen.numIterations(xCoord, yCoord);
                if (numIters >= 0) {
                    hue = 0.7f + numIters / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }

                _RGBVals[x] = rgbColor;
            }

            return null;
        }

        public void done()
        {
            for (int x = 0; x < displaySize; x++) {
                image.drawPixel(x, _y, _RGBVals[x]);
            }

            image.repaint(0, 0, _y, displaySize, 1);
            System.out.println(rowsRemaining);
            if (rowsRemaining-- < 1) {
                enableUI(true);
            }
        }
    }

    public void drawFractal()
    {
        enableUI(false);

        for (int y = 0; y < displaySize; y++)
        {
            FractalWorker worker = new FractalWorker(y);
            worker.execute();
        }

        image.repaint();

    }
    public static void main(String[] args)
    {
        FractalExplorer explorer = new FractalExplorer(600);
        explorer.createAndShowGUI();
        explorer.drawFractal();
    }
}
