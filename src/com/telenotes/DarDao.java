package com.telenotes;

/**
 * Created by Urge_Smith on 1/5/18.
 */
public class DarDao extends TelenotesDbConnection {

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static DarDao instance;

    public synchronized static DarDao getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                try {
                    instance = new DarDao();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    private DarDao() throws Exception {
        super();

    }

}
