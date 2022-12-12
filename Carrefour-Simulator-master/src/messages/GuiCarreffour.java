package messages;


import javax.swing.JFrame;

public class GuiCarreffour extends javax.swing.JFrame {

    public GuiCarreffour() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        Background = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setResizable(false);
        setPreferredSize(new java.awt.Dimension(1055, 730));
        getContentPane().setLayout(null);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cardfgdrfeghgfour.JPG"))); // NOI18N
        Background.setMinimumSize(new java.awt.Dimension(1100, 1100));
        Background.setPreferredSize(new java.awt.Dimension(1100, 1100));
       // jPanel1.add(Background);
        Background.setBounds(0, -160, 1040, 1000);
        setContentPane(Background);
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JLabel Background;

}
