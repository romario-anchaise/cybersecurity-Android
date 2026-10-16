// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.core;

import F0.h;
import V0.p;
import W0.n;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PpVpn extends VpnService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3647c = p.a(new int[]{163, 54, 100, 35, 73});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3648d = PpVpn.class.getName().concat(".MODE");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile PpVpn f3649e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ParcelFileDescriptor f3650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f3651b;

    public static void b() {
        PpVpn ppVpn = f3649e;
        f3649e = null;
        if (ppVpn != null) {
            ParcelFileDescriptor parcelFileDescriptor = ppVpn.f3650a;
            ppVpn.f3650a = null;
            ppVpn.f3651b = 0;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (Throwable unused) {
                }
            }
            ppVpn.stopSelf();
        }
        Log.i(f3647c, "vpn stopped");
    }

    public final void a(VpnService.Builder builder) {
        String str = f3647c;
        ArrayList<String> arrayList = new ArrayList();
        try {
            Iterator<ResolveInfo> it = getPackageManager().queryIntentActivities(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 65536).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null) {
                    arrayList.add(activityInfo.packageName);
                }
            }
        } catch (Throwable th) {
            Log.w(str, "unknown-sources handler query failed", th);
        }
        List list = n.f825a;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : arrayList) {
            if (str2 != null) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty()) {
                    linkedHashSet.add(strTrim);
                }
            }
        }
        for (String str3 : n.f825a) {
            if (str3 != null) {
                String strTrim2 = str3.trim();
                if (!strTrim2.isEmpty()) {
                    linkedHashSet.add(strTrim2);
                }
            }
        }
        for (String str4 : Collections.unmodifiableList(new ArrayList(linkedHashSet))) {
            try {
                builder.addDisallowedApplication(str4);
                Log.i(str, "settings bypass package=" + str4);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        ParcelFileDescriptor parcelFileDescriptor = this.f3650a;
        this.f3650a = null;
        this.f3651b = 0;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (Throwable unused) {
            }
        }
        if (f3649e == this) {
            f3649e = null;
        }
        super.onDestroy();
    }

    @Override // android.net.VpnService
    public final void onRevoke() {
        ParcelFileDescriptor parcelFileDescriptor = this.f3650a;
        this.f3650a = null;
        this.f3651b = 0;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (Throwable unused) {
            }
        }
        stopSelf();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        int i4;
        f3649e = this;
        String stringExtra = intent == null ? null : intent.getStringExtra(f3648d);
        int[] iArrC = y.c(2);
        int length = iArrC.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i4 = 2;
                break;
            }
            i4 = iArrC[i5];
            if (h.a(i4).equals(stringExtra)) {
                break;
            }
            i5++;
        }
        if (this.f3650a != null && this.f3651b == i4) {
            return 2;
        }
        try {
            VpnService.Builder builderAddRoute = new VpnService.Builder(this).addAddress("10.99.0.1", 32).addRoute("0.0.0.0", 0);
            if (i4 == 1) {
                a(builderAddRoute);
            }
            ParcelFileDescriptor parcelFileDescriptorEstablish = builderAddRoute.establish();
            if (parcelFileDescriptorEstablish == null) {
                Log.w(f3647c, "vpn establish returned null mode=" + h.h(i4));
                return 2;
            }
            ParcelFileDescriptor parcelFileDescriptor = this.f3650a;
            this.f3650a = parcelFileDescriptorEstablish;
            this.f3651b = i4;
            f3649e = this;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (Throwable unused) {
                }
            }
            Log.i(f3647c, "vpn established mode=" + h.h(i4));
            return 2;
        } catch (Throwable th) {
            Log.w(f3647c, "vpn establish failed mode=".concat(h.h(i4)), th);
        }
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        b();
        super.onTaskRemoved(intent);
    }
}
