package baekjoon.yj.deque.p_10866;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10866
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = scanner.nextInt();
        scanner.nextLine();

        MyDeque<Integer> myDeque = MyDeque.newInstance();

        while (commandCount-- > 0) {
            String[] commandLine = scanner.nextLine().split(" ");
            String command = commandLine[0];
            Integer arg = commandLine.length > 1 ? Integer.parseInt(commandLine[1]) : null;

            printResult(myDeque, command, arg);
        }
    }

    private static void printResult(MyDeque<Integer> myDeque, String command, Integer arg) {
        try {
            switch (command) {
                case "push_back":
                    myDeque.pushBack(arg);
                    break;
                case "push_front":
                    myDeque.pushFront(arg);
                    break;
                case "pop_front":
                    System.out.println(myDeque.popFront());
                    break;
                case "pop_back":
                    System.out.println(myDeque.popBack());
                    break;
                case "size":
                    System.out.println(myDeque.size());
                    break;
                case "empty":
                    System.out.println(myDeque.empty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(myDeque.front());
                    break;
                case "back":
                    System.out.println(myDeque.back());
                    break;
            }
        } catch (EmptyMyDequeException e) {
            System.out.println(-1);
        }
    }
}

class MyDeque<E> {
    private List<E> elements;

    private MyDeque() {
        elements = new ArrayList<>();
    }

    public static <E> MyDeque<E> newInstance() {
        return new MyDeque<>();
    }

    public void pushFront(E e) {
        elements.add(0, e);
    }

    public void pushBack(E e) {
        elements.add(e);
    }

    public E popFront() {
        if (empty()) {
            throw new EmptyMyDequeException();
        }

        return elements.remove(0);
    }

    public E popBack() {
        if (empty()) {
            throw new EmptyMyDequeException();
        }

        return elements.remove(size() - 1);
    }

    public int size() {
        return this.elements.size();
    }

    public boolean empty() {
        return elements.isEmpty();
    }

    public E front() {
        if (empty()) {
            throw new EmptyMyDequeException();
        }

        return elements.get(0);
    }

    public E back() {
        if (empty()) {
            throw new EmptyMyDequeException();
        }

        return elements.get(size() - 1);
    }
}

class EmptyMyDequeException extends RuntimeException {
}
