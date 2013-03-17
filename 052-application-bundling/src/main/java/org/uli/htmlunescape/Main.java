package org.uli.htmlunescape;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class Main {
    static private final String NAME="http-unescape";
    static private final String ENCODING="UTF-8";
    static public void main(String[] args) {
        Main main = new Main();
        System.exit(main.execute(args));
    }
    
    public int execute(String[] args) {
        int exitCode = 0;
        Options options = new Options();
        @SuppressWarnings("static-access")
        Option f = OptionBuilder.withArgName("fromFile")
                    .hasArg(true)
                    .isRequired(true)
                    .withDescription("input file containing html entities")
                    .create("f");
        @SuppressWarnings("static-access")
        Option t = OptionBuilder.withArgName("toFile")
                    .hasArg(true)
                    .isRequired(true)
                    .withDescription("output file to be generated containing no html entities")
                    .create("t");
        @SuppressWarnings("static-access")
        Option encoding = OptionBuilder.withArgName("encoding")
                    .hasArg(true)
                    .isRequired(false)
                    .withDescription("encoding for input and output")
                    .create("e");
        @SuppressWarnings("static-access")
        Option h = OptionBuilder.hasArg(false)
                    .withDescription("print help (this message)")
                    .create("h");
        options.addOption(f);
        options.addOption(t);
        options.addOption(h);
        options.addOption(encoding);
        CommandLineParser commandLineParser = new PosixParser();
        try {
            CommandLine commandLine = commandLineParser.parse(options, args);
            if (commandLine.hasOption("h")) {
                HelpFormatter helpFormatter = new HelpFormatter();
                helpFormatter.printHelp(NAME, options);
                return(0);
            }
            File fromFile = new File(commandLine.getOptionValue("f"));
            File toFile = new File(commandLine.getOptionValue("t"));
            String charsetName = ENCODING;
            if (commandLine.hasOption("e")) {
                charsetName = commandLine.getOptionValue("e");
            }
            String content = readFile(fromFile, charsetName);
            writeFile(toFile, new HtmlUnescape().unescapeHtml(content), charsetName);
        } catch (ParseException e) {
            System.err.println(NAME+": Command line error - "+e.getMessage());
            exitCode=1;
        } catch (IOException e) {
            System.err.println(NAME+": IO error - "+e.getMessage());
            exitCode=2;
        }
        return exitCode;
    }

    private String readFile(File file, String charsetName) throws IOException {
        byte[] content = new byte[(int) file.length()]; // FIXME: long->int
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(content);
        fileInputStream.close();
        String result = new String(content, charsetName);
        return result;
    }
    
    private void writeFile(File file, String content, String charsetName) throws UnsupportedEncodingException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes(charsetName));
        fileOutputStream.close();
    }
}
