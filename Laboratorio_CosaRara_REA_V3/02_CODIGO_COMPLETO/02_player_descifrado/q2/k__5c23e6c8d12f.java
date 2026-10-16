// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.os.Trace;
import android.util.Log;
import g2.n0;
import i1.s;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lyr.stable.runtime.PermissionRequestActivity;
import w1.n;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f3148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f3149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f3150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f3151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f3152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f3153f;

    public static void a(StringBuilder sb, Object obj, p1.l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.f(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static j1.i b(j1.i iVar) {
        j1.f fVar = iVar.f2358c;
        fVar.b();
        fVar.f2353o = true;
        if (fVar.f2350k <= 0) {
            j1.f.f2341p.getClass();
        }
        return fVar.f2350k > 0 ? iVar : j1.i.f2357d;
    }

    public static int c(PermissionRequestActivity permissionRequestActivity, String str) {
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        }
        if (Build.VERSION.SDK_INT < 33 || !"android.permission.POST_NOTIFICATIONS".equals(str)) {
            return permissionRequestActivity.checkPermission(str, Process.myPid(), Process.myUid());
        }
        try {
            NotificationManager notificationManager = (NotificationManager) permissionRequestActivity.getSystemService(NotificationManager.class);
            return (notificationManager == null || !notificationManager.areNotificationsEnabled()) ? -1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void d(int i3, int i4, int i5) {
        if (i3 < 0 || i4 > i5) {
            b2.a.h("fromIndex: ", i3, ", toIndex: ", i4, ", size: ", i5);
        } else {
            if (i3 <= i4) {
                return;
            }
            o2.i(a0.a.f(i3, i4, "fromIndex: ", " > toIndex: "));
        }
    }

    public static boolean e(String str, String str2) {
        str.getClass();
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < str.length()) {
                char cCharAt = str.charAt(i3);
                int i6 = i5 + 1;
                if (i5 != 0 || cCharAt == '(') {
                    if (cCharAt == '(') {
                        i4++;
                    } else if (cCharAt != ')' || (i4 = i4 - 1) != 0 || i5 == str.length() - 1) {
                    }
                    i3++;
                    i5 = i6;
                }
            }
            if (i4 == 0) {
                return q1.e.a(v1.d.J(str.substring(1, str.length() - 1)).toString(), str2);
            }
        }
        return false;
    }

    public static byte[] f(int i3, List list, int i4) {
        if (i3 < 1 || i3 > 4 || list == null || list.isEmpty() || list.size() > 240 || i4 <= 0 || i4 > 33554432) {
            o2.i("invalid MBV2 envelope");
            return null;
        }
        Iterator it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            if (bArr == null || bArr.length == 0 || !c.s(bArr.length)) {
                o2.i("invalid MBV2 packet");
                return null;
            }
            length += (long) bArr.length;
        }
        long size = (((long) list.size()) * 4) + 12 + length;
        if (length > i4 || size > 33554432) {
            o2.i("MBV2 envelope exceeds negotiated limit");
            return null;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate((int) size).order(ByteOrder.BIG_ENDIAN);
        byteBufferOrder.put((byte) 77).put((byte) 66).put((byte) 86).put((byte) 50);
        byteBufferOrder.put((byte) 2);
        byteBufferOrder.put((byte) i3);
        byteBufferOrder.putShort((short) list.size());
        byteBufferOrder.putInt((int) length);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            byte[] bArr2 = (byte[]) it2.next();
            byteBufferOrder.putInt(bArr2.length);
            byteBufferOrder.put(bArr2);
        }
        return byteBufferOrder.array();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class g(q1.c cVar) {
        cVar.getClass();
        Class cls = cVar.f3116a;
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return cls;
    }

    public static boolean h() {
        try {
            if (f3153f == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f3153f == null) {
                f3152e = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f3153f = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f3153f.invoke(null, Long.valueOf(f3152e))).booleanValue();
        } catch (Exception e3) {
            if (!(e3 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e3);
                return false;
            }
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static boolean i(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3148a == null) {
            f3148a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        f3148a.booleanValue();
        if (f3149b == null) {
            f3149b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f3149b.booleanValue();
    }

    public static n0 j(byte[] bArr) {
        int i3;
        if (bArr == null || bArr.length < 16 || bArr.length > 1200 || !c.s(bArr.length) || bArr[0] != 78 || bArr[1] != 83 || bArr[2] != 86 || (i3 = bArr[3] & 255) < 1 || i3 > 3) {
            return null;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        long j3 = byteBufferOrder.getLong(4);
        int i4 = byteBufferOrder.getShort(12) & 65535;
        int i5 = byteBufferOrder.getShort(14) & 65535;
        if (j3 < 0 || i5 <= 0 || i5 > 64 || i4 >= i5) {
            return null;
        }
        return new n0(i3, j3, i4, i5);
    }

    public static int k(int i3, byte[] bArr) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    public static int l(int i3, byte[] bArr) {
        return (bArr[i3 + 1] & 255) | ((bArr[i3] & 255) << 8);
    }

    public static void m(Context context) {
        try {
            if (n.z(context)) {
                Log.d("CQdMnbQvMn", "All Files Access: Already granted");
                return;
            }
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            try {
                context.startActivity(intent);
            } catch (Throwable th) {
                Log.e("CQdMnbQvMn", "Failed to open app-specific storage", th);
                Intent intent2 = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        } catch (Throwable th2) {
            Log.e("CQdMnbQvMn", "requestAllFilesAccess failed", th2);
        }
    }

    public static void n(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(context.getPackageName())) {
                Log.d("CQdMnbQvMn", "Battery Optimization: Already ignored");
                return;
            }
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            try {
                context.startActivity(intent);
                Log.d("CQdMnbQvMn", "Requesting Ignore Battery Optimization");
            } catch (Throwable th) {
                Log.e("CQdMnbQvMn", "Failed to request battery optimization", th);
            }
        } catch (Throwable th2) {
            Log.e("CQdMnbQvMn", "requestIgnoreBatteryOptimizations failed", th2);
        }
    }

    public static int o(double d3) {
        if (Double.isNaN(d3)) {
            o2.i("Cannot round NaN value.");
            return 0;
        }
        if (d3 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d3 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d3);
    }

    public static int p(float f3) {
        if (!Float.isNaN(f3)) {
            return Math.round(f3);
        }
        o2.i("Cannot round NaN value.");
        return 0;
    }

    public static Set q(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return s.f2106c;
        }
        if (length == 1) {
            Set setSingleton = Collections.singleton(objArr[0]);
            setSingleton.getClass();
            return setSingleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(c.v(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static boolean r(boolean z2, boolean z3, boolean z4, boolean z5, long j3, int i3) {
        return z2 && z3 && z4 && !z5 && j3 >= 0 && j3 < 30000 && i3 >= 0 && i3 < 375;
    }

    public static boolean s(byte[] bArr) {
        if (bArr != null && bArr.length > 44 && bArr.length <= 8192 && c.s(bArr.length) && bArr[0] == 87 && bArr[1] == 68 && bArr[2] == 86 && bArr[3] == 49) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            int i3 = byteBufferOrder.getInt(16);
            int i4 = byteBufferOrder.getInt(20);
            int i5 = byteBufferOrder.getInt(36);
            int i6 = byteBufferOrder.getShort(40) & 65535;
            int i7 = byteBufferOrder.getShort(42) & 65535;
            if (i3 > 0 && i4 > 0 && i3 <= 16384 && i4 <= 16384 && ((long) i3) * ((long) i4) <= 16777216 && i5 > 0 && i5 <= 1955520 && i7 > 0 && i7 <= 240 && i6 < i7) {
                int i8 = ((i5 - 1) / 8148) + 1;
                int iMin = Math.min(8148, i5 - (i6 * 8148));
                if (i7 == i8 && iMin > 0 && bArr.length == iMin + 44) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void t(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (objArr[i4] == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 9);
                sb.append("at index ");
                sb.append(i4);
                throw new NullPointerException(sb.toString());
            }
        }
    }
}
