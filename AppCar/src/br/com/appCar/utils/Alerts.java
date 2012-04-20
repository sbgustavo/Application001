package br.com.appCar.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class Alerts {

    public Alerts() {
    }

    private AlertDialog alert;

    public void showAlerta(String message, Context ctx) {

        alert = new AlertDialog.Builder(ctx).create();
        alert.setTitle("Location");
        alert.setButton("OK", new DialogInterface.OnClickListener() {
            //@Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        alert.setMessage(message);
        alert.show();
    }

    public void AlertAbout(Context ctx, String title, String message) {

        Dialog dialog = new Dialog(ctx);

        //TODO: REFAZER
//        dialog.setContentView(R.layout.about_dialog);
//        dialog.setTitle(title);
//
//        TextView text = (TextView) dialog.findViewById(R.id.text);
//        text.setText(message);
//        ImageView image = (ImageView) dialog.findViewById(R.id.image1);
//        image.setImageResource(R.drawable.android);

        dialog.show();
    }

}
