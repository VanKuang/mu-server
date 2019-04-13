package io.muserver;

import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;

import javax.ws.rs.core.MediaType;
import java.util.*;

import static io.muserver.NettyRequestParameters.isTruthy;
import static io.netty.util.internal.ObjectUtil.checkNotNull;
import static java.util.Collections.emptyList;

class H1Headers implements Headers {

    private final HttpHeaders entries;

    H1Headers() {
        this(new DefaultHttpHeaders());
    }

    H1Headers(HttpHeaders entries) {
        this.entries = entries;
    }

    @Override
    public String get(String name) {
        return entries.get(name);
    }

    @Override
    public String get(CharSequence name) {
        return entries.get(name);
    }

    @Override
    public String get(CharSequence name, String defaultValue) {
        return entries.get(name, defaultValue);
    }

    @Override
    @Deprecated
    public Integer getInt(CharSequence name) {
        return entries.getInt(name);
    }

    @Override
    public int getInt(CharSequence name, int defaultValue) {
        return entries.getInt(name, defaultValue);
    }

    @Override
    public long getLong(String name, long defaultValue) {
        try {
            String stringVal = get(name, null);
            if (stringVal == null) {
                return defaultValue;
            }
            return Long.parseLong(stringVal, 10);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    @Override
    public float getFloat(String name, float defaultValue) {
        try {
            String stringVal = get(name, null);
            if (stringVal == null) {
                return defaultValue;
            }
            return Float.parseFloat(stringVal);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    @Override
    public double getDouble(String name, double defaultValue) {
        try {
            String stringVal = get(name, null);
            if (stringVal == null) {
                return defaultValue;
            }
            return Double.parseDouble(stringVal);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    @Override
    public boolean getBoolean(String name) {
        String val = get(name, "").toLowerCase();
        return isTruthy(val);
    }

    @Override
    @Deprecated
    public Short getShort(CharSequence name) {
        return entries.getShort(name);
    }

    @Override
    @Deprecated
    public short getShort(CharSequence name, short defaultValue) {
        return entries.getShort(name, defaultValue);
    }

    @Override
    public Long getTimeMillis(CharSequence name) {
        return entries.getTimeMillis(name);
    }

    @Override
    public long getTimeMillis(CharSequence name, long defaultValue) {
        return entries.getTimeMillis(name, defaultValue);
    }

    @Override
    public List<String> getAll(String name) {
        return entries.getAll(name);
    }

    @Override
    public List<String> getAll(CharSequence name) {
        return entries.getAll(name);
    }

    @Override
    public List<Map.Entry<String, String>> entries() {
        return entries.entries();
    }

    @Override
    public boolean contains(String name) {
        return entries.contains(name);
    }

    @Override
    public boolean contains(CharSequence name) {
        return entries.contains(name);
    }

    @Override
    public Iterator<Map.Entry<String, String>> iterator() {
        return entries.iteratorAsString();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public Set<String> names() {
        return entries.names();
    }

    @Override
    public Headers add(String name, Object value) {
        entries.add(name, value);
        return this;
    }

    @Override
    public Headers add(CharSequence name, Object value) {
        entries.add(name, value);
        return this;
    }

    @Override
    public Headers add(String name, Iterable<?> values) {
        entries.add(name, values);
        return this;
    }

    @Override
    public Headers add(CharSequence name, Iterable<?> values) {
        entries.add(name, values);
        return this;
    }

    @Override
    public Headers add(Headers headers) {
        for (Map.Entry<String, String> e : headers) {
            add(e.getKey(), e.getValue());
        }
        return this;
    }

    @Override
    public Headers addInt(CharSequence name, int value) {
        entries.addInt(name, value);
        return this;
    }

    @Override
    @Deprecated
    public Headers addShort(CharSequence name, short value) {
        entries.addShort(name, value);
        return this;
    }

    @Override
    public Headers set(String name, Object value) {
        entries.set(name, value);
        return this;
    }

    @Override
    public Headers set(CharSequence name, Object value) {
        entries.set(name, value);
        return this;
    }

    @Override
    public Headers set(String name, Iterable<?> values) {
        entries.set(name, values);
        return this;
    }

    @Override
    public Headers set(CharSequence name, Iterable<?> values) {
        entries.set(name, values);
        return this;
    }

    @Override
    public Headers set(Headers headers) {
        checkNotNull(headers, "headers");
        clear();
        for (Map.Entry<String, String> entry : headers) {
            add(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override
    public Headers setAll(Headers headers) {
        checkNotNull(headers, "headers");
        for (String name : headers.names()) {
            set(name, headers.getAll(name));
        }
        return this;
    }

    @Override
    public Headers setInt(CharSequence name, int value) {
        entries.setInt(name, value);
        return this;
    }

    @Override
    @Deprecated
    public Headers setShort(CharSequence name, short value) {
        entries.setShort(name, value);
        return this;
    }

    @Override
    public Headers remove(String name) {
        entries.remove(name);
        return this;
    }

    @Override
    public Headers remove(CharSequence name) {
        entries.remove(name);
        return this;
    }

    @Override
    public Headers clear() {
        entries.clear();
        return this;
    }

    @Override
    public boolean contains(String name, String value, boolean ignoreCase) {
        return entries.contains(name, value, ignoreCase);
    }

    @Override
    public boolean containsValue(CharSequence name, CharSequence value, boolean ignoreCase) {
        return entries.containsValue(name, value, ignoreCase);
    }

    @Override
    public String getAsString(CharSequence name) {
        return entries.getAsString(name);
    }

    @Override
    public List<String> getAllAsString(CharSequence name) {
        return entries.getAllAsString(name);
    }

    @Override
    public Iterator<Map.Entry<String, String>> iteratorAsString() {
        return entries.iteratorAsString();
    }

    @Override
    public boolean contains(CharSequence name, CharSequence value, boolean ignoreCase) {
        return entries.contains(name, value, ignoreCase);
    }

    @Override
    public boolean equals(Object o) {
        return entries.equals(o);
    }

    @Override
    public int hashCode() {
        return entries.hashCode();
    }


    @Override
    public String toString() {
        return HeadersUtils.toString(getClass(), entries.iteratorCharSequence(), size());
    }

//    HttpHeaders nettyHeaders() {
//        return entries;
//    }

    @Override
    public boolean hasBody() {
        return contains(HeaderNames.TRANSFER_ENCODING) || getInt(HeaderNames.CONTENT_LENGTH, -1) > 0;
    }

    @Override
    public List<ParameterizedHeaderWithValue> accept() {
        return getParameterizedHeaderWithValues(HeaderNames.ACCEPT);
    }

    @Override
    public List<ParameterizedHeaderWithValue> acceptCharset() {
        return getParameterizedHeaderWithValues(HeaderNames.ACCEPT_CHARSET);
    }

    @Override
    public List<ParameterizedHeaderWithValue> acceptEncoding() {
        return getParameterizedHeaderWithValues(HeaderNames.ACCEPT_ENCODING);
    }

    @Override
    public List<ForwardedHeader> forwarded() {
        List<String> all = getAll(HeaderNames.FORWARDED);
        if (all.isEmpty()) {

            List<String> hosts = getAll(HeaderNames.X_FORWARDED_HOST);
            List<String> ports = getAll(HeaderNames.X_FORWARDED_PORT);
            List<String> protos = getAll(HeaderNames.X_FORWARDED_PROTO);
            List<String> fors = getAll(HeaderNames.X_FORWARDED_FOR);
            int max = Math.max(Math.max(Math.max(hosts.size(), protos.size()), fors.size()), ports.size());
            if (max == 0) {
                return emptyList();
            }
            List<ForwardedHeader> results = new ArrayList<>();

            boolean includeHost = hosts.size() == max;
            boolean includeProto = protos.size() == max;
            boolean includeFor = fors.size() == max;
            boolean includePort = ports.size() == max;
            String curHost = includePort && !includeHost ? get(HeaderNames.HOST) : null;

            for (int i = 0; i < max; i++) {
                String host = includeHost ? hosts.get(i) : null;
                String port = includePort ? ports.get(i) : null;
                String proto = includeProto ? protos.get(i) : null;
                String forValue = includeFor ? fors.get(i) : null;
                boolean useDefaultPort = port == null || (proto != null &&
                    ((proto.equalsIgnoreCase("http") && "80".equals(port))
                    || proto.equalsIgnoreCase("https") && "443".equals(port)));
                String hostToUse =
                    includeHost ? host
                    : includePort ? curHost
                    : null;
                if (hostToUse != null && !useDefaultPort) {
                    hostToUse = hostToUse.replaceFirst(":[0-9]+$", "") + ":" + port;
                }
                results.add(new ForwardedHeader(null, forValue, hostToUse, proto, null));
            }

            return results;
        } else {
            List<ForwardedHeader> results = new ArrayList<>();
            for (String s : all) {
                results.addAll(ForwardedHeader.fromString(s));
            }
            return results;
        }
    }

    @Override
    public List<ParameterizedHeaderWithValue> acceptLanguage() {
        return getParameterizedHeaderWithValues(HeaderNames.ACCEPT_LANGUAGE);
    }

    private List<ParameterizedHeaderWithValue> getParameterizedHeaderWithValues(CharSequence headerName) {
        String input = get(headerName);
        if (input == null) {
            return emptyList();
        }
        return ParameterizedHeaderWithValue.fromString(input);
    }

    @Override
    public ParameterizedHeader cacheControl() {
        return ParameterizedHeader.fromString(get(HeaderNames.CACHE_CONTROL));
    }

    @Override
    public MediaType contentType() {
        String value = get(HeaderNames.CONTENT_TYPE);
        if (value == null) {
            return null;
        }
        return MediaTypeParser.fromString(value);
    }
}
