// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k1.G;
import k1.I;
import k1.n;
import k1.o;
import k1.u;
import k1.v;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class e extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f865b;

    public e(v vVar) {
        F0.i.e(vVar, "delegate");
        this.f865b = vVar;
    }

    @Override // k1.o
    public final void a(z zVar) throws IOException {
        F0.i.e(zVar, "path");
        this.f865b.a(zVar);
    }

    @Override // k1.o
    public final List d(z zVar) throws IOException {
        F0.i.e(zVar, "dir");
        List listD = this.f865b.d(zVar);
        ArrayList arrayList = new ArrayList();
        for (z zVar2 : (ArrayList) listD) {
            F0.i.e(zVar2, "path");
            arrayList.add(zVar2);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    @Override // k1.o
    public final n f(z zVar) {
        F0.i.e(zVar, "path");
        n nVarF = this.f865b.f(zVar);
        if (nVarF == null) {
            return null;
        }
        z zVar2 = nVarF.f3492c;
        if (zVar2 == null) {
            return nVarF;
        }
        Map map = nVarF.f3496h;
        F0.i.e(map, "extras");
        return new n(nVarF.f3490a, nVarF.f3491b, zVar2, nVarF.f3493d, nVarF.f3494e, nVarF.f3495f, nVarF.g, map);
    }

    @Override // k1.o
    public final u g(z zVar) {
        return this.f865b.g(zVar);
    }

    @Override // k1.o
    public final G h(z zVar) throws IOException {
        n nVarF;
        z zVarB = zVar.b();
        if (zVarB != null) {
            p036u0.d<z> dVar = new p036u0.d();
            while (zVarB != null && !c(zVarB)) {
                dVar.addFirst(zVarB);
                zVarB = zVarB.b();
            }
            for (z zVar2 : dVar) {
                F0.i.e(zVar2, "dir");
                v vVar = this.f865b;
                vVar.getClass();
                if (!zVar2.e().mkdir() && ((nVarF = vVar.f(zVar2)) == null || !nVarF.f3491b)) {
                    throw new IOException("failed to create directory: " + zVar2);
                }
            }
        }
        return this.f865b.h(zVar);
    }

    @Override // k1.o
    public final I i(z zVar) {
        F0.i.e(zVar, "file");
        return this.f865b.i(zVar);
    }

    public final void j(z zVar, z zVar2) throws IOException {
        F0.i.e(zVar, "source");
        F0.i.e(zVar2, "target");
        this.f865b.j(zVar, zVar2);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        F0.o.f181a.getClass();
        new F0.e(e.class);
        String simpleName = null;
        if (!e.class.isAnonymousClass()) {
            if (e.class.isLocalClass()) {
                String simpleName2 = e.class.getSimpleName();
                Method enclosingMethod = e.class.getEnclosingMethod();
                if (enclosingMethod != null) {
                    simpleName = M0.e.f0(simpleName2, enclosingMethod.getName() + '$');
                } else {
                    Constructor<?> enclosingConstructor = e.class.getEnclosingConstructor();
                    if (enclosingConstructor != null) {
                        simpleName = M0.e.f0(simpleName2, enclosingConstructor.getName() + '$');
                    } else {
                        int iX = M0.e.X(simpleName2, '$', 0, false, 6);
                        if (iX != -1) {
                            simpleName2 = simpleName2.substring(iX + 1, simpleName2.length());
                            F0.i.d(simpleName2, "substring(...)");
                        }
                        simpleName = simpleName2;
                    }
                }
            } else {
                boolean zIsArray = e.class.isArray();
                LinkedHashMap linkedHashMap = F0.e.f172c;
                if (zIsArray) {
                    Class<?> componentType = e.class.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                        simpleName = str.concat("Array");
                    }
                    if (simpleName == null) {
                        simpleName = "Array";
                    }
                } else {
                    simpleName = (String) linkedHashMap.get(e.class.getName());
                    if (simpleName == null) {
                        simpleName = e.class.getSimpleName();
                    }
                }
            }
        }
        sb.append(simpleName);
        sb.append('(');
        sb.append(this.f865b);
        sb.append(')');
        return sb.toString();
    }
}
