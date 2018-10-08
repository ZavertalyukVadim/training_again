package com.service.impl;

import com.service.WriteService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Objects;

@Component
@Log4j2
public class WriteServiceImpl implements WriteService {
    private String DELIMITER = IOUtils.LINE_SEPARATOR;
    private String customString = "To be, or not to be. That is the question. ";

    @Override
    public void writeToFile() {
        Path path = Paths.get("src/main/resources/shakespeare.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
            writer.write(customString + DELIMITER);
        } catch (IOException ex) {
            log.error(ex.getStackTrace());
        }

    }

    @Override
    public void readFromFile() {
        Path path = Paths.get("src/main/resources/shakespeare.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String currentLine;
            System.out.println("first variant");
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
            Files.delete(path);
        } catch (IOException ex) {
            log.error(ex.getStackTrace());
        }
    }

    @Override
    public void writeToResource(String path) {
        URL resource = Thread.currentThread()
                .getContextClassLoader().getResource(path);
        try {
            FileUtils.writeLines(new File(Objects.requireNonNull(resource).getFile()),
                    Collections.singletonList(customString));
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
    }

    @Override
    public void readFromResource(String path) {
        try (InputStream stream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(path)
        ) {
            String stringFromFile = IOUtils.toString(stream, Charset.forName("UTF-8"));
            System.out.println("second variant");
            System.out.println(stringFromFile);
            Files.delete(Paths.get(Objects.requireNonNull(Thread.currentThread()
                    .getContextClassLoader().getResource(path)).getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can not read resource: " + path, e);
        }
    }
}
