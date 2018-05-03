/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.fractalgenerator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author cameronterry
 */
public class FractalGeneratorUI extends javax.swing.JFrame {

    /**
     * Creates new form FractalGeneratorUI
     */
    public FractalGeneratorUI() {
        // the transformed used: T(x, y) -> (x', y')
        // where x' = ax + by + d and y' = cx + ey + f
        this.NUM_PARAMS = 7;
        initComponents();
        
        displayX      = display.getX();
        displayY      = display.getY();
        displayWidth  = display.getWidth();
        displayHeight = display.getHeight();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        display = new javax.swing.JPanel();
        screen = new javax.swing.JLabel();
        userInterface = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        equationScrollPane = new javax.swing.JScrollPane();
        equationsList = new javax.swing.JList<>();
        transformationLabel = new javax.swing.JLabel();
        inputField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        randomEqnsButton = new javax.swing.JButton();
        pixelCountLabel = new javax.swing.JLabel();
        pixelCountField = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        transformationMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveImgMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RandomIFS Fractal Generator");
        setResizable(false);

        screen.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(160, 121, 66)));

        javax.swing.GroupLayout displayLayout = new javax.swing.GroupLayout(display);
        display.setLayout(displayLayout);
        displayLayout.setHorizontalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayLayout.createSequentialGroup()
                .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );
        displayLayout.setVerticalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        generateButton.setText("Run Random IFS");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        equationScrollPane.setViewportView(equationsList);

        transformationLabel.setText("Transformation:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        randomEqnsButton.setText("Random");
        randomEqnsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomEqnsButtonActionPerformed(evt);
            }
        });

        pixelCountLabel.setText("pixels");

        pixelCountField.setText("100000");

        javax.swing.GroupLayout userInterfaceLayout = new javax.swing.GroupLayout(userInterface);
        userInterface.setLayout(userInterfaceLayout);
        userInterfaceLayout.setHorizontalGroup(
            userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInterfaceLayout.createSequentialGroup()
                .addGroup(userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInterfaceLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userInterfaceLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(transformationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userInterfaceLayout.createSequentialGroup()
                        .addComponent(pixelCountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pixelCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(userInterfaceLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(equationScrollPane)
                            .addGroup(userInterfaceLayout.createSequentialGroup()
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(randomEqnsButton)))))
                .addGap(15, 15, 15))
        );
        userInterfaceLayout.setVerticalGroup(
            userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transformationLabel)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addGap(2, 2, 2)
                .addComponent(equationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(removeButton)
                    .addComponent(randomEqnsButton))
                .addGap(18, 18, 18)
                .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(userInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pixelCountLabel)
                    .addComponent(pixelCountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        generateButton.getAccessibleContext().setAccessibleName("");

        fileMenu.setText("File");

        transformationMenu.setText("Transformations...");

        loadMenuItem.setText("Load");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        transformationMenu.add(loadMenuItem);

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        transformationMenu.add(saveMenuItem);

        fileMenu.add(transformationMenu);

        saveImgMenuItem.setText("Save Image...");
        saveImgMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImgMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveImgMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userInterface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultListModel dim = new DefaultListModel();
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String eqn = inputField.getText();
        
        if (eqn.equals("")) {
            Toolkit.getDefaultToolkit().beep();
            inputField.requestFocusInWindow();
            inputField.selectAll();
            return;
        }
        
        int index = equationsList.getSelectedIndex();
        
        if (index == -1) {
            index = 0;
        } else {
            index++;
        }
        
        dim.add(index, eqn);
        equationsList.setModel(dim);
        
        inputField.requestFocusInWindow();
        inputField.setText("");
        
        equationsList.setSelectedIndex(index);
        equationsList.ensureIndexIsVisible(index);
        
        removeButton.setEnabled(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int index = equationsList.getSelectedIndex();
        dim.remove(index);
        
        int size = dim.getSize();
        
        if (size == 0) {
            removeButton.setEnabled(false);
        } else {
            if (index == dim.getSize()) {
                index--;
            }
            
            equationsList.setSelectedIndex(index);
            equationsList.ensureIndexIsVisible(index);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        generate();
    }//GEN-LAST:event_generateButtonActionPerformed

    // TODO: fix the parse functions method
    private void randomEqnsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomEqnsButtonActionPerformed
        dim.removeAllElements();
        equationsList.removeAll();
        
        Random r = new Random();
        int num_eqs = 2;
        
        float[][] gen_params = new float[num_eqs][NUM_PARAMS];
        gen_params[0] = new float[NUM_PARAMS];
        gen_params[1] = new float[NUM_PARAMS];
        
        for (float[] gen_param : gen_params) {
            for (int j = 0; j < NUM_PARAMS - 1; j++) {
                gen_param[j] = (float) (Math.round((r.nextFloat() * 2 - 1) * 100.0)/100.0);
            }
        }
        
        gen_params[0][NUM_PARAMS - 1] = (float) (Math.round(r.nextFloat() * 100.0)/100.0);
        gen_params[1][NUM_PARAMS - 1] = (float) (Math.round((1.0 - (double) gen_params[0][NUM_PARAMS - 1]) * 100.0)/100.0);
        
        
        String[] eqns = new String[num_eqs];
        
        int index = equationsList.getSelectedIndex();
        
        if (index == -1) {
            index = 0;
        } else {
            index++;
        }
        
        for (int k = 0; k < num_eqs; k++) {
            String a_to_str = Arrays.toString(gen_params[k]);
            String withoutBrackets = a_to_str.substring(1, a_to_str.length() - 1);
            eqns[k] = withoutBrackets.replaceAll(",","");
                         
            dim.add(index, eqns[k]);
            index++;
        }
        
        equationsList.setModel(dim);
        removeButton.setEnabled(true);
    }//GEN-LAST:event_randomEqnsButtonActionPerformed

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("IFS Files", "ifs");
        fc.setFileFilter(filter);
        
        int return_val = fc.showOpenDialog(null);
        if (return_val == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                StringBuffer sb;
                try (FileReader fr = new FileReader(file)) {
                    BufferedReader br = new BufferedReader(fr);
                    sb = new StringBuffer();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                        sb.append("\n");
                    }
                }
                
                String[] unscraped_eqns = sb.toString().split("\n");
                int index = equationsList.getSelectedIndex();

                if (index == -1) {
                    index = 0;
                } else {
                    index++;
                }

                for (int k = 0; k < unscraped_eqns.length; k++) {
                    String withoutBrackets = unscraped_eqns[k].substring(1, unscraped_eqns[k].length() - 1);
                    unscraped_eqns[k] = withoutBrackets.replaceAll(",", "");

                    dim.add(index, unscraped_eqns[k]);
                    index++;
                }

                equationsList.setModel(dim);
                removeButton.setEnabled(true);
            } catch (IOException e) {
            }
        }
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("IFS Files", "ifs");
        fc.setFileFilter(filter);
        
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            
            try {
                try (FileWriter fw = new FileWriter(file.getAbsoluteFile())) {
                    ListModel model = equationsList.getModel();
                    String[] eqns = new String[model.getSize()];
                    
                    for (int i = 0; i < model.getSize(); i++) {
                        eqns[i] = (String) model.getElementAt(i);
                    }
                    
                    float[][] coeffs;
                    coeffs = parseFunctions(eqns);
                    
                    for (int i = 0; i < model.getSize(); i++) {
                        fw.write(Arrays.toString(coeffs[i]));
                        fw.write(System.lineSeparator());
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(FractalGeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveImgMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImgMenuItemActionPerformed
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Files", "png");
        fc.setFileFilter(filter);
        
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File output_file = fc.getSelectedFile();
            
            Image pic = icon.getImage();

            BufferedImage bi = new BufferedImage(pic.getWidth(null), pic.getHeight(null), BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = bi.createGraphics();
            g2d.drawImage(img, 0, 0, null);
            g2d.dispose();
            try {
                ImageIO.write(bi, "png", output_file);
            } catch (IOException ex) {
                Logger.getLogger(FractalGeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_saveImgMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FractalGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FractalGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FractalGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FractalGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FractalGeneratorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel display;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane equationScrollPane;
    private javax.swing.JList<String> equationsList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton generateButton;
    private javax.swing.JTextField inputField;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField pixelCountField;
    private javax.swing.JLabel pixelCountLabel;
    private javax.swing.JButton randomEqnsButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JMenuItem saveImgMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel screen;
    private javax.swing.JLabel transformationLabel;
    private javax.swing.JMenu transformationMenu;
    private javax.swing.JPanel userInterface;
    // End of variables declaration//GEN-END:variables

    private float[][] parseFunctions(String[] eqns) {

        float[][] coeffs = new float[eqns.length][NUM_PARAMS];
        
        for (int i = 0; i < eqns.length; i++) {
            List<String> params = Arrays.asList(eqns[i].split(" "));
            
            if (params.size() != NUM_PARAMS) {
                throw new java.lang.RuntimeException("parameters expected: " + NUM_PARAMS + ", parameters recieved: " + params.size());
            }
            
            int p_size = params.size();
            
            for (int j = 0; j < p_size; j++) {
                try {
                    float k = Float.parseFloat(params.get(j));
                    coeffs[i][j] = k;
                } catch (NumberFormatException ex) {
                    System.out.println("An error occured: " + ex);
                }
            }
        }
        return coeffs;
    }

    private void randomIFSTransform(float[][] coeffs, int pixels) {
        
        float[][] outputs = new float[pixels][DIMENSIONS];
        int[][] scaled_outputs = new int[pixels][DIMENSIONS];
        
        RandomIFS set = new RandomIFS(coeffs);
        
        outputs[0] = set.transform(new float[]{1.0f, 1.0f});
        
        for (int p = 1; p < pixels; p++) {
            outputs[p] = set.transform(outputs[p - 1]);
        }
        
        xmin = ymin = Float.MAX_VALUE;
        xmax = ymax = -1;
     
        for (int i = 0; i < pixels; i++) {
            if (outputs[i][0] > xmax) {
                xmax = outputs[i][0];
            }
            if (outputs[i][0] < xmin) {
                xmin = outputs[i][0];
            }
            if (outputs[i][1] > ymax) {
                ymax = outputs[i][1];
            }
            if (outputs[i][1] < ymin) {
                ymin = outputs[i][0];
            }

            // scale to screen coords
            scaled_outputs[i] = to_scale(outputs[i]);
        }
        
//        for (float[] output : scaled_outputs) {
//            System.out.println("(" + output[0] + ", " + output[1] + ")");
//        }

        buildImage(scaled_outputs);
    }

    private int[] to_scale(float[] values) {
        int[] t_values = new int[DIMENSIONS];

        t_values[0] = (int) ((displayX + displayWidth) / (xmax - xmin) * (values[0] - xmin));
        t_values[1] = (int) (-(displayY + displayHeight) / (ymax - ymin) * (values[1] - ymax));

        return t_values;
    }
    
    private void generate() {
        ListModel model = equationsList.getModel();
        String[] eqns = new String[model.getSize()];
        
        for (int i = 0; i < model.getSize(); i++) {
            eqns[i] = (String) model.getElementAt(i);
        }
        
        float[][] coeffs;
        coeffs = parseFunctions(eqns);
        //System.out.println(Arrays.deepToString(coeffs));
        
        int pixels;
        
        try {
            pixels = Integer.parseInt(pixelCountField.getText());
            randomIFSTransform(coeffs, pixels);
            
            icon = new ImageIcon(img);
            screen.setIcon(icon); 
            
            

            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Could not resolve pixel count");
        }
    }
    
    // TODO: make img_width and img_height constant
    private void buildImage(int[][] scaled_outputs) {
        
        int img_width = displayX + displayWidth;
        int img_height = displayY + displayHeight - 10;
        
        img = new BufferedImage(img_width, 
                                img_height,
                                BufferedImage.TYPE_INT_RGB);
        
        g2 = (Graphics2D) img.getGraphics();
        g2.setColor(new Color(227, 229, 232));
        g2.fillRect(0, 0, img_width, img_height);
        g2.setColor(Color.BLACK);
        
        for (int[] pixel : scaled_outputs) {
            g2.fillRect(pixel[0], pixel[1], 1, 1);
        }
    }
    
    // transform is r2 -> r2
    private final int DIMENSIONS = 2;
    private final int NUM_PARAMS;
    private float xmin, xmax, ymin, ymax;
    private BufferedImage img;
    private Graphics2D g2;  
    private final int displayX;
    private final int displayY;
    private final int displayWidth;
    private final int displayHeight;
    private ImageIcon icon;
    
}
