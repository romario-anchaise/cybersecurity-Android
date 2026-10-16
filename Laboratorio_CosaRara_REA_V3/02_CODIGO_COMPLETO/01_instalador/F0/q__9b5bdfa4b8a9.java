// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static void a(E0.p pVar) {
        int iE;
        if (pVar instanceof f) {
            iE = ((f) pVar).e();
        } else if (pVar instanceof E0.a) {
            iE = 0;
        } else {
            iE = pVar instanceof E0.l ? 1 : 2;
        }
        if (iE == 2) {
            return;
        }
        ClassCastException classCastException = new ClassCastException(pVar.getClass().getName().concat(" cannot be cast to kotlin.jvm.functions.Function2"));
        i.g(classCastException, q.class.getName());
        throw classCastException;
    }
}
