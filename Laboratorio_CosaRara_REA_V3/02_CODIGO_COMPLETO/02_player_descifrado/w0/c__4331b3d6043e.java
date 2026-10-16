// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3377a = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f3378b = new ConcurrentHashMap();

    public static s a(URI uri, b bVar) {
        k kVar;
        s sVar;
        String str;
        Pattern pattern = u.f3436a;
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.matches("^https?|wss?$")) {
            scheme = "https";
        }
        int port = uri.getPort();
        if (port == -1) {
            if ("http".equals(scheme) || "ws".equals(scheme)) {
                port = 80;
            } else if ("https".equals(scheme) || "wss".equals(scheme)) {
                port = 443;
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        String rawUserInfo = uri.getRawUserInfo();
        String rawQuery = uri.getRawQuery();
        String rawFragment = uri.getRawFragment();
        String host = uri.getHost();
        if (host == null) {
            String rawAuthority = uri.getRawAuthority();
            if (rawAuthority == null) {
                throw new RuntimeException("unable to parse the host from the authority");
            }
            Matcher matcher = u.f3436a.matcher(rawAuthority);
            if (!matcher.matches()) {
                throw new RuntimeException("unable to parse the host from the authority");
            }
            host = matcher.group(2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        sb.append(rawUserInfo != null ? rawUserInfo.concat("@") : "");
        sb.append(host);
        sb.append(port != -1 ? a0.a.g(":", port) : "");
        sb.append(rawPath);
        sb.append(rawQuery != null ? "?".concat(rawQuery) : "");
        sb.append(rawFragment != null ? "#".concat(rawFragment) : "");
        URI uriCreate = URI.create(sb.toString());
        String str2 = scheme + "://" + host + ":" + port;
        ConcurrentHashMap concurrentHashMap = f3378b;
        boolean z2 = bVar.f3376s || (concurrentHashMap.containsKey(str2) && ((k) concurrentHashMap.get(str2)).f3407p.containsKey(uriCreate.getPath()));
        String query = uriCreate.getQuery();
        if (query != null && ((str = bVar.f6071m) == null || str.isEmpty())) {
            bVar.f6071m = query;
        }
        if (z2) {
            Logger logger = f3377a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("ignoring socket cache for " + uriCreate);
            }
            kVar = new k(uriCreate, bVar);
        } else {
            if (!concurrentHashMap.containsKey(str2)) {
                Logger logger2 = f3377a;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine("new io instance for " + uriCreate);
                }
                concurrentHashMap.putIfAbsent(str2, new k(uriCreate, bVar));
            }
            kVar = (k) concurrentHashMap.get(str2);
        }
        String path = uriCreate.getPath();
        synchronized (kVar.f3407p) {
            try {
                sVar = (s) kVar.f3407p.get(path);
                if (sVar == null) {
                    sVar = new s(kVar, path, bVar);
                    kVar.f3407p.put(path, sVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }
}
