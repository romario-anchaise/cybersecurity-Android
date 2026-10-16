// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f6057b;

    public /* synthetic */ g(l lVar, int i3) {
        this.f6056a = i3;
        this.f6057b = lVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // x0.a
    public final void a(Object... objArr) {
        String str;
        switch (this.f6056a) {
            case 0:
                this.f6057b.k();
                break;
            case 1:
                this.f6057b.h("transport close", null);
                break;
            case 2:
                this.f6057b.i(objArr.length > 0 ? (Exception) objArr[0] : null);
                break;
            case 3:
                a1.b bVar = objArr.length > 0 ? (a1.b) objArr[0] : null;
                Logger logger = l.A;
                l lVar = this.f6057b;
                int i3 = lVar.f6095z;
                if (i3 == 1 || i3 == 2 || i3 == 3) {
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(String.format("socket received: type '%s', data '%s'", bVar.f39a, bVar.f40b));
                    }
                    lVar.a("packet", bVar);
                    lVar.a("heartbeat", new Object[0]);
                    String str2 = bVar.f39a;
                    Object obj = bVar.f40b;
                    if ("open".equals(str2)) {
                        try {
                            lVar.j(new b((String) obj));
                        } catch (JSONException e3) {
                            lVar.a("error", new a(e3));
                            return;
                        }
                    } else if ("ping".equals(str2)) {
                        lVar.a("ping", new Object[0]);
                        f1.b.a(new e(lVar, 0));
                    } else if ("error".equals(str2)) {
                        a aVar = new a("server error");
                        aVar.f6036d = obj;
                        lVar.i(aVar);
                    } else if ("message".equals(str2)) {
                        lVar.a("data", obj);
                        lVar.a("message", obj);
                    }
                } else if (logger.isLoggable(Level.FINE)) {
                    int i4 = lVar.f6095z;
                    StringBuilder sb = new StringBuilder("packet received with socket readyState '");
                    if (i4 == 1) {
                        str = "OPENING";
                    } else if (i4 == 2) {
                        str = "OPEN";
                    } else if (i4 != 3) {
                        str = i4 != 4 ? "null" : "CLOSED";
                    } else {
                        str = "CLOSING";
                    }
                    sb.append(str);
                    sb.append("'");
                    logger.fine(sb.toString());
                }
                break;
            default:
                l lVar2 = this.f6057b;
                LinkedList linkedList = lVar2.f6088s;
                for (int i5 = 0; i5 < lVar2.f6078h; i5++) {
                    linkedList.poll();
                }
                lVar2.f6078h = 0;
                if (linkedList.size() == 0) {
                    lVar2.a("drain", new Object[0]);
                } else {
                    lVar2.g();
                }
                break;
        }
    }
}
