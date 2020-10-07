//Clare DuVal and Jonathan Ayala
//CPSC 2151 Sec 002
//Lab 6

package cpsc2150.MyQueue;

import java.util.*;

/**
 * Correspondence: this = myQ. The front of myQ is the front of the Queue
 * Correspondence: size = myQ.size();
 *
 * @invariant: 0 <= depth <= MAX_DEPTH
 */
public class ListQueueImp<T> implements IQueue<T> {
    private List<T> myQ;
    //complete the class

    /**
     * @return returns a Arraylist myQ
     * @post [returns a new ArrayList myQ comprised of spaces for generic data type T]
     */
    public ListQueueImp()
    {
        myQ = new ArrayList<T>();
    }

    public void add(T x)
    {
        // this add function is from the List library
        myQ.add(myQ.size(),x);
    }

    public T pop()
    {
        T x = myQ.get(0);
        myQ.remove(myQ.get(0));
        return x;
    }

    public int size()
    {
        return myQ.size();
    }

    @Override
    public String toString() {
        String ret = "";

        for (int i = 0; i < size(); i++) {
            ret += myQ.get(i) + "\n";
        }

        return ret;
    }
}

