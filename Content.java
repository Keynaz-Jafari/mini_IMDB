package org.example;

import java.io.File;

public class Content {
    private Type type;
   private File contentfile;

    public void setType(Type type) {
        this.type = type;
    }

    public void setContentfile(File contentfile) {
        this.contentfile = contentfile;
    }

    public Type getType() {
        return this.type;
    }
    public File getContentfile() {
        return this.contentfile;
    }

}
