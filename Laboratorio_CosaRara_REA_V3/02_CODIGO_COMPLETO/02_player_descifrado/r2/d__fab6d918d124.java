// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3176a = new d();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        int i3;
        int iMin;
        logRecord.getClass();
        CopyOnWriteArraySet copyOnWriteArraySet = c.f3174a;
        String loggerName = logRecord.getLoggerName();
        loggerName.getClass();
        int iIntValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (iIntValue > level.intValue()) {
            i3 = 5;
        } else {
            i3 = logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        message.getClass();
        Throwable thrown = logRecord.getThrown();
        String strI = (String) c.f3175b.get(loggerName);
        if (strI == null) {
            strI = v1.d.I(loggerName, 23);
        }
        if (Log.isLoggable(strI, i3)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i4 = 0;
            while (i4 < length) {
                int iD = v1.d.D(message, '\n', i4, 4);
                if (iD == -1) {
                    iD = length;
                }
                while (true) {
                    iMin = Math.min(iD, i4 + 4000);
                    Log.println(i3, strI, message.substring(i4, iMin));
                    if (iMin >= iD) {
                        break;
                    } else {
                        i4 = iMin;
                    }
                }
                i4 = iMin + 1;
            }
        }
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }
}
