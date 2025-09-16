package design_pattern.momento;

public class Main {
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();
        CareTaker careTaker = new CareTaker();

        textEditor.write("A");
        careTaker.saveState(textEditor);
        textEditor.write("B");
        careTaker.saveState(textEditor);

        System.out.println(textEditor.getContent());
        careTaker.undo(textEditor);

        System.out.println(textEditor.getContent());
    }
}
