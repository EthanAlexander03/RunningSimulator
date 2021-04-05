package Tester;

import GameCode.Updater;
import collections.LinkedList;
import io.Simulator;
import tools.Numbers;

/**
 * Tester.java - description
 *
 * @author Ethan Alexander
 * @since Mar. 17, 2021,10:49:11 a.m.
 */
public class Tester {

    /**
     * Default constructor, set class properties
     */
    public Tester() {

        Simulator.header("Testing internal assessment started................");
        final int MIN = 0;
        final int MAX = 10;
        final int LARGEST = 1000000;
        final int SMALLEST = MIN;

        Numbers numbers = new Numbers();
        int[] array = numbers.random(SMALLEST, LARGEST, MAX);
        Integer[] array2 = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = new Integer(array[i]);
        }
        Updater updater = new Updater();

        LinkedList<Integer> oldNumbers = new LinkedList<>();
        oldNumbers.fromArray(array2);

        System.out.println("Before: " + oldNumbers);

        Integer newNumber = numbers.random(SMALLEST, LARGEST);

        LinkedList<Integer> newNumbers = updater.add(oldNumbers, newNumber);

        System.out.println("Number " + newNumber);

        System.out.println("After: " + newNumbers);

        updater.output(newNumbers, newNumber);

        Simulator.header("Testing internal assessment complete...............");
    }
}
