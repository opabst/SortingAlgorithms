package de.oliverpabst.algorithms;

import de.oliverpabst.model.KeyValuePair;
import java.util.ArrayList;

public class QuickSortInPlace {

    private ArrayList<KeyValuePair> sortedSequence;

    public QuickSortInPlace(ArrayList<KeyValuePair> unsortedSequence) {
        if(unsortedSequence.size() >= 2) {
            quickSort(unsortedSequence, 0, unsortedSequence.size()-1);
        }
    }

    public ArrayList<KeyValuePair> getSortedSequence() {
        return sortedSequence;
    }

    private void quickSort(ArrayList<KeyValuePair> unsortedSequence, Integer leftBound, Integer rightBound) {
        if(leftBound >= rightBound) {
            return;
        }

        Integer pivot = unsortedSequence.get(rightBound).getKey();

        Integer leftIndex = leftBound;
        Integer rightIndex = rightBound;

        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && unsortedSequence.get(leftIndex).getKey() <= pivot) {
                leftIndex++;
            }

            while (leftIndex <= rightIndex && unsortedSequence.get(rightIndex).getKey() >= pivot) {
                rightIndex++;
            }

            // Vertauschen und Indexe weiterschieben falls grüßer oder kleiner als Pivot
            if(leftIndex < rightIndex) {
                KeyValuePair temp = unsortedSequence.get(leftIndex);
                unsortedSequence.set(leftIndex, unsortedSequence.get(rightIndex));
                unsortedSequence.set(rightIndex, temp);
                leftIndex++;
                rightIndex++;
            }
        }

        // Pivot vertauschen mit Schlüssel auf leftIndex
        KeyValuePair temp = unsortedSequence.get(leftIndex);
        unsortedSequence.set(leftIndex, unsortedSequence.get(rightBound));
        unsortedSequence.set(rightBound, temp);

        // rekursiv fortfahren
        quickSort(unsortedSequence, leftBound, leftIndex-1);
        quickSort(unsortedSequence, leftIndex+1, rightBound);

        sortedSequence = unsortedSequence;
    }
}
