import arraystrings.ArraysStringsProblems;

public class CtciMain {

    static void main() {
        String input = "Mr John Smith    ";
        System.out.println(input);
        System.out.println(ArraysStringsProblems.urlifyv1(input, input.length()));
        System.out.println(ArraysStringsProblems.urlifyv2(input, input.length()));
        String input2 = "Hello my little world      ";
        System.out.println(input2);
        System.out.println(ArraysStringsProblems.urlifyv1(input2, input2.length()));
        System.out.println(ArraysStringsProblems.urlifyv2(input2, input2.length()));
    }
}
