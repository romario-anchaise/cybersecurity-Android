// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6245a = p.m.f("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z2) {
        String str = f6245a;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z2 ? 1 : 2, 1);
            p.m mVarD = p.m.d();
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z2 ? "enabled" : "disabled");
            mVarD.a(str, sb.toString());
        } catch (Exception e3) {
            p.m mVarD2 = p.m.d();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z2 ? "enabled" : "disabled");
            String string = sb2.toString();
            if (mVarD2.f2856a <= 3) {
                Log.d(str, string, e3);
            }
        }
    }
}
