// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f1909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1910c;

    public /* synthetic */ l(Intent intent, Object obj, int i3) {
        this.f1908a = i3;
        this.f1909b = intent;
        this.f1910c = obj;
    }

    public final void a() {
        switch (this.f1908a) {
            case 0:
                Intent intent = this.f1909b;
                if (intent != null) {
                    ((GoogleApiActivity) this.f1910c).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.f1909b;
                if (intent2 != null) {
                    ((g0.w) this.f1910c).startActivityForResult(intent2, 2);
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e3) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e3);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
