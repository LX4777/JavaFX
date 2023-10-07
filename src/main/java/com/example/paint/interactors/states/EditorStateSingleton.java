package com.example.paint.interactors.states;

public class EditorStateSingleton {
    private StateType stateType;

    private static EditorStateSingleton instance;

    private EditorStateSingleton() {
        this.stateType = StateType.DRAWING;
    }

    public static EditorStateSingleton getInstance() {
        if (instance == null) {
            instance = new EditorStateSingleton();
        }
        return instance;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    public StateType getStateType() {
        return stateType;
    }
}
