package rtrk.pnrs1.ra43_2014;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceNotifier extends Service {

    private CustomNotifications myCustomNotification;
    private CheckerThread myCheckerThread;  //instanca moje niti

    @Override
    public void onCreate()
    {
        myCheckerThread = new CheckerThread(this);
        myCheckerThread.start();
        myCustomNotification = new CustomNotifications(this);
        super.onCreate();
    }


    @Override
    public void onDestroy()
    {
        myCheckerThread.exit();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return myCustomNotification;
    }
}
