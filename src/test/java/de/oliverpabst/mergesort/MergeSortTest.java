package de.oliverpabst.mergesort;

import de.oliverpabst.algorithms.MergeSort;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MergeSortTest {

    public ArrayList<Integer> getResult() {
        ArrayList<Integer> ref = new ArrayList<>();
        ref.add(1);
        ref.add(2);
        ref.add(5);
        ref.add(7);
        ref.add(10);
        ref.add(15);
        ref.add(16);
        ref.add(17);

        return ref;
    }

    public ArrayList<Integer> getTestList() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(10);
        test.add(7);
        test.add(17);
        test.add(16);
        test.add(5);
        test.add(15);
        test.add(2);

        return test;
    }

    @Test
    public void testMergeSort() {
        MergeSort<Integer> ms = new MergeSort(getTestList());

        ArrayList<Integer> sortResult = ms.getSortedSequenceAsArrayList();
        ArrayList<Integer> refList = getResult();

        for(int i = 0; i < sortResult.size(); i++) {
            assertEquals(sortResult.get(i), refList.get(i));
        }
        assertEquals(sortResult.size(), refList.size());
    }
}