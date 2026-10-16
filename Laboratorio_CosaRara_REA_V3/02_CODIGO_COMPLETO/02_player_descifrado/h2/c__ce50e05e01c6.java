// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import java.util.EnumSet;
import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f1960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f1961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f1962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f1963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f1964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f1965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f1966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f1967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f1968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ c[] f1969l;

    static {
        c cVar = new c("IDLE", 0);
        f1960c = cVar;
        c cVar2 = new c("WAITING_NETWORK", 1);
        f1961d = cVar2;
        c cVar3 = new c("WAITING_VALIDATION", 2);
        f1962e = cVar3;
        c cVar4 = new c("CONNECTING", 3);
        f1963f = cVar4;
        c cVar5 = new c("HANDSHAKING", 4);
        f1964g = cVar5;
        c cVar6 = new c("ONLINE", 5);
        f1965h = cVar6;
        c cVar7 = new c("BACKOFF", 6);
        f1966i = cVar7;
        c cVar8 = new c("DEGRADED", 7);
        f1967j = cVar8;
        f1969l = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8};
        HashMap map = new HashMap();
        f1968k = map;
        c[] cVarArr = {cVar2, cVar3, cVar4};
        map.put(cVar, EnumSet.of(cVarArr[0], cVarArr));
        c[] cVarArr2 = {cVar3, cVar4, cVar};
        map.put(cVar2, EnumSet.of(cVarArr2[0], cVarArr2));
        c[] cVarArr3 = {cVar4, cVar2, cVar7, cVar};
        map.put(cVar3, EnumSet.of(cVarArr3[0], cVarArr3));
        c[] cVarArr4 = {cVar5, cVar7, cVar2, cVar3, cVar};
        map.put(cVar4, EnumSet.of(cVarArr4[0], cVarArr4));
        c[] cVarArr5 = {cVar6, cVar7, cVar8, cVar2, cVar3, cVar};
        map.put(cVar5, EnumSet.of(cVarArr5[0], cVarArr5));
        c[] cVarArr6 = {cVar8, cVar7, cVar2, cVar3, cVar};
        map.put(cVar6, EnumSet.of(cVarArr6[0], cVarArr6));
        c[] cVarArr7 = {cVar4, cVar2, cVar3, cVar};
        map.put(cVar7, EnumSet.of(cVarArr7[0], cVarArr7));
        c[] cVarArr8 = {cVar6, cVar7, cVar2, cVar3, cVar};
        map.put(cVar8, EnumSet.of(cVarArr8[0], cVarArr8));
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f1969l.clone();
    }
}
