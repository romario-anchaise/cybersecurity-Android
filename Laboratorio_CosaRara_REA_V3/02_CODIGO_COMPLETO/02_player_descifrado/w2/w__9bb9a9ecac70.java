// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Socket f5813m;

    public w(Socket socket) {
        this.f5813m = socket;
    }

    @Override // w2.f
    public final void k() {
        Socket socket = this.f5813m;
        try {
            socket.close();
        } catch (AssertionError e3) {
            if (!b.d(e3)) {
                throw e3;
            }
            o.f5792a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
        } catch (Exception e4) {
            o.f5792a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e4);
        }
    }

    public final IOException l(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
