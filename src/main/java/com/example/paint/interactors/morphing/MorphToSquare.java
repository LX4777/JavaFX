package com.example.paint.interactors.morphing;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class MorphToSquare extends MorphTo {
    public void morph(Shape shape) {
        Rectangle clipShape = new Rectangle();

        KeyFrame frame = new KeyFrame(Duration.seconds(3));

        if (shape instanceof Circle circle) {
            clipShape.setWidth(circle.getRadius() * 2 + 10);
            clipShape.setHeight(circle.getRadius() * 2 + 10);
            clipShape.relocate(-circle.getRadius() - 5, -circle.getRadius() - 5);
            circle.setClip(clipShape);
            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(circle.radiusProperty(), circle.getRadius() * 2)
            );
        } else if (shape instanceof Ellipse ellipse) {
            double size = Math.max(ellipse.getRadiusX(), ellipse.getRadiusY());
            clipShape.setWidth(size * 2 + 10);
            clipShape.setHeight(size * 2 + 10);
            ellipse.setClip(clipShape);
            clipShape.relocate(ellipse.getCenterX() - clipShape.getWidth() / 2, ellipse.getCenterY() - clipShape.getHeight() / 2);

            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(ellipse.radiusXProperty(), clipShape.getWidth() + 10),
                    new KeyValue(ellipse.radiusYProperty(), clipShape.getHeight() + 10)
            );
        } else if (shape instanceof Rectangle rectangle) {
            double size = Math.max(rectangle.getWidth(), rectangle.getHeight());
            clipShape.setWidth(size);
            clipShape.setHeight(size);
            rectangle.setClip(clipShape);
            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(rectangle.widthProperty(), clipShape.getWidth()),
                    new KeyValue(rectangle.heightProperty(), clipShape.getHeight())
            );
        } else if (shape instanceof Line line) {
            double width = Math.abs(line.getEndX() - line.getStartX());
            double height = Math.abs(line.getEndY() - line.getStartY());
            double max = Math.max(width, height);
            clipShape.setWidth(max);
            clipShape.setHeight(max);
            line.setClip(clipShape);
            clipShape.relocate(line.getStartX(), line.getStartY());
            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(line.strokeWidthProperty(), clipShape.getWidth() * 2)
            );
        }


        Timeline animation = new Timeline(frame);

        animation.playFromStart();
    }
}
