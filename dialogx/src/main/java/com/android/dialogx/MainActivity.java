package com.android.dialogx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.dialogs.BottomMenu;
import com.kongzue.dialogx.dialogs.FullScreenDialog;
import com.kongzue.dialogx.dialogs.MessageDialog;
import com.kongzue.dialogx.dialogs.PopTip;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.DialogXStyle.PopTipSettings.ALIGN;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialogx.interfaces.OnIconChangeCallBack;
import com.kongzue.dialogx.interfaces.OnMenuItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DialogX.init(this);
        findViewById(R.id.messageDialog_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                MessageDialog.build()
//                        .setStyle(IOSStyle.style())
//                        .setTheme(DialogX.THEME.DARK)
//                        .setTitle("标题")
//                        .setMessage("内容")
//                        .setOkButton("确定")
//                        .show();

                MessageDialog.show("标题", "正文内容", "确定").setOkButton(new OnDialogButtonClickListener<MessageDialog>() {
                    @Override
                    public boolean onClick(MessageDialog baseDialog, View v) {
                        Toast.makeText(MainActivity.this, "https://github.com/kongzue/DialogX", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

            }
        });

        findViewById(R.id.waitDialog_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WaitDialog.show("正在加载...", 1f);
            }
        });

        findViewById(R.id.bottomDialog_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomMenu.show(new String[]{"添加", "查看", "编辑", "删除"})
                        .setOnIconChangeCallBack(new OnIconChangeCallBack(true) {
                            @Override
                            public int getIcon(BottomMenu bottomMenu, int index, String menuText) {
                                switch (menuText) {
                                    case "添加":
                                        return R.mipmap.ic_launcher;
                                    case "查看":
                                        return R.mipmap.ic_launcher;
                                    case "编辑":
                                        return R.mipmap.ic_launcher;
                                    case "删除":
                                        return R.mipmap.ic_launcher;
                                }
                                return 0;
                            }
                        })
                        .setOnMenuItemClickListener(new OnMenuItemClickListener<BottomMenu>() {
                            @Override
                            public boolean onClick(BottomMenu dialog, CharSequence text, int index) {
                                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        });
            }
        });

        findViewById(R.id.topTipDialog_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopTip.show(R.drawable.ic_launcher_foreground, "邮件已发送", "撤回").setAlign(ALIGN.TOP).getExitAnimDuration();
            }
        });

        findViewById(R.id.fullScreenDialog_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FullScreenDialog.show(new OnBindView<FullScreenDialog>(R.layout.dialog) {
                    @Override
                    public void onBind(FullScreenDialog dialog, View v) {
                        //...
                    }
                });
            }
        });


    }
}