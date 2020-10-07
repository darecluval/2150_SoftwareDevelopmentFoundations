//Clare DuVal and Jonathan Ayala
//CPSC 2151 Sec 002
//Lab 6

package cpsc2150.MyQueue;

/**
 * Correspondence: this = myQ[0...depth-1], myQ[0] is the front
 of the Queue
 * Correspondence: size = depth
 *
 * @invariant: 0 <= depth <= MAX_DEPTH
 */
public class ArrayQueueImp<T> implements IQueue<T> {
    private T[] myQ;
    private int depth;

    // constructor class makes the array empty

    /**
     * @return returns an array myQ with allocated size MAX_DEPTH
     * @post [returns an array myQ capable of storing MAX_DEPTH amount of generic data type T]
     */
    public ArrayQueueImp()
    {
        depth = 0;
        myQ = (T[]) new Object[MAX_DEPTH];
    }


    public void add(T x)
    {
        myQ[depth] = x;
        depth++;
    }

    public T pop()
    {
        T x = myQ[0];
        int i = 0;

        while (i <= depth) {
            myQ[i] = myQ[i+1];
            i++;
        }

        depth--;
        return x;
    }

    public int size()
    {
        int size = depth;
        return size;
    }

    @Override
    public String toString() {
        String ret = "";

        for (int i = 0; i < size(); i++) {
            ret += myQ[i] + "\n";
        }

        return ret;
    }

}

