// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.os9sp.yfwkcq0dwfxaf.R;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PendingIntent f505g;

    public a(String str, PendingIntent pendingIntent) {
        IconCompat iconCompatA = IconCompat.a(R.drawable.common_full_open_on_phone);
        Bundle bundle = new Bundle();
        this.f502d = true;
        this.f500b = iconCompatA;
        int i3 = iconCompatA.f162a;
        if ((i3 == -1 ? ((Icon) iconCompatA.f163b).getType() : i3) == 2) {
            this.f503e = iconCompatA.b();
        }
        this.f504f = b.a(str);
        this.f505g = pendingIntent;
        this.f499a = bundle;
        this.f501c = true;
        this.f502d = true;
    }
}
