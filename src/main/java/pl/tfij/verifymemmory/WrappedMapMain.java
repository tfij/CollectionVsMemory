package pl.tfij.verifymemmory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static pl.tfij.verifymemmory.Util.LONG_STRING;
import static pl.tfij.verifymemmory.Util.printMemory;

public class WrappedMapMain {

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

    private static class A {
        private final String value;

        private A(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return Objects.equals(value, a.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    private static class B {
        private final String value;

        private B(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            B b = (B) o;
            return Objects.equals(value, b.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    private static class C {
        private final String value;

        private C(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            C c = (C) o;
            return Objects.equals(value, c.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }


}
