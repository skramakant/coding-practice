package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SnapShotArray {
    TreeMap<Integer, Integer>[] hrecords;
    int i = Integer.MAX_VALUE;
    int snapIndex;
    public SnapShotArray(int length) {
        hrecords = new TreeMap[length];
        for(int i = 0; i< length; i++) {
            hrecords[i] = new TreeMap<>();
            hrecords[i].put(0, 0);

        }
    }

    public void set(int index, int val) {
        hrecords[index].put(snapIndex, val);
    }

    public int snap() {
        snapIndex++;
        return snapIndex;
    }

    public int get(int index, int snap_id) {
        return hrecords[index].ceilingEntry(snap_id).getValue();
    }
}
