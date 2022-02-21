package pl.tfij.verifymemmory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static pl.tfij.verifymemmory.Util.LONG_STRING;
import static pl.tfij.verifymemmory.Util.printMemory;

public class WrappedRecordsMapMain {

    public static void main(String[] args) {
        printMemory();
        Map<A, Map<B, C>> map = new HashMap<>();
        for (int i=0; i<1000; i++) {
            Map<B, C> subMap = new HashMap<>();
            for (int j=0; j< 1000; j++) {
                subMap.put(new B("sub" + (i*1000 + j)), new C("v"+i*1000+j));
            }
            map.put(new A(LONG_STRING + i), subMap);
        }
        printMemory();
        System.out.println("Collection size: " + map.entrySet().stream().mapToInt(it -> it.getValue().size()).sum());
    }

    private record A(String value) { }

    private record B(String value) { }

    private record C(String value) { }


}
