class Arithmetic {
    //addition    8 + 9
    //subtraction 8 - 9
    //multiplication 8 * 9
    //division 1/2 (this is integer division)
    //division 1f/2 (this is float division)
    //division 1d/2 (double division)
    //division (double)1/2
    //mod 45 % 2 
    //powers Math.pow(2,3) 2 to the power of 3
}

class Relational {
    // equality ==
    // not equal !=
    //inequalities 
    // <, >, <=, >=
}

class Logical {
    // ! is for NOT
    // && for AND
    // ^^ for OR
}

class Bitwise {
    // & is for bitwise and
    // | is for bitwise or
    // ^ is for xor
    // ~ is for bitwise not
    // << is for left shift
    // >> right shift
}

class PrefixAndPostfix {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int result_i;
        int result_j;

        // the postfix operator
        // 1. the ++ or -- after i is the operator
        // 2. adds or subtracts 1
        // 3. returns i before we added 1
        result_i = i++;


        // the prefix operator
        // 1. the ++ or -- is before the variable
        // 2. adds or subtracts 1
        // 3. it returns the value after we changed it

        result_j = ++j;

    }
}


