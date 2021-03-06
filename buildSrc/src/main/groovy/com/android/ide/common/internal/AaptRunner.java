/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.ide.common.internal;
import java.io.File;
import java.io.IOException;
/**
 * Instances of this class are able to run aapt command.
 */
public class AaptRunner {
    private final String mAaptLocation;
    private final CommandLineRunner mCommandLineRunner;
    public AaptRunner(String aaptLocation, CommandLineRunner commandLineRunner) {
        mAaptLocation = aaptLocation;
        mCommandLineRunner = commandLineRunner;
    }
    /**
     * Runs the aapt crunch command on a single file
     * @param from the file to crunch
     * @param to the output file
     * @throws IOException
     * @throws InterruptedException
     */
    public void crunchPng(File from, File to) throws IOException, InterruptedException {
        String[] command = new String[] {
                mAaptLocation,
                "s",
                "-i",
                from.getAbsolutePath(),
                "-o",
                to.getAbsolutePath()
        };
        mCommandLineRunner.runCmdLine(command);
    }
}