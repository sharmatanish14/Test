package design_pattern.momento;

public class TextEditor {

    private String content;

    public void write(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento peek) {
        content = peek.getContent();
    }
}
