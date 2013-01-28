/*
 * Copyright (C) 2012 HipByte SPRL and contributors
 */
package jos.build;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

public class PropertyList {

    public static String toString(PropertyList plist) {
        final StringBuilder str = new StringBuilder(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                        + "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n"
                        + "<plist version=\"1.0\">\n");

        catElement(plist, str, 1);
        str.append("</plist>\n");
        return str.toString();
    }

    private static String indentLine(final String line, int indent) {
        return StringUtils.repeat("\t", indent) + line + "\n";
    }

    @SuppressWarnings("unchecked")
    private static void catElement(Object plist, StringBuilder str, int indent) {
        if (plist instanceof Map) {
            str.append(indentLine("<dict>", indent));
            Map<String, Object> map = (Map<String, Object>) plist;
            for (Entry<String, Object> entry : map.entrySet()) {
                final String key = entry.getKey();
                final Object val = entry.getValue();
                str.append(indentLine("<key>" + key + "</key>", indent + 1));
                catElement(val, str, indent + 1);
            }
            str.append(indentLine("</dict>", indent));
        } else if (plist instanceof List) {
            str.append(indentLine("<array>", indent));
            List<Object> list = (List<Object>) plist;
            for (Object elem : list) {
                catElement(elem, str, indent + 1);
            }
            str.append(indentLine("</array>", indent));
        } else if (plist instanceof String) {
            str.append(indentLine("<string>" + plist + "</string>", indent));
        } else if (plist instanceof Boolean) {
            Boolean bool = (Boolean) plist;
            if (bool) {
                str.append(indentLine("<true/>", indent));
            } else {
                str.append(indentLine("<false/>", indent));
            }
        } else if (plist instanceof Date) {
            Date date = (Date) plist;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
            str.append(indentLine("<date>" + df.format(date) + "</date>",
                    indent));
        } else if (plist instanceof Integer) {
            str.append(indentLine("<real>" + plist + "</real>", indent));
        } else {
            throw new IllegalStateException(
                    "Invalid plist object of type '"
                            + plist.getClass().getName()
                            + "' (must be either a Map, List, String, Integer, or boolean true/false value)");
        }
    }
}
