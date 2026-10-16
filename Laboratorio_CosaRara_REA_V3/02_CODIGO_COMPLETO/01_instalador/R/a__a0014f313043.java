// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p031r;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
    }

    public static void b(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
