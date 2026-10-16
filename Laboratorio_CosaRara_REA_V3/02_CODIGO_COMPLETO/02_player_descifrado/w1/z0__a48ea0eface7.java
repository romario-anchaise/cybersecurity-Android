// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f5657a = new AtomicReference("");

    public static void a(Context context, File file) {
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
        sessionParams.setSize(file.length());
        sessionParams.setOriginatingUri(Uri.fromFile(file));
        if (Build.VERSION.SDK_INT >= 31) {
            sessionParams.setRequireUserAction(2);
        }
        PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
        int iCreateSession = packageInstaller.createSession(sessionParams);
        PackageInstaller.Session sessionOpenSession = packageInstaller.openSession(iCreateSession);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            OutputStream outputStreamOpenWrite = sessionOpenSession.openWrite("base.apk", 0L, file.length());
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int i3 = fileInputStream.read(bArr);
                    if (i3 == -1) {
                        break;
                    } else {
                        outputStreamOpenWrite.write(bArr, 0, i3);
                    }
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                        throw th;
                    }
                }
                sessionOpenSession.fsync(outputStreamOpenWrite);
                if (outputStreamOpenWrite != null) {
                    outputStreamOpenWrite.close();
                }
                fileInputStream.close();
                int i4 = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
                Intent intent = new Intent("lyr.stable.runtime.action.INSTALL_RESULT");
                intent.setPackage(context.getPackageName());
                sessionOpenSession.commit(PendingIntent.getBroadcast(context, iCreateSession, intent, i4).getIntentSender());
                sessionOpenSession.close();
                StringBuilder sbI = a0.a.i(iCreateSession, "install session committed id=", " apk=");
                sbI.append(file.getName());
                Log.i("ApkInstall", sbI.toString());
            } catch (Throwable th2) {
                if (outputStreamOpenWrite == null) {
                    throw th2;
                }
                try {
                    outputStreamOpenWrite.close();
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            fileInputStream.close();
            throw th4;
        }
    }

    public static String b(String str) {
        return str == null ? "" : str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
