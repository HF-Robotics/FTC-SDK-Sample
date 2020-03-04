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

package com.ftc9929.examples.markdmatthews;

import com.ftc9929.corelib.control.NinjaGamePad;
import com.ftc9929.corelib.control.ToggledButton;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * A very simple OpMode that changes what is sent to the drivers' station
 * telemetry each time the driver "a" button is pressed.
 */
@TeleOp(name="Mark's Example OpMode")
public class SimpleTeleOp extends OpMode {

    private ToggledButton aButtonToggled;

    @Override
    public void init() {
        NinjaGamePad gamepad = new NinjaGamePad(gamepad1);
        aButtonToggled = new ToggledButton(gamepad.getAButton());
    }

    @Override
    public void loop() {
        if (aButtonToggled.isToggledTrue()) {
            telemetry.addData("toggle", "ping");
        } else {
            telemetry.addData("toggle", "pong");
        }

        updateTelemetry(telemetry);
    }
}
