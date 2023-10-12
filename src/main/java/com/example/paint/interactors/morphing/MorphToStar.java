package com.example.paint.interactors.morphing;

import com.example.paint.interactors.creators.StarCreator;
import com.example.paint.interactors.shapes.Star;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class MorphToStar extends MorphTo {
    public void morph(Shape shape) {
        com.example.paint.interactors.shapes.Star starInfo = new Star();
        StarCreator starCreator = new StarCreator();

        KeyFrame frame = new KeyFrame(Duration.seconds(3));

        if (shape instanceof Circle circle) {
            circle.setRadius(circle.getRadius() / 3);
            starInfo.setPoints(0.0, 0, circle.getRadius() * 7, circle.getRadius() * 7);
            Polygon clipShape = starCreator.make(starInfo);

            clipShape.relocate(-starInfo.getWidth() / 2, -starInfo.getHeight() / 2);
            circle.setClip(clipShape);
            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(circle.radiusProperty(), circle.getRadius() * 7)
            );
        } else if (shape instanceof Ellipse ellipse) {
            ellipse.setRadiusX(ellipse.getRadiusX() / 3);
            ellipse.setRadiusY(ellipse.getRadiusY() / 3);

            double maxRadius = Math.max(ellipse.getRadiusX(), ellipse.getRadiusY());

            starInfo.setPoints(0.0, 0, maxRadius * 7, maxRadius * 7);
            Polygon clipShape = starCreator.make(starInfo);

            ellipse.setClip(clipShape);

            clipShape.relocate(ellipse.getCenterX() - starInfo.getWidth() / 2, ellipse.getCenterY() - starInfo.getHeight() / 2);
            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(ellipse.radiusXProperty(), ellipse.getRadiusX() * 7),
                    new KeyValue(ellipse.radiusYProperty(), ellipse.getRadiusY() * 7)
            );
        } else if (shape instanceof Rectangle rectangle) {
            rectangle.setHeight(rectangle.getHeight() / 5);
            rectangle.setWidth(rectangle.getWidth() / 5);
            double maxSize = Math.max(rectangle.getWidth(), rectangle.getHeight());

            starInfo.setPoints(0.0, 0, maxSize * 5, maxSize * 5);
            Polygon clipShape = starCreator.make(starInfo);

            rectangle.setClip(clipShape);
            clipShape.relocate(-(starInfo.getWidth() / 2 - rectangle.getWidth() / 2), -(starInfo.getHeight() / 2 - rectangle.getHeight()));
            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(rectangle.widthProperty(), rectangle.getWidth() * 7),
                    new KeyValue(rectangle.heightProperty(), rectangle.getHeight() * 7),
                    new KeyValue(rectangle.xProperty(), rectangle.getX()-maxSize*2),
                    new KeyValue(rectangle.yProperty(), rectangle.getY()-maxSize*2)
            );
        } else if (shape instanceof Line line) {
            double width = Math.abs(line.getEndX() - line.getStartX());
            double height = Math.abs(line.getEndY() - line.getStartY());
            double maxSize = Math.max(width, height);

            starInfo.setPoints(0.0, 0, maxSize, maxSize);
            Polygon clipShape = starCreator.make(starInfo);

            line.setClip(clipShape);
            clipShape.relocate(line.getStartX(), line.getStartY());
            frame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(line.strokeWidthProperty(), maxSize * 2)
            );
        }

        Timeline animation = new Timeline(frame);

        animation.playFromStart();
    }
}
