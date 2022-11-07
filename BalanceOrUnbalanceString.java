import java.util.LinkedList;

public class BalanceOrUnbalanceString {
    static boolean checkIfBalanced(String s){
        LinkedList<Character> stack = new LinkedList<>();
        for(char ch:s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '[') stack.addFirst(ch);
            else if (stack.size() > 0) {
                if (ch == ')' && stack.getFirst() == '(') stack.removeFirst();
                else if (ch == '}' && stack.getFirst() == '{') stack.removeFirst();
                else if (ch == ']' && stack.getFirst() == '[') stack.removeFirst();
                else return false;
            }
            else return false;
        }
        return stack.size() == 0;
    }

    static void printResult(String s){
        if (checkIfBalanced(s))
            System.out.println("The input String has Balanced Brackets");
        else System.out.println("The input String do not contain Balanced Brackets");
    }

    public static void main(String[] args) {
        String input1 = "([[{}]])", input2 = "()()()({}[]", input3 = "([[{}]]))",
                input4 = "(()(())))", input5 = "(()()()({}[]", input6 = "([[{(()}]]))",
                input7 = "(}";

        printResult(input1);
        printResult(input2);
        printResult(input3);
        printResult(input4);
        printResult(input5);
        printResult(input6);
        printResult(input7);
    }



}
