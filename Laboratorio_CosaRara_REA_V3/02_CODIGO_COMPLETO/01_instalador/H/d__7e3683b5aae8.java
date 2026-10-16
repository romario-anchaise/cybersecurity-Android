// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes.dex */
public final class d extends C0028c {
    @Override // H.C0028c
    public final Signature[] t(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
