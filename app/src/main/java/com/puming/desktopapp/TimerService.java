package com.puming.desktopapp;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {

    private Timer timer;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TimerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateView();
            }
        }, 0, 1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer = null;
        }
    }

    private void updateView() {
        String time = this.format.format(new Date());
        RemoteViews remoteViews=new RemoteViews(getApplicationContext().getPackageName(),R.layout.widget);
        remoteViews.setImageViewResource(1,R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.tv_time,time);
        ComponentName componentName=new ComponentName(getApplicationContext(),DeskTop.class);
        AppWidgetManager widgetManager=AppWidgetManager.getInstance(getApplicationContext());
        widgetManager.updateAppWidget(componentName,remoteViews);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
