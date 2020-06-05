package com.ftc9929.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VariablesDataAndTypes {

    @Test
    public void primitiveTypes() {
        // This is a declaration of a variable. A variable is data, with a value, and a name.

        int foo = 0;

        // The above is also an example of a "statement" in Java, or sometimes called
        // "a line of code".
        //
        // You can think of statements like a sentence. There are nouns (the variables, literal
        // values like "0"), and verbs, in this case the assignment operator. All statements in
        // Java end with the semicolon, ";", because the period ".", means something else.

        // Let's unpack that statement really quickly
        //
        // "int" is a "type", which describes what kind of data the variable contains. In this case
        // it's an integer, a value which is a whole negative, positive or zero.
        //
        // "foo" is the name of the variable.
        //
        // The "=" symbol, is not what you are used to, it's not "equality", it's known as the
        // assignment operator. What it means:
        //
        //     "assign the value on the right, to the variable on the left"
        //
        // So in this case, it means "Assign the value 0 to the variable named 'foo', and treat it
        // as an integer type."

        // This is an example of an assertion that we use when writing tests for our code.
        // We will use tests as the teaching tool to start our programming lessons, because
        // they are a good way to show what is happening, and writing tests for your code is
        // a good habit to develop early on.

        // FIXME: If we run this code, and ask the computer to make this assertion, what do you think
        // will happen?
        assertEquals(1, foo);

        // Here we create an int variable, and don't declare an initial value. Java prevents you
        // from using this variable until a value has been assigned to it.

        int fooNoValue;

        // FIXME: To see, uncommennt the line with the assertion in it, and see what happens!

        // assertEquals(0, fooNoValue);

        // This behavior changes for variables that belong to classes, not methods, but that's
        // for later!

        // -------------------------------------------------------------------------------------
        // Another type of value in Java is a boolean. It can store the value "true" or "false".
        //
        // In reality, inside the computer, booleans store the value "1" or "0". (In fact strings
        // of "1"s and "0"s are the only numbers a computer knows, programmers have just taught
        // them to represent other things with just "1"s and "0s"! (The videos you watch on YouTube,
        // the pictures you send on SnapChat, the sound of your voice on a mobile phone call, are
        // all reduced to "1"s and "0"s at some point!).
        // -------------------------------------------------------------------------------------
        {
            boolean iAmTrue = true;

            boolean iAmFalse = false;

            // Booleans are probably one of the most used types of values in computer programming
            // but they are not seen as often being assigned to any variable. More often they
            // are the result of some logical comparison (equality, relational, logical), and the
            // program does something different based on whether the result is "true" or "false".
            // (more on that later).

            if (1 == 0) {
                // ^ That's the equality operator, it's how you check that a value of a primitive
                // type is the same as the value of another primitive type. This is the source of
                // a common bug, remember in the real world "=" means "equals", but in most
                // computer languages it means "assignment" and some other operator, in Java's case
                // "==" means "equals".
                //
                // The result of making that equality comparison, is of type boolean, evaluating
                // to true or false.
                //
                // We will learn more about if() statements later, but for now it's good to know that
                // what goes in between ( and ) in an if () statement must always evaluate to a
                // boolean type.
            }

            // Now, here's the tricky bug, as written, this assertion will fail, because the
            // "return value" of the assignment operator is always the assigned value. The expression
            // "iAmFalse = false" does not check that iAmFalse has a value of "false", it assigns the
            // value "false" to "iAmFalse", and then returns "false". In this case the assertion
            // will fail. But imagine code you write that is checking if a value is "true", and
            // instead of using "==", you used "=". Can you tell what the bug will be?

            // FIXME: This statement has a bug!
            assertTrue(iAmFalse = false);
        }

        // -------------------------------------------------------------------------------------
        // There are other types in Java (like "char", and "short", and if you end up writing to
        // the FTC hardware directly, you'll use "byte", but by the time you get there, you'll
        // know what one is), which you won't often use.
        //
        // However, there are some other types of numbers we use in FTC, namely the floating
        // point numeric types. All numeric types in Java are signed - they can represent positive
        // and negative values.
        // -------------------------------------------------------------------------------------
        {
            // First, there is "float", A signed number that can represent values that have a
            // decimal point. It has a range that is much larger than anything we use in robotics.
            //
            // Smallest value: 1.4E-45 (1.4 x 10 to the -45th power)
            // Largest value: 3.4028235E38 (3.4 x 10 to the 38th power)

            float floatNumber = 0;

            // "double", similar to a float, but it can represent a larger range of values.
            //
            // Smallest value: 4.9406564584124654 x 10 to the -324 power
            // Largest value: 1.7976931348623157 x 10 to the 308 power

            double bar = 0;

            // Something you should understand about floating point (float/double) types. Computers
            // don'talways follow the rules of math that you are familiar with - because in reality,
            // floating point numbers are approximations. They can't represent values like 0.1, 0.2,
            // or 0.3 - inside the computer they are rounded to the closest value the computer can
            // represent.
            //
            // (If you're really interested, check out
            //
            // https://en.wikipedia.org/wiki/Floating-point_arithmetic#IEEE_754:_floating_point_in_modern_computers
            //
            // for more details, many more details!)

            // When dealing with floating point, think of this like
            // assign the closest value to 0.1 you can, to the variable
            // named "numberA"

            double numberA = 0.1;

            double numberB = 0.2;

            // Assign the result of adding "a" and "b" to
            // the variable named "result". You would think
            // this result would be "0.3"...

            double result = numberA + numberB;

            // By the way, "System.out.println()" is how you get Java to write data to your screen
            System.out.println("Surprise, I'm not 0.3, I am actually " + result);

            // FIXME: You'll notice this has strikethrough in it, you'll see why when we run it.
            assertEquals(0.3, result); //

            // When checking for equality with floating point numbers in any programming language,
            // you need to check that it is "close enough", like this:

            boolean isCloseEnoughToZeroPoint3 = Math.abs(result - 0.3) < 0.01;

            // (which is what this assertEquals code does, under the hood):

            assertEquals(0.3, result, 1);

            //
            // char, and String
            //
            // There is one more type commonly used in FTC (and all of Java), which is 'char',
            // which represents a textual character. However, it's very rarely used alone,
            // instead it is used in Strings, which are....strings of characters (words,
            // sentences, etc. used to communicate with humans).
            //
            // A char represents a single unicode character. Unicode is a set of characters that
            // tries to represent writing in all written languages, as well as things like
            // emoticons. Strings of characters could be anything from "My hovercraft is full of
            // eels", but in Kanji, to the well-known table flip - "(╯°□°）╯︵ ┻━┻".
            //
            // Let's take a look at how Strings work - they are a funny creature in Java, they
            // sometimes act like a primitive type like "int" or "boolean", but are really an
            // object, which leads to some interesting behaviors.

            // You declare a string like this. The value assigned is between the double quotation
            // marks:

            String myStringValue = "Gracious Professionalism";

            // DANGER WILL ROBINSON - equality does *not* reliably work in the way it would
            // with a primitive type, this comparison will *sometimes* work, but not all of
            // the time (the reasons are pretty detailed, ask me later if you care):

            if (myStringValue == "Gracious Professionalism") {
                // do something in a graciously professional manner
            }

            // Instead, if you want to check if one string is equal to another, you use .equals():

            if ("Gracious Professionalism".equals(myStringValue)) {
                // do something in a graciously professional manner
            }

            // Note that it's usually safer to compare to the literal value, rather than
            // ask if the String .equals() the literal value. For now, just remember that,
            // we'll get into *why* this is the case when we talk about objects.

            // There's one other non-standard thing Strings can do. They work with one
            // operator, and that's the "+" sign:

            String partialAlphabet = "a" + "b" + "c";

            // FIXME: Predict what happens when the above statement is executed
            assertEquals("", partialAlphabet);
        }
    }

    @Test
    public void smoothOperators() {

        // -------------------------------------------------------------------------------------
        // You've already learned about three "operators" that work with numeric types:
        //
        // "=" - the assignment operator
        // "+" - numerical addition (it means something else for different data types)
        // "==" - the equality operator. For numeric types, this always works. For objects,
        //        it has some surprising behavior - more on that later.
        //
        // The other operators that work with numeric types, that you should know are:
        // -------------------------------------------------------------------------------------
        {
            //
            // "*" - numerical multiplication
            //

            int nine = 3 * 3;

            //
            // "/" - numerical division
            //

            int two = 4 / 2;

            //
            // "%" - modulo - in other words "what is the remainder after dividing the value on the left
            //                of the operator by the value on the right of the operator.

            int three = 7 % 4;
        }

        // -------------------------------------------------------------------------------------
        // Equality and comparison operators
        //
        // You've already learned about one equality operator, namely "==". There are other
        // comparisons you can make in most programming languages, in Java they are:
        //
        // "==" - equality - you already know this one
        // "!=" - not equals, the opposite of equality
        // ">" - is the value on the left of ">" greater than the one on the right?
        // "<" - is the value on the left of "<" less than the one on the right?
        // "<=" - is the value on the left less than or equal to the one on the right?
        // ">=" - is the value on the left greater than or equal to the one on the right?
        //
        // All great programmers are lazy (in a good way), programmers that create programming
        // languages are no different. Some examples of operators that do more than one thing at
        // a time, are "prefix" and "postfix" operators, namely increment and decrement
        // -------------------------------------------------------------------------------------
        {
            int startValue = 0;

            // Assign the current value of "startValue" to "endValuePostfix", *then* assign
            // startValue the value of 1 + startValue.

            int endValuePostfix = startValue++;

            // FIXME: What would you expect the value of endValuePostfix to be after the computer
            // executes the above statement?

            assertEquals(-1 /* obviously incorrect */, endValuePostfix);

            // Assign the value of "startValue" + 1 to "startValue", then assign that value
            // to "endValuePrefix"
            int endValuePrefix = ++startValue;

            // FIXME: What would you expect the value of endValuePrefix to be after the computer
            // executes the above statement?
            assertEquals(-1 /* obviously incorrect */, endValuePrefix);
        }

    }
}
