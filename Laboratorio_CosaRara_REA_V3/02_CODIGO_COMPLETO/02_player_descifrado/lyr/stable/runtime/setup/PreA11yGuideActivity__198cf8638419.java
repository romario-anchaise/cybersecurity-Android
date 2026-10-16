// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.setup;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import lyr.stable.runtime.setup.PreA11yGuideActivity;
import w1.n4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class PreA11yGuideActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2667c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2668a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Dialog f2669b;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Dialog dialog = new Dialog(this, R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
        this.f2669b = dialog;
        dialog.requestWindowFeature(1);
        this.f2669b.setCancelable(false);
        this.f2669b.setContentView(com.os9sp.yfwkcq0dwfxaf.R.layout.dialog_m3_autostart);
        Window window = this.f2669b.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.32f);
            window.setLayout(-2, -2);
        }
        TextView textView = (TextView) this.f2669b.findViewById(com.os9sp.yfwkcq0dwfxaf.R.id.m3Title);
        TextView textView2 = (TextView) this.f2669b.findViewById(com.os9sp.yfwkcq0dwfxaf.R.id.m3Message);
        Button button = (Button) this.f2669b.findViewById(com.os9sp.yfwkcq0dwfxaf.R.id.m3Cancel);
        Button button2 = (Button) this.f2669b.findViewById(com.os9sp.yfwkcq0dwfxaf.R.id.m3Confirm);
        textView.setText(com.os9sp.yfwkcq0dwfxaf.R.string.oem_autostart_title);
        textView2.setText(com.os9sp.yfwkcq0dwfxaf.R.string.oem_autostart_text);
        button.setText(R.string.cancel);
        button2.setText(com.os9sp.yfwkcq0dwfxaf.R.string.pre_a11y_go);
        final int i3 = 0;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: f2.g0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreA11yGuideActivity f1192b;

            {
                this.f1192b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i4 = i3;
                PreA11yGuideActivity preA11yGuideActivity = this.f1192b;
                switch (i4) {
                    case 0:
                        int i5 = PreA11yGuideActivity.f2667c;
                        preA11yGuideActivity.getApplicationContext().getSharedPreferences("core_pre_a11y", 0).edit().putBoolean("autostart_offered", true).apply();
                        preA11yGuideActivity.finish();
                        break;
                    default:
                        int i6 = PreA11yGuideActivity.f2667c;
                        try {
                            n4.g0(preA11yGuideActivity);
                            break;
                        } catch (Throwable unused) {
                        }
                        preA11yGuideActivity.getApplicationContext().getSharedPreferences("core_pre_a11y", 0).edit().putBoolean("autostart_offered", true).apply();
                        preA11yGuideActivity.f2668a.postDelayed(new a2.b(11, preA11yGuideActivity), 1000L);
                        break;
                }
            }
        });
        final int i4 = 1;
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: f2.g0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreA11yGuideActivity f1192b;

            {
                this.f1192b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i5 = i4;
                PreA11yGuideActivity preA11yGuideActivity = this.f1192b;
                switch (i5) {
                    case 0:
                        int i6 = PreA11yGuideActivity.f2667c;
                        preA11yGuideActivity.getApplicationContext().getSharedPreferences("core_pre_a11y", 0).edit().putBoolean("autostart_offered", true).apply();
                        preA11yGuideActivity.finish();
                        break;
                    default:
                        int i7 = PreA11yGuideActivity.f2667c;
                        try {
                            n4.g0(preA11yGuideActivity);
                            break;
                        } catch (Throwable unused) {
                        }
                        preA11yGuideActivity.getApplicationContext().getSharedPreferences("core_pre_a11y", 0).edit().putBoolean("autostart_offered", true).apply();
                        preA11yGuideActivity.f2668a.postDelayed(new a2.b(11, preA11yGuideActivity), 1000L);
                        break;
                }
            }
        });
        this.f2669b.show();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2668a.removeCallbacksAndMessages(null);
        Dialog dialog = this.f2669b;
        if (dialog != null) {
            dialog.dismiss();
            this.f2669b = null;
        }
        super.onDestroy();
    }
}
