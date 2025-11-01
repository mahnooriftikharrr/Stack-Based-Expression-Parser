import java.util.Stack;
public class ExpressionEvaluator {

    public int evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new RuntimeException("Empty expression");
        }

        Stack<Integer> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isNumber(token)) {
                operands.push(Integer.parseInt(token));
            }
            else if (token.equals("(")) {
                operators.push(token);
            }
            else if (token.equals(")")) {
                processUntilLeftParenthesis(operands, operators);
            }
            else if (isOperator(token)) {
                processOperatorsByPrecedence(token, operands, operators);
                operators.push(token);
            }
            else {
                throw new RuntimeException("Invalid token: " + token);
            }
        }

        while (!operators.isEmpty()) {
            String op = operators.pop();
            if (op.equals("(")) throw new RuntimeException("Mismatched parentheses");
            applyOperation(operands, op);
        }
        if (operands.size() != 1) {
            throw new RuntimeException("Invalid expression: leftover operands");
        }
        return operands.pop();
    }

    private boolean isNumber(String s) {
        return s != null && s.matches("-?\\d+");
    }

    private boolean isOperator(String s) {
        return "+-*/^".contains(s);
    }

    private int precedence(String op) {
        if (op.equals("^")) return 3;
        if (op.equals("*") || op.equals("/")) return 2;
        if (op.equals("+") || op.equals("-")) return 1;
        return 0;
    }

    private void applyOperation(Stack<Integer> operands, String op) {
        if (operands.size() < 2) {
            throw new RuntimeException("Not enough operands for operator " + op);
        }

        int right = operands.pop();
        int left = operands.pop();
        int result;

        if (op.equals("+")) result = left + right;
        else if (op.equals("-")) result = left - right;
        else if (op.equals("*")) result = left * right;
        else if (op.equals("/")) {
            if (right == 0) throw new RuntimeException("Division by zero");
            result = left / right;
        }
        else if (op.equals("^")) result = (int) Math.pow(left, right);
        else throw new RuntimeException("Unknown operator: " + op);

        operands.push(result);
    }

    private void processUntilLeftParenthesis(Stack<Integer> operands, Stack<String> operators) {
        while (!operators.isEmpty() && !operators.peek().equals("(")) {
            applyOperation(operands, operators.pop());
        }
        if (operators.isEmpty()) throw new RuntimeException("Mismatched parentheses");
        operators.pop();
    }

    private void processOperatorsByPrecedence(String token, Stack<Integer> operands, Stack<String> operators) {
        while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
            applyOperation(operands, operators.pop());
        }
    }

}
