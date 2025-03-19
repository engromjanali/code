  import 'dart:collection';


// var exp = Parser().parse(userinput_infix); // infix to postfix by library 
String infixToPostfix(String expression) {
    Map<String, int> precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3};
    List<String> output = [];
    Queue<String> stack = Queue<String>();  // stack will (contain bracket and operator)
    List<String> tokens = expression.split(' ');

    for (String token in tokens) {
      // r'^[a-zA-Z0-9]+$'
      // Check Operand or not?
      // 'r' syntex,
      // '^' instruction string starting point
      // '[a-zA-Z0-9]' mean A-Z,a-z,0-9
      // '+' we should pass al least one digit/char as argument
      // '$' instruction of string end
      if (RegExp(r'^[a-zA-Z0-9]+$').hasMatch(token)) {
        output.add(token);
      }
      else if (precedence.containsKey(token)) {  // Check Operator or not
        while (stack.isNotEmpty &&// checking stack empty or not?
            stack.last != '(' && //checking stack.top == '(' or not?
            precedence[stack.last]! >= precedence[token]!) {// checking new operand priority less than current operand priority or not?
          output.add(stack.removeLast()); // because there are a rule that is we have stack.pop and output.push(piped operand)  until the current operand less then new operand.
        }
        stack.addLast(token);
      }
      else if (token == '(') {  // Left parenthesis
        stack.addLast(token);
      }
      else if (token == ')') {  // Right parenthesis
        while (stack.isNotEmpty && stack.last != '(') { // stack can't be empty and stack.top can't be '('
          output.add(stack.removeLast()); // pop and push to output
        }
        stack.removeLast(); // Remove '('
      }
    }

    while (stack.isNotEmpty) {  // exist operator poping and pushing to output
      output.add(stack.removeLast());
    }

    return output.join(' ');// list will be joined separated by space, return an string.
  }