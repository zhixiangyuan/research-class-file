package me.yuanzx.research.model;

import java.io.*;
import java.util.HashMap;

public class InstructionTable {

    private static HashMap<Integer, String> instructionMap;

    static {
        instructionMap = new HashMap<>();
        File file = new File("ins.txt");
        try (
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {

            String line;
            Integer ins = null;
            for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
                if (i % 2 == 0) {
                    ins = Integer.parseInt(line.substring(2, 4), 16);
                } else if (i % 2 == 1) {
                    instructionMap.put(ins, line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getInstruction(int bytecode) {
        return instructionMap.get(bytecode);
    }
}

