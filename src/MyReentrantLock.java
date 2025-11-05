import java.util.concurrent.atomic.AtomicBoolean;

public class MyReentrantLock implements Lock{
    private Thread keyHolder;
    private AtomicBoolean isLocked = new AtomicBoolean(false);
    private int numberOfLockedLocks;


    @Override
    /**
    * This method is in-charge of locking the lock until possible.
    */
    public void acquire() {
        while (!tryAcquire()){
            Thread.yield();
        }
    }

    /**
     * This method tries to lock the lock if possible.
     * @return Returns TRUE if the method succeeded locking the lock otherwise returns FALSE
     */
    @Override
    public boolean tryAcquire(){
        if (isLocked.compareAndSet(false,true)) {
            keyHolder = Thread.currentThread();
            numberOfLockedLocks++;
            return true;
        }
        else if(Thread.currentThread() == keyHolder) {
            numberOfLockedLocks++;
            return true;
        }
        return false;
    }


    /**
     * This method is in-charge of releasing the lock
     * @throws IllegalReleaseAttempt - If there are no locked locks or other thread that isn't the one holding the key tries to release it - the method will throw an exception.
     */
    @Override
    public void release() throws IllegalReleaseAttempt{
        if(numberOfLockedLocks == 0 || Thread.currentThread() != keyHolder)
            throw new IllegalReleaseAttempt();
        if (--numberOfLockedLocks == 0)
        {
            keyHolder = null;
            isLocked.set(false);
        }
    }


    /**
     * This method closes the resource (the lock)
     */
    @Override
    public void close() {
        release();
    }
}
