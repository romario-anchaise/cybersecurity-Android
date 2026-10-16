// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f360e;

    public /* synthetic */ a(int i3, Object obj) {
        this.f359d = i3;
        this.f360e = obj;
    }

    @Override // c.i
    public final void b() {
        switch (this.f359d) {
            case 0:
                ((b) this.f360e).clear();
                break;
            default:
                ((c) this.f360e).clear();
                break;
        }
    }

    @Override // c.i
    public final Object c(int i3, int i4) {
        switch (this.f359d) {
            case 0:
                return ((b) this.f360e).f394d[(i3 << 1) + i4];
            default:
                return ((c) this.f360e).f369d[i3];
        }
    }

    @Override // c.i
    public final Map d() {
        switch (this.f359d) {
            case 0:
                return (b) this.f360e;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    @Override // c.i
    public final int e() {
        switch (this.f359d) {
            case 0:
                return ((b) this.f360e).f395e;
            default:
                return ((c) this.f360e).f370e;
        }
    }

    @Override // c.i
    public final int f(Object obj) {
        switch (this.f359d) {
            case 0:
                return ((b) this.f360e).d(obj);
            default:
                c cVar = (c) this.f360e;
                return obj == null ? cVar.d() : cVar.c(obj.hashCode(), obj);
        }
    }

    @Override // c.i
    public final int g(Object obj) {
        switch (this.f359d) {
            case 0:
                return ((b) this.f360e).f(obj);
            default:
                c cVar = (c) this.f360e;
                return obj == null ? cVar.d() : cVar.c(obj.hashCode(), obj);
        }
    }

    @Override // c.i
    public final void h(Object obj, Object obj2) {
        switch (this.f359d) {
            case 0:
                ((b) this.f360e).put(obj, obj2);
                break;
            default:
                ((c) this.f360e).add(obj);
                break;
        }
    }

    @Override // c.i
    public final void i(int i3) {
        switch (this.f359d) {
            case 0:
                ((b) this.f360e).g(i3);
                break;
            default:
                ((c) this.f360e).e(i3);
                break;
        }
    }

    @Override // c.i
    public final Object j(int i3, Object obj) {
        switch (this.f359d) {
            case 0:
                int i4 = (i3 << 1) + 1;
                Object[] objArr = ((b) this.f360e).f394d;
                Object obj2 = objArr[i4];
                objArr[i4] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }
}
