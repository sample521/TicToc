# TicToc
Tic-Toc based Timer for benchmarking.

You can create instances of `TicToc` class, then call methods `tic()` and `toc()` to find the time taken in miilisecond between the calls.

Inspired from tic-toc function in MATLAB.

Below are the availabe API calls.<br>
`tic()` - to set the start time of Timer<br>
`toc()` - to end the timer and return the duration in milliseconds from the previous call to `tic()`<br>
`getNew()` - to create a new `TicToc` instance<br>
`now()` - to get the system time in milliseconds using `System.currentTimeMillis()`<br>
`duration()`- if a `tic()` and `toc()` has been called, will silenty return the duration between the same, else will call a `toc()` and return the time duration from the previos `tic()`<br>

Please refer to the `MainClass` class for a sample usage.
