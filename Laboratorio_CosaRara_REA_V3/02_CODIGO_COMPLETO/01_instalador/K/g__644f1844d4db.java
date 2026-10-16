// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

import W.j;
import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import f1.l;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final byte[] f303A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final String[] f304B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final int[] f305C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final byte[] f306D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final d f307E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final d[][] f308F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final d[] f309G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final HashMap[] f310H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final HashMap[] f311I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final HashSet f312J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final HashMap f313K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final Charset f314L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final byte[] f315M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final byte[] f316N;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f317l = Log.isLoggable("ExifInterface", 3);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte[] f322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte[] f323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final byte[] f326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final byte[] f327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte[] f329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final byte[] f330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final byte[] f331z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileDescriptor f332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager.AssetInputStream f333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap[] f335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet f336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ByteOrder f337f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f341k;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f318m = new int[]{8, 8, 8};
        f319n = new int[]{8};
        f320o = new byte[]{-1, -40, -1};
        f321p = new byte[]{102, 116, 121, 112};
        f322q = new byte[]{109, 105, 102, 49};
        f323r = new byte[]{104, 101, 105, 99};
        f324s = new byte[]{79, 76, 89, 77, 80, 0};
        f325t = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f326u = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        f327v = new byte[]{101, 88, 73, 102};
        f328w = new byte[]{73, 72, 68, 82};
        f329x = new byte[]{73, 69, 78, 68};
        f330y = new byte[]{82, 73, 70, 70};
        f331z = new byte[]{87, 69, 66, 80};
        f303A = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        f304B = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f305C = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f306D = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f307E = new d("StripOffsets", 273, 3);
        f308F = new d[][]{dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, new d[]{new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)}, new d[]{new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)}, new d[]{new d("AspectFrame", 4371, 3)}, new d[]{new d("ColorSpace", 55, 3)}};
        f309G = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f310H = new HashMap[10];
        f311I = new HashMap[10];
        f312J = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f313K = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f314L = charsetForName;
        f315M = "Exif\u0000\u0000".getBytes(charsetForName);
        f316N = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            d[][] dVarArr6 = f308F;
            if (i2 >= dVarArr6.length) {
                HashMap map = f313K;
                d[] dVarArr7 = f309G;
                map.put(Integer.valueOf(dVarArr7[0].f297a), 5);
                map.put(Integer.valueOf(dVarArr7[1].f297a), 1);
                map.put(Integer.valueOf(dVarArr7[2].f297a), 2);
                map.put(Integer.valueOf(dVarArr7[3].f297a), 3);
                map.put(Integer.valueOf(dVarArr7[4].f297a), 7);
                map.put(Integer.valueOf(dVarArr7[5].f297a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f310H[i2] = new HashMap();
            f311I[i2] = new HashMap();
            for (d dVar : dVarArr6[i2]) {
                f310H[i2].put(Integer.valueOf(dVar.f297a), dVar);
                f311I[i2].put(dVar.f298b, dVar);
            }
            i2++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00aa A[Catch: all -> 0x0030, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0030, blocks: (B:3:0x0021, B:5:0x0024, B:12:0x0039, B:18:0x0056, B:20:0x0061, B:28:0x0077, B:23:0x0068, B:26:0x0070, B:27:0x0074, B:29:0x0081, B:31:0x008a, B:33:0x0090, B:35:0x0096, B:37:0x009c, B:42:0x00aa), top: B:52:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    public g(j jVar) {
        d[][] dVarArr = f308F;
        this.f335d = new HashMap[dVarArr.length];
        this.f336e = new HashSet(dVarArr.length);
        this.f337f = ByteOrder.BIG_ENDIAN;
        boolean z2 = f317l;
        this.f333b = null;
        this.f332a = null;
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            try {
                try {
                    this.f335d[i2] = new HashMap();
                } catch (Throwable th) {
                    a();
                    if (z2) {
                        p();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                if (z2) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                a();
                if (!z2) {
                    return;
                }
            } catch (UnsupportedOperationException e3) {
                e = e3;
                if (z2) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                a();
                if (!z2) {
                    return;
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(jVar, 5000);
        int iF = f(bufferedInputStream);
        this.f334c = iF;
        if (iF == 4 || iF == 9 || iF == 13 || iF == 14) {
            b bVar = new b(bufferedInputStream);
            int i3 = this.f334c;
            if (i3 == 4) {
                e(bVar, 0, 0);
            } else if (i3 == 13) {
                h(bVar);
            } else if (i3 == 9) {
                i(bVar);
            } else if (i3 == 14) {
                l(bVar);
            }
        } else {
            f fVar = new f(bufferedInputStream);
            int i4 = this.f334c;
            if (i4 == 12) {
                d(fVar);
            } else if (i4 == 7) {
                g(fVar);
            } else if (i4 == 10) {
                k(fVar);
            } else {
                j(fVar);
            }
            fVar.f(this.f338h);
            u(fVar);
        }
        a();
        if (!z2) {
            return;
        }
        p();
    }

    public static ByteOrder q(b bVar) throws IOException {
        short s2 = bVar.readShort();
        boolean z2 = f317l;
        if (s2 == 18761) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        HashMap[] mapArr = this.f335d;
        if (strB != null && b("DateTime") == null) {
            HashMap map = mapArr[0];
            byte[] bytes = strB.concat("\u0000").getBytes(f314L);
            map.put("DateTime", new c(bytes, 2, bytes.length));
        }
        if (b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", c.a(0L, this.f337f));
        }
        if (b("ImageLength") == null) {
            mapArr[0].put("ImageLength", c.a(0L, this.f337f));
        }
        if (b("Orientation") == null) {
            mapArr[0].put("Orientation", c.a(0L, this.f337f));
        }
        if (b("LightSource") == null) {
            mapArr[1].put("LightSource", c.a(0L, this.f337f));
        }
    }

    public final String b(String str) {
        c cVarC = c(str);
        if (cVarC != null) {
            if (!f312J.contains(str)) {
                return cVarC.f(this.f337f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = cVarC.f293a;
                if (i2 != 5 && i2 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i2);
                    return null;
                }
                e[] eVarArr = (e[]) cVarC.g(this.f337f);
                if (eVarArr == null || eVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (eVar.f301a / eVar.f302b));
                e eVar2 = eVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (eVar2.f301a / eVar2.f302b));
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (eVar3.f301a / eVar3.f302b)));
            }
            try {
                return Double.toString(cVarC.d(this.f337f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final c c(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            if (f317l) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < f308F.length; i2++) {
            c cVar = (c) this.f335d[i2].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final void d(f fVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i2;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                i.a(mediaMetadataRetriever, new a(fVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.f335d;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", c.c(Integer.parseInt(strExtractMetadata), this.f337f));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", c.c(Integer.parseInt(strExtractMetadata2), this.f337f));
                }
                if (strExtractMetadata3 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata3);
                    if (i3 == 90) {
                        i2 = 6;
                    } else if (i3 != 180) {
                        i2 = i3 != 270 ? 1 : 8;
                    } else {
                        i2 = 3;
                    }
                    mapArr[0].put("Orientation", c.c(i2, this.f337f));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i4 = Integer.parseInt(strExtractMetadata4);
                    int i5 = Integer.parseInt(strExtractMetadata5);
                    if (i5 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.f(i4);
                    byte[] bArr = new byte[6];
                    fVar.readFully(bArr);
                    int i6 = i4 + 6;
                    int i7 = i5 - 6;
                    if (!Arrays.equals(bArr, f315M)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i7];
                    fVar.readFully(bArr2);
                    this.f338h = i6;
                    r(bArr2, 0);
                }
                if (f317l) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0134  */
    /* JADX WARN: Code duplicated, block: B:70:0x013b A[LOOP:2: B:65:0x0131->B:70:0x013b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x014d  */
    /* JADX WARN: Code duplicated, block: B:98:0x013e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x017f A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void e(K.b r23, int r24, int r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: K.g.e(K.b, int, int):void");
    }

    /* JADX WARN: Code duplicated, block: B:104:0x012b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:106:0x012e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0134  */
    /* JADX WARN: Code duplicated, block: B:112:0x013c A[LOOP:2: B:107:0x012f->B:112:0x013c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:115:0x0142 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:117:0x0145  */
    /* JADX WARN: Code duplicated, block: B:120:0x014b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0153 A[LOOP:3: B:118:0x0146->B:123:0x0153, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:127:0x015c  */
    /* JADX WARN: Code duplicated, block: B:130:0x0166 A[LOOP:4: B:125:0x0157->B:130:0x0166, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:133:0x016c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x016f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:159:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x013a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0151 A[EDGE_INSN: B:167:0x0151->B:122:0x0151 BREAK  A[LOOP:3: B:118:0x0146->B:123:0x0153], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0151 A[EDGE_INSN: B:168:0x0151->B:122:0x0151 BREAK  A[LOOP:3: B:118:0x0146->B:123:0x0153], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00da  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x010c  */
    /* JADX WARN: Code duplicated, block: B:89:0x010e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r8v0 */
    public final int f(BufferedInputStream bufferedInputStream) throws Throwable {
        ?? r6;
        b bVar;
        b bVar2;
        b bVar3;
        boolean z2;
        b bVar4;
        b bVar5;
        boolean z3;
        int i2;
        byte[] bArr;
        boolean z4;
        int i3;
        byte[] bArr2;
        int i4;
        byte[] bArr3;
        boolean z5;
        b bVar6;
        short s2;
        long j2;
        bufferedInputStream.mark(5000);
        byte[] bArr4 = new byte[5000];
        bufferedInputStream.read(bArr4);
        bufferedInputStream.reset();
        int i5 = 0;
        while (true) {
            byte[] bArr5 = f320o;
            if (i5 >= bArr5.length) {
                return 4;
            }
            if (bArr4[i5] != bArr5[i5]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i6 = 0; i6 < bytes.length; i6++) {
                    byte b2 = bArr4[i6];
                    ?? r8 = bytes[i6];
                    try {
                        if (b2 != r8) {
                            try {
                                bVar = new b(bArr4);
                                try {
                                    long j3 = bVar.readInt();
                                    byte[] bArr6 = new byte[4];
                                    bVar.readFully(bArr6);
                                    if (Arrays.equals(bArr6, f321p)) {
                                        if (j3 == 1) {
                                            j3 = bVar.readLong();
                                            j2 = 16;
                                            if (j3 < 16) {
                                            }
                                        } else {
                                            j2 = 8;
                                        }
                                        long j4 = 5000;
                                        if (j3 > j4) {
                                            j3 = j4;
                                        }
                                        long j5 = j3 - j2;
                                        if (j5 >= 8) {
                                            byte[] bArr7 = new byte[4];
                                            boolean z6 = false;
                                            boolean z7 = false;
                                            for (long j6 = 0; j6 < j5 / 4; j6++) {
                                                try {
                                                    bVar.readFully(bArr7);
                                                    if (j6 != 1) {
                                                        if (Arrays.equals(bArr7, f322q)) {
                                                            z6 = true;
                                                        } else if (Arrays.equals(bArr7, f323r)) {
                                                            z7 = true;
                                                        }
                                                        if (z6 && z7) {
                                                            bVar.close();
                                                            return 12;
                                                        }
                                                    }
                                                } catch (EOFException unused) {
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    if (f317l) {
                                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                                    }
                                    if (bVar != null) {
                                    }
                                    bVar3 = new b(bArr4);
                                    ByteOrder byteOrderQ = q(bVar3);
                                    this.f337f = byteOrderQ;
                                    bVar3.f290c = byteOrderQ;
                                    s2 = bVar3.readShort();
                                    if (s2 != 20306) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    bVar3.close();
                                    if (z2) {
                                        return 7;
                                    }
                                    try {
                                        bVar6 = new b(bArr4);
                                        try {
                                            ByteOrder byteOrderQ2 = q(bVar6);
                                            this.f337f = byteOrderQ2;
                                            bVar6.f290c = byteOrderQ2;
                                            if (bVar6.readShort() == 85) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            bVar6.close();
                                        } catch (Exception unused2) {
                                            bVar5 = bVar6;
                                            if (bVar5 != null) {
                                                bVar5.close();
                                            }
                                            z3 = false;
                                        } catch (Throwable th) {
                                            th = th;
                                            bVar4 = bVar6;
                                            if (bVar4 != null) {
                                                bVar4.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception unused3) {
                                        bVar5 = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bVar4 = null;
                                    }
                                    if (z3) {
                                        return 10;
                                    }
                                    i2 = 0;
                                    while (true) {
                                        bArr = f326u;
                                        if (i2 < bArr.length) {
                                            z4 = true;
                                            break;
                                        }
                                        if (bArr4[i2] != bArr[i2]) {
                                            z4 = false;
                                            break;
                                        }
                                        i2++;
                                    }
                                    if (z4) {
                                        return 13;
                                    }
                                    i3 = 0;
                                    while (true) {
                                        bArr2 = f330y;
                                        if (i3 < bArr2.length) {
                                            i4 = 0;
                                            while (true) {
                                                bArr3 = f331z;
                                                if (i4 < bArr3.length) {
                                                    z5 = true;
                                                } else {
                                                    if (bArr4[bArr2.length + i4 + 4] != bArr3[i4]) {
                                                        break;
                                                    }
                                                    i4++;
                                                }
                                                if (z5) {
                                                    return 14;
                                                }
                                                return 0;
                                            }
                                        }
                                        if (bArr4[i3] != bArr2[i3]) {
                                            break;
                                        }
                                        i3++;
                                    }
                                    z5 = false;
                                    if (z5) {
                                        return 14;
                                    }
                                    return 0;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bVar = null;
                            } catch (Throwable th3) {
                                th = th3;
                                r6 = 0;
                                if (r6 != 0) {
                                    r6.close();
                                }
                                throw th;
                            }
                            bVar.close();
                            try {
                                bVar3 = new b(bArr4);
                                try {
                                    ByteOrder byteOrderQ3 = q(bVar3);
                                    this.f337f = byteOrderQ3;
                                    bVar3.f290c = byteOrderQ3;
                                    s2 = bVar3.readShort();
                                    if (s2 != 20306 || s2 == 21330) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    bVar3.close();
                                } catch (Exception unused4) {
                                    if (bVar3 != null) {
                                        bVar3.close();
                                    }
                                    z2 = false;
                                } catch (Throwable th4) {
                                    th = th4;
                                    bVar2 = bVar3;
                                    if (bVar2 != null) {
                                        bVar2.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception unused5) {
                                bVar3 = null;
                            } catch (Throwable th5) {
                                th = th5;
                                bVar2 = null;
                            }
                            if (z2) {
                                return 7;
                            }
                            bVar6 = new b(bArr4);
                            ByteOrder byteOrderQ4 = q(bVar6);
                            this.f337f = byteOrderQ4;
                            bVar6.f290c = byteOrderQ4;
                            if (bVar6.readShort() == 85) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            bVar6.close();
                            if (z3) {
                                return 10;
                            }
                            i2 = 0;
                            while (true) {
                                bArr = f326u;
                                if (i2 < bArr.length) {
                                    z4 = true;
                                    break;
                                }
                                if (bArr4[i2] != bArr[i2]) {
                                    z4 = false;
                                    break;
                                }
                                i2++;
                            }
                            if (z4) {
                                return 13;
                            }
                            i3 = 0;
                            while (true) {
                                bArr2 = f330y;
                                if (i3 < bArr2.length) {
                                    i4 = 0;
                                    while (true) {
                                        bArr3 = f331z;
                                        if (i4 < bArr3.length) {
                                            z5 = true;
                                        } else {
                                            if (bArr4[bArr2.length + i4 + 4] != bArr3[i4]) {
                                                break;
                                                break;
                                            }
                                            i4++;
                                        }
                                        if (z5) {
                                            return 14;
                                        }
                                        return 0;
                                    }
                                }
                                if (bArr4[i3] != bArr2[i3]) {
                                    break;
                                    break;
                                }
                                i3++;
                            }
                            z5 = false;
                            if (z5) {
                                return 14;
                            }
                            return 0;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r6 = r8;
                    }
                }
                return 9;
            }
            i5++;
        }
    }

    public final void g(f fVar) throws IOException {
        int i2;
        int i3;
        j(fVar);
        HashMap[] mapArr = this.f335d;
        c cVar = (c) mapArr[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f296d);
            fVar2.f290c = this.f337f;
            byte[] bArr = f324s;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.f(0L);
            byte[] bArr3 = f325t;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.f(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.f(12L);
            }
            s(fVar2, 6);
            c cVar2 = (c) mapArr[7].get("PreviewImageStart");
            c cVar3 = (c) mapArr[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", cVar2);
                mapArr[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) mapArr[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.g(this.f337f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i4 = iArr[2];
                int i5 = iArr[0];
                if (i4 <= i5 || (i2 = iArr[3]) <= (i3 = iArr[1])) {
                    return;
                }
                int i6 = (i4 - i5) + 1;
                int i7 = (i2 - i3) + 1;
                if (i6 < i7) {
                    int i8 = i6 + i7;
                    i7 = i8 - i7;
                    i6 = i8 - i7;
                }
                c cVarC = c.c(i6, this.f337f);
                c cVarC2 = c.c(i7, this.f337f);
                mapArr[0].put("ImageWidth", cVarC);
                mapArr[0].put("ImageLength", cVarC2);
            }
        }
    }

    public final void h(b bVar) throws IOException {
        if (f317l) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.f290c = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f326u;
        bVar.a(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i2 = bVar.readInt();
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i3 = length + 8;
                if (i3 == 16 && !Arrays.equals(bArr2, f328w)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f329x)) {
                    return;
                }
                if (Arrays.equals(bArr2, f327v)) {
                    byte[] bArr3 = new byte[i2];
                    bVar.readFully(bArr3);
                    int i4 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i4) {
                        this.f338h = i3;
                        r(bArr3, 0);
                        x();
                        u(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i4 + ", calculated CRC value: " + crc32.getValue());
                }
                int i5 = i2 + 4;
                bVar.a(i5);
                length = i3 + i5;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void i(b bVar) throws IOException {
        boolean z2 = f317l;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        bVar.a(i2 - bVar.f289b);
        bVar.readFully(bArr4);
        e(new b(bArr4), i2, 5);
        bVar.a(i4 - bVar.f289b);
        bVar.f290c = ByteOrder.BIG_ENDIAN;
        int i5 = bVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i5);
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f307E.f297a) {
                short s2 = bVar.readShort();
                short s3 = bVar.readShort();
                c cVarC = c.c(s2, this.f337f);
                c cVarC2 = c.c(s3, this.f337f);
                HashMap[] mapArr = this.f335d;
                mapArr[0].put("ImageLength", cVarC);
                mapArr[0].put("ImageWidth", cVarC2);
                if (z2) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s2) + ", width: " + ((int) s3));
                    return;
                }
                return;
            }
            bVar.a(unsignedShort2);
        }
    }

    public final void j(f fVar) throws IOException {
        o(fVar);
        s(fVar, 0);
        w(fVar, 0);
        w(fVar, 5);
        w(fVar, 4);
        x();
        if (this.f334c == 8) {
            HashMap[] mapArr = this.f335d;
            c cVar = (c) mapArr[1].get("MakerNote");
            if (cVar != null) {
                f fVar2 = new f(cVar.f296d);
                fVar2.f290c = this.f337f;
                fVar2.a(6);
                s(fVar2, 9);
                c cVar2 = (c) mapArr[9].get("ColorSpace");
                if (cVar2 != null) {
                    mapArr[1].put("ColorSpace", cVar2);
                }
            }
        }
    }

    public final void k(f fVar) throws IOException {
        if (f317l) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        j(fVar);
        HashMap[] mapArr = this.f335d;
        c cVar = (c) mapArr[0].get("JpgFromRaw");
        if (cVar != null) {
            e(new b(cVar.f296d), (int) cVar.f295c, 5);
        }
        c cVar2 = (c) mapArr[0].get("ISO");
        c cVar3 = (c) mapArr[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", cVar2);
    }

    public final void l(b bVar) throws IOException {
        if (f317l) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.f290c = ByteOrder.LITTLE_ENDIAN;
        bVar.a(f330y.length);
        int i2 = bVar.readInt() + 8;
        byte[] bArr = f331z;
        bVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i3 = bVar.readInt();
                int i4 = length + 8;
                if (Arrays.equals(f303A, bArr2)) {
                    byte[] bArr3 = new byte[i3];
                    bVar.readFully(bArr3);
                    this.f338h = i4;
                    r(bArr3, 0);
                    u(new b(bArr3));
                    return;
                }
                if (i3 % 2 == 1) {
                    i3++;
                }
                length = i4 + i3;
                if (length == i2) {
                    return;
                }
                if (length > i2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.a(i3);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void m(b bVar, HashMap map) throws IOException {
        c cVar = (c) map.get("JPEGInterchangeFormat");
        c cVar2 = (c) map.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int iE = cVar.e(this.f337f);
        int iE2 = cVar2.e(this.f337f);
        if (this.f334c == 7) {
            iE += this.f339i;
        }
        if (iE > 0 && iE2 > 0 && this.f333b == null && this.f332a == null) {
            bVar.a(iE);
            bVar.readFully(new byte[iE2]);
        }
        if (f317l) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iE + ", length: " + iE2);
        }
    }

    public final boolean n(HashMap map) {
        c cVar = (c) map.get("ImageLength");
        c cVar2 = (c) map.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.e(this.f337f) <= 512 && cVar2.e(this.f337f) <= 512;
    }

    public final void o(f fVar) throws IOException {
        ByteOrder byteOrderQ = q(fVar);
        this.f337f = byteOrderQ;
        fVar.f290c = byteOrderQ;
        int unsignedShort = fVar.readUnsignedShort();
        int i2 = this.f334c;
        if (i2 != 7 && i2 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i3 = fVar.readInt();
        if (i3 < 8) {
            throw new IOException(F0.h.b(i3, "Invalid first Ifd offset: "));
        }
        int i4 = i3 - 8;
        if (i4 > 0) {
            fVar.a(i4);
        }
    }

    public final void p() {
        int i2 = 0;
        while (true) {
            HashMap[] mapArr = this.f335d;
            if (i2 >= mapArr.length) {
                return;
            }
            Log.d("ExifInterface", "The size of tag group[" + i2 + "]: " + mapArr[i2].size());
            for (Map.Entry entry : mapArr[i2].entrySet()) {
                c cVar = (c) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + cVar.toString() + ", tagValue: '" + cVar.f(this.f337f) + "'");
            }
            i2++;
        }
    }

    public final void r(byte[] bArr, int i2) throws IOException {
        f fVar = new f(bArr);
        o(fVar);
        s(fVar, i2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0204  */
    /* JADX WARN: Code duplicated, block: B:107:0x0215  */
    /* JADX WARN: Code duplicated, block: B:108:0x021a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0226  */
    /* JADX WARN: Code duplicated, block: B:111:0x022d  */
    /* JADX WARN: Code duplicated, block: B:114:0x024b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:118:0x0253  */
    /* JADX WARN: Code duplicated, block: B:126:0x0291  */
    /* JADX WARN: Code duplicated, block: B:128:0x0299  */
    /* JADX WARN: Code duplicated, block: B:131:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:133:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:150:0x0330  */
    /* JADX WARN: Code duplicated, block: B:174:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x012e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0144  */
    /* JADX WARN: Code duplicated, block: B:71:0x014b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0151  */
    /* JADX WARN: Code duplicated, block: B:75:0x0157  */
    /* JADX WARN: Code duplicated, block: B:76:0x016b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0172  */
    /* JADX WARN: Code duplicated, block: B:81:0x017c  */
    /* JADX WARN: Code duplicated, block: B:82:0x017e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0183  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:92:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:98:0x0200  */
    /* JADX WARN: Instruction removed from duplicated block: B:128:0x0299, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x012e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:75:0x0157, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:92:0x01dd, please report this as an issue */
    public final void s(f fVar, int i2) throws IOException {
        HashMap[] mapArr;
        long j2;
        boolean z2;
        int i3;
        Integer num;
        HashSet hashSet;
        long j3;
        String str;
        int i4;
        int unsignedShort;
        long j4;
        int i5;
        String strD;
        int i6;
        Integer numValueOf = Integer.valueOf(fVar.f289b);
        HashSet hashSet2 = this.f336e;
        hashSet2.add(numValueOf);
        short s2 = fVar.readShort();
        boolean z3 = f317l;
        if (z3) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s2));
        }
        if (s2 <= 0) {
            return;
        }
        short s3 = 0;
        while (true) {
            mapArr = this.f335d;
            if (s3 >= s2) {
                break;
            }
            int unsignedShort2 = fVar.readUnsignedShort();
            int unsignedShort3 = fVar.readUnsignedShort();
            int i7 = fVar.readInt();
            long j5 = ((long) fVar.f289b) + 4;
            d dVar = (d) f310H[i2].get(Integer.valueOf(unsignedShort2));
            if (z3) {
                Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i2), Integer.valueOf(unsignedShort2), dVar != null ? dVar.f298b : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i7)));
            }
            if (dVar != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = f305C;
                    if (unsignedShort3 < iArr.length) {
                        int i8 = dVar.f299c;
                        if (i8 == 7 || unsignedShort3 == 7 || i8 == unsignedShort3 || (i3 = dVar.f300d) == unsignedShort3 || (((i8 == 4 || i3 == 4) && unsignedShort3 == 3) || (((i8 == 9 || i3 == 9) && unsignedShort3 == 8) || ((i8 == 12 || i3 == 12) && unsignedShort3 == 11)))) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = i8;
                            }
                            j2 = ((long) iArr[unsignedShort3]) * ((long) i7);
                            if (j2 < 0 || j2 > 2147483647L) {
                                if (z3) {
                                    Log.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i7);
                                }
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else if (z3) {
                            Log.d("ExifInterface", "Skip the tag entry since data format (" + f304B[unsignedShort3] + ") is unexpected for tag: " + dVar.f298b);
                        }
                    } else if (z3) {
                        Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                    }
                } else if (z3) {
                    Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                if (z2) {
                    if (j2 > 4) {
                        i6 = fVar.readInt();
                        if (z3) {
                            Log.d("ExifInterface", "seek to data offset: " + i6);
                        }
                        if (this.f334c != 7) {
                            if ("MakerNote".equals(dVar.f298b)) {
                                this.f339i = i6;
                            } else if (i2 != 6 && "ThumbnailImage".equals(dVar.f298b)) {
                                this.f340j = i6;
                                this.f341k = i7;
                                c cVarC = c.c(6, this.f337f);
                                c cVarA = c.a(this.f340j, this.f337f);
                                c cVarA2 = c.a(this.f341k, this.f337f);
                                mapArr[4].put("Compression", cVarC);
                                mapArr[4].put("JPEGInterchangeFormat", cVarA);
                                mapArr[4].put("JPEGInterchangeFormatLength", cVarA2);
                            }
                        }
                        fVar.f(i6);
                    } else {
                        j5 = j5;
                        unsignedShort3 = unsignedShort3;
                        i7 = i7;
                    }
                    num = (Integer) f313K.get(Integer.valueOf(unsignedShort2));
                    if (z3) {
                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j2);
                    }
                    if (num != null) {
                        i4 = unsignedShort3;
                        if (i4 != 3) {
                            if (i4 != 4) {
                                j4 = ((long) fVar.readInt()) & 4294967295L;
                            } else if (i4 == 8) {
                                unsignedShort = fVar.readShort();
                            } else if (i4 != 9 || i4 == 13) {
                                unsignedShort = fVar.readInt();
                            } else {
                                j4 = -1;
                            }
                            if (z3) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j4), dVar.f298b));
                            }
                            i5 = fVar.f292e;
                            if (j4 > 0 || (i5 != -1 && j4 >= i5)) {
                                hashSet = hashSet2;
                                if (z3) {
                                    strD = F0.h.d("Skip jump into the IFD since its offset is invalid: ", j4);
                                    if (i5 != -1) {
                                        strD = strD + " (total length: " + i5 + ")";
                                    }
                                    Log.d("ExifInterface", strD);
                                }
                            } else {
                                hashSet = hashSet2;
                                if (!hashSet.contains(Integer.valueOf((int) j4))) {
                                    fVar.f(j4);
                                    s(fVar, num.intValue());
                                } else if (z3) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j4 + ")");
                                }
                            }
                            fVar.f(j5);
                        } else {
                            unsignedShort = fVar.readUnsignedShort();
                        }
                        j4 = unsignedShort;
                        if (z3) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j4), dVar.f298b));
                        }
                        i5 = fVar.f292e;
                        if (j4 > 0) {
                            hashSet = hashSet2;
                            if (z3) {
                                strD = F0.h.d("Skip jump into the IFD since its offset is invalid: ", j4);
                                if (i5 != -1) {
                                    strD = strD + " (total length: " + i5 + ")";
                                }
                                Log.d("ExifInterface", strD);
                            }
                        } else {
                            hashSet = hashSet2;
                            if (z3) {
                                strD = F0.h.d("Skip jump into the IFD since its offset is invalid: ", j4);
                                if (i5 != -1) {
                                    strD = strD + " (total length: " + i5 + ")";
                                }
                                Log.d("ExifInterface", strD);
                            }
                        }
                        fVar.f(j5);
                    } else {
                        hashSet = hashSet2;
                        j3 = j5;
                        int i9 = fVar.f289b + this.f338h;
                        byte[] bArr = new byte[(int) j2];
                        fVar.readFully(bArr);
                        c cVar = new c(i9, bArr, unsignedShort3, i7);
                        mapArr[i2].put(dVar.f298b, cVar);
                        str = dVar.f298b;
                        if ("DNGVersion".equals(str)) {
                            this.f334c = 3;
                        }
                        if (((!"Make".equals(str) || "Model".equals(str)) && cVar.f(this.f337f).contains("PENTAX")) || ("Compression".equals(str) && cVar.e(this.f337f) == 65535)) {
                            this.f334c = 8;
                        }
                        if (fVar.f289b != j3) {
                            fVar.f(j3);
                        }
                    }
                } else {
                    fVar.f(j5);
                    hashSet = hashSet2;
                }
                s3 = (short) (s3 + 1);
                hashSet2 = hashSet;
                s2 = s2;
            } else if (z3) {
                Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            }
            j2 = 0;
            z2 = false;
            if (z2) {
                fVar.f(j5);
                hashSet = hashSet2;
            } else {
                if (j2 > 4) {
                    i6 = fVar.readInt();
                    if (z3) {
                        Log.d("ExifInterface", "seek to data offset: " + i6);
                    }
                    if (this.f334c != 7) {
                        if ("MakerNote".equals(dVar.f298b)) {
                            this.f339i = i6;
                        } else if (i2 != 6) {
                        }
                    }
                    fVar.f(i6);
                } else {
                    j5 = j5;
                    unsignedShort3 = unsignedShort3;
                    i7 = i7;
                }
                num = (Integer) f313K.get(Integer.valueOf(unsignedShort2));
                if (z3) {
                    Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j2);
                }
                if (num != null) {
                    i4 = unsignedShort3;
                    if (i4 != 3) {
                        if (i4 != 4) {
                            j4 = ((long) fVar.readInt()) & 4294967295L;
                        } else if (i4 == 8) {
                            if (i4 != 9) {
                            }
                            unsignedShort = fVar.readInt();
                        } else {
                            unsignedShort = fVar.readShort();
                        }
                        if (z3) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j4), dVar.f298b));
                        }
                        i5 = fVar.f292e;
                        if (j4 > 0) {
                            hashSet = hashSet2;
                            if (z3) {
                                strD = F0.h.d("Skip jump into the IFD since its offset is invalid: ", j4);
                                if (i5 != -1) {
                                    strD = strD + " (total length: " + i5 + ")";
                                }
                                Log.d("ExifInterface", strD);
                            }
                        } else {
                            hashSet = hashSet2;
                            if (z3) {
                                strD = F0.h.d("Skip jump into the IFD since its offset is invalid: ", j4);
                                if (i5 != -1) {
                                    strD = strD + " (total length: " + i5 + ")";
                                }
                                Log.d("ExifInterface", strD);
                            }
                        }
                        fVar.f(j5);
                    } else {
                        unsignedShort = fVar.readUnsignedShort();
                    }
                    j4 = unsignedShort;
                    if (z3) {
                        Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j4), dVar.f298b));
                    }
                    i5 = fVar.f292e;
                    if (j4 > 0) {
                        hashSet = hashSet2;
                        if (z3) {
                            strD = F0.h.d("Skip jump into the IFD since its offset is invalid: ", j4);
                            if (i5 != -1) {
                                strD = strD + " (total length: " + i5 + ")";
                            }
                            Log.d("ExifInterface", strD);
                        }
                    } else {
                        hashSet = hashSet2;
                        if (z3) {
                            strD = F0.h.d("Skip jump into the IFD since its offset is invalid: ", j4);
                            if (i5 != -1) {
                                strD = strD + " (total length: " + i5 + ")";
                            }
                            Log.d("ExifInterface", strD);
                        }
                    }
                    fVar.f(j5);
                } else {
                    hashSet = hashSet2;
                    j3 = j5;
                    int i10 = fVar.f289b + this.f338h;
                    byte[] bArr2 = new byte[(int) j2];
                    fVar.readFully(bArr2);
                    c cVar2 = new c(i10, bArr2, unsignedShort3, i7);
                    mapArr[i2].put(dVar.f298b, cVar2);
                    str = dVar.f298b;
                    if ("DNGVersion".equals(str)) {
                        this.f334c = 3;
                    }
                    if (!"Make".equals(str)) {
                    }
                    this.f334c = 8;
                    if (fVar.f289b != j3) {
                        fVar.f(j3);
                    }
                }
            }
            s3 = (short) (s3 + 1);
            hashSet2 = hashSet;
            s2 = s2;
        }
        HashSet hashSet3 = hashSet2;
        int i11 = fVar.readInt();
        if (z3) {
            Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i11)));
        }
        long j6 = i11;
        if (j6 <= 0) {
            if (z3) {
                Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i11);
                return;
            }
            return;
        }
        if (hashSet3.contains(Integer.valueOf(i11))) {
            if (z3) {
                Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i11);
                return;
            }
            return;
        }
        fVar.f(j6);
        if (mapArr[4].isEmpty()) {
            s(fVar, 4);
        } else if (mapArr[5].isEmpty()) {
            s(fVar, 5);
        }
    }

    public final void t(int i2, String str, String str2) {
        HashMap[] mapArr = this.f335d;
        if (mapArr[i2].isEmpty() || mapArr[i2].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i2];
        map.put(str2, map.get(str));
        mapArr[i2].remove(str);
    }

    public final void u(b bVar) throws IOException {
        c cVar;
        int iE;
        HashMap map = this.f335d[4];
        c cVar2 = (c) map.get("Compression");
        if (cVar2 == null) {
            m(bVar, map);
            return;
        }
        int iE2 = cVar2.e(this.f337f);
        if (iE2 != 1) {
            if (iE2 == 6) {
                m(bVar, map);
                return;
            } else if (iE2 != 7) {
                return;
            }
        }
        c cVar3 = (c) map.get("BitsPerSample");
        if (cVar3 != null) {
            int[] iArr = (int[]) cVar3.g(this.f337f);
            int[] iArr2 = f318m;
            if (Arrays.equals(iArr2, iArr) || (this.f334c == 3 && (cVar = (c) map.get("PhotometricInterpretation")) != null && (((iE = cVar.e(this.f337f)) == 1 && Arrays.equals(iArr, f319n)) || (iE == 6 && Arrays.equals(iArr, iArr2))))) {
                c cVar4 = (c) map.get("StripOffsets");
                c cVar5 = (c) map.get("StripByteCounts");
                if (cVar4 == null || cVar5 == null) {
                    return;
                }
                long[] jArrR = l.r(cVar4.g(this.f337f));
                long[] jArrR2 = l.r(cVar5.g(this.f337f));
                if (jArrR == null || jArrR.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrR2 == null || jArrR2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrR.length != jArrR2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j2 = 0;
                for (long j3 : jArrR2) {
                    j2 += j3;
                }
                byte[] bArr = new byte[(int) j2];
                this.g = true;
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < jArrR.length; i4++) {
                    int i5 = (int) jArrR[i4];
                    int i6 = (int) jArrR2[i4];
                    if (i4 < jArrR.length - 1 && i5 + i6 != jArrR[i4 + 1]) {
                        this.g = false;
                    }
                    int i7 = i5 - i2;
                    if (i7 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    try {
                        bVar.a(i7);
                        int i8 = i2 + i7;
                        byte[] bArr2 = new byte[i6];
                        try {
                            bVar.readFully(bArr2);
                            i2 = i8 + i6;
                            System.arraycopy(bArr2, 0, bArr, i3, i6);
                            i3 += i6;
                        } catch (EOFException unused) {
                            Log.d("ExifInterface", "Failed to read " + i6 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d("ExifInterface", "Failed to skip " + i7 + " bytes.");
                        return;
                    }
                }
                if (this.g) {
                    long j4 = jArrR[0];
                    return;
                }
                return;
            }
        }
        if (f317l) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void v(int i2, int i3) {
        HashMap[] mapArr = this.f335d;
        boolean zIsEmpty = mapArr[i2].isEmpty();
        boolean z2 = f317l;
        if (zIsEmpty || mapArr[i3].isEmpty()) {
            if (z2) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = (c) mapArr[i2].get("ImageLength");
        c cVar2 = (c) mapArr[i2].get("ImageWidth");
        c cVar3 = (c) mapArr[i3].get("ImageLength");
        c cVar4 = (c) mapArr[i3].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (z2) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (cVar3 == null || cVar4 == null) {
            if (z2) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iE = cVar.e(this.f337f);
        int iE2 = cVar2.e(this.f337f);
        int iE3 = cVar3.e(this.f337f);
        int iE4 = cVar4.e(this.f337f);
        if (iE >= iE3 || iE2 >= iE4) {
            return;
        }
        HashMap map = mapArr[i2];
        mapArr[i2] = mapArr[i3];
        mapArr[i3] = map;
    }

    public final void w(f fVar, int i2) throws IOException {
        c cVarC;
        c cVarC2;
        HashMap[] mapArr = this.f335d;
        c cVar = (c) mapArr[i2].get("DefaultCropSize");
        c cVar2 = (c) mapArr[i2].get("SensorTopBorder");
        c cVar3 = (c) mapArr[i2].get("SensorLeftBorder");
        c cVar4 = (c) mapArr[i2].get("SensorBottomBorder");
        c cVar5 = (c) mapArr[i2].get("SensorRightBorder");
        if (cVar != null) {
            if (cVar.f293a == 5) {
                e[] eVarArr = (e[]) cVar.g(this.f337f);
                if (eVarArr == null || eVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                    return;
                }
                cVarC = c.b(eVarArr[0], this.f337f);
                cVarC2 = c.b(eVarArr[1], this.f337f);
            } else {
                int[] iArr = (int[]) cVar.g(this.f337f);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                cVarC = c.c(iArr[0], this.f337f);
                cVarC2 = c.c(iArr[1], this.f337f);
            }
            mapArr[i2].put("ImageWidth", cVarC);
            mapArr[i2].put("ImageLength", cVarC2);
            return;
        }
        if (cVar2 != null && cVar3 != null && cVar4 != null && cVar5 != null) {
            int iE = cVar2.e(this.f337f);
            int iE2 = cVar4.e(this.f337f);
            int iE3 = cVar5.e(this.f337f);
            int iE4 = cVar3.e(this.f337f);
            if (iE2 <= iE || iE3 <= iE4) {
                return;
            }
            c cVarC3 = c.c(iE2 - iE, this.f337f);
            c cVarC4 = c.c(iE3 - iE4, this.f337f);
            mapArr[i2].put("ImageLength", cVarC3);
            mapArr[i2].put("ImageWidth", cVarC4);
            return;
        }
        c cVar6 = (c) mapArr[i2].get("ImageLength");
        c cVar7 = (c) mapArr[i2].get("ImageWidth");
        if (cVar6 == null || cVar7 == null) {
            c cVar8 = (c) mapArr[i2].get("JPEGInterchangeFormat");
            c cVar9 = (c) mapArr[i2].get("JPEGInterchangeFormatLength");
            if (cVar8 == null || cVar9 == null) {
                return;
            }
            int iE5 = cVar8.e(this.f337f);
            int iE6 = cVar8.e(this.f337f);
            fVar.f(iE5);
            byte[] bArr = new byte[iE6];
            fVar.readFully(bArr);
            e(new b(bArr), iE5, i2);
        }
    }

    public final void x() {
        v(0, 5);
        v(0, 4);
        v(5, 4);
        HashMap[] mapArr = this.f335d;
        c cVar = (c) mapArr[1].get("PixelXDimension");
        c cVar2 = (c) mapArr[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            mapArr[0].put("ImageWidth", cVar);
            mapArr[0].put("ImageLength", cVar2);
        }
        if (mapArr[4].isEmpty() && n(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!n(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        t(0, "ThumbnailOrientation", "Orientation");
        t(0, "ThumbnailImageLength", "ImageLength");
        t(0, "ThumbnailImageWidth", "ImageWidth");
        t(5, "ThumbnailOrientation", "Orientation");
        t(5, "ThumbnailImageLength", "ImageLength");
        t(5, "ThumbnailImageWidth", "ImageWidth");
        t(4, "Orientation", "ThumbnailOrientation");
        t(4, "ImageLength", "ThumbnailImageLength");
        t(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
