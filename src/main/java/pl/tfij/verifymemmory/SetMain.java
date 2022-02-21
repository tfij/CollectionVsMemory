package pl.tfij.verifymemmory;

import java.util.*;

import static pl.tfij.verifymemmory.Util.LONG_STRING;
import static pl.tfij.verifymemmory.Util.printMemory;

public class SetMain {

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

    private static class Key {
        private final String a;
        private final String b;
        private final String c;

        public Key(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(a, key.a) && Objects.equals(b, key.b) && Objects.equals(c, key.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

}
