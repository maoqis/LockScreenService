package service.lock.com.lockservice;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

public class AndroidApp extends Application {
  @Override public void onCreate() {
    super.onCreate();
    Intent i = new Intent(this, ScreenService.class);
    i.putExtra("screen_state", true);
    this.startService(i);
    Log.d("SERVICE", "STARTED");
  }
}
