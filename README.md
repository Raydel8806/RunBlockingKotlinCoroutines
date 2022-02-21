"# RunBlockingKotlinCoroutines" 

runBlocking is a coroutine function. By not providing any context, it will get run on the main thread.Runs a new coroutine and blocks the current thread interruptible until its completion. This function should not be used from a coroutine. It is designed to bridge regular blocking code to libraries that are written in suspending style, to be used in main functions and in tests.
