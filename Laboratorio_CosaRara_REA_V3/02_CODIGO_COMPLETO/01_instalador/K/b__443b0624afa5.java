// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class b extends InputStream implements DataInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataInputStream f288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteOrder f290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f292e;

    public b(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        this.f292e = bArr.length;
    }

    public final void a(int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            DataInputStream dataInputStream = this.f288a;
            int i4 = i2 - i3;
            int iSkip = (int) dataInputStream.skip(i4);
            if (iSkip <= 0) {
                if (this.f291d == null) {
                    this.f291d = new byte[8192];
                }
                iSkip = dataInputStream.read(this.f291d, 0, Math.min(8192, i4));
                if (iSkip == -1) {
                    throw new EOFException("Reached EOF while skipping " + i2 + " bytes.");
                }
            }
            i3 += iSkip;
        }
        this.f289b += i3;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f288a.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f289b++;
        return this.f288a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f289b++;
        return this.f288a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.f289b++;
        int i2 = this.f288a.read();
        if (i2 >= 0) {
            return (byte) i2;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f289b += 2;
        return this.f288a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i2, int i3) throws IOException {
        this.f289b += i3;
        this.f288a.readFully(bArr, i2, i3);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.f289b += 4;
        DataInputStream dataInputStream = this.f288a;
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        if ((i2 | i3 | i4 | i5) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f290c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i5 << 24) + (i4 << 16) + (i3 << 8) + i2;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
        }
        throw new IOException("Invalid byte order: " + this.f290c);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        this.f289b += 8;
        DataInputStream dataInputStream = this.f288a;
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        int i9 = dataInputStream.read();
        if ((i2 | i3 | i4 | i5 | i6 | i7 | i8 | i9) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f290c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (((long) i9) << 56) + (((long) i8) << 48) + (((long) i7) << 40) + (((long) i6) << 32) + (((long) i5) << 24) + (((long) i4) << 16) + (((long) i3) << 8) + ((long) i2);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (((long) i2) << 56) + (((long) i3) << 48) + (((long) i4) << 40) + (((long) i5) << 32) + (((long) i6) << 24) + (((long) i7) << 16) + (((long) i8) << 8) + ((long) i9);
        }
        throw new IOException("Invalid byte order: " + this.f290c);
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.f289b += 2;
        DataInputStream dataInputStream = this.f288a;
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        if ((i2 | i3) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f290c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (short) ((i3 << 8) + i2);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((i2 << 8) + i3);
        }
        throw new IOException("Invalid byte order: " + this.f290c);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f289b += 2;
        return this.f288a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f289b++;
        return this.f288a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.f289b += 2;
        DataInputStream dataInputStream = this.f288a;
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        if ((i2 | i3) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f290c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i3 << 8) + i2;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i2 << 8) + i3;
        }
        throw new IOException("Invalid byte order: " + this.f290c);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i2) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    public b(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f288a.read(bArr, i2, i3);
        this.f289b += i4;
        return i4;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f289b += bArr.length;
        this.f288a.readFully(bArr);
    }

    public b(InputStream inputStream, ByteOrder byteOrder) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f288a = dataInputStream;
        dataInputStream.mark(0);
        this.f289b = 0;
        this.f290c = byteOrder;
        this.f292e = inputStream instanceof b ? ((b) inputStream).f292e : -1;
    }
}
