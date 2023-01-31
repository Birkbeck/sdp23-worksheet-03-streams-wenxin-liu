import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Outline {

    public static List<String> getList() {
        return List.of("hi", "bat", "ear", "hello", "iguana",
                "beaver", "winterland", "elephant", "eye", "qi");
    }

    // Loop through the words and print each one on a separate line,
    // with two spaces in front of each word.
    public static void question1() {
        List<String> words = getList();
        System.out.println("1: ");
        // YOUR CODE
        words.stream()
                .map(word -> "  " + word)
                .forEach(System.out::println);
    }

    // Repeat this problem but without two spaces in front of each word.
    // This should be trivial if you use the same approach as the previous
    // question; the point here is to make use of a method reference.
    public static void question2() {
        List<String> words = getList();
        System.out.println("2: ");
        // YOUR CODE
        words.forEach(System.out::println);
    }

    // For each of the following lambda expressions (see Question 5 in Worksheet 2),
    // produce the list that contains the elements of the original list
    // that satisfy the predicate defined by the lambda expression
    // (use the filter stream operation):
    //  - s -> s.length() < 4 (strings with no more than 3 characters),
    //  -  s -> s.contains("b") (strings containing "b"),
    // s -> (s.length() % 2) == 0 (strings of even length).

    public static void question3() {
        List<String> words = getList();
        System.out.println("3:");
        // YOUR CODE
        words.stream()
                .filter(word -> word.length() < 4)
                .forEach(System.out::println);

        System.out.println("\n");

        words.stream()
                .filter(word -> word.contains("b"))
                .forEach(System.out::println);

        System.out.println("\n");

        words.stream()
                .filter(word -> (word.length() % 2) == 0)
                .forEach(System.out::println);
    }


    // For each of the following lambda expressions (see Question 7 in Worksheet 2),
    // produce the list that contains the results of applying the function
    // defined by the lambda expression to each element of the original list
    // (use the map stream operation):
    // - s -> s + "!",
    //  s -> s.replace("i", "eye"),
    //  s -> s.toUpperCase().

    public static void question4() {
        List<String> words = getList();
        System.out.println("4:");
        // YOUR CODE
        words.stream()
                .map(word -> word + "!")
                .forEach(System.out::println);

        System.out.println("\n");

        words.stream()
                .map(word -> word.replace("i", "eye"))
                .forEach(System.out::println);

        System.out.println("\n");

        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }


    // (*) Turn the strings in the list into uppercase, keep only the
    // ones that are shorter than four characters, and, of what is remaining,
    // keep only the ones that contain "e", and print the first result.
    // Repeat the process, except checking for a "q" instead of an "e".

    public static void question5() {
        List<String> words = getList();
        System.out.println("5a:");
        // YOUR CODE
        List<String> firstResult = words.stream()
                .map(String::toUpperCase)
                .filter(word -> word.length() < 4)
//                .filter(word -> word.contains("e"))
                .toList();

//        System.out.println(firstResult.get(0));

        System.out.println();

        List<String> secondResult = words.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(word -> word.length() < 4)
                .filter(word -> word.contains("q"))
                .toList();

        Optional<String> alternativeMethod = words.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(word -> word.length() < 4)
                .filter(word -> word.contains("Q"))
                .findFirst();

        alternativeMethod.ifPresent(System.out::println);

//        System.out.println(secondResult.get(0));
    }


    // (** ) The above example uses lazy evaluation, but it is not easy to see
    // that it is doing so. Create a variation of the above example that shows
    // that it is doing lazy evaluation. The simplest way is to track which
    // entries are turned into upper case.

    public static void question6() {
        List<String> words = getList();
        System.out.println("6:");
        // YOUR CODE
    }

    // (*) Produce a single String that is the result of concatenating the
    // uppercase versions of all the Strings.
    // For example, the result should be "HIHELLO...".
    // Hint: use a map operation that turns the words into upper case,
    // followed by a reduce operation that concatenates them.

    public static void question7() {
        List<String> words = getList();
        System.out.println("7:");
        // YOUR CODE

        String result = words.stream()
                .map(String::toUpperCase)
                .reduce("", (partialList, element) -> partialList + element);

        System.out.println(result);
    }


    // (*) Produce a single String that is the result of concatenating the
    // uppercase versions of all the Strings.
    // For example, the result should be "HIHELLO...".
    // Use a single reduce operation, without using map.

    public static void question8() {
        List<String> words = getList();
        System.out.println("8:");
        // YOUR CODE
    }

    // (*) Produce a String that is all the words concatenated together, but
    // with commas in between. For example, the result should be "hi,hello,...".
    // Note that there is no comma at the beginning, before "hi", and also no comma
    // at the end, after the last word.

    public static void question9() {
        List<String> words = getList();
        System.out.println("9:");
        // YOUR CODE
    }


    // CONTINUE WITH THE REST OF THE QUESTIONS

    public static void main(String... args) { // varargs alternative to String[]
        question1();
        System.out.println();

        question2();
        System.out.println();

        question3();
        System.out.println();

        question4();
        System.out.println();

        question5();
        System.out.println();
    }

    static void printWords(List<String> words) {
        words.stream()
                .map(word -> "  " + word)
                .forEach(System.out::print);
    }
}