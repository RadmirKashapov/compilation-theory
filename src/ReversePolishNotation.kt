import java.util.*

/**
 * @return true if symbol [c] is digit
 */
fun isDigit(c: Char) = (c in '0'..'9')

/**
 * @return priority of operations
 */
fun prirority(c: Char) = when {
    c === '(' -> 1
    c === '+' || c === '-' -> 2
    c === '*' || c === '/' -> 3
    else -> 0
}

/**
 * @return reverse Polish Notation in the best situation
 */
fun toReversePolishNotation(strInput: String) {
    var wasOperation = 0
    var wasBrackets = 0
    var lengthCounter = 0
    var strOut = ""

    val stack = Stack<Char>()

    if(!isDigit(strInput[0])) throw Exception("Syntax error")

    while(lengthCounter != strInput.length) {
        var str: Char = strInput[lengthCounter]
        if(isDigit(str)) {
                strOut += str
                lengthCounter++
                wasOperation = 0
                continue
            }
        else strOut += ' '

        when{
            str === '(' -> {
                stack.push(str)
                ++wasBrackets
                wasOperation = 0
            }
            str === '*' || str === '/' || str === '+' || str === '-' -> {
                if(lengthCounter == strInput.length) throw Exception("Syntax Error")

                if(wasOperation == 0) {

                    wasOperation = 1

                    while(prirority(str) <= prirority(stack.lastElement())) strOut += stack.pop()

                    if(prirority(str) > prirority(stack.lastElement())) stack.push(str)
                    } else throw Exception("Syntax Error")
             }
            str === ')' -> {
                if(wasOperation === 1) throw Exception("Syntax error")
                else
                    while((stack.lastElement()) != '(' && wasBrackets > 0){
                        strOut += stack.pop()
                    }
                --wasBrackets
            }
            else -> throw Exception("Error: invalid symbol in the string")
        }
    }
    while (!stack.empty()) strOut += stack.pop()
    if(wasBrackets != 0) throw Exception("Error: wrong number of brackets")
}

/**
 * @return result of string [strOut] reversed in polish notation
 */
fun calculateRPN(strOut: String): Int {
    val stack = Stack<Int>()
    var n1: Int
    var n2: Int
    var res: Int = 0

    for(i in 0..strOut.length){
        if(isDigit(strOut[i])) stack.push(strOut[i]?.toInt())
        else {
            n2 = stack.pop();
            n1 = stack.pop();
            when(strOut[i]) {
                '+' -> res = n1 + n2
                '-' -> res = n1 - n2
                '*' -> res = n1 * n2
                '/' -> res = n1 / n2
                else -> Exception("Error")
            }
            stack.push(res);
        }
    }
    return stack.pop();
}