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

import com.ftc9929.testing.fakes.drive.FakeDcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.junit.Assert;
import org.junit.Test;

public class ClassesFieldsMethods {
    class TankDrivebase {
        DcMotor leftFrontMotor;

        DcMotor leftRearMotor;

        DcMotor rightFrontMotor;

        DcMotor rightRearMotor;

        // This is a very special method, called the constructor. It's how code that uses your
        // class can create objects of this class. It's always named the same as the class
        // and has no return type, because it's implied that the return type is of the class

        public TankDrivebase(DcMotor leftFrontMotor,
                             DcMotor leftRearMotor,
                             DcMotor rightFrontMotor,
                             DcMotor rightRearMotor) {
            this.leftFrontMotor = leftFrontMotor;
            this.leftRearMotor = leftRearMotor;
            this.rightFrontMotor = rightFrontMotor;
            this.rightRearMotor = rightRearMotor;

            // Motors all rotate in the same direction, but this will cause robot to drive
            // in a circle, one side needs reversed!

            this.leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
            this.leftRearMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        // FIXME: What should the API (the contract) look like for code that wants to make
        // the tank drivebase move look like? What values do we think the calling code should
        // give our object to make it do something?
        //
        // Ask yourself - what is the knowledge/information that a tank drivebase should know
        // that something that uses it does not really need to know? That knowledge is the
        // logic you keep in the TankDrivebase class!

        // You also have options about how the driver interacts with the robot,
        // is this two-stick forward/back, or "halo", or something else?

        public void drive() {

            // FIXME: You need to somehow get from what the caller of drive() is giving this
            // object, to a set of power levels to give to all four motors

            // HINT: One way to simplify this is to figure out how many *actual* power values
            // are needed!

            this.leftFrontMotor.setPower(0);
            this.leftRearMotor.setPower(0);
            this.rightFrontMotor.setPower(0);
            this.rightRearMotor.setPower(0);
        }
    }

    @Test
    public void testOurDrivebase() {
        FakeDcMotorEx fakeLeftFrontMotor = new FakeDcMotorEx();
        FakeDcMotorEx fakeLeftRearMotor = new FakeDcMotorEx();
        FakeDcMotorEx fakeRightFrontMotor = new FakeDcMotorEx();
        FakeDcMotorEx fakeRightRearMotor = new FakeDcMotorEx();

        TankDrivebase drivebase = new TankDrivebase(fakeLeftFrontMotor,
                fakeLeftRearMotor,
                fakeRightFrontMotor,
                fakeRightRearMotor);

        // From this point, we need to make the drivebase do things, by calling methods on it
        // and then using Assertions against the fake dc motors to show that our code is working
        // as we expect.

        // FIXME: Of course, this one is false
        Assert.assertEquals(fakeLeftFrontMotor.getPower(), 999, 0.01);
    }
}
