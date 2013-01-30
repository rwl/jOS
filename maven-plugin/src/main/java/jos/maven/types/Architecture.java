package jos.maven.types;

public enum Architecture {
    I386 ("i386"),
    X86_64 ("x86_64"),
    ARM6 ("arm6"),
    ARM7 ("arm7");

    private final String arch;

    private Architecture(final String arch) {
        this.arch = arch;
    }

    public String getArch() {
        return arch;
    }
}
