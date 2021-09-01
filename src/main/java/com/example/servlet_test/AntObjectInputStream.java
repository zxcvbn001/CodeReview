package com.example.servlet_test;

import java.io.*;
import java.util.List;

public class AntObjectInputStream extends ObjectInputStream {
    public AntObjectInputStream(InputStream inputStream)
            throws IOException, IOException {
        super(inputStream);
    }

    /**
     * 只允许反序列化List class
     */
    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException,
            ClassNotFoundException {
        if (!desc.getName().equals(List.class.getName())) {
            throw new InvalidClassException(
                    "Unauthorized deserialization attempt",
                    desc.getName());
        }
        return super.resolveClass(desc);
    }
}