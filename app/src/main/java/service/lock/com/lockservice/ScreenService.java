package service.lock.com.lockservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ScreenService extends Service {
  private ScreenReceiver mReceiver;
  private Boolean screenOn = null;

  @Override public void onCreate() {
    super.onCreate();
    // REGISTER RECEIVER THAT HANDLES SCREEN ON AND SCREEN OFF LOGIC
    IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
    filter.addAction(Intent.ACTION_SCREEN_OFF);
    mReceiver = new ScreenReceiver();
    registerReceiver(mReceiver, filter);
    Log.d("SERVICE", "CREATED");
  }

  @Override public int onStartCommand(Intent intent, int flags, int startId) {
    if(intent == null) return START_STICKY;
    if (screenOn != null && intent.getBooleanExtra("screen_state", false)) {
      Intent activityIntent = new Intent(this, LandingActivity.class);
      activityIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);
      this.startActivity(activityIntent);
    } else {
      screenOn = intent.getBooleanExtra("screen_state", false);
    }
    return super.onStartCommand(intent, flags, startId);
  }

  @Nullable @Override public IBinder onBind(Intent intent) {
    return null;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    unregisterReceiver(mReceiver);
  }
}
