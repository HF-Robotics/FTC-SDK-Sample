/*
 Copyright (c) 2020 The Tech Ninja Team (https://ftc9929.com)
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */

package com.ftc9929.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StatementsLoopsAndConditionals {

    @Test
    public void statements() {
        // This should look familiar, it's the first statement we saw in VariablesDataAndTypes

        int foo = 0;

        // Statements in Java have a structure. The most common, simple statements you'll see
        // are variable declarations with assignments, and expressions
        //
        // Variable declaration:

        double bar = 0.234;

        // Expressions, usually with an assignment:

        bar = bar * 1.045;

        // Calling a method, and storing the result via an assignment:

        bar = Math.sqrt(bar);

        // Notice how these all follow a pattern:
        //
        // [declaration] variable = value, evaluating an expression, or calling a method, end with ;

        // The semicolon ";", is the "period" at the end of a Java statement. It tells the computer
        // that what has been written is a complete thought. While this is valid code, it's
        // hard to read, so please don't do it:

        int baz = 9; double qux = Math.PI; char quux = 'q'; float corge = (float)Math.E;

        // You might ask, why is the semicolon even needed, the computer can infer that after
        // "int baz = 9", the statement is complete. Remember the last lesson (1) Computers
        // are dumb, and (2) Computer grammars are very precise - no guessing. People who design
        // computer languages don't want the "Let's eat grandma" problem that exists in English.

        // In what order do statements get executed? They get executed in sequence. Ignoring
        // what happens when a constructor is called (more on that in another lesson), statements
        // are executed from top-to bottom order, unless they are part of a loop or conditional.
    }

    @Test
    public void whileLoops() {
        // All computer languages have a way to tell the computer to do something over, and over,
        // and over again. Computers are very good at doing repetitive things - which is one
        // of the reasons they are helpful at solving every day problems - they don't get bored.
        //
        // In computer programming terms, this "doing something over and over" again is called
        // "iteration".

        // The "while" loop is one form of iteration in Java (as well as most programming languages)

        boolean keepLooping = false;

        while (keepLooping) {
            // Every statement between the "{" on the line above and the "}" character will run as
            // long as what's in the "( ... )" after the "while" keyword evaluates to true.

            // In this case, the while loop is evaluating the value of a variable "keepLooping"
            // to determine whether or not to run the code in this loop.

            // FIXME: Here's a thought experiment (although you can actually run this to see what happens):

            // Given how things are setup right now in the code, does this line of code run? If it does,
            // it will fail the test. If not, you should get a "green bar" when the test is run.

            // What is your prediction?

            fail("This line of code ran");
        }

        // There is another variant of the while loop, which is known as the do-while loop. In this
        // form, all of the code is run first and *then* the check is made:

        do {
            // FIXME: Same thought experiment as above - what happens in this case?
            fail("This line of code ran");
        } while (keepLooping);

        // Notice that anything that evaluates to a boolean can be used in a while or do-while loop:
        //
        //
        //        while (1 == 1) {
        //
        //        }
        //
        //        do {
        //
        //        } while (isSkyBlue()) // where isSkyBlue is a method that returns a boolean

        // Here is a pitfalls of the usually clear syntax of Java, as it relates
        // to while loops:

        while (keepLooping);
        {
            System.out.println("I'm still looping");
            keepLooping = false;
        }

        // Above, the ; after (keepLooping) ends the while statement. The code inside the { .. }
        // will get executed if and only if the while loop terminates when "keepLooping" is false.
        //
        // If your code was relying on keepLooping to be set to a value that stops the loop, that
        // will not happen. Instead, the loop will run forever, doing nothing!

        // From a general programming practice point of view, and especially in control systems
        // that end up existing in a physical world, it is important to never end up in endless
        // loops. For that reason, when you write code for FTC, or review others' code, make sure
        // loops * always terminate *, either by having some loop counter with a maximum, or a
        // timeout (usually best). This also gives us a chance to introduce the "break" keyword:

        int loopCounter = 0;

        int loopRuns = 0;

        while (true) {
            // This loop would usually run forever, but we'll maintain a counter, and "break out"
            // after it's run a certain amount of times

            loopCounter++; // our old friend, the postfix increment
            loopRuns++; // To check later how many times the code in this loop runs

            if (loopCounter > 2) {
                break; // this causes the loop to stop running
            }
        }

        // FIXME: Given the loop above, how many times did it run? (the number is stored in loopRuns
        assertEquals(0, loopRuns);

        // Note: It's important to understand how the "control" of when your loop stops running
        // actually controls how many times the code runs. This is a common area for bugs.
        //
        // Remember, there are only two hard problems in computer science: Cache invalidation,
        // naming things, and off-by-1 errors
    }

    @Test
    public void forLoops() {
        // For loops are more commonly-used in most programming languages. They're usually used
        // to visit items in a list, or to perform a set of statements a certain number of times
        //
        // One syntax of a "for" loop, is:
        //
        // for (initialization; exit-check; do-this-every-time) {
        //
        //      runThisCodeEveryTime();
        // }
        //
        // As an example, here's a loop that counts from 0 to 10, and prints the value
        //
        // (Question: Think about why the exit-check is "i < 11")

        System.out.println("\n This is an example of using a counter to do something 'n' times \n");

        for (int i = 0; i < 11; i++) {
            System.out.println("The number is: " + i);
        }

        // There is another syntax of for loops specifically for working with lists of things.
        // One way to express the list concept in Java, is what's known as an "array", this is
        // what it looks like:

        int[] aListOfIntegers = new int[] { 1, 4, 2, 9, 42, 16};

        System.out.println("\n This is an example of iterating over a list of things\n");

        // Iterating over the items in a list with a for loop in Java then looks like this:

        for (int oneInteger : aListOfIntegers) {
            System.out.println("The number in the list is: " + oneInteger);
        }

        // We will later learn about other types of lists, and list-like things known as Iterables
        // which work with the same syntax of for loop above. For now, it's just handy to know that
        // if you want to work with all of the elements in a list in Java, the above syntax is
        // what you should use.

        // Now, for some work for something to try, we will iterate through the values 1-26. The
        // Char type is structured in such a way, at least for English, that the Char that
        // represents the next letter in sequence, is +1 from the current value. So, the exercise
        // is to fix the for loop below to print the letters "a-z" and their character numerical
        // values:

        System.out.println("\n This is an example of iterating and printing Chars...\n");

        // FIXME: None of the values, and operators in the for loop itself are correct
        // In fact, if you run it (it will run), you might get unexpected results, but try
        // it first, anyway!

        for (int i = 42;/* This is not the correct value to start with */
             i < 9929; /* This is probably not the correct limit, or check */
              i-- /* This is probably not the correct operation to do each time */) {

            System.out.println((int)'a' + i + " = " + (char)('a' + i));
        }
    }

    @Test
    public void conditionals() {
        // Conditionals are all about making choices, the most-used form looks like this:

        boolean shouldIRunThatCode = false;

        if (shouldIRunThatCode) {
            System.out.println("I'm running the code");
        } else {
            System.out.println("I'm not running the code, I'm doing something else");
        }

        // If there is no "other thing to do", it looks like this:

        if (shouldIRunThatCode) {
            System.out.println("I'm running the code");
        }

        // FIXME: Use the following methods inside the if statements below, to create a lawful
        // self-driving algorithm that deals with stoplights:
        //
        // stopTheCar()
        // slowDown()
        // proceedThroughIntersection
        //
        // There is a logic bug that we will discuss in-person with this code, that is a common
        // mistake that all programmers make.
        StoplightColor colorISee = StoplightColor.RED;

        if (colorISee == StoplightColor.GREEN) {

        } else if (colorISee == StoplightColor.RED) {

        } else if (colorISee == StoplightColor.YELLOW) {

        }

        // A more compact way to deal with an if() that checks a variable for multiple values is
        // a "switch" statement, the above code in if(), looks like this as a switch:

        switch (colorISee) {
            case RED:
                // Your code goes here
                break;
            case GREEN:
                // Your code goes here
                break;
            case YELLOW:
                // Your code goes here
                break;
        }

        // There are subtle bugs in the above code, we'll talk about those too:
    }

    enum StoplightColor {RED, YELLOW, GREEN, NONE};

    private void stopTheCar() {}

    private void slowDown() {}

    private void proceedThroughIntersection() {}
}
