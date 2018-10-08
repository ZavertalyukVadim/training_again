package com.service;

public interface WriteService {
    void writeToFile();

    void readFromFile();

    void readFromResource(String path);

    void writeToResource(String path);
}
