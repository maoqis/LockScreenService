package service.lock.com.lockservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
      Intent i = new Intent(context, ScreenService.class);
      i.putExtra("screen_state", true);
      context.startService(i);
      Log.d("SERVICE", "SCREEN_ON");
    }
  }
}
