// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import androidx.work.impl.WorkDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3451b;

    public /* synthetic */ a1(int i3, Object obj) {
        this.f3450a = i3;
        this.f3451b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        long j3;
        int iMax;
        ActivityInfo activityInfo;
        String str;
        String str2;
        int i3 = this.f3450a;
        Object obj = this.f3451b;
        switch (i3) {
            case 0:
                d1 d1Var = (d1) obj;
                for (int i4 = 0; i4 < 3; i4++) {
                    synchronized (d1Var.f3752a) {
                        j3 = d1Var.f3757f;
                        break;
                    }
                    e2.n1 n1Var = d1Var.f3753b;
                    n1Var.getClass();
                    HashMap map = new HashMap();
                    int i5 = Build.VERSION.SDK_INT;
                    PackageManager packageManager = (PackageManager) n1Var.f905c;
                    List<PackageInfo> installedPackages = i5 >= 33 ? packageManager.getInstalledPackages(PackageManager.PackageInfoFlags.of(512L)) : packageManager.getInstalledPackages(512);
                    if (installedPackages != null) {
                        for (PackageInfo packageInfo : installedPackages) {
                            if (packageInfo != null && (str2 = packageInfo.packageName) != null) {
                                map.put(str2, packageInfo);
                            }
                        }
                    }
                    Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(131072L)) : packageManager.queryIntentActivities(intent, 131072);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (listQueryIntentActivities != null) {
                        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                            if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null) {
                                String strA = d1.a(activityInfo.packageName, 255);
                                if (!strA.isEmpty() && !linkedHashMap.containsKey(strA)) {
                                    PackageInfo packageInfo2 = (PackageInfo) map.get(strA);
                                    ApplicationInfo applicationInfo = resolveInfo.activityInfo.applicationInfo;
                                    if (applicationInfo == null && packageInfo2 != null) {
                                        applicationInfo = packageInfo2.applicationInfo;
                                    }
                                    CharSequence charSequenceLoadLabel = resolveInfo.loadLabel(packageManager);
                                    String strA2 = d1.a(charSequenceLoadLabel == null ? strA : charSequenceLoadLabel.toString(), 256);
                                    linkedHashMap.put(strA, new e1(strA, strA2.isEmpty() ? strA : strA2, ((applicationInfo == null ? 0 : applicationInfo.flags) & 129) != 0, resolveInfo.activityInfo.enabled && (applicationInfo == null || applicationInfo.enabled), true, (packageInfo2 == null || (str = packageInfo2.versionName) == null) ? "" : d1.a(str, 128)));
                                }
                            }
                        }
                    }
                    ArrayList arrayList = new ArrayList(linkedHashMap.values());
                    arrayList.sort(Comparator.comparing(new d2.i(3)).thenComparing(new d2.i(4)));
                    int size = arrayList.size();
                    boolean z2 = size > 1024;
                    ArrayList arrayList2 = z2 ? new ArrayList(arrayList.subList(0, 1024)) : arrayList;
                    try {
                        ChangedPackages changedPackages = packageManager.getChangedPackages(0);
                        iMax = changedPackages != null ? Math.max(0, changedPackages.getSequenceNumber()) : 0;
                        break;
                    } catch (RuntimeException unused) {
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    int iMax2 = Math.max(arrayList2.size(), size);
                    boolean z3 = z2 || iMax2 > arrayList2.size();
                    int iMax3 = Math.max(0, iMax);
                    long jMax = Math.max(0L, jElapsedRealtime);
                    d1Var.f3755d.getClass();
                    c1 c1Var = new c1(j3, System.currentTimeMillis(), iMax2, z3, arrayList2, iMax3, jMax);
                    synchronized (d1Var.f3752a) {
                        try {
                            if (d1Var.f3757f == j3) {
                                d1Var.f3754c.i(c1Var);
                                d1Var.f3758g = c1Var;
                                return c1Var;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                o2.l("launcher inventory changed during refresh");
                return null;
            default:
                WorkDatabase workDatabase = ((z.f) obj).f6244a;
                Long lG = workDatabase.l().g("next_alarm_manager_id");
                int iLongValue = lG != null ? (int) lG.longValue() : 0;
                workDatabase.l().h(new y.d("next_alarm_manager_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                return Integer.valueOf(iLongValue);
        }
    }
}
