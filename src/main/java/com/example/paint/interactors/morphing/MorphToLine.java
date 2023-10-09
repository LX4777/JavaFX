package com.example.paint.interactors.morphing;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class MorphToLine extends MorphTo {
    @Override
    public void morph(Shape shape) {
        Line clipShape = new Line();

        KeyFrame firstFrame = new KeyFrame(Duration.seconds(3));
        KeyValue keyValue = null;

        if (shape instanceof Rectangle myRectangle) {
            double size = Math.max(myRectangle.getWidth(), myRectangle.getHeight());
            clipShape.setStartX(0);
            clipShape.setStartY(0);
            clipShape.setEndX(myRectangle.getWidth());
            clipShape.setEndY(myRectangle.getHeight());
            clipShape.setStrokeWidth(size * 1.5);
            myRectangle.setClip(clipShape);
            keyValue = new KeyValue(clipShape.strokeWidthProperty(), 3);
        } else if (shape instanceof Ellipse ellipse) {
            double size = Math.max(ellipse.getRadiusX(), ellipse.getRadiusY()) * 2;
            clipShape.setStartX(ellipse.getCenterX() - ellipse.getRadiusX());
            clipShape.setStartY(ellipse.getCenterY() - ellipse.getRadiusY());
            clipShape.setEndX(ellipse.getCenterX() + ellipse.getRadiusX());
            clipShape.setEndY(ellipse.getCenterY() + ellipse.getRadiusY());
            clipShape.setStrokeWidth(size);
            ellipse.setClip(clipShape);
            keyValue = new KeyValue(clipShape.strokeWidthProperty(), 3);
        } else if (shape instanceof Circle circle) {
            double size = circle.getRadius() * 2;
            clipShape.setStartX(-circle.getRadius());
            clipShape.setStartY(-circle.getRadius());
            clipShape.setEndX(circle.getRadius() * 2);
            clipShape.setEndY(circle.getRadius() * 2);
            clipShape.setStrokeWidth(size);
            circle.setClip(clipShape);
            keyValue = new KeyValue(clipShape.strokeWidthProperty(), 3);
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
