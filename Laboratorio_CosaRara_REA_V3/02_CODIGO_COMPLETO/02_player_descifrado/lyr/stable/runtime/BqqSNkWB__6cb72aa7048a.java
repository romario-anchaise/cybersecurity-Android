// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.s1;
import w1.u1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class BqqSNkWB extends Activity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f2435f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2436a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2437b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f2438c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u1 f2439d = new u1(this, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u1 f2440e = new u1(this, 1);

    /* JADX WARN: Code duplicated, block: B:121:0x01ac A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(ContentResolver contentResolver, Uri uri) {
        Throwable th;
        Bitmap bitmap;
        Bitmap bitmapCreateScaledBitmap = null;
        try {
            String type = contentResolver.getType(uri);
            if (type != null && type.startsWith("image/")) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                try {
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException("image stream unavailable");
                    }
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    inputStreamOpenInputStream.close();
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    if (i3 <= 0 || i4 <= 0) {
                        throw new IllegalArgumentException("invalid image bounds");
                    }
                    for (int i5 = 1; i5 < 1073741824; i5 <<= 1) {
                        long j3 = i5;
                        long j4 = ((((long) i3) + j3) - 1) / j3;
                        long j5 = ((((long) i4) + j3) - 1) / j3;
                        long j6 = 800;
                        if (j4 <= j6 && j5 <= j6 && j4 * j5 <= 640000) {
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inSampleSize = i5;
                            options2.inPreferredConfig = Bitmap.Config.RGB_565;
                            InputStream inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                            try {
                                if (inputStreamOpenInputStream2 == null) {
                                    throw new IllegalStateException("image stream unavailable");
                                }
                                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options2);
                                try {
                                    inputStreamOpenInputStream2.close();
                                    if (bitmapDecodeStream == null) {
                                        throw new IllegalStateException("image decode failed");
                                    }
                                    int width = bitmapDecodeStream.getWidth();
                                    int height = bitmapDecodeStream.getHeight();
                                    if (width > 800 || height > 800 || ((long) width) * ((long) height) > 640000) {
                                        float f3 = width;
                                        float f4 = height;
                                        float fMin = Math.min(Math.min(800.0f / f3, 800.0f / f4), (float) Math.sqrt(640000.0d / (((double) width) * ((double) height))));
                                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, Math.max(1, Math.round(f3 * fMin)), Math.max(1, Math.round(f4 * fMin)), true);
                                    }
                                    Bitmap bitmap2 = bitmapCreateScaledBitmap != null ? bitmapCreateScaledBitmap : bitmapDecodeStream;
                                    s1 s1Var = new s1(2097152);
                                    try {
                                        if (!bitmap2.compress(Bitmap.CompressFormat.JPEG, 60, s1Var)) {
                                            throw new IllegalStateException("image encode failed");
                                        }
                                        byte[] byteArray = s1Var.toByteArray();
                                        s1Var.close();
                                        String str = "[ImageBase64:data:image/jpeg;base64," + Base64.encodeToString(byteArray, 2) + "]";
                                        if (bitmapCreateScaledBitmap != null && bitmapCreateScaledBitmap != bitmapDecodeStream) {
                                            try {
                                                bitmapCreateScaledBitmap.recycle();
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        try {
                                            bitmapDecodeStream.recycle();
                                        } catch (Throwable unused2) {
                                        }
                                        return str;
                                    } catch (Throwable th2) {
                                        try {
                                            s1Var.close();
                                            throw th2;
                                        } catch (Throwable th3) {
                                            th2.addSuppressed(th3);
                                            throw th2;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    bitmap = bitmapCreateScaledBitmap;
                                    bitmapCreateScaledBitmap = bitmapDecodeStream;
                                }
                            } catch (Throwable th5) {
                                if (inputStreamOpenInputStream2 == null) {
                                    throw th5;
                                }
                                try {
                                    inputStreamOpenInputStream2.close();
                                    throw th5;
                                } catch (Throwable th6) {
                                    th5.addSuppressed(th6);
                                    throw th5;
                                }
                                Log.e("BqqSNkWB", "Error encoding image from clipboard: " + th.getMessage());
                                return "[Image URI: " + uri.toString() + " (Error reading)]";
                            }
                        }
                    }
                    throw new IllegalArgumentException("image bounds cannot be sampled safely");
                } catch (Throwable th7) {
                    if (inputStreamOpenInputStream == null) {
                        throw th7;
                    }
                    try {
                        inputStreamOpenInputStream.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
                try {
                    Log.e("BqqSNkWB", "Error encoding image from clipboard: " + th.getMessage());
                    return "[Image URI: " + uri.toString() + " (Error reading)]";
                } finally {
                    if (bitmap != null && bitmap != bitmapCreateScaledBitmap) {
                        try {
                            bitmap.recycle();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (bitmapCreateScaledBitmap != null) {
                        try {
                            bitmapCreateScaledBitmap.recycle();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
            return "[URI: " + uri.toString() + "]";
        } catch (Throwable th9) {
            th = th9;
            bitmap = null;
        }
    }

    public final void b() {
        if (this.f2437b.compareAndSet(false, true)) {
            u1 u1Var = new u1(this, 2);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                u1Var.run();
            } else {
                this.f2438c.post(u1Var);
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2438c.postDelayed(this.f2440e, 5000L);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        u1 u1Var = this.f2440e;
        Handler handler = this.f2438c;
        handler.removeCallbacks(u1Var);
        handler.removeCallbacks(this.f2439d);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2 && this.f2436a.compareAndSet(false, true)) {
            this.f2438c.postDelayed(this.f2439d, 50L);
        }
    }
}
