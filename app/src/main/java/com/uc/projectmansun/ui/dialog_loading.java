package com.uc.projectmansun.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.uc.projectmansun.R;

public class dialog_loading {

    public dialog_loading(){}

    public static final Dialog loading (Context context){
        final Dialog dialog = new Dialog(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View loadingdialog = layoutInflater.inflate(R.layout.loading_dialog, null);
        dialog.setContentView(loadingdialog);
        dialog.setCancelable(false);
        return dialog;
    }
}
