package com.github.aistomin.mst;

import com.github.aistomin.mst.simple.SimpleTestConsole;
import com.github.aistomin.mst.tests.MajorScaleDegreesTest;
import com.github.aistomin.mst.tests.SimpleCMajorScaleTest;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aistomin on 2019-06-04.
 * <p>
 * Main class of the application.
 */
public final class Main {

    /**
     * The list of all the available tests.
     */
    private final static List<Test> TESTS = Arrays.asList(
        new MajorScaleDegreesTest(),
        new SimpleCMajorScaleTest()
    );

    /**
     * Main method of the application.
     *
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        System.out.println(
            "Please select one of the tests below(type the number in []): "
        );
        for (int i = 0; i < TESTS.size(); i++) {
            System.out.println(
                String.format("[%d] %s", i, TESTS.get(i).name())
            );
        }
        final Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            final String next = scanner.next();
            try {
                new SimpleTestConsole(
                    TESTS.get(Integer.parseInt(next))
                ).runTest();
                done = true;
            } catch (final Throwable error) {
                error.printStackTrace();
            }
        }
        System.out.println("Good bye!!! :)");
    }
}
