// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import C.h;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;
import p028p0.a;

/* JADX INFO: loaded from: classes.dex */
public final class v extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2523c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ z f2524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2525e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(z zVar, h hVar) {
        super(zVar);
        this.f2524d = zVar;
        this.f2525e = hVar;
    }

    @Override // p009f.w
    public final IntentFilter d() {
        switch (this.f2523c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // p009f.w
    public final int e() {
        Location location;
        boolean z2;
        long j2;
        Location lastKnownLocation;
        switch (this.f2523c) {
            case 0:
                return ((PowerManager) this.f2525e).isPowerSaveMode() ? 2 : 1;
            default:
                h hVar = (h) this.f2525e;
                M m2 = (M) hVar.f113c;
                if (m2.f2429b <= System.currentTimeMillis()) {
                    Context context = (Context) hVar.f111a;
                    int iB = a.b(context, "android.permission.ACCESS_COARSE_LOCATION");
                    Location lastKnownLocation2 = null;
                    LocationManager locationManager = (LocationManager) hVar.f112b;
                    if (iB == 0) {
                        try {
                            lastKnownLocation = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        } catch (Exception e2) {
                            Log.d("TwilightManager", "Failed to get last known location", e2);
                        }
                        location = lastKnownLocation;
                    } else {
                        location = null;
                    }
                    if (a.b(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation2 = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e3) {
                            Log.d("TwilightManager", "Failed to get last known location", e3);
                        }
                    }
                    if (lastKnownLocation2 == null || location == null ? lastKnownLocation2 != null : lastKnownLocation2.getTime() > location.getTime()) {
                        location = lastKnownLocation2;
                    }
                    z2 = false;
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (L.f2424d == null) {
                            L.f2424d = new L();
                        }
                        L l2 = L.f2424d;
                        l2.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        l2.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        z2 = l2.f2427c == 1;
                        long j3 = l2.f2426b;
                        long j4 = l2.f2425a;
                        l2.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                        long j5 = l2.f2426b;
                        if (j3 == -1 || j4 == -1) {
                            j2 = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis <= j4) {
                                j5 = jCurrentTimeMillis > j3 ? j4 : j3;
                            }
                            j2 = j5 + 60000;
                        }
                        m2.f2428a = z2;
                        m2.f2429b = j2;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i2 = Calendar.getInstance().get(11);
                        if (i2 < 6 || i2 >= 22) {
                            z2 = true;
                        }
                    }
                    break;
                } else {
                    z2 = m2.f2428a;
                }
                return z2 ? 2 : 1;
        }
    }

    @Override // p009f.w
    public final void g() throws IllegalAccessException {
        switch (this.f2523c) {
            case 0:
                this.f2524d.o(true, true);
                break;
            default:
                this.f2524d.o(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(z zVar, Context context) {
        super(zVar);
        this.f2524d = zVar;
        this.f2525e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
