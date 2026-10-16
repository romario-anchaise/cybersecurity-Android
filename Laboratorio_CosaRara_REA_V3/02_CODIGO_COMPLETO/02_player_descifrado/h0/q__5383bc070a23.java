// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f1922a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    public static Intent a(Context context, x xVar) {
        Bundle bundleCall;
        String str = xVar.f1935a;
        Intent intent = null;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (xVar.f1937c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f1922a);
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
                try {
                    bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle);
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    if (bundleCall != null) {
                        Intent intent2 = (Intent) bundleCall.getParcelable("serviceResponseIntentKey");
                        if (intent2 != null) {
                            intent = intent2;
                        } else {
                            PendingIntent pendingIntent = (PendingIntent) bundleCall.getParcelable("serviceMissingResolutionIntentKey");
                            if (pendingIntent != null) {
                                StringBuilder sb = new StringBuilder(str.length() + 72);
                                sb.append("Dynamic lookup for intent failed for action ");
                                sb.append(str);
                                sb.append(" but has possible resolution");
                                Log.w("ServiceBindIntentUtils", sb.toString());
                                throw new p(new e0.b(25, pendingIntent, null));
                            }
                        }
                    }
                    if (intent == null) {
                        Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action: ".concat(str));
                    }
                } catch (Throwable th) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    throw th;
                }
            } catch (RemoteException | IllegalArgumentException e3) {
                Log.w("ServiceBindIntentUtils", "Dynamic intent resolution failed: ".concat(e3.toString()));
                bundleCall = null;
            }
        }
        return intent == null ? new Intent(str).setPackage(xVar.f1936b) : intent;
    }
}
