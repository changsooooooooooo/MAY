package ch3.justOneProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@FunctionalInterface
interface BufferedReaderProcessor{
    String process(BufferedReader b) throws IOException;
}

public class Type2 {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String twoLines = processFile((BufferedReader br) -> br.readLine()+br.readLine());
    }
}
