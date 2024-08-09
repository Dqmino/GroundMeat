package codes.domino.gui;

import codes.domino.automator.ClickPerformer;
import codes.domino.recorder.ClickRecorder;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends javax.swing.JFrame {
    private static MainMenu mainMenu;
    private int lastId;
    // Variables declaration - do not modify
    private javax.swing.JButton startRecButton;
    private javax.swing.JButton stopRecButton;
    private javax.swing.JButton startClickingButton;
    private javax.swing.JButton stopClickingButton;
    private javax.swing.JLabel lastIdText;
    private javax.swing.JLabel selectedRecordingText;
    private javax.swing.JLabel clickHereText;
    private javax.swing.JPanel starterPanel;
    private javax.swing.JPanel clickRecordingArena;
    private javax.swing.JScrollPane lastRecordingPanel;
    private JComboBox<Integer> selectedRecordingOptions;
    private javax.swing.JTextPane lastRecording;

    private MainMenu() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static MainMenu getInstance() {
        if (mainMenu == null) {
            mainMenu = new MainMenu();
        }
        return mainMenu;
    }

    private void initComponents() {

        starterPanel = new javax.swing.JPanel();
        startRecButton = new javax.swing.JButton();
        stopRecButton = new javax.swing.JButton();
        startClickingButton = new javax.swing.JButton();
        stopClickingButton = new javax.swing.JButton();
        stopClickingButton.setEnabled(false);
        selectedRecordingOptions = new javax.swing.JComboBox<>();
        selectedRecordingOptions.setFocusable(false);
        selectedRecordingOptions.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        lastRecordingPanel = new javax.swing.JScrollPane();
        lastRecording = new javax.swing.JTextPane();
        lastRecording.setFocusable(false);
        lastIdText = new javax.swing.JLabel();
        selectedRecordingText = new javax.swing.JLabel();
        clickRecordingArena = new javax.swing.JPanel();
        clickHereText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        starterPanel.setDoubleBuffered(false);

        startRecButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        startRecButton.setText("Start Recording");
        startRecButton.addActionListener(this::startRecordClickEvent);
        startRecButton.setFocusable(false);

        stopRecButton.setFont(new java.awt.Font("Yu Gothic UI", Font.PLAIN, 18)); // NOI18N
        stopRecButton.setText("Stop Recording");
        stopRecButton.addActionListener(this::stopRecordClickEvent);
        stopRecButton.setFocusable(false);

        startClickingButton.setFont(new java.awt.Font("Yu Gothic UI", Font.PLAIN, 18)); // NOI18N
        startClickingButton.setText("Start Clicking (F6)");
        startClickingButton.addActionListener(this::startClickingClickEvent);
        startClickingButton.setFocusable(false);

        stopClickingButton.setFont(new java.awt.Font("Yu Gothic UI", Font.PLAIN, 18)); // NOI18N
        stopClickingButton.setText("Stop Clicking (F6)");
        stopClickingButton.addActionListener(this::stopClickingButtonEventListener);
        stopClickingButton.setFocusable(false);

        lastRecording.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        lastRecording.setEditable(false);
        lastRecordingPanel.setViewportView(lastRecording);

        lastIdText.setText("Last recording ID:");
        lastIdText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        selectedRecordingText.setText("Selected Recoding:");
        selectedRecordingText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        clickHereText.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 36)); // NOI18N
        clickHereText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clickHereText.setText("Click Here");

        javax.swing.GroupLayout clickRecordingArenaLayout = new javax.swing.GroupLayout(clickRecordingArena);
        clickRecordingArena.setLayout(clickRecordingArenaLayout);
        clickRecordingArenaLayout.setHorizontalGroup(
                clickRecordingArenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(clickRecordingArenaLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(clickHereText, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clickRecordingArenaLayout.setVerticalGroup(
                clickRecordingArenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clickRecordingArenaLayout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addComponent(clickHereText, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout starterPanelLayout = new javax.swing.GroupLayout(starterPanel);
        starterPanel.setLayout(starterPanelLayout);
        starterPanelLayout.setHorizontalGroup(
                starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(starterPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(starterPanelLayout.createSequentialGroup()
                                                .addComponent(clickRecordingArena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(starterPanelLayout.createSequentialGroup()
                                                .addGroup(starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startRecButton)
                                                        .addComponent(stopRecButton)
                                                        .addComponent(lastIdText)
                                                        .addComponent(lastRecordingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                .addGroup(starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(startClickingButton)
                                                                .addComponent(stopClickingButton)
                                                                .addComponent(selectedRecordingOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(starterPanelLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(selectedRecordingText)))
                                                .addGap(13, 13, 13))))
        );
        starterPanelLayout.setVerticalGroup(
                starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(starterPanelLayout.createSequentialGroup()
                                .addGroup(starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startClickingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startRecButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(stopRecButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stopClickingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(starterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(starterPanelLayout.createSequentialGroup()
                                                .addComponent(lastIdText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lastRecordingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(starterPanelLayout.createSequentialGroup()
                                                .addComponent(selectedRecordingText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(selectedRecordingOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                                .addComponent(clickRecordingArena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        lastIdText.getAccessibleContext().setAccessibleDescription("");
        clickRecordingArena.getAccessibleContext().setAccessibleName("clickArea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(starterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(starterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void startRecordClickEvent(java.awt.event.ActionEvent evt) {
        lastId = ClickRecorder.getInstance().startRecording(clickRecordingArena);
        lastRecording.setText(String.valueOf(lastId));
        selectedRecordingOptions.addItem(lastId);
        selectedRecordingOptions.setEditable(false);
        startClickingButton.setEnabled(false);
        stopClickingButton.setEnabled(false);
        startRecButton.setEnabled(false);
    }

    private void stopRecordClickEvent(java.awt.event.ActionEvent evt) {
        ClickRecorder.getInstance().stopRecording(lastId).clickQueue();
        startClickingButton.setEnabled(true);
        stopRecButton.setEnabled(false);
        startRecButton.setEnabled(true);
        selectedRecordingOptions.setEditable(true);
    }

    private void startClickingClickEvent(java.awt.event.ActionEvent evt) {
        startClicking();
        startRecButton.setEnabled(false);
        stopRecButton.setEnabled(false);
    }

    private void stopClickingButtonEventListener(java.awt.event.ActionEvent evt) {
        stopClicking();
        startRecButton.setEnabled(true);
        stopRecButton.setEnabled(false);
    }

    private void startClicking() {
        if (selectedRecordingOptions.getSelectedItem() == null) {
            return;
        }
        try {
            ClickPerformer.getInstance().setShouldLoop(true);
            ClickPerformer.getInstance().onRepeat(ClickRecorder.getInstance().getRecording((Integer) selectedRecordingOptions.getSelectedItem()));
        } catch (InterruptedException | AWTException e) {
            throw new RuntimeException(e);
        }
        startClickingButton.setEnabled(false);
        stopClickingButton.setEnabled(true);
    }

    private void stopClicking() {
        ClickPerformer.getInstance().setShouldLoop(false);
        ClickPerformer.getInstance().setShouldClick(false);
        startClickingButton.setEnabled(true);
        stopClickingButton.setEnabled(false);
    }

    public void toggleClicking() {
        if (ClickPerformer.getInstance().shouldLoop()) {
            stopClicking();
        } else {
            startClicking();
        }
    }

    public void addRecording(int id) {
        this.selectedRecordingOptions.addItem(id);
    }

}
