package map;

import util.Printer;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    Map<String, String> languages = new HashMap<>();
    Map<String, String> realLanguages = new HashMap<>();

    public void run() {
        testPutMethod();
        Printer.printSeparator();
        testPutIfAbsent();
        Printer.printSeparator();
        loopThroughTheKeys(languages);
    }

    private void testPutMethod() {
        if (languages.containsKey("JAVA")) {
            System.out.println("JAVA is already exists!");
        } else {
            languages.put("JAVA", "a compiled high level, object-oriented, platform independent language");
            System.out.println("JAVA added successfully!");
        }

        languages.put("Python", "an interpreted, object-oriented, high-level programming language, with dynamic semantics");
        // languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("Algol", "an algorithmic language")); // <- result null, as it was not added first!
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("JAVA"));

        // as key is unique, this overwrites the value in map!
        languages.put("JAVA", "this course is about JAVA");
        System.out.println(languages.get("JAVA"));

        if (languages.containsKey("Python")) {
            System.out.println("Python is already exists as a key value in map!");
        } else {
            languages.put("Python", "this course not is about Python");
        }

        System.out.println(languages.get("Python"));

        // languages.remove("Lisp"); // the whole key-entry will be removed, also the values that contained by the key!

        if (languages.remove("BASIC", "Beginners Code")) {
            System.out.println("BASIC removed!");
        } else {
            System.out.println("BASIC is not removed! Key/value pair not found!");
        }

        System.out.println(languages.replace("Lips", "a functional programming language with imperative features"));
        System.out.println(languages.replace("Scala", "this will not be added!"));

        /*if (languages.replace("Lips", "Therein lies madness", "new value for Lips key entry!")) {
            System.out.println("Lips replaced");
            } else {
            System.out.println("Lips was not replaced");
        }*/
    }

    private void loopThroughTheKeys(Map<String, String> map) {
        for (String key: languages.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    private void testPutIfAbsent() {
        // PutIfAbsent is going to add only if the key is not already present in map!
        realLanguages.putIfAbsent("English", "USA");
        realLanguages.putIfAbsent("English", "UK");

        System.out.println(realLanguages.get("English")); // <- output: only USA!
    }
}
