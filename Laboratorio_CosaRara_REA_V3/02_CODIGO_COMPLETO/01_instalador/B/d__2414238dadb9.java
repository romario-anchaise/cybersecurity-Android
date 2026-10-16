// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p002b;

import android.os.Bundle;
import androidx.lifecycle.EnumC0076n;
import androidx.lifecycle.InterfaceC0080s;
import androidx.lifecycle.InterfaceC0082u;
import java.util.HashMap;
import p004c.a;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC0080s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f2081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f2082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f2083d;

    public d(i iVar, String str, b bVar, a aVar) {
        this.f2083d = iVar;
        this.f2080a = str;
        this.f2081b = bVar;
        this.f2082c = aVar;
    }

    @Override // androidx.lifecycle.InterfaceC0080s
    public final void g(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        boolean zEquals = EnumC0076n.ON_START.equals(enumC0076n);
        String str = this.f2080a;
        i iVar = this.f2083d;
        if (!zEquals) {
            if (EnumC0076n.ON_STOP.equals(enumC0076n)) {
                iVar.f2095f.remove(str);
                return;
            } else {
                if (EnumC0076n.ON_DESTROY.equals(enumC0076n)) {
                    iVar.d(str);
                    return;
                }
                return;
            }
        }
        HashMap map = iVar.f2095f;
        b bVar = this.f2081b;
        a aVar = this.f2082c;
        map.put(str, new g(aVar, bVar));
        HashMap map2 = iVar.g;
        if (map2.containsKey(str)) {
            Object obj = map2.get(str);
            map2.remove(str);
            bVar.a(obj);
        }
        Bundle bundle = iVar.f2096h;
        a aVar2 = (a) bundle.getParcelable(str);
        if (aVar2 != null) {
            bundle.remove(str);
            bVar.a(aVar.a(aVar2.f2079b, aVar2.f2078a));
        }
    }
}
