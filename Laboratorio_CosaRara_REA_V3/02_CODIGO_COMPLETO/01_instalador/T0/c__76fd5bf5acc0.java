// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p034t0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ c[] f4125a = {new c("SYNCHRONIZED", 0), new c("PUBLICATION", 1), new c("NONE", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    c EF5;

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f4125a.clone();
    }
}
