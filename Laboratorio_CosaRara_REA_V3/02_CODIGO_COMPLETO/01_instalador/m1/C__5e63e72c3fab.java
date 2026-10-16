// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class C extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f3752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3753f;
    public final boolean g;

    public /* synthetic */ C(Method method, int i2, boolean z2, int i3) {
        this.f3751d = i3;
        this.f3752e = method;
        this.f3753f = i2;
        this.g = z2;
    }

    @Override // m1.W
    public final void a(L l2, Object obj) {
        switch (this.f3751d) {
            case 0:
                Map map = (Map) obj;
                int i2 = this.f3753f;
                Method method = this.f3752e;
                if (map == null) {
                    throw W.o(method, i2, "Field map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw W.o(method, i2, "Field map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw W.o(method, i2, F0.h.e("Field map contained null value for key '", str, "'."), new Object[0]);
                    }
                    String string = value.toString();
                    if (string == null) {
                        throw W.o(method, i2, "Field map value '" + value + "' converted to null by " + C0198b.class.getName() + " for key '" + str + "'.", new Object[0]);
                    }
                    l2.a(str, string, this.g);
                }
                return;
            case 1:
                Map map2 = (Map) obj;
                int i3 = this.f3753f;
                Method method2 = this.f3752e;
                if (map2 == null) {
                    throw W.o(method2, i3, "Header map was null.", new Object[0]);
                }
                for (Map.Entry entry2 : map2.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    if (str2 == null) {
                        throw W.o(method2, i3, "Header map contained null key.", new Object[0]);
                    }
                    Object value2 = entry2.getValue();
                    if (value2 == null) {
                        throw W.o(method2, i3, F0.h.e("Header map contained null value for key '", str2, "'."), new Object[0]);
                    }
                    l2.b(str2, value2.toString(), this.g);
                }
                return;
            default:
                Map map3 = (Map) obj;
                int i4 = this.f3753f;
                Method method3 = this.f3752e;
                if (map3 == null) {
                    throw W.o(method3, i4, "Query map was null", new Object[0]);
                }
                for (Map.Entry entry3 : map3.entrySet()) {
                    String str3 = (String) entry3.getKey();
                    if (str3 == null) {
                        throw W.o(method3, i4, "Query map contained null key.", new Object[0]);
                    }
                    Object value3 = entry3.getValue();
                    if (value3 == null) {
                        throw W.o(method3, i4, F0.h.e("Query map contained null value for key '", str3, "'."), new Object[0]);
                    }
                    String string2 = value3.toString();
                    if (string2 == null) {
                        throw W.o(method3, i4, "Query map value '" + value3 + "' converted to null by " + C0198b.class.getName() + " for key '" + str3 + "'.", new Object[0]);
                    }
                    l2.d(str3, string2, this.g);
                }
                return;
        }
    }
}
