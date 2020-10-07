//Clare DuVal
//CPSC 2151 Sec 002
//Lab 5

package cpsc2150.MyQueue;

import java.util.*;

    /**
     * Correspondence: this = myQ. The front of myQ is the front of the Queue
     * Correspondence: size = myQ.size();
     *
     * @invariant: 0 <= depth <= MAX_DEPTH
     */
    public class ListQueueImp implements IntegerQueueI {
        private List<Integer> myQ;
        //complete the class

        /**
         * @return returns a Arraylist myQ
         * @post [returns a new ArrayList myQ comprised of spaces for Integers]
         */
        public ListQueueImp()
        {
            myQ = new ArrayList<Integer>();
        }

        public void add(Integer x)
        {
            // this add function is from the List library
            myQ.add(myQ.size(),x);
        }

        public Integer pop()
        {
            Integer x = myQ.get(0);
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

