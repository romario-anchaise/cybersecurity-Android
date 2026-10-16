// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class H extends C0189e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Socket f3455m;

    public H(Socket socket) {
        this.f3455m = socket;
    }

    @Override // k1.C0189e
    public final void j() {
        Socket socket = this.f3455m;
        try {
            socket.close();
        } catch (AssertionError e2) {
            if (!f1.l.D(e2)) {
                throw e2;
            }
            x.f3514a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        } catch (Exception e3) {
            x.f3514a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
        }
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
