// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import F0.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p018k0.p;
import p018k0.y;
import p028p0.d;
import s0.b;

/* JADX INFO: renamed from: n0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0232n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f3940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f3942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Method f3943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ y f3944f;
    public final /* synthetic */ y g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f3945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f3946i;

    public C0232n(String str, Field field, boolean z2, Method method, y yVar, y yVar2, boolean z3, boolean z4) {
        this.f3942d = z2;
        this.f3943e = method;
        this.f3944f = yVar;
        this.g = yVar2;
        this.f3945h = z3;
        this.f3946i = z4;
        this.f3939a = str;
        this.f3940b = field;
        this.f3941c = field.getName();
    }

    public final void a(b bVar, Object obj) throws IllegalAccessException {
        Object objInvoke;
        Field field = this.f3940b;
        boolean z2 = this.f3942d;
        Method method = this.f3943e;
        if (z2) {
            if (method == null) {
                C0236s.a(obj, field);
            } else {
                C0236s.a(obj, method);
            }
        }
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e2) {
                throw new p(h.e("Accessor ", d.d(method, false), " threw exception"), e2.getCause());
            }
        } else {
            objInvoke = field.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        bVar.u(this.f3939a);
        this.f3944f.b(bVar, objInvoke);
    }
}
