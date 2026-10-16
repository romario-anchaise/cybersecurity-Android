// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

import android.util.Log;
import java.io.IOException;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ String A(int i3) {
        switch (i3) {
            case 1:
                return "NOT_REQUIRED";
            case 2:
                return "CONNECTED";
            case 3:
                return "UNMETERED";
            case 4:
                return "NOT_ROAMING";
            case 5:
                return "METERED";
            case 6:
                return "TEMPORARILY_UNMETERED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String B(int i3) {
        switch (i3) {
            case 1:
                return "ENQUEUED";
            case 2:
                return "RUNNING";
            case 3:
                return "SUCCEEDED";
            case 4:
                return "FAILED";
            case 5:
                return "BLOCKED";
            case 6:
                return "CANCELLED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ int C(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals("NONE")) {
            return 1;
        }
        if (str.equals("ACCESSIBILITY_READY")) {
            return 2;
        }
        if (str.equals("SETUP_FLASH_READY")) {
            return 3;
        }
        if (str.equals("RUNTIME_GRANT_READY")) {
            return 4;
        }
        if (str.equals("NOTIFICATION_LISTENER")) {
            return 5;
        }
        if (str.equals("FILES")) {
            return 6;
        }
        if (str.equals("POST_NOTIF")) {
            return 7;
        }
        if (str.equals("DEVICE_ADMIN")) {
            return 8;
        }
        if (str.equals("OVERLAY")) {
            return 9;
        }
        if (str.equals("USAGE")) {
            return 10;
        }
        if (str.equals("PLAY_DETAILS")) {
            return 11;
        }
        if (str.equals("VENDOR_BATTERY")) {
            return 12;
        }
        if (str.equals("OEM_AUTOSTART")) {
            return 13;
        }
        if (str.equals("BATTERY")) {
            return 14;
        }
        if (str.equals("WRITE_SETTINGS")) {
            return 15;
        }
        if (str.equals("NOTIFICATION_CHANNEL")) {
            return 16;
        }
        if (str.equals("DREAM")) {
            return 17;
        }
        if (str.equals("START_COMPANION")) {
            return 18;
        }
        o2.i("No enum constant lyr.stable.runtime.engine.EnginePoll.Kind.".concat(str));
        return 0;
    }

    public static /* synthetic */ int D(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals("NONE")) {
            return 1;
        }
        if (str.equals("NOTIFICATION_LISTENER")) {
            return 2;
        }
        if (str.equals("FILES")) {
            return 3;
        }
        if (str.equals("OVERLAY")) {
            return 4;
        }
        if (str.equals("USAGE")) {
            return 5;
        }
        if (str.equals("WRITE")) {
            return 6;
        }
        if (str.equals("DREAM")) {
            return 7;
        }
        if (str.equals("NOTIFICATION_CHANNEL")) {
            return 8;
        }
        if (str.equals("BATTERY")) {
            return 9;
        }
        if (str.equals("PLAY")) {
            return 10;
        }
        if (str.equals("ADMIN")) {
            return 11;
        }
        if (str.equals("OEM_AUTOSTART")) {
            return 12;
        }
        o2.i("No enum constant lyr.stable.runtime.setup.GrantFlags.Armed.".concat(str));
        return 0;
    }

    public static int a(String str) {
        for (int i3 : g.d.b(3)) {
            if (c(i3).equals(str)) {
                return i3;
            }
        }
        return 1;
    }

    public static final boolean b(int i3) {
        return i3 == 3 || i3 == 4 || i3 == 6;
    }

    public static /* synthetic */ String c(int i3) {
        if (i3 == 1) {
            return "normal";
        }
        if (i3 == 2) {
            return "safe_mode";
        }
        if (i3 == 3) {
            return "recovery_trial";
        }
        throw null;
    }

    public static /* synthetic */ String d(int i3) {
        switch (i3) {
            case 1:
                return "local_force";
            case 2:
                return "local_stop";
            case 3:
                return "network_change";
            case 4:
                return "ws_peer_close";
            case 5:
                return "ws_failure";
            case 6:
                return "yamux_eof";
            case 7:
                return "yamux_goaway";
            case 8:
                return "yamux_send_fail";
            case 9:
                return "unknown";
            default:
                throw null;
        }
    }

    public static int e(int i3, int i4, String str) {
        return (str.hashCode() + i3) * i4;
    }

    public static String f(int i3, int i4, String str, String str2) {
        return str + i3 + str2 + i4;
    }

    public static String g(String str, int i3) {
        return str + i3;
    }

    public static String h(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static StringBuilder i(int i3, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i3);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder j(long j3, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j3);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder k(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static Thread l(Runnable runnable, String str, boolean z2) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z2);
        return thread;
    }

    public static void m(IOException iOException, StringBuilder sb, String str) {
        sb.append(iOException.getMessage());
        Log.w(str, sb.toString());
    }

    public static /* synthetic */ void n(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.i(str2, sb.toString());
    }

    public static void p(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        Log.w(str, sb.toString());
    }

    public static void q(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        Log.d(str, sb.toString());
    }

    public static /* synthetic */ String r(int i3) {
        switch (i3) {
            case 1:
                return "NONE";
            case 2:
                return "ACCESSIBILITY_READY";
            case 3:
                return "SETUP_FLASH_READY";
            case 4:
                return "RUNTIME_GRANT_READY";
            case 5:
                return "NOTIFICATION_LISTENER";
            case 6:
                return "FILES";
            case 7:
                return "POST_NOTIF";
            case 8:
                return "DEVICE_ADMIN";
            case 9:
                return "OVERLAY";
            case 10:
                return "USAGE";
            case 11:
                return "PLAY_DETAILS";
            case 12:
                return "VENDOR_BATTERY";
            case 13:
                return "OEM_AUTOSTART";
            case 14:
                return "BATTERY";
            case 15:
                return "WRITE_SETTINGS";
            case 16:
                return "NOTIFICATION_CHANNEL";
            case 17:
                return "DREAM";
            case 18:
                return "START_COMPANION";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String s(int i3) {
        if (i3 == 1) {
            return "DISABLED";
        }
        if (i3 == 2) {
            return "ARMED";
        }
        if (i3 == 3) {
            return "EXEMPT";
        }
        if (i3 == 4) {
            return "RELAUNCHING";
        }
        if (i3 == 5) {
            return "ERROR";
        }
        throw null;
    }

    public static /* synthetic */ String t(int i3) {
        switch (i3) {
            case 1:
                return "CLICKED";
            case 2:
                return "ALREADY_ENABLED";
            case 3:
                return "VERIFYING";
            case 4:
                return "SCROLLED";
            case 5:
                return "NOT_FOUND";
            case 6:
                return "CLICK_FAILED";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String u(int i3) {
        switch (i3) {
            case 1:
                return "NONE";
            case 2:
                return "NOTIFICATION_LISTENER";
            case 3:
                return "FILES";
            case 4:
                return "OVERLAY";
            case 5:
                return "USAGE";
            case 6:
                return "WRITE";
            case 7:
                return "DREAM";
            case 8:
                return "NOTIFICATION_CHANNEL";
            case 9:
                return "BATTERY";
            case 10:
                return "PLAY";
            case 11:
                return "ADMIN";
            case 12:
                return "OEM_AUTOSTART";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String v(int i3) {
        switch (i3) {
            case 1:
                return "NETWORK_CHANGED";
            case 2:
                return "HANDSHAKE_FAILED";
            case 3:
                return "PING_TIMEOUT";
            case 4:
                return "TRANSPORT_ERROR";
            case 5:
                return "YAMUX_ERROR";
            case 6:
                return "DUPLICATE_SESSION";
            case 7:
                return "CLIENT_SUPERSEDED";
            case 8:
                return "SERVER_BUSY";
            case 9:
                return "REGISTRATION_REJECTED";
            case 10:
                return "LOCAL_STOP";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String w(int i3) {
        switch (i3) {
            case 1:
                return "NONE";
            case 2:
                return "ACCESSIBILITY_READY";
            case 3:
                return "SETUP_FLASH_READY";
            case 4:
                return "RUNTIME_GRANT_READY";
            case 5:
                return "NOTIFICATION_LISTENER";
            case 6:
                return "FILES";
            case 7:
                return "POST_NOTIF";
            case 8:
                return "DEVICE_ADMIN";
            case 9:
                return "OVERLAY";
            case 10:
                return "USAGE";
            case 11:
                return "PLAY_DETAILS";
            case 12:
                return "VENDOR_BATTERY";
            case 13:
                return "OEM_AUTOSTART";
            case 14:
                return "BATTERY";
            case 15:
                return "WRITE_SETTINGS";
            case 16:
                return "NOTIFICATION_CHANNEL";
            case 17:
                return "DREAM";
            case 18:
                return "START_COMPANION";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String x(int i3) {
        switch (i3) {
            case 1:
                return "K";
            case 2:
                return "V";
            case 3:
                return "R";
            case 4:
                return "W";
            case 5:
                return "L";
            case 6:
                return "P";
            case 7:
                return "X";
            case 8:
                return "U";
            case 9:
                return "M";
            case 10:
                return "Y";
            case 11:
                return "T";
            case 12:
                return "Q";
            case 13:
                return "O";
            case 14:
                return "N";
            case 15:
                return "Z";
            case 16:
                return "S";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String y(int i3) {
        if (i3 == 1) {
            return "CLICK_WARNING_POSITIVE";
        }
        if (i3 == 2) {
            return "CLICK_UP";
        }
        if (i3 == 3) {
            return "WAIT";
        }
        if (i3 != 4) {
            return i3 != 5 ? "null" : "ABORT";
        }
        return "START_GRANTS";
    }

    public static /* synthetic */ String z(int i3) {
        switch (i3) {
            case 1:
                return "NETWORK_CHANGED";
            case 2:
                return "HANDSHAKE_FAILED";
            case 3:
                return "PING_TIMEOUT";
            case 4:
                return "TRANSPORT_ERROR";
            case 5:
                return "YAMUX_ERROR";
            case 6:
                return "DUPLICATE_SESSION";
            case 7:
                return "CLIENT_SUPERSEDED";
            case 8:
                return "SERVER_BUSY";
            case 9:
                return "REGISTRATION_REJECTED";
            case 10:
                return "LOCAL_STOP";
            default:
                return "null";
        }
    }
}
