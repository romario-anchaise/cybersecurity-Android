// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import java.util.Comparator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0099q implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2027a;

    public /* synthetic */ C0099q(int i2) {
        this.f2027a = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        if (r0 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return -1;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compare(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            int r0 = r6.f2027a
            switch(r0) {
                case 0: goto L27;
                case 1: goto Le;
                default: goto L5;
            }
        L5:
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            java.lang.Comparable r8 = (java.lang.Comparable) r8
            int r7 = r7.compareTo(r8)
            return r7
        Le:
            l1.g r7 = (l1.g) r7
            k1.z r7 = r7.f3550a
            l1.g r8 = (l1.g) r8
            k1.z r8 = r8.f3550a
            if (r7 != r8) goto L1a
            r7 = 0
            goto L26
        L1a:
            if (r7 != 0) goto L1e
            r7 = -1
            goto L26
        L1e:
            if (r8 != 0) goto L22
            r7 = 1
            goto L26
        L22:
            int r7 = r7.compareTo(r8)
        L26:
            return r7
        L27:
            androidx.recyclerview.widget.s r7 = (androidx.recyclerview.widget.C0100s) r7
            androidx.recyclerview.widget.s r8 = (androidx.recyclerview.widget.C0100s) r8
            androidx.recyclerview.widget.RecyclerView r0 = r7.f2035d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L33
            r3 = r2
            goto L34
        L33:
            r3 = r1
        L34:
            androidx.recyclerview.widget.RecyclerView r4 = r8.f2035d
            if (r4 != 0) goto L3a
            r4 = r2
            goto L3b
        L3a:
            r4 = r1
        L3b:
            r5 = -1
            if (r3 == r4) goto L44
            if (r0 != 0) goto L42
        L40:
            r1 = r2
            goto L5e
        L42:
            r1 = r5
            goto L5e
        L44:
            boolean r0 = r7.f2032a
            boolean r3 = r8.f2032a
            if (r0 == r3) goto L4d
            if (r0 == 0) goto L40
            goto L42
        L4d:
            int r0 = r8.f2033b
            int r2 = r7.f2033b
            int r0 = r0 - r2
            if (r0 == 0) goto L56
            r1 = r0
            goto L5e
        L56:
            int r7 = r7.f2034c
            int r8 = r8.f2034c
            int r7 = r7 - r8
            if (r7 == 0) goto L5e
            r1 = r7
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C0099q.compare(java.lang.Object, java.lang.Object):int");
    }
}
