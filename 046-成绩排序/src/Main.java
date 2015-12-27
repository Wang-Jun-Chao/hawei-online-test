import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-12-24 22:13
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();

            Student[] students = new Student[n];

            for (int i = 0; i < n; i++) {
                String name = scanner.next().trim();
                int score = scanner.nextInt();
                students[i] = new Student(name, score);
            }


            sort(t, students);

            StringBuilder builder = new StringBuilder();
            for (Student s : students) {
                builder.append(s.name).append(" ").append(s.score).append('\n');
            }

            System.out.print(builder.toString());
        }

        scanner.close();
    }

    private static void sort(int t, Main.Student[] students) {
        if (t == 1) {
            Arrays.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Main.Student s, Main.Student t) {
                    return s.score - t.score;
                }
            });
        } else if (t == 0) {
            Arrays.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Main.Student s, Main.Student t) {
                    return t.score - s.score;
                }
            });
        }
    }

    private static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
