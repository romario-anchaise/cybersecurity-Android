// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package com.google.android.gms.common.api;

import a0.a;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import e0.b;
import g0.c;
import h0.o;
import p0.e;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f468b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f469a = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (i3 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f469a = 0;
            setResult(i4, intent);
            if (booleanExtra) {
                c cVarD = c.d(this);
                if (i4 == -1) {
                    e eVar = cVarD.f1450m;
                    eVar.sendMessage(eVar.obtainMessage(3));
                } else if (i4 == 0) {
                    cVarD.e(new b(13, null, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i3 == 2) {
            this.f469a = 0;
            setResult(i4, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f469a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f469a = bundle.getInt("resolution");
        }
        if (this.f469a == 1) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent == null) {
            o.c(num);
            e0.e.f671d.d(this, num.intValue(), this);
            this.f469a = 1;
            return;
        }
        try {
            googleApiActivity = this;
            try {
                googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                googleApiActivity.f469a = 1;
            } catch (ActivityNotFoundException e3) {
                e = e3;
                ActivityNotFoundException activityNotFoundException = e;
                if (extras.getBoolean("notify_manager", true)) {
                    c.d(googleApiActivity).e(new b(22, null, null), googleApiActivity.getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String strH = a.h("Activity not found while launching ", pendingIntent.toString(), ".");
                    if (Build.FINGERPRINT.contains("generic")) {
                        strH = strH.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", strH, activityNotFoundException);
                }
                googleApiActivity.f469a = 1;
                googleApiActivity.finish();
            } catch (IntentSender.SendIntentException e4) {
                e = e4;
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                googleApiActivity.finish();
            }
        } catch (ActivityNotFoundException e5) {
            e = e5;
            googleApiActivity = this;
        } catch (IntentSender.SendIntentException e6) {
            e = e6;
            googleApiActivity = this;
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f469a);
        super.onSaveInstanceState(bundle);
    }
}
