package design_pattern.momento;

import java.util.Stack;

public class CareTaker {

    private final Stack<EditorMemento> history = new Stack<>();

    public void saveState(TextEditor textEditor){
        history.push(textEditor.save());
    }

    public void undo(TextEditor textEditor){
        if(!history.empty()){
            history.pop();
            textEditor.restore(history.peek());
        }
    }
}
