package application1.lesson3;

public class Lesson3 {

    /**
     * <strong>Homework 2</strong>
     *
     * <p>Your task is to implement {@link ListImpl} and {@link StringListIterator}.
     * <p>To verify, that your implementation works as expected, you can use this method or provided junit tests.
     */
    public static void main(String[] args) {

        var x = new ListImpl<String>();

        x.add("Adam");
        x.add("Daniel");
        x.add("Karel");

        for (String s : x) {
            System.out.println(s);
        }
        x.add(5,"pavel");





    }
}
