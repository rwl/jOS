/*
 * Copyright (C) 2013 Mono Project
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jos.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Parser {

    public static class Declaration {
        public String selector, retval, parameters;
        public boolean is_abstract, is_static, appearance;

        public Declaration(String selector, String retval, String parameters,
                boolean is_abstract, boolean is_static, boolean appearance) {
            this.selector = selector;
            this.retval = retval;
            this.parameters = parameters;
            this.is_abstract = is_abstract;
            this.is_static = is_static;
            this.appearance = appearance;
        }

    }

    public static class Declarations {
        private List<Declaration> decls = new ArrayList<Declaration>();
        private PrintWriter gencs;

        public Declarations(PrintWriter gencs) {
            this.gencs = gencs;
        }

        public final void add(final Declaration d) {
            if (d == null) {
                return;
            }

            decls.add(d);
        }

        private int count(final String s, final char k) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (c == k) {
                    count++;
                }
            }
            return count;
        }

        private String hasGetter(final String getter1, final String getter2) {
            if (hasGetter(getter1)) {
                return getter1;
            }
            if (hasGetter(getter2)) {
                return getter2;
            }
            return null;
        }

        private boolean hasGetter(final String getter) {
            for (final Declaration d : decls) {
                final String sel = d.selector;
                if (count(sel, ':') == 0 && sel.equals(getter)) {
                    return true;
                }
            }
            return false;
        }

        private List<String> ignore = new ArrayList<String>();

        private boolean remove(final String sel) {
            ignore.add(sel);
            return true;
        }

        public final void generate(final String extraAttribute) {
            final List<Declaration> copy = decls;
            final List<String> properties = new ArrayList<String>();
            for (final Declaration d : copy) {
                final String sel = d.selector;
                if (sel.startsWith("set") && sel.endsWith(":")
                        && count(sel, ':') == 1) {
                    final String getter1 = Character.toLowerCase(sel.charAt(3))
                            + StringUtils.strip(sel.substring(4), ":");
                    final String getter2 = "is"
                            + StringUtils.strip(sel.substring(3), ":");
                    String getter = hasGetter(getter1, getter2);
                    if (getter != null) {
                        remove(sel);
                        properties.add(getter);
                    }
                }
            }

            for (Declaration d : decls) {
                if (ignore.contains(d.selector)
                        || properties.contains(d.selector)) {
                    continue;
                }

                if (extraAttribute != null) {
                    gencs.printf("\t\t[%s]", extraAttribute);
                    gencs.println();
                }
                if (d.is_abstract) {
                    gencs.println("\t\t[Abstract]");
                }
                if (d.is_static) {
                    gencs.println("\t\t[Static]");
                }
                if (d.appearance) {
                    gencs.println("\t\t[Appearance]");
                }
                gencs.printf("\t\t[Export (\"%s\")]", d.selector);
                gencs.println();
                gencs.printf("\t\t%s %s (%s);", d.retval,
                        Parser.cleanSelector(d.selector), d.parameters);
                gencs.println();
                gencs.println();
            }

            if (properties.size() > 0) {
                gencs.println("\t\t//Detected properties");
            }
            for (String d : properties) {
                Declaration decl = null;
                for (Declaration x : decls) {
                    if (x.selector.equals(d)) {
                        decl = x;
                        break;
                    }
                }
                String sel = decl.selector;
                if (sel.startsWith("is")) {
                    sel = Character.toLowerCase(sel.charAt(2))
                            + sel.substring(3);
                }

                if (decl.is_abstract) {
                    gencs.println("\t\t[Abstract]");
                }
                if (decl.is_static) {
                    gencs.println("\t\t[Static]");
                }
                gencs.printf("\t\t[Export (\"%s\")]", sel);
                gencs.println();
                gencs.printf("\t\t%s %s {{ %sget; set; }}", decl.retval, sel,
                        d.startsWith("is") ? "[Bind (\"" + d + "\")]" : "");
                gencs.println();
                gencs.println();
            }
        }
    }

    private PrintWriter gencs;
    private BufferedReader r;

    // Used to limit which APIs to include in the binding
    private String limit;
    private String extraAttribute;
    // private OptionSet options;

    private List<String> types = new ArrayList<String>();

    private void processProperty(String line, boolean appearance) {
        boolean ro = false;
        String getter = null;

        line = cleanDeclaration(line);
        if (line.length() == 0) {
            return;
        }

        int p = line.indexOf(')');
        String sub = line.substring(0, p + 1);
        if (sub.indexOf("readonly") != -1) {
            ro = true;
        }
        int j = sub.indexOf("getter=");
        if (j != -1) {
            int k = StringUtils.indexOfAny(sub.substring(j + 1), ",)") + j + 1; // TODO
            // check
            // translation
            // System.out.println("j=%d k=%d str=%s", j, k, sub);
            getter = sub.substring(j + 7, j + 7 + k - (j + 7));
        }

        final StringBuilder type = new StringBuilder();
        int i = p + 1;
        for (; i < line.length(); i++) {
            char c = line.charAt(i);
            if (!Character.isWhitespace(c)) {
                break;
            }
        }
        for (; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c)) {
                break;
            }
            type.append(c);
        }

        for (; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c) || c == '*') {
                continue;
            } else {
                break;
            }
        }
        final StringBuilder selector = new StringBuilder();
        for (; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c) || c == ';') {
                break;
            }
            selector.append(c);
        }
        if (extraAttribute != null) {
            gencs.printf("\t\t[{0}]", extraAttribute);
            gencs.println();
        }
        if (appearance) {
            gencs.printf("\t\t[Appearance]");
            gencs.println();
        }
        gencs.printf("\t\t[Export (\"%s\")]", selector);
        gencs.println();

        gencs.printf("\t\t%s %s {{ %s %s }}", remapType(type.toString()),
                selector.toString(), getter != null ? "[Bind (\"" + getter
                        + "\")] get;" : "get;", ro ? "" : "set; ");
        gencs.println();
        gencs.println();
    }

    private String makeSelector(final String sig) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sig.length(); i++) {
            char c = sig.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == ';') {
                break;
            } else if (c == ':') {
                sb.append(c);
                i++;
                for (; i < sig.length(); i++) {
                    c = sig.charAt(i);
                    if (c == ')') {
                        for (++i; i < sig.length()
                                && Character.isWhitespace(sig.charAt(i)); i++) {
                            ;
                        }

                        for (++i; i < sig.length(); i++) {
                            if (!Character.isLetterOrDigit(sig.charAt(i))) {
                                break;
                            }
                        }
                        break;
                    }
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static enum State {
        SKIP_TO_TYPE, END_OF_TYPE, SKIP_TO_PARAMETER, PARAMETER;
    }

    private String makeParameters(final String sig) {
        int colon = sig.indexOf(':');
        if (colon == -1) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();
        State state = State.SKIP_TO_TYPE;
        for (int i = 0; i < sig.length(); i++) {
            char c = sig.charAt(i);

            switch (state) {
            case SKIP_TO_TYPE:
                if (Character.isWhitespace(c)) {
                    continue;
                }
                if (c == '(') {
                    tsb = new StringBuilder();
                    state = State.END_OF_TYPE;
                }
                break;
            case END_OF_TYPE:
                if (c == ')') {
                    state = State.SKIP_TO_PARAMETER;
                    sb.append(remapType(tsb.toString()));
                    sb.append(' ');
                } else {
                    if (c != '*') {
                        tsb.append(c);
                    }
                }
                break;

            case SKIP_TO_PARAMETER:
                if (!Character.isWhitespace(c)) {
                    state = State.PARAMETER;
                    sb.append(c);
                }
                break;
            case PARAMETER:
                if (Character.isWhitespace(c)) {
                    state = State.SKIP_TO_TYPE;
                    sb.append(", ");
                } else {
                    if (c != ';') {
                        sb.append(c);
                    }
                }
                break;
            }

        }

        // System.out.println("  -> %s", sb.toString());
        return sb.toString();
    }

    private String remapType(String type) {
        if (type.endsWith("*")) {
            type = type.substring(0, type.length() - 1);
        }
        type = type.trim();
        if (type.equals("NSInteger")) {
            return "int";
        } else if (type.equals("CGFloat") || type.equals("GLfloat")) {
            return "float";
        } else if (type.equals("NSTextAlignment")) {
            return "uint";
        } else if (type.equals("NSString") || type.equals("NSString *")) {
            return "string";
        } else if (type.equals("NSSize") || type.equals("CGSize")) {
            return "SizeF";
        } else if (type.equals("NSRect") || type.equals("CGRect")) {
            return "RectangleF";
        } else if (type.equals("NSPoint") || type.equals("CGPoint")) {
            return "PointF";
        } else if (type.equals("NSGlyph")) {
            return "uint";
        } else if (type.equals("NSUInteger")) {
            return "uint";
        } else if (type.equals("instancetype") || type.equals("id")) {
            return "NSObject";
        } else if (type.equals("BOOL") || type.equals("GLboolean")) {
            return "bool";
        } else if (type.equals("SEL")) {
            return "Selector";
        } else if (type.equals("NSURL")) {
            return "NSUrl";
        } else if (type.equals("NSTimeInterval")) {
            return "double";
        } else if (type.equals("dispatch_queue_t")) {
            return "DispatchQueue";
        } else if (type.equals("SCNVector4")) {
            return "Vector4";
        } else if (type.equals("SCNVector3")) {
            return "Vector3";
        }
        return type;
    }

    private String rx = "(NS_AVAILABLE\\(.*\\)|NS_AVAILABLE_IOS\\([0-9_]+\\)|NS_AVAILABLE_MAC\\([0-9_]+\\)|__OSX_AVAILABLE_STARTING\\([_A-Z0-9,]+\\))";
    private String rx2 = "AVAILABLE_MAC_OS_X_VERSION[_A-Z0-9]*";
    private String rx3 = "AVAILABLE_MAC_OS_X_VERSION[_A-Z0-9]*";
    private String rx4 = "UI_APPEARANCE_SELECTOR";

    private String cleanDeclaration(final String line) {
        return rx4
                .replaceAll(rx3.replaceAll(
                        rx2.replaceAll(rx.replaceAll(line, ""), ""), ""), "");
    }

    public static String cleanSelector(final String selector) {
        return selector.replace(":", "");
    }

    public static boolean hasLimitKeyword(final String line) {
        return line.indexOf("__OSX_AVAILABLE_STARTING") != -1
                || line.indexOf("NS_AVAILABLE") != -1;
    }

    private Declaration processDeclaration(final boolean isProtocol,
            String line, final boolean isOptional) {
        /*
         * boolean debug = false; if (line.indexOf("6_0") != -1) { debug = true;
         * }
         */

        if (limit != null) {
            if (!hasLimitKeyword(line)) {
                return null;
            }
            if (line.indexOf(limit) == -1) {
                return null;
            }
        }

        final boolean appearance = (line.indexOf("UI_APPEARANCE_SELECTOR") != -1);
        line = cleanDeclaration(line);
        if (line.length() == 0) {
            return null;
        }

        final boolean isAbstract = isProtocol && !isOptional;

        if (line.startsWith("@property")) {
            if (isAbstract) {
                gencs.println("\t\t[Abstract]");
            }
            processProperty(line, appearance);
            return null;
        }
        // System.out.println("PROCESSING: %s", line);
        boolean isStatic = line.startsWith("+");
        int p, q;
        p = line.indexOf('(');
        if (p == -1) {
            return null;
        }
        q = line.indexOf(')');
        // System.out.println("->%s\np=%d q-p=%d", line, p, q-p);
        final String retval = remapType(line
                .substring(p + 1, p + 1 + q - p - 1));
        p = line.indexOf(';');
        final String signature = StringUtils.strip(
                line.substring(q + 1, q + 1 + p - q), " ;");
        // System.out.println("SIG: %s %d", line, p);
        final String selector = makeSelector(signature);
        final String parameters = makeParameters(signature);

        // System.out.println("signature: %s", signature);
        // System.out.println("selector: %s", selector);
        return new Declaration(selector, retval, parameters, isAbstract,
                isStatic, appearance);
    }

    private void processInterface(final String iface) throws IOException {
        boolean need_close = iface.indexOf("{") != -1;
        String[] cols = iface.split("\\s+"); // TODO: check split translation
        String line;

        // System.out.println("**** %s ", iface);
        types.add(cols[1]);
        if (extraAttribute != null) {
            gencs.printf("\n\t[%s]", extraAttribute);
        }
        if (cols.length >= 4) {
            gencs.printf("\n\t[BaseType (typeof (%s))]", cols[3]);
            gencs.println();
        }
        gencs.printf("\t%sinterface %s {{", limit == null ? ""
                : "public partial ", cols[1]);
        gencs.println();

        /*
         * while ((line = r.readLine()) != null && (need_close &&
         * !line.startsWith ("}"))) { if (line.equals("{")) { need_close = true;
         * } }
         */
        line = r.readLine();
        if (line.equals("{")) {
            need_close = true;
        }
        while (line != null && (need_close && !line.equals("}"))) {
            line = r.readLine();
        }

        Declarations decl = new Declarations(gencs);
        while ((line = r.readLine()) != null && !line.startsWith("@end")) {
            String full = "";

            while ((line = r.readLine()) != null && !line.startsWith("@end")) {
                full += line;
                if (full.indexOf(';') != -1) {
                    full = full.replace('\n', ' ');
                    decl.add(processDeclaration(false, full, false));
                    full = "";
                }
            }
            break;
        }
        decl.generate(extraAttribute);
        gencs.println("\t}");
    }

    private void processProtocol(final String proto) throws IOException {
        final String[] d = proto.split("[ <>]", -1);
        String line;

        types.add(d[1]);
        if (extraAttribute != null) {
            gencs.printf("\n\t[%s]", extraAttribute);
            gencs.println();
        }
        gencs.printf("\n\t[BaseType (typeof (%s))]", d.length > 2 ? d[2]
                : "NSObject");
        gencs.println();
        gencs.println("\t[Model]");
        gencs.printf("\tinterface %s {{", d[1]);
        gencs.println();
        boolean optional = false;

        Declarations decl = new Declarations(gencs);
        while ((line = r.readLine()) != null && !line.startsWith("@end")) {
            if (line.startsWith("@optional")) {
                optional = true;
            }

            String full = "";
            while ((line = r.readLine()) != null && !line.startsWith("@end")) {
                full += line;
                if (full.indexOf(';') != -1) {
                    full = full.replace('\n', ' ');
                    decl.add(processDeclaration(true, full, optional));
                    full = "";
                }
            }
            if (line.startsWith("@end")) {
                break;
            }
        }
        decl.generate(extraAttribute);
        gencs.println("\t}");
    }

    private void showHelp() {
        // options.writeOptionDescriptions(System.out);
        System.exit(0);
    }

    private String clean(final String prefix, final String line) {
        return line.substring(line.indexOf(prefix));
    }

    public Parser() {
        gencs = new PrintWriter(System.out);

        /*
         * options = new OptionSet() { {"limit=",
         * "Limit methods to methods for the specific API level (ex: 5_0)", arg
         * => limit = arg}, {"extra=",
         * "Extra attribute to add, for example: 'Since(6,0)'", arg =>
         * extraAttribute = arg}, {"help", "Shows the help", a => ShowHelp()} };
         */
    }

    public void main(String[] args) {
        List<String> sources = null;

        try {
            // sources = options.parse(args);
            sources = Arrays.asList(args);
        } catch (java.lang.Exception e) {
            System.out.println("Error parsing argument");
            return;
        }
        if (sources.isEmpty()) {
            showHelp();
        }

        for (final String f : sources) {
            final File fs = new File(f);
            try {
                r = new BufferedReader(new FileReader(fs));
                String line;
                while ((line = r.readLine()) != null) {
                    line = line.replace("UIKIT_EXTERN_CLASS ", "");

                    if (line.startsWith("#")) {
                        continue;
                    }
                    if (line.length() == 0) {
                        continue;
                    }
                    if (line.startsWith("@class")) {
                        continue;
                    }

                    if (line.indexOf("UIKIT_CLASS_AVAILABLE") != -1) {
                        int p = line.indexOf('@');
                        if (p == -1) {
                            continue;
                        }
                        line = line.substring(p);
                    }

                    if (line.indexOf("@interface") != -1) {
                        processInterface(clean("@interface", line));
                    }
                    if (line.indexOf("@protocol") != -1 && !line.endsWith(";") /*&& line.indexOf("<") != -1)*/) {
                        processProtocol(clean("@protocol", line));
                    }
                }
            } catch (final IOException e) {
                System.err.println("Error parsing '" + f + "': " + e.getMessage());
                break;
            } finally {
                try {
                    r.close();
                } catch (final IOException e) {

                }
            }
        }
        gencs.close();
    }
}