// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pe implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4874a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2.d0 f4875b;

    public /* synthetic */ pe(g2.d0 d0Var) {
        this.f4875b = d0Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        int i3 = this.f4874a;
        g2.d0 d0Var = this.f4875b;
        switch (i3) {
            case 0:
                g2.b0 b0Var = d0Var.f1577j;
                if (b0Var != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(32);
                    while (true) {
                        int i4 = b0Var.read();
                        if (i4 < 0) {
                            throw new EOFException("a11y_enabled ACK stream closed before newline");
                        }
                        if (i4 == 10) {
                            return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                        }
                        if (byteArrayOutputStream.size() < 128) {
                            byteArrayOutputStream.write(i4);
                        } else {
                            o2.l("a11y_enabled ACK line too large");
                        }
                    }
                } else {
                    o2.l("a11y_enabled ACK input missing");
                }
                return null;
            default:
                return cf.f0(d0Var.f1577j);
        }
    }

    public /* synthetic */ pe(cf cfVar, g2.d0 d0Var) {
        this.f4875b = d0Var;
    }
}
