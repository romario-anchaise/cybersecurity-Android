// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3712a;

    static {
        int i2;
        String property = System.getProperty("java.version");
        try {
            String[] strArrSplit = property.split("[._]", 3);
            i2 = Integer.parseInt(strArrSplit[0]);
            if (i2 == 1 && strArrSplit.length > 1) {
                i2 = Integer.parseInt(strArrSplit[1]);
            }
        } catch (NumberFormatException unused) {
            i2 = -1;
        }
        if (i2 == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < property.length(); i3++) {
                    char cCharAt = property.charAt(i3);
                    if (!Character.isDigit(cCharAt)) {
                        break;
                    }
                    sb.append(cCharAt);
                }
                i2 = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
        }
        if (i2 == -1) {
            i2 = 6;
        }
        f3712a = i2;
    }
}
