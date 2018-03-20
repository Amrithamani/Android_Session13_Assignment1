package com.amritha.acadgild.android_session13_assignment1;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    //setting the custom BroadCast Receiver

    private static final String SHOW_POPUP_DIALOG_ACTION = "com.amritha.acadgild.android_session13_assignment1.showpopupdialog";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);//setting the text
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Create an intent that when received will launch the PopUpActivity using Pending Intent

        Intent intent = new Intent(context, NewAppWidget.class);

        intent.setAction(SHOW_POPUP_DIALOG_ACTION);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Now, when the widget is pressed the pendingIntent will be sent
        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // If the intent is the one that we've defined to launch the pop up dialog

        // then create and launch the PopUpActivity

        if (intent.getAction().equals(SHOW_POPUP_DIALOG_ACTION)) {


            Intent popUpIntent = new Intent(context, PopUpActivity.class);

            popUpIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(popUpIntent);

        }

        super.onReceive(context, intent);
    }

}

