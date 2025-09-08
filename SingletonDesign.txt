Singleton Design Pattern

    1. Singleton Design pattern ensures only one instance of class is created throught the application.
    2. Provide a global access point to instance

In short → "One class, one object, accessible everywhere."

Instead of creating mutiple object we can create one object and can be used in differnet places

Commonly Eg are:
    1. Loggers
    2. Database connection pool

Key Benefits:
    1. Saves memeory
    2. Easy global access

V0 version:

class DbConnectionPool{
    public static DbConnectionPool instance = null;
    private DbConnectionPool(){
        // private constructor to prevent instantiation
    }
    public static DbConnectionPool getInstance(){
        if(instance == null){
            instance = new DbConnectionPool();
        }
        return instance;
    }
}

But this is not thread safe, multiple threads can create multiple instances
Thread Safe Version:


V1 version:
class DbConnectionPool{
    private static DbConnectionPool instance = null;
    private static readonly object padlock = new object();
    private DbConnectionPool(){
        // private constructor to prevent instantiation
    }
    public synchronized static DbConnectionPool getInstance(){
        if(instance == null){
            instance = new DbConnectionPool();
        }
        return instance;
    }
}

This is thread safe but it has performance issue, every time lock is acquired even instance is created

V2 version:
class DbConnectionPool{
    private static DbConnectionPool instance = new DbConnectionPool();
    private DbConnectionPool(){
        // private constructor to prevent instantiation
    }
    public static DbConnectionPool getInstance(){
        return instance;
    }
}

Prons of this approach:
    1. Thread safe
    2. Simple to implement
    3. Dosen't require locking

Cons of this approach:
    1. Instance is created even if it is not used
    2. If constructor has heavy operation it can slow down application startup

V3 version: Lazy Initialization with Double Check Locking
class DbConnectionPool{
    private static volatile DbConnectionPool instance = null;
    private DbConnectionPool(){
        // private constructor to prevent instantiation
    }
    public static DbConnectionPool getInstance(){
        if(instance == null){
            lock(padlock){
                if(instance == null){
                    instance = new DbConnectionPool();
                }
            }
        }
        return instance;
    }
}