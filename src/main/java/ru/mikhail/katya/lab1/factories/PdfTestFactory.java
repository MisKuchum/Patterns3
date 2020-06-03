package ru.mikhail.katya.lab1.factories;

import org.springframework.stereotype.Component;
import ru.mikhail.katya.lab1.pojo.DocumentProxy;
import ru.mikhail.katya.lab1.pojo.Pdf;

@Component
public class PdfTestFactory implements DocumentFactory {

    public DocumentProxy getDocument() {
        return DocumentProxy.of(new Pdf("pdf-name", "pdf-content"));
    }

}
