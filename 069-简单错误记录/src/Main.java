import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-12-28 21:46
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        Error[] errors = new Error[8];

        int idx = 0;
        while (scanner.hasNext()) {
            String name = scanner.next();
            int line = scanner.nextInt();
            int i = name.lastIndexOf("\\");
            if (i != -1) {
                name = name.substring(i + 1);
                if (name.length() > 16) {
                    name = name.substring(name.length() - 16);
                }
            }


            Error e = new Error(name, line, 1);

            Error err = contains(errors, e);

            // 如果不在list中
            if (err == null) {
                errors[idx % 8] =  e;
                idx++;
            }
            // list中已经有值了
            else {
                err.count++;
            }
        }

        scanner.close();


        for (Error e : errors) {
            System.out.println(e.name + " " + e.line + " " + e.count);
        }
    }

    private static Error contains(Error[] errors, Error e) {
        for (Error err : errors) {
            if (err != null && err.equals(e)) {
                return err;
            }
        }
        return null;
    }

    private static class Error {
        String name;
        int line;
        int count;

        public Error(String name, int line, int count) {
            this.name = name;
            this.line = line;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Error error = (Error) o;

            if (line != error.line) return false;
            return name != null ? name.equals(error.name) : error.name == null;
        }
    }
}
