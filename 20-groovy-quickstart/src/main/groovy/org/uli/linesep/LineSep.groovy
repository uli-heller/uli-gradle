package org.uli.linesep;

class LineSep {
  static enum FileType {
    UNIX, DOS,
  }

  FileType getFileType(File f) {
      FileType tft = FileType.DOS;
      if (f.getText().indexOf("\r") < 0) {
        tft = FileType.UNIX;
      }
      return tft;
  }

  static public void main(String[] args) {
    LineSep ls = new LineSep();
    boolean fSingleFile = args.length <= 1 ? true : false;
    args.each {
      FileType tft = ls.getFileType(new File(it));
      if (! fSingleFile) {
        print "${it} -> ";
      }
      println tft;
    }
  }
}
