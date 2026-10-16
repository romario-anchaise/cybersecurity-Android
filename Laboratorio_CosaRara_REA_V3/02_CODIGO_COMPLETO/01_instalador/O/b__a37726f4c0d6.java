// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f474f = false;
    public c[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f475h;

    public b(AssetManager assetManager, Executor executor, e eVar, String str, File file) {
        this.f469a = executor;
        this.f470b = eVar;
        this.f473e = str;
        this.f472d = file;
        int i2 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i2 <= 34) {
            switch (i2) {
                case 24:
                case 25:
                    bArr = f.f490h;
                    break;
                case 26:
                    bArr = f.g;
                    break;
                case 27:
                    bArr = f.f489f;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = f.f488e;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    bArr = f.f487d;
                    break;
            }
        }
        this.f471c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f470b.r();
            }
            return null;
        }
    }

    public final void b(final int i2, final Serializable serializable) {
        this.f469a.execute(new Runnable() { // from class: O.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f466a.f470b.l(i2, serializable);
            }
        });
    }
}
