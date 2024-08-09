package codes.domino;

import codes.domino.gui.MainMenu;
import codes.domino.recorder.ClickRecorder;
import codes.domino.serializer.ClickRecordsSerializer;
import com.formdev.flatlaf.FlatDarkLaf;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.io.IOException;

public class GroundMeatMain {

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        MainMenu mainMenu = MainMenu.getInstance();

        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
                @Override
                public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
                    if (nativeEvent.getKeyCode() != NativeKeyEvent.VC_F6) return;
                    mainMenu.toggleClicking();
                }
            });
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        ClickRecorder.getInstance();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                ClickRecordsSerializer.getInstance().save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));

    }
}