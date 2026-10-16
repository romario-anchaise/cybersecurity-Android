// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && i.class == obj.getClass();
    }

    public final int hashCode() {
        return i.class.getName().hashCode();
    }

    public final String toString() {
        return "Retry";
    }
}
