package service.lock.com.lockservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartServiceAtBootReceiver extends BroadcastReceiver {
  @Override public void onReceive(Context context, Intent intent) {
    Intent i = new Intent(context, ScreenService.class);
    i.putExtra("screen_state", false);
    context.startService(i);
  }
}
