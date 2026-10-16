// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y1;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f6226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f6227b;

    static {
        EnumMap enumMap = new EnumMap(k.class);
        enumMap.put(k.f6219c, b("com.android.settings"));
        enumMap.put(k.f6220d, b("com.samsung.accessibility", "com.samsung.android.settings"));
        enumMap.put(k.f6221e, b("com.miui.accessibility", "com.miui.securitycenter"));
        enumMap.put(k.f6222f, b("com.coloros.settings", "com.oplus.settings", "com.realme.settings", "com.coloros.accessibility", "com.oplus.accessibility"));
        enumMap.put(k.f6223g, b("com.vivo.settings", "com.vivo.accessibility", "com.vivo.permissionmanager", "com.vivo.permission.manager"));
        enumMap.put(k.f6224h, b("com.huawei.settings", "com.huawei.accessibility", "com.huawei.systemmanager"));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = enumMap.values().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll((Set) it.next());
        }
        Collections.unmodifiableMap(enumMap);
        f6226a = Collections.unmodifiableSet(linkedHashSet);
        f6227b = b("com.samsung.accessibility", "com.miui.accessibility", "com.coloros.accessibility", "com.oplus.accessibility", "com.vivo.accessibility", "com.huawei.accessibility");
    }

    public static boolean a(CharSequence charSequence) {
        return f6226a.contains(charSequence == null ? "" : charSequence.toString().trim().toLowerCase(Locale.ROOT));
    }

    public static Set b(String... strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Collections.addAll(linkedHashSet, strArr);
        return Collections.unmodifiableSet(linkedHashSet);
    }
}
