import java.io.*;
import java.math.BigInteger;
import java.rmi.dgc.VMID;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
//        inputStream = new FileInputStream(new File("palindrome.in"));
//        outputStream = new FileOutputStream(new File("palindrome.out"));
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream, true);
        int t = 1;
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in, out);
        }
        out.close();
    }


    public static void solve(InputReader in, PrintWriter out) throws IOException {

    }


static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}
}