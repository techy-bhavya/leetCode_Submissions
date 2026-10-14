class Solution {
    public static int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        } else if(ch == '/' || ch == '*'){ 
            return 2;
        } else {
            return 0;
        }
    }

    public static int evaluate(int v1, int v2, char op){
        if(op == '+'){
            return v1 + v2;
        } else if(op == '-'){
            return v1 - v2;
        } else if(op == '*'){
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }

    public int calculate(String exp){
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i); 

            // Skip spaces if the input string contains them
            if (ch == ' ') {
                continue;
            }

            // Fix: Parse multi-digit numbers
            if(ch >= '0' && ch <= '9'){
                int value = 0;
                while (i < exp.length() && exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
                    value = value * 10 + (exp.charAt(i) - '0');
                    i++;
                }
                i--; // Step back since the outer loop increment will advance 'i'
                operands.push(value);
            } 
            else if(ch == '+' || ch == '-' || ch =='/' || ch == '*'){

                while(operators.size() > 0 && precedence(operators.peek()) >= precedence(ch)){
                    char op = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int res = evaluate(v1,v2,op);

                    operands.push(res);
                }

                operators.push(ch);
            }
        }

        while(operators.size() > 0){
            char op = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();

            int res = evaluate(v1,v2,op);

            operands.push(res);
        }

        return operands.peek();
    }
}
