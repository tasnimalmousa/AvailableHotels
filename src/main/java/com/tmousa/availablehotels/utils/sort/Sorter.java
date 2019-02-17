package com.tmousa.availablehotels.utils.sort;

import java.util.List;

/**
 * The Sorter Interface
 * A Generic interface for list of objects sorting
 *
 * @author  tmousa
 */
public interface Sorter<T extends Object> {
    /**
     * sort
     * This method sorts a List of objects
     *
     * @param objects List of objects to be sorted
     *
     * @return List of sorted objects
     */
    List<T> sort(List<T> objects);
}
