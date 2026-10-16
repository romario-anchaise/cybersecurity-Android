// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Base64;
import android.util.LruCache;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.NotificationListener;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w7 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f5400h = {78, 79, 84, 49};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5401a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f5403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f5404d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f5402b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f5405e = ConcurrentHashMap.newKeySet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LruCache f5406f = new LruCache(256);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LruCache f5407g = new LruCache(512);

    public w7(ScreenMirrorService screenMirrorService) {
        this.f5401a = screenMirrorService.getApplicationContext();
    }

    public static String a(w7 w7Var, String str) {
        LruCache lruCache = w7Var.f5406f;
        if (str == null) {
            return null;
        }
        String str2 = (String) lruCache.get(str);
        if (str2 != null) {
            return str2;
        }
        try {
            Drawable applicationIcon = w7Var.f5401a.getPackageManager().getApplicationIcon(str);
            if (applicationIcon == null) {
                return null;
            }
            int intrinsicWidth = applicationIcon.getIntrinsicWidth();
            int intrinsicHeight = applicationIcon.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                intrinsicWidth = 96;
                intrinsicHeight = 96;
            }
            if (intrinsicWidth > 96 || intrinsicHeight > 96) {
                float fMax = 96 / Math.max(intrinsicWidth, intrinsicHeight);
                intrinsicWidth = Math.max(1, (int) (intrinsicWidth * fMax));
                intrinsicHeight = Math.max(1, (int) (intrinsicHeight * fMax));
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            applicationIcon.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            applicationIcon.draw(canvas);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            bitmapCreateBitmap.recycle();
            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            lruCache.put(str, strEncodeToString);
            return strEncodeToString;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Bundle bundle, String str) {
        Object obj;
        CharSequence charSequence = bundle.getCharSequence(str);
        if (charSequence == null && (obj = bundle.get(str)) != null) {
            charSequence = obj.toString();
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static byte[] c(byte b3, JSONObject jSONObject) {
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        return ByteBuffer.allocate(9 + bytes.length).put(f5400h).put(b3).putInt(bytes.length).put(bytes).array();
    }

    public final boolean d() {
        Context context = this.f5401a;
        try {
            String packageName = context.getPackageName();
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
            if (string == null) {
                return false;
            }
            String[] strArrSplit = string.split(":");
            String name = NotificationListener.class.getName();
            for (String str : strArrSplit) {
                if (str != null) {
                    if (str.contains(packageName) && str.contains(name)) {
                        return true;
                    }
                    if (str.startsWith(packageName + "/")) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final synchronized void e() {
        if (this.f5402b.get()) {
            return;
        }
        this.f5402b.set(true);
        HandlerThread handlerThread = new HandlerThread("notif-worker");
        this.f5403c = handlerThread;
        handlerThread.start();
        this.f5404d = new Handler(this.f5403c.getLooper());
        NotificationListener notificationListenerC = NotificationListener.c();
        if (notificationListenerC != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = notificationListenerC.f2459a;
            if (!copyOnWriteArrayList.contains(this)) {
                copyOnWriteArrayList.add(this);
            }
        }
    }

    public final synchronized void f() {
        try {
            this.f5402b.set(false);
            NotificationListener notificationListenerC = NotificationListener.c();
            if (notificationListenerC != null) {
                notificationListenerC.f2459a.remove(this);
            }
            Iterator it = this.f5405e.iterator();
            while (it.hasNext()) {
                ((v7) it.next()).a();
            }
            this.f5405e.clear();
            HandlerThread handlerThread = this.f5403c;
            if (handlerThread != null) {
                try {
                    handlerThread.quitSafely();
                } catch (Exception unused) {
                }
                this.f5403c = null;
                this.f5404d = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
