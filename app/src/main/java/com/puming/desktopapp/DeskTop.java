package com.puming.desktopapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by puming on 2016/2/1.
 */
public class DeskTop extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        //刷新widget时执行
//        RemoteViews  remoteViews=new RemoteViews(context.getPackageName(),R.layout.widget);
//        remoteViews.setImageViewResource(1,R.mipmap.ic_launcher);
//        ComponentName componentName=new ComponentName(context,DeskTop.class);
//        appWidgetManager.updateAppWidget(componentName,remoteViews);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        //widget从屏幕移除时执行
        context.stopService(new Intent(context,TimerService.class));
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        //widget添加到屏幕时执行
        context.startService(new Intent(context,TimerService.class));
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
}
