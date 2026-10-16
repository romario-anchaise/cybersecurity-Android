// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n2;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(j2.b.f2365e);
        return simpleDateFormat;
    }
}
