package service.lock.com.lockservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LandingActivity extends AppCompatActivity {
  private static final String TAG = "LandingActivity";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
//        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
//        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    setShowWhenLocked(true);
    setTurnScreenOn(true);

    setContentView(R.layout.activity_landing);


  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);


  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop() called "+this.isDestroyed());
  }

  @Override
  protected void onDestroy() {
    Log.d(TAG, "onDestroy() called "+this.isDestroyed());
    super.onDestroy();
    Log.d(TAG, "onDestroy() called"+this.isDestroyed());
  }
}
