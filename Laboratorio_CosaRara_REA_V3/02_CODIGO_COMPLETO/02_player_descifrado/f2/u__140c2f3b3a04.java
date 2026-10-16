// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;
import w1.ma;
import w1.rd;
import w1.sf;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1331c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f1333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f1334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1336h;

    public /* synthetic */ u(ScreenMirrorService screenMirrorService, WebView webView, int i3, boolean z2, long j3) {
        this.f1335g = screenMirrorService;
        this.f1336h = webView;
        this.f1332d = i3;
        this.f1334f = z2;
        this.f1333e = j3;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:46:0x009b  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c2 A[Catch: all -> 0x00cd, TryCatch #5 {all -> 0x00cd, blocks: (B:51:0x00b4, B:53:0x00c2, B:55:0x00c8), top: B:84:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f2 A[Catch: all -> 0x013d, TryCatch #6 {all -> 0x013d, blocks: (B:62:0x00e3, B:65:0x00f2, B:67:0x00f6, B:69:0x00ff, B:71:0x0129, B:70:0x0106), top: B:86:0x00e3 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f6 A[Catch: all -> 0x013d, TryCatch #6 {all -> 0x013d, blocks: (B:62:0x00e3, B:65:0x00f2, B:67:0x00f6, B:69:0x00ff, B:71:0x0129, B:70:0x0106), top: B:86:0x00e3 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0106 A[Catch: all -> 0x013d, TryCatch #6 {all -> 0x013d, blocks: (B:62:0x00e3, B:65:0x00f2, B:67:0x00f6, B:69:0x00ff, B:71:0x0129, B:70:0x0106), top: B:86:0x00e3 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:? A[Catch: all -> 0x008b, SYNTHETIC, TRY_LEAVE, TryCatch #4 {all -> 0x008b, blocks: (B:17:0x0044, B:28:0x0070, B:42:0x008a, B:41:0x0087, B:18:0x004c, B:27:0x006d, B:36:0x007f, B:35:0x007c, B:32:0x0077, B:20:0x0053, B:21:0x0055, B:23:0x005b, B:26:0x0062, B:38:0x0082), top: B:83:0x0044, inners: #0, #2 }] */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String string;
        String strEncodeToString;
        CharSequence applicationLabel;
        Drawable drawableLoadIcon;
        Bitmap bitmap;
        int i3 = this.f1331c;
        Object obj = this.f1336h;
        Object obj2 = this.f1335g;
        switch (i3) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) obj2;
                WebView webView = (WebView) obj;
                String str2 = this.f1334f ? "6c0522e44b.html" : "3382533eab.html";
                try {
                    InputStream inputStreamOpen = screenMirrorService.getAssets().open(str2);
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i4 = inputStreamOpen.read(bArr);
                                if (i4 <= 0) {
                                    str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                                    byteArrayOutputStream.close();
                                    inputStreamOpen.close();
                                    if (str == null) {
                                        Log.w("BindShield", "f5 missing asset ".concat(str2));
                                        return;
                                    }
                                    String language = Locale.getDefault().getLanguage();
                                    string = t9.f5177h;
                                    strEncodeToString = "";
                                    if (string != null || string.trim().isEmpty()) {
                                        try {
                                            applicationLabel = screenMirrorService.getPackageManager().getApplicationLabel(screenMirrorService.getApplicationInfo());
                                            if (applicationLabel == null && applicationLabel.length() > 0) {
                                                string = applicationLabel.toString();
                                            } else {
                                                try {
                                                } catch (Throwable unused) {
                                                    string = "";
                                                }
                                            }
                                            break;
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    String strReplace = str.replace("APPNAME", string).replace("[LNG]", language);
                                    try {
                                        drawableLoadIcon = screenMirrorService.getApplicationInfo().loadIcon(screenMirrorService.getPackageManager());
                                        if (drawableLoadIcon != null) {
                                            if ((drawableLoadIcon instanceof BitmapDrawable) || ((BitmapDrawable) drawableLoadIcon).getBitmap() == null) {
                                                int iMax = Math.max(1, drawableLoadIcon.getIntrinsicWidth());
                                                int iMax2 = Math.max(1, drawableLoadIcon.getIntrinsicHeight());
                                                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                                                Canvas canvas = new Canvas(bitmapCreateBitmap);
                                                drawableLoadIcon.setBounds(0, 0, iMax, iMax2);
                                                drawableLoadIcon.draw(canvas);
                                                bitmap = bitmapCreateBitmap;
                                            } else {
                                                bitmap = ((BitmapDrawable) drawableLoadIcon).getBitmap();
                                            }
                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                                            strEncodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
                                            break;
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                    String strReplace2 = strReplace.replace("[BASE-ICO]", strEncodeToString).replace("[LAUNCHER_MS]", String.valueOf(45000L)).replace("[SCAN_MS]", String.valueOf(45000L)).replace("[SCAN_SEC]", "45").replace("[ELAPSED_MS]", String.valueOf(Math.max(0L, this.f1333e)));
                                    Charset charset = StandardCharsets.UTF_8;
                                    w.f1338a.post(new g(this.f1332d, webView, new String(Base64.decode(Base64.encodeToString(strReplace2.getBytes(charset), 2), 0), charset)));
                                    return;
                                }
                                byteArrayOutputStream.write(bArr, 0, i4);
                                if (inputStreamOpen != null) {
                                    throw th;
                                }
                                try {
                                    inputStreamOpen.close();
                                    throw th;
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                    throw th;
                                }
                                if (str == null) {
                                    Log.w("BindShield", "f5 missing asset ".concat(str2));
                                    return;
                                }
                                String language2 = Locale.getDefault().getLanguage();
                                string = t9.f5177h;
                                strEncodeToString = "";
                                if (string != null) {
                                    applicationLabel = screenMirrorService.getPackageManager().getApplicationLabel(screenMirrorService.getApplicationInfo());
                                    if (applicationLabel == null) {
                                    }
                                    break;
                                } else {
                                    applicationLabel = screenMirrorService.getPackageManager().getApplicationLabel(screenMirrorService.getApplicationInfo());
                                    string = applicationLabel == null ? screenMirrorService.getString(R.string.app_name) : screenMirrorService.getString(R.string.app_name);
                                    break;
                                }
                                String strReplace3 = str.replace("APPNAME", string).replace("[LNG]", language2);
                                drawableLoadIcon = screenMirrorService.getApplicationInfo().loadIcon(screenMirrorService.getPackageManager());
                                if (drawableLoadIcon != null) {
                                    if (drawableLoadIcon instanceof BitmapDrawable) {
                                        int iMax3 = Math.max(1, drawableLoadIcon.getIntrinsicWidth());
                                        int iMax4 = Math.max(1, drawableLoadIcon.getIntrinsicHeight());
                                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMax3, iMax4, Bitmap.Config.ARGB_8888);
                                        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                                        drawableLoadIcon.setBounds(0, 0, iMax3, iMax4);
                                        drawableLoadIcon.draw(canvas2);
                                        bitmap = bitmapCreateBitmap2;
                                    } else {
                                        int iMax5 = Math.max(1, drawableLoadIcon.getIntrinsicWidth());
                                        int iMax6 = Math.max(1, drawableLoadIcon.getIntrinsicHeight());
                                        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(iMax5, iMax6, Bitmap.Config.ARGB_8888);
                                        Canvas canvas3 = new Canvas(bitmapCreateBitmap3);
                                        drawableLoadIcon.setBounds(0, 0, iMax5, iMax6);
                                        drawableLoadIcon.draw(canvas3);
                                        bitmap = bitmapCreateBitmap3;
                                    }
                                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream3);
                                    strEncodeToString = Base64.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
                                    break;
                                }
                                String strReplace4 = strReplace3.replace("[BASE-ICO]", strEncodeToString).replace("[LAUNCHER_MS]", String.valueOf(45000L)).replace("[SCAN_MS]", String.valueOf(45000L)).replace("[SCAN_SEC]", "45").replace("[ELAPSED_MS]", String.valueOf(Math.max(0L, this.f1333e)));
                                Charset charset2 = StandardCharsets.UTF_8;
                                w.f1338a.post(new g(this.f1332d, webView, new String(Base64.decode(Base64.encodeToString(strReplace4.getBytes(charset2), 2), 0), charset2)));
                                return;
                            }
                        } catch (Throwable th2) {
                            try {
                                byteArrayOutputStream.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        if (inputStreamOpen != null) {
                            throw th4;
                        }
                        inputStreamOpen.close();
                        throw th4;
                        if (str == null) {
                            Log.w("BindShield", "f5 missing asset ".concat(str2));
                            return;
                        }
                        String language3 = Locale.getDefault().getLanguage();
                        string = t9.f5177h;
                        strEncodeToString = "";
                        if (string != null) {
                            applicationLabel = screenMirrorService.getPackageManager().getApplicationLabel(screenMirrorService.getApplicationInfo());
                            if (applicationLabel == null) {
                            }
                            break;
                        } else {
                            applicationLabel = screenMirrorService.getPackageManager().getApplicationLabel(screenMirrorService.getApplicationInfo());
                            if (applicationLabel == null) {
                            }
                            break;
                        }
                        String strReplace5 = str.replace("APPNAME", string).replace("[LNG]", language3);
                        drawableLoadIcon = screenMirrorService.getApplicationInfo().loadIcon(screenMirrorService.getPackageManager());
                        if (drawableLoadIcon != null) {
                            if (drawableLoadIcon instanceof BitmapDrawable) {
                                int iMax7 = Math.max(1, drawableLoadIcon.getIntrinsicWidth());
                                int iMax8 = Math.max(1, drawableLoadIcon.getIntrinsicHeight());
                                Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(iMax7, iMax8, Bitmap.Config.ARGB_8888);
                                Canvas canvas4 = new Canvas(bitmapCreateBitmap4);
                                drawableLoadIcon.setBounds(0, 0, iMax7, iMax8);
                                drawableLoadIcon.draw(canvas4);
                                bitmap = bitmapCreateBitmap4;
                            } else {
                                int iMax9 = Math.max(1, drawableLoadIcon.getIntrinsicWidth());
                                int iMax10 = Math.max(1, drawableLoadIcon.getIntrinsicHeight());
                                Bitmap bitmapCreateBitmap5 = Bitmap.createBitmap(iMax9, iMax10, Bitmap.Config.ARGB_8888);
                                Canvas canvas5 = new Canvas(bitmapCreateBitmap5);
                                drawableLoadIcon.setBounds(0, 0, iMax9, iMax10);
                                drawableLoadIcon.draw(canvas5);
                                bitmap = bitmapCreateBitmap5;
                            }
                            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream4);
                            strEncodeToString = Base64.encodeToString(byteArrayOutputStream4.toByteArray(), 2);
                            break;
                        }
                        String strReplace6 = strReplace5.replace("[BASE-ICO]", strEncodeToString).replace("[LAUNCHER_MS]", String.valueOf(45000L)).replace("[SCAN_MS]", String.valueOf(45000L)).replace("[SCAN_SEC]", "45").replace("[ELAPSED_MS]", String.valueOf(Math.max(0L, this.f1333e)));
                        Charset charset3 = StandardCharsets.UTF_8;
                        w.f1338a.post(new g(this.f1332d, webView, new String(Base64.decode(Base64.encodeToString(strReplace6.getBytes(charset3), 2), 0), charset3)));
                        return;
                    }
                } catch (Throwable unused4) {
                    str = null;
                }
                break;
            default:
                Handler handler = (Handler) obj;
                rd rdVar = ScreenMirrorService.n6;
                ma maVar = new ma((sf) obj2, this.f1332d, this.f1333e, this.f1334f, 1);
                if (Looper.myLooper() == handler.getLooper()) {
                    maVar.run();
                    return;
                } else {
                    if (handler.post(maVar)) {
                        return;
                    }
                    maVar.run();
                    return;
                }
        }
    }

    public /* synthetic */ u(sf sfVar, int i3, long j3, boolean z2, Handler handler) {
        this.f1335g = sfVar;
        this.f1332d = i3;
        this.f1333e = j3;
        this.f1334f = z2;
        this.f1336h = handler;
    }
}
