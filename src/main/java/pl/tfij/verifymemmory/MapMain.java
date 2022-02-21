package pl.tfij.verifymemmory;

import java.util.HashMap;
import java.util.Map;

import static pl.tfij.verifymemmory.Util.LONG_STRING;
import static pl.tfij.verifymemmory.Util.printMemory;

public class MapMain {

    public static void main(String[] args) {
        printMemory();
        Map<String, Map<String, String>> map = new HashMap<>();
        for (int i=0; i<1000; i++) {
            Map<String, String> subMap = new HashMap<>();
            for (int j=0; j< 1000; j++) {
                subMap.put("sub" + (i*1000 + j), "v"+i*1000+j);
            }
            map.put(LONG_STRING + i, subMap);
        }
        printMemory();
        System.out.println("Collection size: " + map.entrySet().stream().mapToInt(it -> it.getValue().size()).sum());
    }

}
