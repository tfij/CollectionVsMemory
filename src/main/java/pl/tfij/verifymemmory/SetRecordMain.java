package pl.tfij.verifymemmory;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static pl.tfij.verifymemmory.Util.LONG_STRING;
import static pl.tfij.verifymemmory.Util.printMemory;

public class SetRecordMain {

    public static void main(String[] args) {
        printMemory();
        Set<Key> set = new HashSet<>();
        for (int i=0; i<1000; i++) {
            for (int j=0; j< 1000; j++) {
                set.add(new Key(LONG_STRING + i, "sub" + (i*1000 + j), "v"+i*1000+j));
            }
        }
        printMemory();
        System.out.println("Collection size: " + set.size());
    }

    private record Key(String a, String b, String c) { }

}
