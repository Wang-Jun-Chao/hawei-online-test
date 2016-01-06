import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-05 14:49
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        Map<Key, List<String>> map = new HashMap<>();

        while (scanner.hasNext()) {
            map.clear();
            int n = scanner.nextInt();
            // 构造一个字典
            while ((--n) >= 0) {
                String s = scanner.next();
                Key k = new Key(s);
                if (map.containsKey(k)) {
                    map.get(k).add(s);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    map.put(k, list);
                }
            }

            //
            String s = scanner.next();
            // s的第i个兄弟节点
            int i = scanner.nextInt();

            Key k = new Key(s);

            List<String> list = map.get(k);

            if (list != null) {
                Collections.sort(list);
                // 删除s
                while (list.contains(s)) {
                    list.remove(s);
                }

                System.out.println(list.size());

                int cnt = 0;
                Iterator<String> itr = list.iterator();
                String t = "";
                while (cnt < i && itr.hasNext()) {
                    t = itr.next();

                    if (!t.equals(s)) {
                        cnt++;
                        if (cnt == i) {
                            System.out.println(t);
                        }
                    }
                }
            }else {
                System.out.println(0);
            }
        }

        scanner.close();
    }

    private static class Key {
        private String s;
        private String t;
        private int hashCode;

        public Key(String s) {
            this.s = s;

            if (s == null) {
                hashCode = 0;
            } else {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                t = new String(chars);
                hashCode = t.hashCode();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            return t != null ? t.equals(key.t) : key.t == null;

        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }
}
