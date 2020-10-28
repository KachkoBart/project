package test.GetContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ContentImpl implements Content{
    @Override
    public String getPage(String name) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(name).getFile());
        FileInputStream inputStream = new FileInputStream(file);
        byte[] obj = inputStream.readAllBytes();
        return new String(obj, StandardCharsets.UTF_8);
    }
}
