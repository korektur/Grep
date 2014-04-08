package ru.ifmo.ctddev.Akhundov.task1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Grep {
    private static final int BLOCK_SIZE = 2048;
    private static final String GRATING = "#";
    private static final String ROOT_FOLDER = System.getProperty("user.dir");
    private static final String SEPARATOR = System.lineSeparator();
    private static final byte[] BYTES_SEPARATOR = SEPARATOR.getBytes();
    private static final String[] STRING_ENCODING = {"UTF-8", "Cp1251", "KOI8_R"};
    private static String[] arguments;
    private static Charset[] ENCODING = new Charset[STRING_ENCODING.length];

    static {
        for (int i = 0; i < STRING_ENCODING.length; ++i) {
            ENCODING[i] = Charset.forName(STRING_ENCODING[i]);
        }
    }

    public static void main(String[] args) {
        //arguments = new String[args.length];
        //System.arraycopy(args, 0, arguments, 0, args.length);
        if (args[0].equals("-")) {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> arrayList = new ArrayList<>();

            while (sc.hasNext()) {
                arrayList.add(sc.nextLine());
                if (arrayList.get(arrayList.size() - 1).equals("-")) {
                    break;
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            arguments = new String[arrayList.size() - 1];
            for (int i = 0; i < arrayList.size() - 1; ++i)
                arguments[i] = arrayList.get(i);
        } else {
            arguments = new String[args.length];
            for (int i = 0; i < args.length; ++i)
                arguments[i] = args[i];
        }

        foldersSearch(new File(ROOT_FOLDER));
    }

    private static ArrayList<Integer> getSeparatorPositions(byte[] bytes, int readSize) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < readSize; ++i) {
            boolean isSeparator = true;
            for (int j = 0; j < BYTES_SEPARATOR.length; ++j) {
                if (i + j >= readSize || bytes[i + j] != BYTES_SEPARATOR[j]) {
                    isSeparator = false;
                    break;
                }
            }
            if (isSeparator) {
                result.add(i + BYTES_SEPARATOR.length - 1);
            }
        }
        return result;
    }

    private static ArrayList<Integer> getArgEndsFromPrefixFunction(byte[] arg, byte[] bytes, byte slash, int readSize) {
        byte[] str = new byte[arg.length + 1 + readSize];
        ArrayList<Integer> result = new ArrayList<>();

        System.arraycopy(arg, 0, str, 0, arg.length);
        str[arg.length] = slash;
        for (int i = 0; i < readSize; ++i) str[arg.length + i + 1] = bytes[i];

        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        for (int i = 1; i < str.length; ++i) {
            int k = prefix.get(i - 1);
            while (k > 0 && str[i] != str[k])
                k = prefix.get(k - 1);
            if (str[i] == str[k])
                ++k;
            prefix.add(k);
            if (k == arg.length) {
                result.add(i - arg.length - 1);
            }
        }
        return result;
    }

    private static void printBlock(byte[] bytes, int startPosition, int finishPosition, int indForEncoding) {
        byte[] result = new byte[finishPosition - startPosition + 1];
        System.arraycopy(bytes, startPosition, result, 0, finishPosition + 1 - startPosition);
        System.out.print(new String(result, ENCODING[indForEncoding]));

    }

    private static void folderProcessing(final File folder) {
        boolean isPrintFolder = false;
        String folderString = folder.getAbsolutePath().substring(ROOT_FOLDER.length(), folder.getAbsolutePath().length()) + ":";

        int prevSeparatorPosition = -1;
        int prevEncodingIndex = -1;
        boolean isOnlyPrint = false;
        int readBytes = 0;

        try {
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(folder, "r")) {
                byte[] bytes = new byte[BLOCK_SIZE];
                while (true) {
                    int readSize = randomAccessFile.read(bytes);
                    if (readSize < 1)
                        break;
                    boolean stopFlag = false;
                    ArrayList<Integer> separatorPositions = getSeparatorPositions(bytes, readSize);
                    ArrayList<Boolean> isPrintSegment = new ArrayList<>();
                    for (int i = 0; i < separatorPositions.size(); ++i) isPrintSegment.add(false);
                    if (isOnlyPrint) {
                        if (separatorPositions.size() > 0) {
                            if (!isPrintFolder) {
                                System.out.println(folderString);
                                isPrintFolder = true;
                            }
                            printBlock(bytes, 0, separatorPositions.get(0), prevEncodingIndex);
                            prevSeparatorPosition = separatorPositions.get(0) + readBytes;
                            isPrintSegment.set(0, true);
                            isOnlyPrint = false;
                        } else {
                            printBlock(bytes, 0, readSize - 1, prevEncodingIndex);
                            readBytes += readSize;
                            continue;
                        }
                    }

                    for (String argument : arguments) {
                        for (int j = 0; j < ENCODING.length; ++j) {
                            String tmp = new String(bytes, ENCODING[j]).toLowerCase();
                            byte[] bytesInLowerCase = tmp.getBytes(ENCODING[j]);
                            ArrayList<Integer> argEnds = getArgEndsFromPrefixFunction(argument.getBytes(ENCODING[j]), bytesInLowerCase, GRATING.getBytes(ENCODING[j])[0], readSize);
                            int separatorPositionIndex = 0;

                            for (Integer argEnd : argEnds) {
                                while (separatorPositionIndex < separatorPositions.size() && separatorPositions.get(separatorPositionIndex) < argEnd) {
                                    ++separatorPositionIndex;
                                }
                                if (separatorPositions.size() == 0) {
                                    if (!isPrintFolder) {
                                        System.out.println();
                                        System.out.print(folderString);
                                        isPrintFolder = true;
                                    }
                                    printBlock(bytes, 0, readSize - 1, j);
                                    stopFlag = true;
                                    break;
                                }

                                if (separatorPositionIndex == separatorPositions.size()) {
                                    if (isOnlyPrint) break;
                                    isOnlyPrint = true;
                                    prevEncodingIndex = j;
                                    if (separatorPositions.get(separatorPositions.size() - 1) + 1 < readSize / 2 || readSize != BLOCK_SIZE) {
                                        if (!isPrintFolder) {
                                            System.out.println();
                                            System.out.print(folderString);
                                            isPrintFolder = true;
                                        }
                                        printBlock(bytes, separatorPositions.get(separatorPositions.size() - 1) + 1, readSize - 1, j);
                                    }
                                } else if (separatorPositionIndex == 0) {
                                    if (isPrintSegment.get(0))
                                        continue;
                                    randomAccessFile.seek(prevSeparatorPosition + 1);
                                    while (true) {
                                        if (prevSeparatorPosition == -1)
                                            readSize = Math.min(readBytes, BLOCK_SIZE);
                                        else
                                            readSize = Math.min(readBytes - prevSeparatorPosition, BLOCK_SIZE);

                                        if (readSize <= 0)
                                            break;
                                        bytes = new byte[readSize];
                                        randomAccessFile.read(bytes);
                                        if (!isPrintFolder) {
                                            System.out.println();
                                            System.out.println(folderString);
                                            isPrintFolder = true;
                                        }
                                        printBlock(bytes, 0, readSize - 1, j);
                                        prevSeparatorPosition += readSize;
                                        if (readSize < BLOCK_SIZE)
                                            break;
                                    }
                                    if (!isPrintFolder) {
                                        System.out.println();
                                        System.out.println(folderString);
                                        isPrintFolder = true;
                                    }
                                    if (prevEncodingIndex == -1)
                                        prevEncodingIndex = j;
                                    bytes = new byte[BLOCK_SIZE];
                                    readSize = randomAccessFile.read(bytes);
                                    printBlock(bytes, 0, separatorPositions.get(0), prevEncodingIndex);


                                    prevSeparatorPosition = separatorPositions.get(0) + readBytes;
                                    isPrintSegment.set(0, true);

                                } else {
                                    if (isPrintSegment.get(separatorPositionIndex))
                                        break;
                                    isPrintSegment.set(separatorPositionIndex, true);
                                    if (separatorPositions.get(separatorPositionIndex - 1) + 1 < readSize / 2 || readSize != BLOCK_SIZE) {
                                        if (!isPrintFolder) {
                                            System.out.println();
                                            System.out.println(folderString);
                                            isPrintFolder = true;
                                        }
                                        printBlock(bytes, separatorPositions.get(separatorPositionIndex - 1) + 1, separatorPositions.get(separatorPositionIndex), j);
                                    }
                                }
                            }

                        }
                        if (stopFlag) {
                            break;
                        }
                    }
                    if (separatorPositions.size() > 0) {
                        for (int i = 0; i < separatorPositions.size(); ++i)
                            if (separatorPositions.get(i) >= readSize / 2) {
                                if (i > 0) {
                                    prevSeparatorPosition = readBytes + separatorPositions.get(i - 1);
                                }
                                break;
                            }
                    }
                    readBytes += readSize / 2;
                    randomAccessFile.seek(readBytes + 1);
                    if (readSize != BLOCK_SIZE)
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception with folder");
        }
    }

    private static void foldersSearch(final File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (final File fileEntry : files) {
                if (fileEntry.isDirectory()) {
                    foldersSearch(fileEntry);
                } else {
                    folderProcessing(fileEntry);
                }
            }
        }
    }
}
