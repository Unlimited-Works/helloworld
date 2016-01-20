package unlimited_works.memcached;

import net.rubyeye.xmemcached.CASOperation;

/**
 *
 */
public class CasWithRetry implements CASOperation {
    private int maxTries;
    public CasWithRetry(int maxTries) {
        this.maxTries = maxTries;
    }

    @Override
    public int getMaxTries() {
        return maxTries;
    }

    @Override
    public Object getNewValue(long currentCAS, Object currentValue) {
        System.out.println("current value " + currentValue);
        return 3; //return new value to update
    }
}
