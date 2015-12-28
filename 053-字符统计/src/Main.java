import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-12-27 14:41
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(count(input));
        }

        scanner.close();
    }

    private static String count(String s) {

        Set<Node> set = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node t, Node s) {

                if (t.v != s.v) {
                    return s.v - t.v;
                }

                return t.c - s.c;
            }
        });

        Map<Character, Node> map = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c ==' ') {
                if (map.containsKey(c)) {
                    map.get(c).v++;
                } else {
                    map.put(c, new Node(c, 1));
                }
            }
        }


        for (Node n : map.values()) {
            set.add(n);
        }

        StringBuilder builder = new StringBuilder(set.size());
        for (Node n : set) {
            builder.append(n.c);
        }

        return builder.toString();
    }

    private static class Node {
        private char c;
        private int v;

        public Node(char c, int v) {
            this.c = c;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return c == node.c;

        }

        @Override
        public int hashCode() {
            return (int) c;
        }
    }
}
