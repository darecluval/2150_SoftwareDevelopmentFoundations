//Clare DuVal and Jonathan Ayala
//CPSC 2151 Sec 002
//Lab 6

package cpsc2150.MyQueue;

import java.util.*;

public class StringQueueApp {

    private static Scanner in;

    private static void addToQueue(IQueue q) {

        System.out.println("What string to add to the Queue?");
        String x = in.next();
        q.add(x);
    }

    private static void getNext(IQueue q) {
        //If queue is empty, return error
        if (q.size() == 0) {
            System.out.println("Queue is empty!");
        }

        //Peek at the first postion
        else {
            System.out.println("Next string is: " + q.remove(0));
        }
    }

    private static void peekInQueue(IQueue q) {
        //If queue is empty, return error
        if (q.size() == 0) {
            System.out.println("Queue is empty!");
        }

        //Peek at the first postion
        else {
            System.out.println("Peek: " + q.peek());
        }
    }

    private static void peekAtEnd(IQueue q) {
        //If queue is empty, return error
        if (q.size() == 0) {
            System.out.println("Queue is empty!");
        }

        //Peek at the final position using endOfQueue()
        else {
            System.out.println("Peek at end: " + q.endOfQueue());
        }
    }

    private static void insertInQueue(IQueue q) {
        //Takes in what number to insert
        System.out.println("What string to add to the Queue?");
        String x = in.next();

        int pos = q.size() + 1;

        while (pos >= q.size()) {
            //Takes in what position to insert x in to
            System.out.println("What position to input in?");
            pos = in.nextInt();

            //If x is not a position in the queue return an error
            if (pos > (q.size()+1)) {
                System.out.println("Not a valid position in the Queue!");
                pos = q.size() + 1;
            } else {
                q.insert(x, pos);
                break;
            }
        }
    }

    private static void getFromQueue(IQueue q) {
        int pos = q.size() + 2;

        while (pos > (q.size()+1)) {
            //Takes in what number to get
            System.out.println("What position to get from the Queue?");
            pos = in.nextInt();

            //If x is not a position in the queue return an error
            if (pos > (q.size()+1)) {
                System.out.println("Not a valid position in the Queue!");
                pos = q.size() + 2;
            } else {
                System.out.println(q.get(pos-1) + " is at position " + pos + " in the Queue.");
                pos = q.size();
                break;
            }
        }
    }

    private static void removeFromQueue(IQueue q) {
        int pos = 0;

        while (pos < 1) {
            //Takes in what number to remove
            System.out.println("What position to get from the Queue?");
            pos = in.nextInt();

            //If x is not a position in the queue return an error
            if ((pos > q.size()) || (0 >= pos)) {
                System.out.println("Not a valid position in the Queue!");
                pos = 1;
            } else {
                System.out.println(q.remove(pos-1) + " was at position " + pos + " in the Queue.");
                break;
            }


        }
    }


    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.println("Enter 1 for array implementation or 2 for List implementation");
        int answer = in.nextInt();
        IQueue<String> q;
        if(answer == 1) {
            q = new ArrayQueueImp<>();
        } else {
            q = new ListQueueImp<>();
        }
        displayMenu();
        answer = in.nextInt();
        while(answer != 8)
        {
            if(answer == 1)
            {
                addToQueue(q);
            }
            else if(answer == 2)
            {
                getNext(q);
            }
            else if(answer == 3)
            {
                peekInQueue(q);
            }
            else if(answer == 4)
            {
                peekAtEnd(q);
            }
            else if(answer == 5)
            {
                insertInQueue(q);
            }
            else if(answer == 6)
            {
                getFromQueue(q);
            }
            else if(answer == 7)
            {
                removeFromQueue(q);
            }
            else {
                System.out.println("Not a valid option!"); }
            System.out.println("Queue is: ");
            System.out.println(q.toString());
            System.out.println(" ");
            displayMenu();
            answer = in.nextInt();
        }
    }
    private static void displayMenu() {
        System.out.println("Select an option: ");
        System.out.println("1. Add to the Queue");
        System.out.println("2. Get next string from the Queue");
        System.out.println("3. Peek at the front of the Queue");
        System.out.println("4. Peek at the end of the Queue");
        System.out.println("5. Insert in the Queue");
        System.out.println("6. Get a position in the Queue");
        System.out.println("7. Remove from a position in the Queue");
        System.out.println("8. Quit");
    }

}

