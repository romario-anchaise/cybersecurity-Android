// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H0;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f254a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f254a) {
            case 0:
                return new Random();
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(Y0.b.f1123e);
                return simpleDateFormat;
        }
    }
}
