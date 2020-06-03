package ru.mikhail.katya.lab1;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mikhail.katya.lab1.factories.PdfTestFactory;
import ru.mikhail.katya.lab1.pojo.DocumentProxy;

import java.util.logging.Logger;

@RequiredArgsConstructor
@SpringBootApplication
public class Lab1Application implements CommandLineRunner {

	private final PdfTestFactory pdfTestFactory;
	private final Logger logger = Logger.getGlobal();

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final DocumentProxy document = pdfTestFactory.getDocument();

		logger.info(document.toString());

		document.setName("PDF");
		document.setContent("new content");

		logger.info(document.toString());

		document.undo();

		logger.info(document.toString());
	}
}
