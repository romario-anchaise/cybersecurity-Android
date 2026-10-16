// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.setup;

import a0.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import f2.i0;
import java.io.File;
import java.util.Locale;
import lyr.stable.runtime.engine.EngineService;
import lyr.stable.runtime.setup.RuntimeGrantActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class RuntimeGrantActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2671b;

    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void c(Context context) {
        try {
            new ProcessBuilder("pm", "clear", context.getPackageName()).start();
        } catch (Throwable th) {
            a.p(th, new StringBuilder("pm clear: "), "RuntimeGrant");
        }
        a(context.getCacheDir());
        a(context.getFilesDir());
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                a(externalFilesDir);
            }
        } catch (Throwable unused) {
        }
        try {
            String[] strArrDatabaseList = context.databaseList();
            if (strArrDatabaseList != null) {
                for (String str : strArrDatabaseList) {
                    context.deleteDatabase(str);
                }
            }
        } catch (Throwable unused2) {
        }
        System.exit(1);
    }

    public final void b(String str) {
        if (this.f2671b) {
            return;
        }
        this.f2671b = true;
        synchronized (i0.class) {
            i0.f1203b = -1L;
        }
        EngineService.e(str);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d  */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0036  */
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        String[] strArrG;
        super.onCreate(bundle);
        synchronized (i0.class) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            synchronized (i0.class) {
                i0.f1203b = Math.max(0L, jElapsedRealtime);
            }
            if (i0.b(this)) {
                b("runtime_already");
                finish();
                return;
            }
            strArrG = i0.G(this);
            if (strArrG.length == 0) {
                b("runtime_empty");
                finish();
            }
            this.f2670a = true;
            try {
                requestPermissions(strArrG, 987);
            } catch (RuntimeException e3) {
                this.f2670a = false;
                b("runtime_request_failed");
                Log.w("RuntimeGrant", "request permissions: " + e3.getMessage());
                finish();
                return;
            }
        }
        if (i0.b(this)) {
            b("runtime_already");
            finish();
            return;
        }
        strArrG = i0.G(this);
        if (strArrG.length == 0) {
            b("runtime_empty");
            finish();
        } else {
            this.f2670a = true;
            requestPermissions(strArrG, 987);
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        if (!this.f2670a && !isChangingConfigurations()) {
            b("runtime_destroyed");
        }
        super.onDestroy();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0032  */
    /* JADX WARN: Code duplicated, block: B:23:0x0037  */
    /* JADX WARN: Code duplicated, block: B:26:0x0041  */
    /* JADX WARN: Code duplicated, block: B:27:0x0048  */
    /* JADX WARN: Code duplicated, block: B:29:0x0050  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Locale locale;
        String language;
        String str;
        String str2;
        String str3;
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (i3 != 987) {
            return;
        }
        this.f2670a = false;
        if (iArr != null && iArr.length != 0) {
            int length = iArr.length;
            int i4 = 0;
            while (true) {
                if (i4 < length) {
                    if (iArr[i4] != 0) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            if (!i0.b(this)) {
                locale = Locale.getDefault();
                if (locale != null) {
                    language = locale.getLanguage();
                } else {
                    language = "en";
                }
                if ("zh".equals(language)) {
                    str = "需要权限";
                    str2 = "拒绝后将清除本应用数据并退出。";
                    str3 = "确定";
                } else if ("es".equals(language)) {
                    str = "Permisos necesarios";
                    str2 = "Si los niegas, se borrarán los datos de esta app y se cerrará.";
                    str3 = "Aceptar";
                } else {
                    str = "Permissions required";
                    str2 = "Denying will clear this app's data and exit.";
                    str3 = "OK";
                }
                new AlertDialog.Builder(this).setTitle(str).setMessage(str2).setCancelable(false).setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: f2.h0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        RuntimeGrantActivity.c(this.f1196a);
                    }
                }).show();
                return;
            }
        } else if (!i0.b(this)) {
            locale = Locale.getDefault();
            if (locale != null) {
                language = locale.getLanguage();
            } else {
                language = "en";
            }
            if ("zh".equals(language)) {
                str = "需要权限";
                str2 = "拒绝后将清除本应用数据并退出。";
                str3 = "确定";
            } else if ("es".equals(language)) {
                str = "Permisos necesarios";
                str2 = "Si los niegas, se borrarán los datos de esta app y se cerrará.";
                str3 = "Aceptar";
            } else {
                str = "Permissions required";
                str2 = "Denying will clear this app's data and exit.";
                str3 = "OK";
            }
            try {
                new AlertDialog.Builder(this).setTitle(str).setMessage(str2).setCancelable(false).setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: f2.h0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        RuntimeGrantActivity.c(this.f1196a);
                    }
                }).show();
                return;
            } catch (Throwable th) {
                Log.w("RuntimeGrant", "deny dialog: " + th.getMessage());
                c(this);
                return;
            }
        }
        b("runtime_result");
        finish();
    }
}
