package com.android.dialogx;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.kongzue.dialogx.dialogs.MessageDialog;
import com.kongzue.dialogx.interfaces.OnDialogButtonClickListener;

/**
 * @Author Zach on 2021/12/8 14:18
 */

public class MessageDialogX {

    public void showDialog(Context context) {
        MessageDialog.show("标题", "正文内容", "确定").setOkButton(new OnDialogButtonClickListener<MessageDialog>() {
            @Override
            public boolean onClick(MessageDialog baseDialog, View v) {
                Toast.makeText(context, "https://github.com/kongzue/DialogX", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
