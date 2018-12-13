package de.oliverpabst.algorithms;

/**
 * TODO: Von T auf KeyValuePair-Paare umstellen
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>>  {

    private ArrayDeque<T> sortedSequence;

    public MergeSort(ArrayList<T> _unsortedSequence) {

        sortedSequence = sort(new ArrayDeque<>(_unsortedSequence));
    }

    public ArrayDeque<T> getSortedSequence() {
        return sortedSequence;
    }

    public ArrayList<T> getSortedSequenceAsArrayList() {
        return new ArrayList(sortedSequence);
    }

    private ArrayDeque<T> sort(ArrayDeque<T> _unsortedSequence) {
        ArrayDeque<T> sortedSequence = new ArrayDeque<>();

        int n = _unsortedSequence.size();

        if(n >= 2) {
            ArrayDeque<T> leftSeq = new ArrayDeque<>();

            for(int i = 0; i < n/2; i++) {
                leftSeq.addLast(_unsortedSequence.pollFirst());
            }

            ArrayDeque<T> rightSeq = new ArrayDeque<>();

            for(int j = n/2; j < n; j++) {
                rightSeq.addLast(_unsortedSequence.pollFirst());
            }

            leftSeq = sort(leftSeq);
            rightSeq = sort(rightSeq);

            sortedSequence = merge(leftSeq, rightSeq);

            return sortedSequence;
        } else {
            return _unsortedSequence;
        }
    }

    private ArrayDeque<T> merge(ArrayDeque<T> _leftSeq, ArrayDeque<T> _rightSeq) {
        ArrayDeque<T> sortedSequence = new ArrayDeque<>();

        while(!_leftSeq.isEmpty() && !_rightSeq.isEmpty()) {
            if(_leftSeq.getFirst().compareTo(_rightSeq.getFirst()) <= 0) {
                sortedSequence.addLast(_leftSeq.pollFirst());
            } else {
                sortedSequence.add(_rightSeq.pollFirst());
            }
        }

        while(!_rightSeq.isEmpty()) {
            sortedSequence.addLast(_rightSeq.pollFirst());
        }

        while(!_leftSeq.isEmpty()) {
            sortedSequence.add(_leftSeq.pollFirst());
        }

        return sortedSequence;
    }
}
