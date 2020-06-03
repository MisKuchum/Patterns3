package ru.mikhail.katya.lab1.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Stack;

// Паттерн: Заместитель
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentProxy {

    private Document document;
    private final Stack<Document> documentPrevVersions;

    // Паттерн: Фабричный метод
    public static DocumentProxy of(@NonNull Document document) {
        return new DocumentProxy(
                document,
                new Stack<>() {{
                    add(document);
                }}
        );
    }

    public String getContent() {
        return document.getContent();
    }

    public String getName() {
        return document.getName();
    }

    public synchronized void setContent(String string) {
        new Thread(() -> documentPrevVersions.add(document.clone())).start();
        document.setContent(string);
    }

    public synchronized void setName(String string) {
        new Thread(() -> documentPrevVersions.add(document.clone())).start();
        document.setName(string);
    }

    public synchronized void undo() {
        document = documentPrevVersions.pop();
    }

    public Document getDocument() {
        return document;
    }

    @Override
    public String toString() {
        return document.toString();
    }
}
