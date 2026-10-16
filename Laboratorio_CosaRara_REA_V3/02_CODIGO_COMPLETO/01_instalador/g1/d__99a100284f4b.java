// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2762a = new d();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        int i2;
        int iMin;
        F0.i.e(logRecord, "record");
        CopyOnWriteArraySet copyOnWriteArraySet = c.f2760a;
        String loggerName = logRecord.getLoggerName();
        F0.i.d(loggerName, "record.loggerName");
        int iIntValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (iIntValue > level.intValue()) {
            i2 = 5;
        } else {
            i2 = logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        F0.i.d(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        String strI0 = (String) c.f2761b.get(loggerName);
        if (strI0 == null) {
            strI0 = M0.e.i0(23, loggerName);
        }
        if (Log.isLoggable(strI0, i2)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i3 = 0;
            while (i3 < length) {
                int iX = M0.e.X(message, '\n', i3, false, 4);
                if (iX == -1) {
                    iX = length;
                }
                while (true) {
                    iMin = Math.min(iX, i3 + 4000);
                    String strSubstring = message.substring(i3, iMin);
                    F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i2, strI0, strSubstring);
                    if (iMin >= iX) {
                        break;
                    } else {
                        i3 = iMin;
                    }
                }
                i3 = iMin + 1;
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
