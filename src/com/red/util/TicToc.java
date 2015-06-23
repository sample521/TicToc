/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 - Jos Angel George
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.red.util;

/**
 * <b>Simple Tic-Toc based Timer Class</b>
 * 
 * <p>Can be used to determine time taken (in millisecond precision)
 * between two lines of code.</p>
 * 
 * <p>Inspired by tic-toc function in MATLAB</p> <br>
 * 
 * <p>use {@link TicToc#getNew()} to create a new instance</p>
 * <p>use {@link TicToc#tic()} to start the Timer</p>
 * <p>use {@link TicToc#toc()} to stop the timer and return the duration</p>
 * <p>use {@link TicToc#now()} to get the current system millisecond</p>
 * <p>use {@link TicToc#duration()} to get the duration between last tic 
 * 							and last toc without calling a toc (like a peek).</p>
 * 
 * @since initial
 * @author Jos Angel George
 * 
 * */
public class TicToc {

	private long start;
	private long end;

	/**
	 * <p>Private Default Constructor</p>
	 * <p>Kindly use {@link TicToc#getNew()} for creating new instances.</p>
	 * */
	private TicToc() {}

	/**
	 * <p>Static Constructor</p>
	 * <p>Creates and returns a TicToc object and auto-starts it.</p>
	 * */
	public static TicToc getNew() {
		TicToc ticToc = new TicToc();
		ticToc.tic();
		return ticToc;
	}

	/**
	 * <p>Sets the timer start time. </p>
	 * <p>Subsequent calls will override previous start times</p>
	 * <p>Note: A call to tic will clear the previous toc.</p>
	 * 
	 * @return void
	 * */
	public void tic() {
		this.start = System.currentTimeMillis();
		this.end = 0;
	}

	/**
	 * <p>Sets the end time. Subsequent calls will override previous end times</p>
	 * 
	 * @return duration between last toc and its previous tic (in ms)
	 * */
	public long toc() {
		this.end = System.currentTimeMillis();
		return (this.end - this.start);
	}

	/**
	 * <p>Method to find the duration between tic and toc</p>
	 * <p>If a toc is not called after last tic, A toc is called implicitly </p>
	 * 
	 * @return long- the time duration in milliseconds from last toc till its previous tic.
	 * */
	public long duration() {
		if (end == 0) {
			return this.toc();
		}
		return (this.end - this.start);
	}

	/**
	 * 
	 * <p>Return the current millisecond;</p>
	 * <p>(directly return) {@link System#currentTimeMillis()}</p>
	 * 
	 * @return long - "the difference, measured in milliseconds, between the
	 *         current time and midnight, January 1, 1970 UTC."
	 * */
	public long now() {
		return System.currentTimeMillis();
	}
}
