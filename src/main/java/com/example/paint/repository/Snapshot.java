package com.example.paint.repository;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;

public class Snapshot {
    public static void make(Canvas canvas) {
        try {
            Image snapshot = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("saves/save.png"));
        } catch (Exception e) {
            System.out.println("Не удалось сохранить: " + e.getMessage());
        }
    }
}
