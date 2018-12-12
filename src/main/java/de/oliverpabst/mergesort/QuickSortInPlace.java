package de.oliverpabst.mergesort;

/**
 * TODO: Von T auf KeyValue umstellen
 */

import java.util.ArrayList;

public class QuickSortInPlace<T> {

    private ArrayList<T> sortedSequence;

    public QuickSortInPlace(ArrayList<T> unsortedSequence) {
        if(unsortedSequence.size() >= 2) {
            quickSort(unsortedSequence, 0, unsortedSequence.size()-1);
        }
    }

    public ArrayList<T> getSortedSequence() {
        return sortedSequence;
    }

    private void quickSort(ArrayList<T> unsortedSequence, Integer leftBound, Integer rightBound) {
        if(leftBound >= rightBound) {
            return;
        }

        T pivot = unsortedSequence.get(rightBound);

        Integer leftIndex = leftBound;
        Integer rightIndex = rightBound;

        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && unsortedSequence.get(leftIndex) <= pivot) {
                leftIndex++;
            }

            while (leftIndex <= rightIndex && unsortedSequence.get(rightIndex) >= pivot) {
                rightIndex++;
            }

            // Vertauschen und Indexe weiterschieben falls grüßer oder kleiner als Pivot
            if(leftIndex < rightIndex) {
                unsortedSequence.swap(unsortedSequence.get(leftIndex), unsortedSequence.get(rightIndex));
                leftIndex++;
                rightIndex++;
            }
        }

        // Pivot vertauschen mit Schlüssel auf leftIndex
        unsortedSequence.swap(unsortedSequence.get(leftIndex), unsortedSequence.get(rightBound));

        // rekursiv fortfahren
        quicksort(unsortedSequence, leftBound, leftIndex-1);
        quicksort(unsortedSequence, leftIndex+1, rightBound);

        sortedSequence = unsortedSequence;
    }
}
