package com.example.paint.interactors.actions;

import com.example.paint.interactors.states.EditorStateSingleton;
import com.example.paint.interactors.states.StateType;

public class SetDragStatusAction {
    public static void run(boolean status) {
        EditorStateSingleton editorState = EditorStateSingleton.getInstance();

        editorState.setStateType(status ? StateType.DRAG_AND_DROP : StateType.DRAWING);
    }
}
