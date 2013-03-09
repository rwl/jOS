/*
 * Copyright (C) 2012 Mono Project
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
package jos.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang.StringUtils;

public class Parser {

    public static class Declaration {
        public String selector, retval, parameters;
        public boolean isAbstract, isStatic, appearance;

        public Declaration(String selector, String retval, String parameters,
                boolean isAbstract, boolean isStatic, boolean appearance) {
            this.selector = selector;
            this.retval = retval;
            this.parameters = parameters;
            this.isAbstract = isAbstract;
            this.isStatic = isStatic;
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

        public final void generate(final String extraAnnotation) {
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
//                final String dummyReturn = Parser.mapDummyReturn(d.retval);

                if (extraAnnotation != null) {
                    gencs.println("\t/**");
                    gencs.printf("\t * @%s", extraAnnotation);
                    gencs.println();
                    gencs.println("\t */");
                }
                if (d.appearance) {
                    gencs.println("\t@Appearance");
                }
                gencs.printf("\t@Export(\"%s\")", d.selector);
                gencs.println();
                gencs.printf("\tpublic %s%s%s %s(%s) {",
                        (d.isStatic ? "static " : ""),
                        (d.isAbstract ? ""/*"abstract "*/ : ""),
                        d.retval,
                        Parser.cleanSelector(d.selector), d.parameters);
                gencs.println();
                gencs.println("\t\tthrow new RuntimeException();");
//                if (dummyReturn != null) {
//                    gencs.printf("\t\treturn %s;", dummyReturn);
//                    gencs.println();
//                }
                gencs.printf("\t}");
                gencs.println();
                gencs.println();
            }

            if (properties.size() > 0) {
                gencs.println("\t// Detected properties");
            }
            for (String d : properties) {
                Declaration decl = null;
                for (final Declaration x : decls) {
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

                //gencs.printf("\t@Export(\"%s\")", sel);
                //gencs.println();
//                gencs.printf("\tpublic %s%s%s %s;",
//                        (decl.isStatic ? "static " : ""),
//                        (decl.isAbstract ? ""/*"abstract "*/ : ""),
//                        decl.retval, sel);
//                gencs.println();
//                gencs.println();

                if (d.startsWith("is")) {
                    gencs.printf("\t@Bind(\"%s\")", d);
                    gencs.println();
                }
                gencs.printf("\t@Export(\"%s\")", sel);
                gencs.println();
                gencs.printf("\tpublic %s get%s() {", decl.retval, StringUtils.capitalize(sel));
                gencs.println();
//                gencs.printf("\t\treturn this.%s;");
                gencs.printf("\t\tthrow new RuntimeException();");
                gencs.println();
                gencs.printf("\t}");
                gencs.println();
                gencs.println();

                gencs.printf("\t@Export(\"set%s:\")", StringUtils.capitalize(sel));
                gencs.println();
                gencs.printf("\tpublic void set%s(%s value) {", StringUtils.capitalize(sel), decl.retval);
                gencs.println();
                gencs.printf("\t\tthrow new RuntimeException();");
                gencs.println();
                gencs.printf("\t}");
                gencs.println();
                gencs.println();
            }
        }
    }

    private PrintWriter gencs;
    private BufferedReader r;

    // Used to limit which APIs to include in the binding
    private String limit;
    private String extraAnnotation;
    // private OptionSet options;
    private boolean debug = false;

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
            int k = StringUtils.indexOfAny(sub.substring(j + 1), ",)") + j + 1;
            // TODO check translation
            log("j=%d k=%d str=%s", j, k, sub);
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
        if (extraAnnotation != null) {
            gencs.println("\t/**");
            gencs.printf("\t * @%s", extraAnnotation);
            gencs.println();
            gencs.println("\t */");
        }
        if (appearance) {
            gencs.printf("\t@Appearance");
            gencs.println();
        }
        //gencs.printf("\t@Export(\"%s\")", selector);
        //gencs.println();

        final String retval = remapType(type.toString());
//        gencs.printf("\tpublic %s %s;", retval, selector);
//        gencs.println();
//        gencs.println();

        if (getter != null) {
            gencs.printf("\t@Bind(\"" + getter + "\")");
            gencs.println();
        }
        gencs.printf("\t@Export(\"%s\")", selector.toString());
        gencs.println();
        gencs.printf("\tpublic %s get%s() {", retval, StringUtils.capitalize(selector.toString()));
        gencs.println();
        gencs.printf("\t\tthrow new RuntimeException();");
        gencs.println();
        gencs.printf("\t}");
        gencs.println();
        gencs.println();

        if (!ro) {
            gencs.printf("\t@Export(\"set%s:\")", StringUtils.capitalize(selector.toString()));
            gencs.println();
            gencs.printf("\tpublic void set%s(%s value) {", StringUtils.capitalize(selector.toString()), retval);
            gencs.println();
            gencs.printf("\t\tthrow new RuntimeException();");
            gencs.println();
            gencs.printf("\t}");
            gencs.println();
            gencs.println();
        }
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

        log("  -> %s", sb.toString());
        return sb.toString();
    }

    private static String remapType(String type) {
        if (type.endsWith("*")) {
            type = type.substring(0, type.length() - 1);
        }
        type = type.trim();
        if (type.equals("NSInteger")) {
            return "int";
        } else if (type.equals("CGFloat") || type.equals("GLfloat")) {
            return "float";
        } else if (type.equals("NSTextAlignment")) {
            return "int";
        } else if (type.equals("NSString") || type.equals("NSString *")) {
            return "String";
        /*} else if (type.equals("NSSize") || type.equals("CGSize")) {
            return "SizeF";
        } else if (type.equals("NSRect") || type.equals("CGRect")) {
            return "RectangleF";
        } else if (type.equals("NSPoint") || type.equals("CGPoint")) {
            return "PointF";*/
        } else if (type.equals("NSGlyph")) {
            return "int";
        } else if (type.equals("NSUInteger")) {
            return "int";
        } else if (type.equals("instancetype") || type.equals("id")) {
            return "NSObject";
        } else if (type.equals("BOOL") || type.equals("GLboolean")) {
            return "boolean";
        } else if (type.equals("SEL")) {
            return "Selector";
        } else if (type.equals("NSURL")) {
            return "NSUrl";
        } else if (type.equals("NSTimeInterval")) {
            return "double";
        } else if (type.equals("dispatch_queue_t")) {
            return "DispatchQueue";
        /*} else if (type.equals("SCNVector4")) {
            return "Vector4";
        } else if (type.equals("SCNVector3")) {
            return "Vector3";*/
        }
        return type;
    }

    /*private static String mapDummyReturn(final String type) {
        if (type.equals("void")) {
            return null;
        } else if (type.equals("int")) {
            return "0";
        } else if (type.equals("float")) {
            return "0.0f";
        } else if (type.equals("String")) {
            return "\"\"";
        } else if (type.equals("boolean")) {
            return "false";
        } else if (type.equals("double")) {
            return "0.0";
        } else {
            return "null";
        }
    }*/

    private String rx = "(NS_AVAILABLE\\(.*\\)|NS_AVAILABLE_IOS\\([0-9_]+\\)|NS_AVAILABLE_MAC\\([0-9_]+\\)|__OSX_AVAILABLE_STARTING\\([_A-Z0-9,]+\\))";
    private String rx2 = "AVAILABLE_MAC_OS_X_VERSION[_A-Z0-9]*";
    private String rx3 = "AVAILABLE_MAC_OS_X_VERSION[_A-Z0-9]*";
    private String rx4 = "UI_APPEARANCE_SELECTOR";

    private String cleanDeclaration(final String line) {
        return line.replaceAll(rx, "").replaceAll(rx2, "").replaceAll(rx3, "").replaceAll(rx4, "");
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
                gencs.println("\t@Abstract");
            }
            processProperty(line, appearance);
            return null;
        }
        log("PROCESSING: %s", line);
        boolean isStatic = line.startsWith("+");
        int p, q;
        p = line.indexOf('(');
        if (p == -1) {
            return null;
        }
        q = line.indexOf(')');
        log("->%s\np=%d q-p=%d", line, p, q-p);
        String retval = null;
        try {
            retval = remapType(line
                .substring(p + 1, p + 1 + q - p - 1));
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        p = line.indexOf(';');
        String signature = null;
        try {
            signature = StringUtils.strip(
                    line.substring(q + 1, q + 1 + p - q), " ;");
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        log("SIG: %s %d", line, p);
        final String selector = makeSelector(signature);
        final String parameters = makeParameters(signature);

        log("signature: %s", signature);
        log("selector: %s", selector);
        return new Declaration(selector, retval, parameters, isAbstract,
                isStatic, appearance);
    }

    private void processInterface(final String iface) throws IOException {
        boolean need_close = iface.indexOf("{") != -1;
        String[] cols = iface.split("\\s+");
        String line;

        log("**** %s ", iface);
        types.add(cols[1]);
        if (extraAnnotation != null) {
            gencs.println("/**");
            gencs.printf(" * @%s", extraAnnotation);
            gencs.println();
            gencs.println(" */");
        }

        final List<String> baseTypes = new ArrayList<String>();
        for (int i = 3; i < cols.length; i++) {
            final String clazz = StringUtils.strip(cols[i], " ,<>{}");
            if (!clazz.isEmpty() && !clazz.equals("NSObject")) {
                baseTypes.add(clazz);
            }
        }

        if (baseTypes.size() > 0) {
            gencs.printf("@BaseType(");
            if (baseTypes.size() > 1)
                gencs.printf("{");
            for (int i = 0; i < baseTypes.size(); i++) {
                gencs.printf("%s.class", baseTypes.get(i));
                if (i != baseTypes.size() - 1) gencs.printf(", ");
            }
            if (baseTypes.size() > 1)
                gencs.printf("}");
            gencs.println(")");
        }

        gencs.println("@Register(isWrapper = true)");
        gencs.printf("public class %s", cols[1]);
        if (baseTypes.size() > 0) {
            gencs.printf(" extends");
            for (int i = 0; i < baseTypes.size(); i++) {
                gencs.printf(" %s", baseTypes.get(i));
                if (i != baseTypes.size() - 1) gencs.printf(",");
            }
        }
        gencs.println(" {");


        /*
         * while ((line = r.readLine()) != null && (need_close &&
         * !line.startsWith ("}"))) { if (line.equals("{")) { need_close = true;
         * } }
         */
        line = r.readLine();
        if ("{".equals(line)) {
            need_close = true;
        }
        while (line != null && (need_close && !line.equals("}"))) {
            line = r.readLine();
        }

        Declarations decl = new Declarations(gencs);
        while ((line = r.readLine()) != null && !line.startsWith("@end")) {
            String full = line;

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
        decl.generate(extraAnnotation);
        gencs.println("}");
        gencs.println();
    }

    private void processProtocol(final String proto) throws IOException {
        final String[] d = proto.split("[ <>]", -1);
        String line;

        types.add(d[1]);
        if (extraAnnotation != null) {
            gencs.println("/**");
            gencs.printf(" * @%s", extraAnnotation);
            gencs.println();
            gencs.println(" */");
        }

        final List<String> baseTypes = new ArrayList<String>();
        for (int i = 2; i < d.length; i++) {
            final String clazz = StringUtils.strip(d[i], " ,");
            if (!clazz.isEmpty() && !clazz.equals("NSObject")) {
                baseTypes.add(clazz);
            }
        }

        if (baseTypes.size() > 0) {
            gencs.printf("@BaseType(");
            if (baseTypes.size() > 1)
                gencs.printf("{");
            for (int i = 0; i < baseTypes.size(); i++) {
                gencs.printf("%s.class", baseTypes.get(i));
                if (i != baseTypes.size() - 1) gencs.printf(", ");
            }
            if (baseTypes.size() > 1)
                gencs.printf("}");
            gencs.println(")");
        }

        gencs.println("@Model");
        gencs.println("@Register(isWrapper = true)");
        gencs.printf("public class %s extends NSObject", d[1]);
        if (baseTypes.size() > 0) {
            for (int i = 0; i < baseTypes.size(); i++) {
                gencs.printf(", %s", baseTypes.get(i));
            }
        }
        gencs.println(" {");

        boolean optional = false;
        Declarations decl = new Declarations(gencs);
        while ((line = r.readLine()) != null && !line.startsWith("@end")) {
            if (line.startsWith("@optional")) {
                optional = true;
            }

            String full = line;
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
        decl.generate(extraAnnotation);
        gencs.println("}");
        gencs.println();
    }

    private void processEnum(String line) {
        final String[] types = line.split(",");
        if (types.length < 2) {
            throw new IllegalStateException();
        }
        final String name = StringUtils.strip(types[1], "){ ");
        gencs.printf("public enum %s {", name);
        gencs.println();
        try {
            boolean first = true;
            while ((line = r.readLine()) != null) {
                if (line.indexOf("};") != -1) {
                    gencs.println(";");
                    break;
                } else if (!first) {
                    gencs.println(",");
                } else {
                    first = false;
                }
                String enumValue = line.split("//")[0];
                enumValue = enumValue.split(",")[0].trim();
                enumValue = enumValue.split("=")[0].trim();
                if (enumValue.startsWith(name)) {
                    enumValue = "@Bind(\"" + enumValue + "\") "
                            + enumValue.substring(name.length());
                }
                gencs.printf("\t%s", enumValue);
            }
        } catch (IOException e) {
            System.err.println("Error parsing '" + line + "': " + e.getMessage());
        }
        gencs.println("}");
        gencs.println();
    }

    private void log(String msg, Object ... args) {
        if (debug) {
            System.out.println(String.format(msg, args));
        }
    }

    private String clean(final String prefix, final String line) {
        return line.substring(line.indexOf(prefix));
    }

    public Parser() {
        gencs = new PrintWriter(System.out);
    }

    public void parse(String[] args) {
        final Options options = new Options();
        options.addOption("h", "help", false, "Show usage info");
        options.addOption("d", "debug", false, "Show debug info");
        options.addOption("l", "limit", true, "Limit methods to methods for the specific API level (ex: 5_0)");
        options.addOption("a", "annotation", true, "Comment annotation to add, for example: 'since 6.0'");

        final CommandLineParser parser = new PosixParser();
        CommandLine cmd = null;
        List<String> sources = null;
        try {
            cmd = parser.parse(options, args);
            @SuppressWarnings("unchecked")
            final List<String> arglist = cmd.getArgList();
            sources = arglist;
        } catch (ParseException e) {
            System.err.println("Error parsing command line: " + e.getMessage());
            return;
        }

        if (sources == null || sources.isEmpty() || cmd.hasOption('h')) {
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("parse", options);
            return;
        }

        debug = cmd.hasOption('d');
        limit = cmd.getOptionValue('l', null);
        extraAnnotation = cmd.getOptionValue('a', null);

        for (final String f : sources) {
            final File fs = new File(f);
            try {
                boolean multiLineComment = false;
                r = new BufferedReader(new FileReader(fs));
                String line;
                while ((line = r.readLine()) != null) {
                    line = line.trim();
                    line = line.replace("UIKIT_EXTERN_CLASS ", "");

                    if (line.startsWith("/*")) {
                        multiLineComment = true;
                    }
                    if (multiLineComment) {
                        if (line.endsWith("*/")) {
                            multiLineComment = false;
                            continue;
                        }
                    }
                    if (multiLineComment) {
                        continue;
                    }

                    if (line.startsWith("//")) {
                        continue;
                    }
                    if (line.startsWith("#")) {
                        continue;
                    }
                    if (line.length() == 0) {
                        continue;
                    }
                    if (line.startsWith("@class")) {
                        continue;
                    }

                    if (line.indexOf("_CLASS_AVAILABLE") != -1) {
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
                    if (line.indexOf("typedef NS_ENUM") != -1) {
                        processEnum(clean("typedef NS_ENUM", line));
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

    public static void main(String[] args) {
        new Parser().parse(args);
    }
}