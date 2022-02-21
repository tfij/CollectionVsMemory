package pl.tfij.verifymemmory;

public class Util {

    public final static String LONG_STRING = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
            Quisque bibendum viverra tortor a mattis. 
            Pellentesque ornare lacus non nulla malesuada, maximus sollicitudin erat mattis. 
            Integer sodales est sit amet neque condimentum feugiat. 
            Mauris condimentum odio et dolor porta, sit amet dignissim nunc feugiat.""";

    public static void printMemory() {
        System.gc();
        long memoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Current memory: " + memoryUsage / 1024 / 1024 + "MB");
    }
}
