package application1.lesson2;

public class Loops {

    /**
     * Implement sum of numbers up to "x". For example x = 3 results in 1+2+3 = 6.
     */
    public int sum(int x) {
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * Implement sum of even numbers up to "x".
     */
    public int sumEven(int x) {
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    /**
     * Find out after how many iterations of "x" reaches zero in case that:
     * <ul>
     *     <li>if x is even, divide by 2</li>
     *     <li>if x is odd, then x = 3*x + 1</li>
     * </ul>
     * For example for x=3, next iteration is 10 (3*3 + 1), then 5 (10 / 2).
     * For x=3 iterations leads to the sequence 3, 10, 5, 16, 4, 2, 1 -> method should return "6", since "x" reached value 1 after 6 iterations.
     */
    public long hailstoneProblem(int x) {
            int number = x;
            int steps = 0;
            while (number != 1) {
                if (number % 2 == 0) {
                    System.out.println(number + " is even, so I take half: " + number / 2);
                    number /= 2;
                } else {
                    System.out.println(number + " is odd, so I make 3n + 1: " + (number * 3 + 1));
                    number = number * 3 + 1;
                }
                steps++;
            }
            System.out.println("The process took " + steps + (steps < 2 ? " step" : " steps") + " to reach 1");
        return steps;
    }


    /**
     * Your task is to create triangle of size 'x'. which look like this for x = 3:
     *
     * <p>x
     * <p>xx
     * <p>xxx
     */
    public void triangle1(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    /**
     * Your task is to create triangle of size 'x', which look like this for x = 3:
     *
     * <p>xxx
     * <p>xx
     * <p>x
     */
    public void triangle2(int x) {
        for (int i = x; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    /**
     * Your task is to create triangle of size 'x', which look like this for x = 3:
     *
     * <p>  x
     * <p> xx
     * <p>xxx
     */
    public void triangle3(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = i; j < x; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }

    }
}
