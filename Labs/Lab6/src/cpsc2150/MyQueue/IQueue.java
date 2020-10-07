//Clare DuVal and Jonathan Ayala
//CPSC 2151 Sec 002
//Lab 6

package cpsc2150.MyQueue;

/**
 * A queue containing a generic data type T.
 * A queue is a data structure where the first item added to the
 structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 *
 * Initialization ensures the queue is empty
 * Defines: size : Z
 * Constraints: 0 <= size <= MAX_DEPTH
 */
public interface IQueue <T> {
    int MAX_DEPTH = 100;

    /**
     *
     * @param x an generic data type T that is added to the queue
     * @return adds an generic data type T x to the end of a queue
     *
     * @pre [ x is a valid generic data type T]
     * @post [ places generic data type T x into the end of the queue ]
     *
     */
    void add(T x);

    /**
     *
     * @return an generic data type T from the front of the queue
     *
     * @post [ the generic data type T returned was previously
     *         contained in the queue and the queue afterwards
     *         contains all except the generic data type T ]
     *
     */
    T pop();

    /**
     *
     * @return the number of generic data type T in the queue
     *
     * @post [the size returned is an generic data type T >= 0]
     *
     */
    int size();

    /**
     *
     * @return an generic data type T from the front of the queue, but does not remove it
     *
     * @post [the returned generic data type T is contained
     *        in the queue at the first position]
     *
     */
    default T peek() {
        T p, ret = null;

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
     * @return an generic data type T located at the end of the queue, but doe not remove it
     *
     * @post [the returned generic data type T is contained in
     *        the queue at the final position]
     *
     */
    default T endOfQueue() {
        T p, ret = null;

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
     * @param x is an generic data type T that will be added to the queue
     * @param pos is an generic data type T that represents where the generic data type T x will be added
     *
     * @return the queue now contains generic data type T x at position pos
     *
     * @pre [ generic data type T x is a valid generic data type T, and pos > 0 ]
     * @post the queue size grows by one and all the generic data type T
     *       after pos are shifted down one position
     *
     */
    default void insert(T x, int pos) {
        T temp;
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
     * @return the queue now contains 1 less element where the generic data type T in the queue was
     *
     * @pre [ queue is at least 1 element long, and pos > 0 ]
     * @post [ a returned generic data type T is a valid generic data type T,
     *         and the queue no longer contains the generic data type T ]
     *
     */
    default T remove(int pos) {
        T p, ret = null;

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
     * @returns an generic data type T at position pos without removing it from the queue
     *
     * @pre [ pos > 0 ]
     * @post [ a returned generic data type T is a valid generic data type T
     *         contained in the queue at position pos ]
     *
     */
    default T get(int pos) {
        T p, ret = null;

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

