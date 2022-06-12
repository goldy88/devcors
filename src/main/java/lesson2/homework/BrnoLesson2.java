package lesson2.homework;

public class BrnoLesson2 {

    /**
     * Fill main method with your calls of {@link Conditions} and {@link Loops} methods.
     *
     * <p>Output results of methods calls using System.out.println with reasonable message.
     */
    public static void main(String[] args) {

        Conditions condition = new Conditions();
        Loops loop = new Loops();

        System.out.println("Conditions methods:");
        System.out.println("Is 'a' greater than 'b' ? " + condition.isGreaterThan(51, 41));
        System.out.println("/**************************************************/");
        System.out.println("return 1 in case 'a' is greater than 'b', -1 if smaller, 0 if they are equal. Result is: " + condition.compare(100, 20));
        System.out.println("/**************************************************/");
        System.out.println("The result of the factorial is: " + condition.mutatedFactorial(9, 5));
        System.out.println("/**************************************************/");
        System.out.println("Is it a working day? " + condition.isWorkingDay("friday"));
        System.out.println("/**************************************************/");
        System.out.println("Number of day is " + condition.dayOfWeekUsingSwitch("Wednesday"));
        System.out.println("/**************************************************/");
        System.out.println("Number of day is " + condition.dayOfWeekUsingIf("sunday"));
        System.out.println();


        System.out.println("Loops methods:");
        System.out.println("The sum of the numbers is: " + loop.sum(5));
        System.out.println("The sum of the even numbers is: " + loop.sumEven(6));
        System.out.println();

        loop.hailstoneProblem(3);
        System.out.println();

        System.out.println("Right Triangle");
        loop.triangle1(3);
        System.out.println();

        System.out.println("Right Downward Triangle");
        loop.triangle2(3);
        System.out.println();

        System.out.println("Left Triangle");
        loop.triangle3(3);

    }

}
