package com.example.paint.interactors.morphing;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class MorphToCircle extends MorphTo {
    @Override
    public void morph(Shape shape) {
        Circle clipShape = new Circle();

        KeyFrame firstFrame = new KeyFrame(Duration.seconds(3));
        KeyValue keyValue = null;

        if (shape instanceof Rectangle myRectangle) {
            double size = (Math.min(myRectangle.getWidth(), myRectangle.getHeight()) / 2);
            clipShape.setRadius(size * 2);
            myRectangle.setClip(clipShape);
            double offsetX = clipShape.getRadius() - myRectangle.getWidth() / 2;
            double offsetY = clipShape.getRadius() - myRectangle.getHeight() / 2;
            clipShape.relocate(-offsetX, -offsetY);
            keyValue = new KeyValue(clipShape.radiusProperty(), size);
        } else if (shape instanceof Ellipse ellipse) {
            double maxSize = Math.max(ellipse.getRadiusX(), ellipse.getRadiusY());
            double minSize = Math.min(ellipse.getRadiusX(), ellipse.getRadiusY());
            clipShape.setRadius(maxSize);
            ellipse.setClip(clipShape);
            double offsetX = ellipse.getCenterX() - clipShape.getRadius();
            double offsetY = ellipse.getCenterY() - ellipse.getRadiusY();
            clipShape.relocate(offsetX, offsetY);
            keyValue = new KeyValue(clipShape.radiusProperty(), minSize);
        } else if (shape instanceof Line line) {
            double maxSize = Math.max(Math.abs(line.getEndX() - line.getStartX()), Math.abs(line.getEndY() - line.getStartY()));
            double minSize = Math.max(Math.abs(line.getEndX() - line.getStartX()), Math.abs(line.getEndY() - line.getStartY()));
            clipShape.setRadius(maxSize);
            clipShape.relocate(0, 0);
            line.setClip(clipShape);
            keyValue = new KeyValue(line.strokeWidthProperty(), clipShape.getRadius() * 2.5);
        }

        if (keyValue != null) {
            firstFrame = new KeyFrame(
                    Duration.seconds(3),
                    keyValue
            );
        }
        Timeline animation = new Timeline(firstFrame);

        animation.playFromStart();
    }
}
