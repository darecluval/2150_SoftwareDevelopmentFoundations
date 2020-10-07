//Clare DuVal
//CPSC 2151 Sec 002
//Lab 5

package cpsc2150.MyQueue;

/**
 * A queue containing integers.
 * A queue is a data structure where the first item added to the
 structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 *
 * Initialization ensures the queue is empty
 * Defines: size : Z
 * Constraints: 0 <= size <= MAX_DEPTH
 */
public interface IntegerQueueI {
    int MAX_DEPTH = 100;

    /**
     *
     * @param x an integer that is added to the queue
     * @return adds an integer x to the end of a queue
     *
     * @pre [ x is a valid integer]
     * @post [ places Integer x into the end of the queue ]
     *
     */
    void add(Integer x);

    /**
     *
     * @return an Integer from the front of the queue
     *
     * @post [ the Integer returned was previously
     *         contained in the queue and the queue afterwards
     *         contains all except the Integer ]
     *
     */
    Integer pop();

    /**
     *
     * @return the number of Integers in the queue
     *
     * @post [the size returned is an integer >= 0]
     *
     */
    int size();

    /**
     *
     * @return an Integer from the front of the queue, but does not remove it
     *
     * @post [the returned Integer is contained
     *        in the queue at the first position]
     *
     */
    default Integer peek() {
        Integer p, ret = 47;

        for (int i = 0; i < size(); i++) {

            p = pop();

            if (i == 0) {
                ret = p;
            }

            add(p);
        }

        return ret;
    }

    /**
     *
     * @return an Integer located at the end of the queue, but doe not remove it
     *
     * @post [the returned Integer is contained in
     *        the queue at the final position]
     *
     */
    default Integer endOfQueue() {
        Integer p, ret = 47;

        for (int i = 0; i < size(); i++) {

            p = pop();

            if (i == size()) {
                ret = p;
            }

            add(p);
        }

        return ret;
    }

    /**
     *
     * @param x is an Integer that will be added to the queue
     * @param pos is an integer that represents where the Integer x will be added
     *
     * @return the queue now contains Integer x at position pos
     *
     * @pre [ Integer x is a valid integer, and pos > 0 ]
     * @post the queue size grows by one and all the Integers
     *       after pos are shifted down one position
     *
     */
    default void insert(Integer x, int pos) {
        Integer temp;
        int i;

        if (pos == (size()+1)) {
            add(x);
        } else {
            for (i = 0; i < size(); i++) {
                if (i == (pos-1)) {
                    add(x);
                } else {
                    temp = pop();
                    add(temp);
                }
            }
        }

    }

    /**
     *
     * @param pos is an integer that represents a position in the queue
     * @return the queue now contains 1 less element where the Integer in the queue was
     *
     * @pre [ queue is at least 1 element long, and pos > 0 ]
     * @post [ a returned Integer is a valid Integer,
     *         and the queue no longer contains the Integer ]
     *
     */
    default Integer remove(int pos) {
        Integer p, ret = 47;

        for(int i = 0; i <= size(); i++) {

            p = pop();
            if (i != pos) {
                add(p);
            } else {
                ret = p;
            }

        }
        return ret;

    }

    /**
     *
     * @param pos is an integer that represents a position in the queue
     * @returns an Integer at position pos without removing it from the queue
     *
     * @pre [ pos > 0 ]
     * @post [ a returned Integer is a valid Integer
     *         contained in the queue at position pos ]
     *
     */
    default Integer get(int pos) {
        Integer p, ret = 47;

        for (int i = 0; i < size(); i++) {

            p = pop();

            if (i == pos) {
                ret = p;
            }

            add(p);
        }

        return ret;
    }
}

