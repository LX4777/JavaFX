package com.example.paint.interactors.actions;

import javafx.application.Platform;

public class ExitAppAction {
    public static void run () {
        Platform.exit();
    }
}
