/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int valid(int number) {
    // 6 digit number
    if(number < 100000 || number > 999999) {
        return 0;
    }

    int six = number / 100000;
    int five = number % 100000 / 10000;
    int four = number % 10000 / 1000;
    int three = number % 1000 / 100;
    int two = number % 100 / 10;
    int one = number % 10;

    // double digits
    if(
        six != five
        &&
        five != four
        &&
        four != three
        &&
        three != two
        &&
        two != one
        ) {
            return 0;
        }

    // ascending orders
    if(
        six > five
        ||
        five > four
        ||
        four > three
        ||
        three > two
        ||
        two > one
        ) {
            return 0;
        }

        return 1;
}

int main()
{
    int bottom = 234208;
    int top = 765869;

    int matchingNumbers = 0;

    for(int number = bottom; number <= top; number++) {
        matchingNumbers += valid(number);
    }

    printf("valid numbers in range %d - %d = %d", bottom, top, matchingNumbers);
    return 0;
}
