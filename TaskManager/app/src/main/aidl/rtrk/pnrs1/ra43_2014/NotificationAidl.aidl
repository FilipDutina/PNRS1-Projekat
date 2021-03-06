// NotificationAidl.aidl
package rtrk.pnrs1.ra43_2014;

// Declare any non-default types here with import statements

interface NotificationAidl {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

     /*
        It allows you to define the programming interface that both the client and service agree upon in order to communicate with each other using interprocess communication (IPC).
     */

    void notificationAdd();

    void notificationEdit();

    void notificationDelete();
}
