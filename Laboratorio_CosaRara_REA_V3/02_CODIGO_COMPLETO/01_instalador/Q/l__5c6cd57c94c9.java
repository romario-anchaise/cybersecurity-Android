// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationManager f4014a;

    static {
        new HashSet();
    }

    public l(Context context) {
        this.f4014a = (NotificationManager) context.getSystemService("notification");
    }
}
