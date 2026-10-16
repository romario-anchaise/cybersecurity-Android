// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V;

import A.C0005e;
import M0.m;
import X0.B;
import X0.C0056c;
import X0.InterfaceC0057d;
import X0.n;
import X0.p;
import X0.y;
import android.util.Base64;
import f1.l;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import m1.AbstractC0202f;
import m1.AbstractC0208l;
import m1.InterfaceC0203g;
import m1.InterfaceC0209m;
import p036u0.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f654f;

    public void a(Z.f fVar, Class cls) {
        ((ArrayList) this.f653e).add(new p034t0.d(fVar, cls));
    }

    public void b(p005c0.a aVar, Class cls) {
        ((ArrayList) this.f651c).add(new p034t0.d(aVar, cls));
    }

    public y c() {
        Map mapUnmodifiableMap;
        p pVar = (p) this.f650b;
        if (pVar == null) {
            throw new IllegalStateException("url == null");
        }
        String str = (String) this.f651c;
        n nVarB = ((C0005e) this.f652d).B();
        B b2 = (B) this.f653e;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f654f;
        byte[] bArr = Y0.b.f1119a;
        F0.i.e(linkedHashMap, "<this>");
        if (linkedHashMap.isEmpty()) {
            mapUnmodifiableMap = o.f4147a;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
            F0.i.d(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        }
        return new y(pVar, str, nVarB, b2, mapUnmodifiableMap);
    }

    public void d(C0056c c0056c) {
        F0.i.e(c0056c, "cacheControl");
        String string = c0056c.toString();
        if (string.length() == 0) {
            ((C0005e) this.f652d).G("Cache-Control");
        } else {
            f("Cache-Control", string);
        }
    }

    public InterfaceC0203g e(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = (List) this.f654f;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            InterfaceC0203g interfaceC0203gA = ((AbstractC0202f) list.get(i2)).a(type, annotationArr);
            if (interfaceC0203gA != null) {
                return interfaceC0203gA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((AbstractC0202f) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public void f(String str, String str2) {
        F0.i.e(str2, "value");
        C0005e c0005e = (C0005e) this.f652d;
        c0005e.getClass();
        l.j(str);
        l.l(str2, str);
        c0005e.G(str);
        c0005e.z(str, str2);
    }

    public void g(String str, B b2) {
        F0.i.e(str, "method");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (b2 == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
                throw new IllegalArgumentException(F0.h.e("method ", str, " must have a request body.").toString());
            }
        } else if (!f1.d.u(str)) {
            throw new IllegalArgumentException(F0.h.e("method ", str, " must not have a request body.").toString());
        }
        this.f651c = str;
        this.f653e = b2;
    }

    public InterfaceC0209m h(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        List list = (List) this.f653e;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            InterfaceC0209m interfaceC0209mA = ((AbstractC0208l) list.get(i2)).a(type);
            if (interfaceC0209mA != null) {
                return interfaceC0209mA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((AbstractC0208l) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public InterfaceC0209m i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = (List) this.f653e;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            InterfaceC0209m interfaceC0209mB = ((AbstractC0208l) list.get(i2)).b(type, annotationArr, this);
            if (interfaceC0209mB != null) {
                return interfaceC0209mB;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((AbstractC0208l) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public void j(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        List list = (List) this.f653e;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((AbstractC0208l) list.get(i2)).getClass();
        }
    }

    public void k(Class cls, Object obj) {
        F0.i.e(cls, "type");
        if (obj == null) {
            ((LinkedHashMap) this.f654f).remove(cls);
            return;
        }
        if (((LinkedHashMap) this.f654f).isEmpty()) {
            this.f654f = new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f654f;
        Object objCast = cls.cast(obj);
        F0.i.b(objCast);
        linkedHashMap.put(cls, objCast);
    }

    public void l(String str) {
        F0.i.e(str, "url");
        if (m.R(str, "ws:", true)) {
            String strSubstring = str.substring(3);
            F0.i.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            str = "http:".concat(strSubstring);
        } else if (m.R(str, "wss:", true)) {
            String strSubstring2 = str.substring(4);
            F0.i.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
            str = "https:".concat(strSubstring2);
        }
        F0.i.e(str, "<this>");
        X0.o oVar = new X0.o();
        oVar.c(null, str);
        this.f650b = oVar.a();
    }

    public String toString() {
        switch (this.f649a) {
            case 3:
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.f650b) + ", mProviderPackage: " + ((String) this.f651c) + ", mQuery: " + ((String) this.f652d) + ", mCertificates:");
                int i2 = 0;
                while (true) {
                    List list = (List) this.f653e;
                    if (i2 >= list.size()) {
                        sb.append("}mCertificatesArray: 0");
                        return sb.toString();
                    }
                    sb.append(" [");
                    List list2 = (List) list.get(i2);
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list2.get(i3), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                    i2++;
                }
                break;
            default:
                return super.toString();
        }
    }

    public a(String str, String str2, String str3, List list) {
        this.f649a = 3;
        str.getClass();
        this.f650b = str;
        str2.getClass();
        this.f651c = str2;
        this.f652d = str3;
        list.getClass();
        this.f653e = list;
        this.f654f = str + "-" + str2 + "-" + str3;
    }

    public a(InterfaceC0057d interfaceC0057d, p pVar, List list, List list2) {
        this.f649a = 2;
        this.f650b = new ConcurrentHashMap();
        this.f651c = interfaceC0057d;
        this.f652d = pVar;
        this.f653e = list;
        this.f654f = list2;
    }

    public a(b bVar) {
        this.f649a = 0;
        this.f650b = p036u0.f.C(bVar.f655a);
        this.f651c = p036u0.f.C(bVar.f656b);
        this.f652d = p036u0.f.C(bVar.f657c);
        this.f653e = p036u0.f.C(bVar.f658d);
        this.f654f = p036u0.f.C(bVar.f659e);
    }

    public a() {
        this.f649a = 1;
        this.f654f = new LinkedHashMap();
        this.f651c = "GET";
        this.f652d = new C0005e(10);
    }
}
