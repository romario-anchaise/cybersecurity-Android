// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import p022m0.d;
import p022m0.j;

/* JADX INFO: loaded from: classes.dex */
public final class s extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f3428a;

    public s(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f3428a = bool;
    }

    public static boolean d(s sVar) {
        Serializable serializable = sVar.f3428a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final BigInteger a() {
        Serializable serializable = this.f3428a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (d(this)) {
            return BigInteger.valueOf(b().longValue());
        }
        String strC = c();
        d.d(strC);
        return new BigInteger(strC);
    }

    public final Number b() {
        Serializable serializable = this.f3428a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new j((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final String c() {
        Serializable serializable = this.f3428a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return b().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        Serializable serializable = this.f3428a;
        Serializable serializable2 = sVar.f3428a;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (d(this) && d(sVar)) {
            if ((serializable instanceof BigInteger) || (serializable2 instanceof BigInteger)) {
                return a().equals(sVar.a());
            }
            return b().longValue() == sVar.b().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        if ((serializable instanceof BigDecimal) && (serializable2 instanceof BigDecimal)) {
            return (serializable instanceof BigDecimal ? (BigDecimal) serializable : d.i(c())).compareTo(serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : d.i(sVar.c())) == 0;
        }
        double dDoubleValue = serializable instanceof Number ? b().doubleValue() : Double.parseDouble(c());
        double dDoubleValue2 = serializable2 instanceof Number ? sVar.b().doubleValue() : Double.parseDouble(sVar.c());
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f3428a;
        if (serializable == null) {
            return 31;
        }
        if (d(this)) {
            jDoubleToLongBits = b().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(b().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public s(Number number) {
        Objects.requireNonNull(number);
        this.f3428a = number;
    }

    public s(String str) {
        Objects.requireNonNull(str);
        this.f3428a = str;
    }
}
